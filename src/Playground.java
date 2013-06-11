import processing.core.*;


public class Playground extends PApplet {

	// Global Fields

	public int width = 940;
	public int height = 200;
	public boolean movementlock = false;
	public boolean hungry = true;
	public int numFrame  = 8;
	public int score = 0;

	PFont font;

	public Snake snake;

	public Food food;

	public void setup() {
		size(width,height);
		frameRate(numFrame);
		//background(0);
		food = new Food(10, this);
		snake = new Snake(width/2-10,height/2-10, 10, this);
		snake.display();
		size(width,height);

//		font =  new PFont();
//		font = loadFont("Arial");

	}

	public void draw() {
		movementlock = false;
		frameRate(numFrame);
		background(0);

		int a = snake.sx.getFirst();
		int b = snake.sy.getFirst();
		
		if ((a <= -10) || 
				(a + snake.cellSize  >= width) ||
				(b < -10) ||
				(b >= height)) {

			snake.slaughterTheSnake(true);
		} 

		


		for (int i = 1; i < snake.sx.size(); i++) {

			if((a == snake.sx.get(i)) && ( b == snake.sy.get(i)) ) {
				snake.slaughterTheSnake(true);
			}
		}

		food.display();
		snake.display();
		snake.move();

		if( (snake.sx.getFirst() == food.fx) && (snake.sy.getFirst() == food.fy)) {

			snake.eat();
			food.generateRandomness();
			numFrame++;
			score += 5;
			

		}
//
//		textFont(font, 32); 
//		text(""+score, 5, 5);
		


	}



	//controls


	public void keyPressed() {
		if (!movementlock) {
			if (key == CODED) {
				if (keyCode == UP && snake.speedY!=1) {
					snake.changeDirection(0,-1);
				} else if (keyCode == DOWN && snake.speedY!=-1) {
					snake.changeDirection(0, 1);
				} else if (keyCode == LEFT && snake.speedX!=1) {
					snake.changeDirection(-1,0);
				} else if (keyCode == RIGHT && snake.speedX!=-1){
					snake.changeDirection(1,0);
				} else if (keyCode == ALT) {
					snake.eat();
					//					food.generateRandomness();
				}
			} 
		}
		movementlock = true;
	}





}
