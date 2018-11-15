////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           Dorm Designer 3000
//Files:           LoadButton.java
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
import java.util.zip.DataFormatException;
import java.io.*;

public class LoadButton extends Button implements DormGUI {
	/**
	 * Constructor for LoadButton.
	 * Initializes the fields of a new Load button object positioned on the top of the display
	 * at point (x, y)
	 * 
	 * @param processing PApplet object that calls other 
	 * 			Data classes that helps to do a lot of other things through out the game
	 * 
	 */
	public LoadButton(float x, float y, PApplet processing){
		super(x, y, processing);
		label = "Load Room";
	}
	@Override
	public void mouseDown(Furniture[] furniture) {
		if (isMouseOver()) {
			//System.out.println("Load Button pressed");

			loadRoom(furniture, "RoomData.ddd");
		}
	} 

	/*
	 * This method reads the data from each the file, filename
	 */
	private void loadRoom(Furniture[] furniture, String filename){
		FileReader fReader = null;
		BufferedReader bReader = null;
		try {

			fReader = new FileReader(filename);
			bReader = new BufferedReader(fReader);

			/*
			 * To load, we are going to first clearthe furrnet Furniture[] array
			 */
			for (int i = 0; i < furniture.length; i++) {
				if (furniture[i] != null) {
					furniture[i] = null;
				}
			}

			/*
			 * Now we will start reading from the file and create a new 
			 * furniture at the correct positions from each line in the file
			 * 
			 */

			for(int i = 0; bReader.ready(); i++) {

				String line = bReader.readLine();

				if(!line.isEmpty()) {

					//add furniture to the array
					String type = line.split(":")[0].trim().toLowerCase(); // extracts the type of the furniture from the line
					String phys = line.split(":")[1].trim().toLowerCase();

					if (phys.split(",").length == 3) {
						float xPos = Float.parseFloat(phys.split(",")[0].trim().toLowerCase());
						float yPos = Float.parseFloat(phys.split(",")[1].trim().toLowerCase());
						float[] pos = new float[] {xPos, yPos};

						int rotations =  Integer.parseInt(phys.split(",")[2].trim().toLowerCase());



						furniture[i] = new Furniture(type, pos, rotations, processing);
					}
					else {
						throw new DataFormatException();
					}


					//System.out.println(line);

				}


			}	
			bReader.close();
			fReader.close();


		}
		catch (DataFormatException dfe1){
			System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
		}
		catch (FileNotFoundException fnf) {
			System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");

		} catch (IOException e) {
			System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
			
		} catch(ArrayIndexOutOfBoundsException arrayOut) {
			System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
		}
		finally {
			try {
				if(bReader != null) {
					bReader.close();
				} else if (fReader != null) {
					fReader.close();
				}
			} catch (IOException e) {
				System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
			}
		}
	}



}
