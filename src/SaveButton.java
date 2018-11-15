////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           Dorm Designer 3000
//Files:           SaveButton.java
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
import java.io.*;

public class SaveButton extends Button implements DormGUI {


	/**
	 * Constructor for SaveButton.
	 * Initializes the fields of a new Save button object positioned on the top of the display
	 * at point (x, y)
	 * 
	 * @param processing PApplet object that calls other 
	 * 			Data classes that helps to do a lot of other things through out the game
	 * 
	 */
	public SaveButton(float x, float y, PApplet processing){ 
		super(x, y, processing);
		label = "Save Room";
	}

	/*
	 * This method  calls the saveRoom method to write to a file 
	 * "RoomData.ddd" the data of all furniture in the room
	 */
	@Override 
	public void mouseDown(Furniture[] furniture) {
		if (isMouseOver()) {
			//		System.out.println("Save Button pressed");

			saveRoom(furniture, "RoomData.ddd");
		}
	} 

	/*
	 * This method writes the data of each
	 * item of furniture placed in the room to a file, filename
	 */
	private void saveRoom(Furniture[] furniture, String filename){
		PrintStream saving = null;
		
		
		try {
			String data = "";

			saving = new PrintStream(filename);


			/*Go through the furniture array
			 * for each furniture that is NOT null
			 * Save its properties on one line
			 * furniture type, position, rotations 
			 */

			for (int i = 0; i < furniture.length; i++) {
				if(furniture[i] != null) {
					data = (furniture[i].getType() + ":" + furniture[i].getPositionX() + "," + furniture[i].getPositionY() + "," + furniture[i].getRotations() + "\n");
					saving.println(data);
				}
			}

			saving.close();

			//		System.out.println(data);
		}catch(FileNotFoundException fnf) {
			fnf.getMessage();
			System.out.println("WARNING: Could not save room contents to file RoomData.ddd.");
		}
		finally {
			if (saving != null) {
				saving.close(); 
			}
		}
	}
}

