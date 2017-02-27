
import java.awt.Color;


public class BugRun {
  
  public static void main(String[] args) { 
	  
		// Setup EZ graphics system.
		EZ.initialize(500,500);  // PIXEL picture element 

		
		EZ.setBackgroundColor(new Color(0,150,0)); 

		
		// Load a picture of a bug from the file.
		// Make a variable called bugPicture of type EZImage.
		// Put inside the bugPicture variable, a picture from the file "bug.png"
	
		EZImage bugPicture = EZ.addImage("bug.png", 0,0);
		// Make a variable called bugPicture of type EZImage and store in it
		// an image whose filename is "bug.png" and put that picture at location 0,0
		
		// Use to keep track of X position of bug.
		int posX = 0;
		int posY = 200;
		
		// This is a WHILE loop that will loop FOREVER....
		while (true) {

			bugPicture.translateTo(posX, posY); // Set x position of bug.

			bugPicture.rotateTo(posX);

			posX= posX+1;
			
			System.out.println(posX);
			
			// Make sure to do this or else the graphics wonʻt refresh
			EZ.refreshScreen();

		}

	}

} //end class
