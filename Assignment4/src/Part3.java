import java.io.InputStreamReader;
import java.util.Scanner;

public class Part3 {
	
	// function that takes in an integer and prints out all of 
	// the factors of that integer
	public static void factorize(int x) {
		String result = "";
		for(int i = 1; i <= x; i++) {
			if (x % i == 0) {
				result += i + " ";
			}
		}
		System.out.println("The factors of " + x + " are: " + result);
	}
	
	static Scanner scanner;

	// create a static function to print out all factors of a positive integer
	// the function should accept one parameter, which is the integer being factored
	
	public static void main(String[] args) {
		
		scanner = new Scanner(new InputStreamReader(System.in)); 
		System.out.print("Enter a number to factor: "); 		 
		int number = scanner.nextInt();
		
		if (number < 0) {
			System.out.println("Program only accepts positive numbers.");
		}
		else {
			factorize(number);
		}
			
	}
}







