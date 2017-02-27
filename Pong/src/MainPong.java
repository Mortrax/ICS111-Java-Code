import java.awt.Color;
import java.util.Random;


public class MainPong {

	public static void main(String[] args) {
		// Setup EZ graphics system.
				EZ.initialize(700,500);    // Start up EZ and make a screen of 700 x 500 pixels in size

				EZ.setBackgroundColor(new Color(0, 0,0));  // Make the background black.
	
				EZImage backgroundPicture = EZ.addImage("milleniumfalcon.jpg", 450,200);
				EZImage probePicture = EZ.addImage("probe.png", 0,0);
				EZImage saberPicture = EZ.addImage("saber-blue.png", 0,0);
			
			
				EZSound saberSound = EZ.addSound("saberhum.wav");
				EZSound clashSound = EZ.addSound("clash.wav");
				EZSound impressiveSound = EZ.addSound("impressive.wav");
				saberSound.loop();

				
				int posX = 0;			// Stores the x position of the probe
				int posY = 200;			// Stores the y position of the probe	
				int directionX = 5;		// Stores the x direction of the probe
				int directionY = 5;		// Stores the y direction of the probe
				int rotationAngle = 0;	// Stores the rotation angle of the probe
				int saberX = 700/2;		// Stores X Position of the light saber 

				int bounces = 0;		// Stores the number of times the probe has bounced off the lightsaber
				
				int mouseX = EZInteraction.getXMouse();
				while (true) {

					probePicture.translateTo(posX, posY); // Set the position of the probe.

					probePicture.rotateTo(rotationAngle); // Set the rotation angle of the probe.
										
					posX= posX+directionX;
					posY= posY+directionY;
					
					rotationAngle+=directionX;

					
					if (posX > 700 ) {
						directionX = -directionX;
					}
					if (posX < 0) {
						directionX = -directionX;
					}
					
		//			if ((posX > 700) || (posX < 0)) {
		//				directionX = -directionX;
		//			}
					
					if (posY > 600 ) {		// if the ball reaches all the way to the bottom reset it to the top
						posY=0;
					}
					if (posY < 0) {
						directionY = -directionY;
					}
					/*
					if (EZInteraction.isKeyDown('d')) {
						saberX+=10;
					} else if (EZInteraction.isKeyDown('a')) {
						saberX-=10;
					}
					*/
					int halfSaberWidth = saberPicture.getWidth()/2;
					
					
					mouseX = EZInteraction.getXMouse();
					saberX = mouseX;
					saberPicture.translateTo(saberX, 480);
					
					if ((posX < saberX+halfSaberWidth) && (posX > saberX-halfSaberWidth) && (posY > 460) && (posY < 480)){

						directionY = -directionY;
						clashSound.play();
						bounces++;
						if (bounces == 3) {
							impressiveSound.play();
							bounces = 0;
						}
					}
					
					// Make sure to do this or else the graphics wonʻt refresh
					EZ.refreshScreen();
				}
	}

}
