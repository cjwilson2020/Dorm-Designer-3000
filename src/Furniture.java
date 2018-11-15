//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dorm Designer 3000
// Files:           Furniture.java
// Course:          CS 300 Summer 2018
//
// Author:          Christopher J Wilson
// Email:           cwilson32@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Sarad Aryal
// Partner Email:   saryal2@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/*Furniture class used to create sofas, beds, and other items in Dorm Designer*/
import java.util.Random;
/*
 * Furniture class for all furniture created by user
 * implements the dormGUI interface
 */
public class Furniture implements DormGUI{

	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	private int rotations;
	private String type;
	private static boolean captured = false;

	 

	
	// initializes the fields of a new bed object positioned in the center of the display
	public Furniture(String type, PApplet processing) { 
		this.processing = processing;
		this.type = type;
		this.image = processing.loadImage("Images/" + type + ".png"); 
		position = new float[2];
		position[0] = processing.width/2;
		position[1] = processing.height/2;
	
		isDragging = false;
		rotations = 0;
		
	}
	
	/*
	 * Furniture constructor that accepts String type, float array position, int rotations, 
	 * and PApplet processing as parameters
	 */
	public Furniture(String type, float[] position, int rotations, PApplet processing) { 
		this.processing = processing;
		this.type = type;
		this.image = processing.loadImage("Images/" + type + ".png"); 
		this.position = new float[] {position[0], position[1]};

		isDragging = false;
		this.rotations = rotations;

	}

	// draws this bed at its current position
	public void update() { 
		this.image = processing.loadImage("Images/" + type + ".png"); 
		processing.image(image, position[0], position[1], rotations*PApplet.PI/2);

		if(isDragging) {
			position[0] = processing.mouseX;
			position[1] = processing.mouseY;

		}
	}

	// used to start dragging the bed, when the mouse is over this bed when it is pressed
	//I added some static variables so I wouldn't grab multiple furnitures at once
	//It does this by assigning each Furniture an id based
	//on the system's current time and a static boolean that
	//is true when a one furniture is being dragged and false if nothing is 
	public  void mouseDown(Furniture[] furniture) {

		if (isMouseOver()) {

			//Then mouse is clicking on this bed 
			if (captured == false) {
				captured = true;
				isDragging = true;
			
			}
		}
	
	}


	// used to indicate that the bed is no longer being dragged
	public void mouseUp() {
		captured = false;
		isDragging = false;
	
	}

	// helper method to determine whether the mouse is currently over this bed
	public boolean isMouseOver() { 
		boolean withinBedHeight = false;
		boolean withinBedWidth = false;
		
		if ((rotations % 2) == 0) {
			withinBedWidth = ((position[0] - (image.width/2)) < processing.mouseX ) && (processing.mouseX < (position[0] + (image.width/2))) ;
			withinBedHeight = ((position[1] - (image.height/2)) < processing.mouseY ) && (processing.mouseY < (position[1] + (image.height/2))) ;
		}else {
			withinBedHeight = ((position[1] - (image.width/2)) < processing.mouseY ) && (processing.mouseY < (position[1] + (image.width/2))) ;
			withinBedWidth = ((position[0] - (image.height/2)) < processing.mouseX ) && (processing.mouseX < (position[0] + (image.height/2))) ;

		}


		if (withinBedWidth && withinBedHeight) {
			return true;

		} 

		return false;
	}

	//This method rotates this furniture object 90 degress clockwise every time it is called
	// and increments the number of rotations.
	public void rotate() { 
		rotations++;

	}
	
	/*
	 * Helper method used to get the type field private variable
	 */
	public String getType() {
		return type;
	}
	
	/*
	 * Helper method used to get the x position using the position field private float array
	 */
	public float getPositionX() {
		return position[0];
	}
	
	/*
	 * Helper method used to get the y position using the position field private float array
	 */
	public float getPositionY() {
		return position[1];
	}
	
	/*
	 * Helper method used to get the rotations field private variable
	 */
	public int getRotations() {
		return rotations;
	}
	
}
