/*
 *  Enclose translated code within a function
 * 	to be passed to a new instance of "Processing" method later.
 * 
 */

function snakeSketch (p) {
	// Global Fields

	var width = 600;
	var height = 200;
	var movementlock = false;
// no need for hungry
//	var hungry = true;
	var numFrame  = 5;
	var score = 0;
	
		// Snake Fields

	var cellSize = 10; // size of the Snake Module
	var speedX = 1; // the value of the x 
	var speedY = 0; // the value of the y
	var isDead = false; // if true the snake has crash into a wall or in himself
	var sx = new Array(); // here is where the values of each rect of the body
	var sy = new Array(); // the same as above ;)

	// Food Fields

	var fx, fy;
	var foodSize = cellSize;
	
	// Control Fields

	var stopped = false;
	
	snakeSketch.turnOff = function () {
		p.exit();
		//alert('Bang! Stopped.');

};

	
	// General Methods	
	
		// Snake Methods
		function displaySnake() {

		//	if the snake hasn't "encoutrered" a wall or himself
		// this method will provide a way to display the snake to the rest of the world

		if (!isDead) {
			//parent.fill(255,100);
			//parent.noStroke();

			for (var i = 0; i < sx.length; i++) {

				p.fill(0,255,0); 
				p.rect( sx[i], sy[i], cellSize, cellSize);			
			}

		} else {
			p.background(255, 0, 0);
		}
	}
		function moveTheSnake() {

		sx.pop();
		sx.unshift(sx[0] + (speedX*cellSize));

		sy.pop();
		sy.unshift(sy[0] + (speedY*cellSize));

		}
			
		function changeSnakeDir(x, y) {
		speedX = x;
		speedY = y;
	}

		function slaughterTheSnake(destiny) {
		isDead = destiny;
	}


		function eat() {
		
		// old java:
		// sx.addLast(sx.getLast());
		//
		// TRY THIS:
		sx.push(sx[sx.length-1]);
		
		// OLD JAVA
		//sy.addLast(sy.getLast());
		sy.push(sy[sy.length-1]);
		
		//p.rect(sx[sx.length-1], sy[sy.length-1], cellSize, cellSize);

	}



	
		//Food Methods
		function displayFood() {

		p.fill(255,0,0);
		p.rect(fx,fy,foodSize, foodSize);

		}


		function generateRandomness() {

		var deltaX = Math.floor( p.random((-width)/(2*foodSize),(width)/(2*foodSize)) );
		var deltaY = Math.floor( p.random((-height)/(2*foodSize),(height)/(2*foodSize)) );	
		fx = (width/2  + deltaX*foodSize);
		fy = (height/2 + deltaY*foodSize);

		}

		
	
	// Processing Methods
		// processing setup
		p.setup = function() {
		p.size(width,height);
		p.frameRate(numFrame);
		//background(0);

		var x =  width/2-10;
		var y =  height/2-10;

	// toGhiz: perch li ripeti NEL .PDE ? 		
	//		sx = new LinkedList<Integer>();
	//		sy = new LinkedList<Integer>();
	
		/* init snake */
		
		// MAYBE ORDER REVERSE ? YES, INSTANT DEATH OTHERWISE !!
		
		for(var i=3; i>0; i--) {
		//for (var i = 0; i < 3; i++) {
			sx.push(x + i*cellSize );
			sy.push(y );
		}

		displaySnake();
		generateRandomness();

	
	};
	
		// processing draw
	p.draw = function() {
				movementlock = false;

				p.frameRate(numFrame);
				p.background(0);

		//var a = sx[0];
		//var b = sy[0];

//		if ((a < 0) || (a + cellSize  > width) || (b < 0) || (b + cellSize > height)) {
//
//			slaughterTheSnake(true);
//		}
				// TEST FOR auto-collision and THEN "magic" walls
				for (var i = 1; i < sx.length; i++) {

					if ((sx[0] == sx[i] ) && ( sy[0] == sy[i] ) ) {
						slaughterTheSnake(true);
					}
				}

				// "magic" walls!
				if (sx[0] <=0) sx[0] = width - cellSize;
				if (sx[0] >= width - cellSize) sx[0] = 0;
				if (sy[0] <0) sy[0] = height - cellSize;
				if (sy[0] >=height) sy[0] = 0;
				
		displayFood();
		displaySnake();
		moveTheSnake();

		var prev = score;

		if ( (sx[0] == fx ) && (sy[0] == fy) ) {

			eat();
			generateRandomness();

			score += 5;
		}

		if (( (score%20) == 0 ) && (score != 0) && (score != prev)) {

			numFrame += 1;
		}



		var s = "Score: " + score;
		p.text(s,5,5,80,60);
//		String f = "FrameR: " + numFrame;
//		text(f,5,65,80,125);
	
	};
	


	
	// KeyPress-related Methods
	//	COPIED FROM JSNAKE.js
	p.keyPressed = function () {

		if (p.keyCode == p.ESC) { 
				if (stopped) {
					p.loop();
					stopped = false; }
				else {
					p.text("Paused",50,50,80,60);
					p.noLoop();
					stopped = true; }
		}
		
		if (!movementlock) {
			//if (key == CODED) {
				if ( p.keyCode == p.UP && speedY!=1) {
					changeSnakeDir(0,-1);
				} else if ( p.keyCode == p.DOWN && speedY!=-1) {
					changeSnakeDir(0, 1);
				} else if (p.keyCode == p.LEFT && speedX!=1) {
					changeSnakeDir(-1,0);
				} else if (p.keyCode == p.RIGHT && speedX!=-1){
					changeSnakeDir(1,0);
				} else if (p.keyCode == p.ALT) {
					eat();
					//food.generateRandomness();
					}
			//} 
		}
		movementlock = true;
	};


}
