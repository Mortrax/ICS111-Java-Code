import java.awt.Color;

public class DiagonalRect {

	public static void main(String[] args) {
		EZ.initialize(500, 500);
		int x = 25;
		int y = 25;
		
		int h = 50;
		int w = 50;
		Color currentColor = Color.BLUE;
		
		while (x < 500) {
			EZ.addRectangle(x, y, w, h, currentColor, true);
			x += 50;
			y += 50;
			currentColor = currentColor == Color.BLUE ? Color.RED : Color.BLUE;
			EZ.refreshScreen();
		}
	}

}
