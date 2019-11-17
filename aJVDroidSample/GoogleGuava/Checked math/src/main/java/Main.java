import com.google.common.math.IntMath;

public class Main {

	public static int factorial_checked(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++)
			factorial = IntMath.checkedMultiply(i, factorial);
		return factorial;
	}

	public static void main(String[] args) {
		System.out.println("Factorial of 5 is " + factorial_checked(5));
		System.out.println("Factorial of 10 is " + factorial_checked(10));
		System.out.println("Factorial of 15 is " + factorial_checked(15));
	}
}