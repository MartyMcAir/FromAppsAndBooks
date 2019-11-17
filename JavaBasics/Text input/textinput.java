import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = scnr.next();
		System.out.println("Hello, " + name + "!");
		scnr.close();
	}
}