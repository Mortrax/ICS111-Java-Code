import java.util.Scanner;

public class Part3 {

	
	public static void main(String[] args) {
		
		// provided scanner
		Scanner scan = new Scanner(System.in);
		
		// prompt the user asking what value they wish to go up through to test for primes
		System.out.println("Please enter a value for viewing primes: ");
		
		
		// get the number using the scanner.nextInt() function. Let's call that value, 'A'.
		int A = scan.nextInt();
		
		// for each number from 1 to 'A', if it is prime, then print it.
		
		for(int i = 1; i <= A; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
		
		scan.close();
		// TIP 1: start by implementing the isPrime function then try it with a few simple cases
		
		// TIP 2: try iterating through a fixed number of values. For example, with 10 values, you should see 1,2,3,5,7 as the primes.
		
		// TIP 3: add the scanner last. that should be the easiest part.
		
	}

	
	public static boolean isPrime(int a) {
		
		// assume 'a' is prime
		boolean prime = true;
		
		// technically 1 isn't a prime number :P
		if (a == 1) {
			return false;
		}
		
		// loop?
		for(int i = 2; i < a; i++) {
			if (a % i == 0) {
				prime = false;
				break;
			}
		}
		
		
		// return if 'a' is prime
		return prime;	
	}
	
}
