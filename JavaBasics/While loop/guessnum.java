import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random r = new Random();
		int n = r.nextInt(10);
		int guess = -1;
		Scanner scnr = new Scanner(System.in);
		while (guess != n) {
			System.out.print("Your try: ");
			guess = scnr.nextInt();
			if (guess > n)
				System.out.println("Too high");
			if (guess < n)
				System.out.println("Too low");
		}
		scnr.close();
		System.out.println("Congratulations, you won!");
	}
}