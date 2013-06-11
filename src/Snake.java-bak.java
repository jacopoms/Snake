import processing.core.PApplet;



public class Snake extends PApplet {
	
	// Global Fields
	
	public int headX;
	public int headY;
	public int snakeWidth;
	public int snakeHeight;
	public int speed;
	
	public PApplet parent;
	
	
	public Snake (int x, int y, int width, int height, PApplet p) {
		
		this.parent = p;
		this.headX = x;
		this.headY = y;
		this.snakeWidth =  width;
		this.snakeHeight = height;
		
	}
	
	public void display() {
		
		parent.fill(255,100);
		//parent.noStroke();
		parent.rect(headX,headY,snakeWidth,snakeHeight);
	}
	
	public void move(int speedX, int speedY) {
		
		headX += speedX;
		snakeWidth += speedX;
		headY += speedY;
		snakeHeight += speedY;
	}
	
	public int getWidth () {
		return width;
	}
	
	public int getHeight () {
		return height;
	}

	public void changeSnakeSize(int module) {
		snakeWidth += module; 
		//snakeHeight += module;
	}


}
