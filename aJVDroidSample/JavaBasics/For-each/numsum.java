import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Integer[] lst = new Integer[10];
		Random r = new Random();
		for (int i = 0; i < 10; i++)
			lst[i] = r.nextInt(100);
		int sum = 0;
		for (Integer i : lst)
			sum += i;
		System.out.print("Numbers: ");
		System.out.println(Arrays.toString(lst));
		System.out.println("Sum: " + sum);
	}
}