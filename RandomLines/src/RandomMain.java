import java.awt.Color;
import java.util.Random;
public class RandomMain {
	static Random randomGenerator = new Random();
	static int screenHeight = 500;
	static int screenWidth = 500;
	static Color lineColor = new Color(255, 255, 0);
	
	static int randomXLeft() {
		return randomGenerator.nextInt(screenWidth/2);
	}
	
	static int randomXRight() {
		return randomGenerator.nextInt(screenWidth/2 + 1) + screenWidth/2; 
	}
	
	static void drawLine(int y) {
		EZ.addLine(randomXLeft(), y, randomXRight(), y, lineColor, 5);
	}
	

	public static void main(String[] args) {
		EZ.initialize(screenWidth, screenHeight);
		EZ.setBackgroundColor(Color.GREEN);
		int yIncrement = screenHeight/10;
		int yCoord = 0;
		
		while (yCoord <= screenHeight) {
			drawLine(yCoord);
			yCoord += yIncrement;
		}
		EZ.refreshScreen();

	}

}
