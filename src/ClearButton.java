////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           Dorm Designer 3000
//Files:           ClearButton.java
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

public class ClearButton extends Button implements DormGUI {
	/**
	 * Constructor for ClearLoadButton.
	 * Initializes the fields of a new Clear button object positioned on the top of the display
	 * at point (x, y)
	 * 
	 * @param processing PApplet object that calls other 
	 * 			Data classes that helps to do a lot of other things through out the game
	 * 
	 */
	public ClearButton(float x, float y, PApplet processing){ 
		super(x, y, processing);
		label = "Clear Room";
	}
	
	/*
	 * Mouse down method that clears the furniture array by 
	 * assigning null to every object in the furniture array
	 */
	@Override
	public void mouseDown(Furniture[] furniture) {
		

		if (isMouseOver()) {
			processing.fill(100);
			processing.rect(getPosition()[0] - (getWidth()/2),  getPosition()[1] - (getHeight()/2), getPosition()[0] + (getWidth()/2),  getPosition()[1] + (getHeight()/2));

			processing.fill(0);
			processing.text(label, getPosition()[0], getPosition()[1]);
			
			for(int i = 0; i < furniture.length; i++) {
				furniture[i] = null;
			}
		}
		
	}

}
