import java.awt.Color;
import java.util.Random;


public class JitterMain {

	public static void main(String[] args) {
		
		
		EZ.initialize(850, 768);							

		EZ.setBackgroundColor(new Color(255, 255, 255));	

		int turtles = 100;
		
		EZImage[] turtlePictures = new EZImage[turtles];

		Random randomGenerator;
		randomGenerator = new Random(); 
		int turtleX = 0;
		int turtleY = 0;

		for (int i=0; i < turtles; i++){
			
				turtleX = randomGenerator.nextInt(800);
				turtleY = randomGenerator.nextInt(700); 
				turtlePictures[i]= EZ.addImage("turtle.png", turtleX,turtleY);
		}

		while(true){
			for (int i=0; i < turtles; i++){
				turtleX = turtlePictures[i].getXCenter();
				turtleY = turtlePictures[i].getYCenter();
				
				turtleX += -2+randomGenerator.nextInt(5);
				turtleY += -2+randomGenerator.nextInt(5);
				
				turtlePictures[i].translateTo(turtleX, turtleY);
			}
			EZ.refreshScreen();
		}
	}

}
