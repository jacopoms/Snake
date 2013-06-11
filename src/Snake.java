import processing.core.PApplet;
import java.util.LinkedList;



public class Snake extends PApplet {

	// Global Fields


	public int cellSize; // size of the Snake Module
	public int speedX = 1; // the value of the x 
	public int speedY = 0; // the value of the y
	private boolean isDead = false; // if true the snake has crash into a wall or in himself
	public PApplet parent; // I got to use this variable
	public LinkedList<Integer> sx ; // here is where the values of each rect of the body
	public LinkedList<Integer> sy ; // the same as above ;)
	public boolean isFood = false;



	public Snake (int x, int y, int cellSize, PApplet p) {

		this.parent = p;
		this.cellSize = cellSize;
		sx = new LinkedList<Integer>();
		sy = new LinkedList<Integer>();

		// initizialize the snake -  I had to put some value here so the method display will work	
		for (int i = 0; i < 3;i++) {

			sx.addFirst(x+i*cellSize);
			sy.addFirst(y+cellSize);

		}

	}
	

	public void display() {
		
		//	if the snake hasn't "encoutrered" a wall or himself
		// this method will provide a way to display the snake to the rest of the world
		
		if (!isDead) {
			//parent.fill(255,100);
			//parent.noStroke();
			
			for (int i = 0; i < sx.size();i++) {

				parent.fill(0,255,0); 
				parent.rect(sx.get(i),
						sy.get(i),
						cellSize,
						cellSize);			
			}
			
		} else {
			parent.background(255, 0, 0);
		}
	}

	public void move() {
		
		sx.removeLast();
		sx.addFirst(sx.getFirst()+speedX*cellSize);

		sy.removeLast();
		sy.addFirst(sy.getFirst()+speedY*cellSize);

	}


	public void changeDirection(int x, int y) {
		speedX = x;
		speedY = y;
	}

	protected void slaughterTheSnake(boolean destiny) {
		isDead = destiny;
	}

	public void eat() {
		//if (isFood) {
			//int x = sx.getLast()+cellSize;
			//int y = sy.getLast()+cellSize;
			sx.addLast(sx.getLast());
			sy.addLast(sy.getLast());
			//parent.fill(0,255,0);
			parent.rect(sx.getLast(), sy.getLast(), cellSize, cellSize);
	//	}
	}
}
