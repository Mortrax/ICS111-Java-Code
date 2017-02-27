
import java.util.Random;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {


		// 1. Computer thinks of a random number.
		Random randomGenerator; // Declare a variable called randomGenerator of type Random
		randomGenerator = new Random(); // make a random number generator and store it in the variable called randomGenerator
		int randomInteger = randomGenerator.nextInt(10); // make a random number from 0 to 10 and store it in the variable randomInteger
		
		int guess; // create an integer variable called guess
		int count = 0; // create an integer variable called count and set it to zero

		
		// make something called a scannner that will let the computer let me type into it
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		
		
		do {
			// 2. You tell the computer the number.
			// 2a Computer asks you to type in a number.
			System.out.println("Guess a number from 0 to 10? ");
			guess = scanner.nextInt();  // Wait for the user to type in a number

			// 3. The Computer says either too high, too low or spot on
			// depending on your guess.

			// 3a If your guess is more than the computerʻs then say “Too high”
			if (guess > randomInteger) {
				System.out.println("Too high!");
			}

			// 3b If your guess is less than the computerʻs then say “Too low”
			if (guess < randomInteger) {
				System.out.println("Too low!");
			}

			// 3c If it is right then say “BINGO!”
			if (guess == randomInteger) {
				System.out.println("BINGO!");
			}

			// 4. Computer goes back to step 2 if you didnʻt get it. Otherwise
			// it tells you how many guesses you took.
			// 4a Computer keeps count of how many tries you made.

			count++;

			// 4c If your guess was wrong then go back to 2.
		} while (guess != randomInteger);

		// 4b If your guess was right then it tells you how many tries you
		// made.

		System.out.println("You took " + count + " guesses!");


		
		// If you took more than or exactly 5 guesses say: "DUMMY ASS!"
		if (count >= 5){
			System.out.println("DUMB ASS");
		}
		
		// If you took less than 5 guesses but more than 3 guesses: "LAME"
		if (count > 3 && count < 5){
			System.out.println("LAME");
		}
		
		// If you took fewer than the above then say: "YOU"RE PSYCHIC TELL JASON TO GIVE YOU AN A AND SKIP THE REST OF THE CLASS"
		if (count < 3) {
			System.out.println("YOUʻRE PSYCHIC TELL JASON TO GIVE YOU AN A AND SKIP THE REST OF THE CLASS");
		}
	}

}
