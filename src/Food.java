import processing.core.PApplet;


public class Food extends PApplet {
	
	
	public int fx;
	public int fy;
	public int foodSize;
	
	
	public PApplet parent;
	
	
	
	/*
	 * The Food Constructor
	 * 
	 */

	public Food(int size, PApplet p) {
		
		this.parent = p;
		foodSize = size;
		
		generateRandomness();
		
	}
	
	public void display() {
		
		parent.fill(255,0,0);
		parent.rect(fx,fy,foodSize, foodSize);
		
	}
	

	public void generateRandomness() {
		
		int deltaX = (int) random((-parent.width)/(2*foodSize),(parent.width)/(2*foodSize));
		int deltaY = (int) random(-parent.height/(2*foodSize),parent.height/(2*foodSize));	
		fx = (parent.width/2 +  deltaX*foodSize);
		fy = (parent.height/2 + deltaY*foodSize);
		
		
	}
	
	
}
