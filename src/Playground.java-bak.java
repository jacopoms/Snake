import processing.core.*;


public class Playground extends PApplet {

	// Global Fields

	
	public int width = 940;
	public int height = 198;
	
	public Snake snake;

	
	

	public void setup() {
		size(width,height);
		background(0);
		snake = new Snake(width/2-10,height/2-10, 10, 10, this);
		
		
	}
		
	public void draw() {
		
		
		snake.display();
	}

	//controls
	
	
	public void keyPressed() {
		  if (key == CODED) {
		    if (keyCode == UP) {
		      snake.move(0, -1);
		    } else if (keyCode == DOWN) {
		      snake.move(0, 1);
		    } else if (keyCode == LEFT) {
		    	snake.move(-1,0);
		    } else if (keyCode == RIGHT){
		    	snake.move(1,0);
		    } else if (keyCode == ALT) {
		    	snake.changeSnakeSize(width/snake.snakeWidth);
		    }
 		  } 
		}
	

	

}
