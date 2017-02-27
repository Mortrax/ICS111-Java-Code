
public class Part1 {
	// member variable that represents the mathematical constant Pi
	static float PI = 3.14159f;
	
	// function that takes in a float representing the radius of a circle
	// and returns a float representing the area of that circle
	public static float areaOfCircle(float radius) {
		return PI * radius * radius;
	}
	
	// function that takes in a float representing the radius of a circle
	// and returns a float representing the circumference of that circle
	public static float circumferenceOfCircle(float radius) {
		return 2 * PI * radius;
	}
	
	// function that takes in a float representing the radius of a sphere
	// and returns a float representing the volume of that sphere
	public static float volumeOfSphere(float radius) {
		return (4.0f/3.0f) * PI * (float)Math.pow(radius, 3);
	}
	
	public static void circleString(int x) {
		while(x > 0) {
			System.out.println("Circles are pretty cool");
			x--;
		}
	}
	
	
	public static void main(String[] args) {
		
		for(int i = 5; i < 25; i+=5) {
			// test each of our functions through each iteration of the loop
			// with the unique argument i = 5,10,15,20
			
			// test areaOfCircle
			System.out.println("The area of a circle of radius " + i +
					" is " + areaOfCircle((float) i));
			
			// test circumferenceOfCircle
			System.out.println("The circumference of a circle of radius " + i +
					" is " + circumferenceOfCircle((float) i));
			
			// test volumeOfSphere
			System.out.println("The volume of a sphere of radius " + i + 
			" is " + volumeOfSphere((float)i));
			
			System.out.println("");
			
			
		}
		
		// test our circleString function with an argument of 5
		circleString(5);
		
	}
}
