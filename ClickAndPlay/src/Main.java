import java.awt.Color;


public class Main {

	public static void main(String[] args) {


		 // Setup EZ graphics system.
		  EZ.initialize(700,500);
		  
		  // Set the background color to dark green
		  EZ.setBackgroundColor(new Color(0,100,0));
		  
		  // Add an image of the chicken and place it at position 200,200
		  EZImage picture1 = EZ.addImage("chicken.png", 200, 200);
		  
		  // Add an image of the asteroid and place it at 500,200
		  EZImage picture2 = EZ.addImage("asteroid.png", 500, 200);
		  
		  // Add an image of the finger and place it at 0,0
		  EZImage picture3 = EZ.addImage("finger.png", 0, 0);
		  
		 // Make 2 variables, both are integers. One is called clickX, the other is clickY.
		  // Set those variables to zero to begin with.
		 int clickX = 0;
		 int clickY = 0;
		 
		 // Add a sound file.
		 EZSound sound1 = EZ.addSound("crow.wav");
		 
		 // Add a second sound file.
		 EZSound sound2 = EZ.addSound("explosion.wav");
		 
		 // While true means do what is inside this while loop forever....
		  while(true) {
			  
			  // Get the mouseʻs X and Y position
			  clickX = EZInteraction.getXMouse();
			  clickY = EZInteraction.getYMouse();
			  
			  // Move the picture of my finger to the positon of clickX, clickY
			  picture3.translateTo(clickX, clickY);			  
			  
			  // If I press and release my left mouse button, then....
			  if (EZInteraction.wasMouseLeftButtonReleased()) {

				  // If clickX and clickY is on top of my picture then...
			      if (picture1.isPointInElement(clickX, clickY)) {		    	  
			    	  // Play the 1st sound
			    	  sound1.play(); 
			    	  		
			      }
			      
			      // If click X and clickY is on my second picture....
			      if (picture2.isPointInElement(clickX, clickY)) {			    	  
			    	  // Plqy the second sound
			    	  sound2.play(); 
			      }
			  }			  
			  
		      //Make sure to do this or else the graphics wonʻt refresh
		      EZ.refreshScreen();
		  }
	}

}
