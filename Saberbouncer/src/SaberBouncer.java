import java.awt.Color;



public class SaberBouncer {

	public static void main(String[] args) {

		// Setup EZ graphics system.
		EZ.initialize(700,500);

		EZ.setBackgroundColor(new Color(0, 0,0)); 
		

		EZImage jediPicture = EZ.addImage("yoda.png", 350,250);
		EZImage saberPicture = EZ.addImage("saber.png", 0,0);
		EZSound sound = EZ.addSound("saberhum.wav");
		sound.loop();
		

		int posX = 0;
		int posY = 200;
		int directionX = 10;
		int directionY = 10;
		int rotationAngle = 0;
		

		while (true) {
			System.out.println(posX + " " +posY + " " +directionX + " "+directionY);
			saberPicture.translateTo(posX, posY); // Set the position of the lightsaber.

			saberPicture.rotateTo(rotationAngle); // Set the rotation angle of the lightsaber.
			
			posX= posX+directionX;
			posY= posY+directionY;
			
			rotationAngle++;
			
			if (posX > 700 ) {
				directionX = -directionX;
			}
			if (posX < 0) {
				directionX = -directionX;
			}
			
			if (posY > 500 ) {
				directionY = -directionY;
			}
			if (posY < 0) {
				directionY = -directionY;
			}


			// Make sure to do this or else the graphics wonʻt refresh
			EZ.refreshScreen();

		}
		

	}

}
