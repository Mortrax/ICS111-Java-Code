import java.util.Scanner;
import java.io.InputStreamReader;
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.print("What is your name: ");
		
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String input = scanner.nextLine();
		System.out.println("Hello " + input + "!");
		scanner.close();

	}

}
