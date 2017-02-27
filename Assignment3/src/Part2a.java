
public class Part2a {

	public static void main(String[] args) {
	
		// declare an integer called x and initialize to 100
		int x = 100;

		// declare an integer called y and initialize to 1
		int y = 1;
		
		// declare a String called z and initialize to x plus ":"
		String z = x + ":";
	   
		// start a while loop that runs while factor is less than number+1
		while (y < x + 1) {
		
			// check if x has a remainder of 0 when divided by y
			if (x % y == 0) {
			
				// if so, add a space followed by y to string z
				z = z + " " + y;
			}	
			// increment y
			y++;
		}
		System.out.println(z);
	}	
}

