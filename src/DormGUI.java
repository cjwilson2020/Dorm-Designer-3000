////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           Dorm Designer 3000
//Files:           DormGUI.java
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
/*
 * This is the interface for our buttons and furniture 
 * that are created, saved, and loaded by the user
 */
public interface DormGUI {
	public void update();	
	public void mouseDown(Furniture[] furniture);
	public void mouseUp();
	public boolean isMouseOver();
}
