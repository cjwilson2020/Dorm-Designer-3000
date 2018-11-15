/////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           Dorm Designer 3000
//Files:           Button.java
//Course:          CS 300 Summer 2018
//
//Author:          Christopher J Wilson
//Email:           cwilson32@wisc.edu
//Lecturer's Name: Mouna Kacem
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    Sarad Aryal
//Partner Email:   saryal2@wisc.edu
//Partner Lecturer's Name: Mouna Kacem
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//_X_ Write-up states that pair programming is allowed for this assignment.
//_X_ We have both read and understand the course Pair Programming Policy.
//_X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
//Persons:         (identify each person and describe their help in detail)
//Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
 
public class Button implements DormGUI {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	protected PApplet processing;
	private float[] position;
	protected String label;

	/*This is the default constructor*/
	public Button() {
		//Default Constructor - NOT USED
	}
	
	/*This constructor takes in a float x, float y ,and a PApplet processing in as a parameter*/
	public Button(float x, float y, PApplet processing) {
		position = new float[] {x, y};
		this.processing = processing;
		label = "Button";
	}
	
	/*
	 * update method for Button class that shades the button
	 */
	public void update() {
		if (isMouseOver()) {
			processing.fill(100); //Dark grey
			processing.rect(position[0] - (WIDTH/2),  position[1] - (HEIGHT/2), position[0] + (WIDTH/2),  position[1] + (HEIGHT/2));

			processing.fill(0); 
			processing.text(label, position[0], position[1]);

		} else {
			processing.fill(200); //Light grey
			processing.rect(position[0] - (WIDTH/2),  position[1] - (HEIGHT/2), position[0] + (WIDTH/2),  position[1] + (HEIGHT/2));

			processing.fill(0);
			processing.text(label, position[0], position[1]);

		}
	}
	
	/*
	 * Prints Button was pressed when the mouse button is 
	 * clicked and the mouse is over this button object
	 * 
	 */
	@Override
	public void mouseDown(Furniture[] furniture) {
	    if(isMouseOver()) 
	        System.out.println("A button was pressed.");
	    
	
	}
	
	/*
	 * Empty declaration of mouseUp method. Called when mouse button is released
	 * 	 */
	@Override
	public void mouseUp() {
		
	}
	
	/*
	 * Helper method to get private WIDTH variable
	 */
	public int getWidth() {
		return WIDTH;
	}
	
	/*
	 * Helper method to get private HEIGHT variable
	 */
	public int getHeight() {
		return HEIGHT;
	}
	
	/*
	 * Helper method to get private position variable
	 */
	public float[] getPosition() {
		return position;
	}
	
	/*
	 * Helper method to set private position variable
	 */
	public void setPosition(float x, float y) {
		position = new float[] {x, y};
	}
	
	/*
	 * Checks to see if mouse coordinates are within the area of this Button
	 */
	public boolean isMouseOver() {
		boolean withinButtonWidth = ((position[0] - (WIDTH/2)) < processing.mouseX ) && (processing.mouseX < (position[0] + (WIDTH/2))) ;
		boolean withinButtonHeight = ((position[1] - (HEIGHT/2)) < processing.mouseY ) && (processing.mouseY < (position[1] + (HEIGHT/2))) ;

		if (withinButtonWidth && withinButtonHeight) {
			
			return true;

		}
		return false;
		
	}
}