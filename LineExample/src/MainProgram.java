import java.awt.Color;


public class MainProgram {

	public static void main(String[] args) {
		// Setup EZ graphics system.
		EZ.initialize(500,500); 

				
		EZ.setBackgroundColor(new Color(250,250,0)); 
				
		Color lineColor1 = new Color(0,255,0);
		Color lineColor2 = new Color(0,255,255);
		Color lineColor3 = new Color(250, 0, 0);
		Color lineColor4 = new Color(255, 255, 255);
		
		int y = 0;
		while(y < 500) {
			EZ.addLine(250,250,0,y,lineColor1,5);
			y+=20;
		}
		EZ.refreshScreen();

		y = 0;
		while(y < 500) {
			EZ.addLine(250,250,500,y,lineColor2,5);
			y+=20;
		}
		EZ.refreshScreen();
		
		int x = 0;
		while(x < 500) {
			EZ.addLine(250, 250, x, 0, lineColor3, 5);
			x+=20;
		}
		EZ.refreshScreen();
		
		x = 0;
		while(x < 500) {
			EZ.addLine(250, 250, x, 500, lineColor4, 5);
			x+=20;
		}
		EZ.refreshScreen();
	}

}
