//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dorm Designer 3000
// Files:           Main.java
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
import java.util.ArrayList;
/**
 * This class contains a number of methods for the Dorm Designer 3000.
 * This class calls a number of other classes, which helps to create all sorts of
 * required things for the game. 
 * @author Christopher Wilson
 */

public class Main {
	private PApplet processing;
	private PImage backgroundImage;
	private ArrayList<DormGUI> guiObjects;

	private CreateFurnitureButton bedButton;
	private CreateFurnitureButton sofaButton;
	private CreateFurnitureButton sinkButton;
	private CreateFurnitureButton deskButton;
	private CreateFurnitureButton dresserButton;
	private SaveButton saveButton;
	private LoadButton loadButton;
	private ClearButton clearButton;

	/**
	 * Constructor for Main.
	 * Initializes the fields of a new bed object positioned on the center of the display
	 * 
	 * @param processing PApplet object that calls other 
	 * 			Data classes that helps to do a lot of other things through out the game
	 * 
	 */
	public Main(PApplet processing) {
		this.processing = processing;

		processing.background(95,158,160); //loads the background color 
		guiObjects = new ArrayList<DormGUI>();

		//Instantiate guiObjects
		guiObjects.add(bedButton);
		guiObjects.add(sofaButton);
		guiObjects.add(sinkButton);
		guiObjects.add(deskButton);
		guiObjects.add(dresserButton);
		guiObjects.add(saveButton);
		guiObjects.add(loadButton);
		guiObjects.add(clearButton);

		
		guiObjects.set(0, new CreateFurnitureButton("bed", 50,24, processing));
		guiObjects.set(1, new CreateFurnitureButton( "sofa", 150, 24, processing));
		guiObjects.set(2, new CreateFurnitureButton( "sink", 250,24, processing));
		guiObjects.set(3, new CreateFurnitureButton("desk", 350,24, processing));
		guiObjects.set(4, new CreateFurnitureButton("dresser", 450,24, processing));
		guiObjects.set(5, new ClearButton(550, 24, processing));
		guiObjects.set(6, new SaveButton(650, 24, processing));
		guiObjects.set(7, new LoadButton(750, 24, processing));


		backgroundImage = processing.loadImage("Images/background.png"); 
		processing.image(backgroundImage, processing.width/2,  processing.height/2);
		// width [resp. height]: System variable of the processing library that stores the width [resp. height] of the display window


	}

	/**
	 * This is the main method for Dorm Designer 3000. This method
	 * 	 calls to various supporting methods.
	 * 
	 * @param args command-line arguments
	 *
	 */
	public static void main(String[] args) {
		Utility.startApplication();


	}

	/**
	 * This method is constantly called by main 
	 * and frequently prints out on the screen.
	 *  
	 */ 
	public void update() {
		//Load Background
		processing.background(95,158,160); //loads the background color 

		processing.image(backgroundImage, processing.width/2,  processing.height/2); // LOAD ROOM
		// width [resp. height]: System variable of the processing 
		// library that stores the width [resp. height] of the display window

		for(int x = 0; x < guiObjects.size();x++) {
			guiObjects.get(x).update();
		}

	}

	/**
	 * call back method called by the Utility cass when the mouse buttn is pressed
	 */
	public  void mouseDown() { 
		Furniture[] furniture = extractFurnitureFromGUIObjects();
		
		for(int x = 0; x < guiObjects.size() ;x++) {
			guiObjects.get(x).mouseDown(furniture);
			
		}
		replaceFurnitureInGUIObjects(furniture);
		
	}

	/*The Utility method in the DormDesigner.jar file calls this method 
	 * every time the left or right mouse button has been RELEASED  */
	public void mouseUp() {
		for(int x = 0; x < guiObjects.size() ;x++) {
			guiObjects.get(x).mouseUp();

		}
	}

	/*The Utility method in the DormDesigner.jar file calls this 
	 * method upon the pressing of any key on the keyboard*/ 
	public void keyPressed() {
		Furniture[] furniture = extractFurnitureFromGUIObjects();
		if ((processing.key == 'D') || (processing.key == 'd')) {
			for (int i = 0; i < furniture.length; i++) {
				if(furniture[i] != null) {
					if(furniture[i].isMouseOver()) {
						furniture[i] = null;
						break;
					}
				}

			}

		} else if ((processing.key == 'R') || (processing.key == 'r')) {
			for (int i = 0; i < furniture.length; i++) {
				if(furniture[i] != null) {
					if(furniture[i].isMouseOver()) {
						furniture[i].rotate();;
						break;
					}
				}

			}

		}
		replaceFurnitureInGUIObjects(furniture);
	}

	// Max number of furniture that LoadButton will be allowed to load at once.    
	private final static int MAX_LOAD_FURNITURE = 100;        
	/**
	 * This method creates a new Furniture[] for the old mouseDown() methods
	 * to make use of.  It does so by copying all Furniture references from
	 * this.guiObjects into a temporary array of size MAX_LOAD_FURNITURE.
	 * @return that array of Furniture references.
	 */
	private Furniture[] extractFurnitureFromGUIObjects() {
	    Furniture[] furniture = new Furniture[MAX_LOAD_FURNITURE];
	    int nextFreeIndex = 0;
	    for(int i=0;i<guiObjects.size() && nextFreeIndex < furniture.length;i++)
	        if(guiObjects.get(i) instanceof Furniture)
	            furniture[nextFreeIndex++] = (Furniture)guiObjects.get(i);        
	    return furniture;        
	}    
	/**
	 * This method first removes all Furniture references from this.guiObjects,
	 * and then adds back in all of the non-null references from it's parameter.
	 * @param furniture contains the only furniture that will be left in 
	 *   this.guiObjects after this method is invoked (null references ignored).
	 */
	private void replaceFurnitureInGUIObjects(Furniture[] furniture) {
	    for(int i=0;i<guiObjects.size();i++)
	        if(guiObjects.get(i) instanceof Furniture)
	            guiObjects.remove(i--);
	    for(int i=0;i<furniture.length;i++)
	        if(furniture[i] != null)
	            guiObjects.add(furniture[i]);
	}

}
