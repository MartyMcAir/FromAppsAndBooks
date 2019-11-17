import java.math.RoundingMode;

import com.google.common.math.IntMath;

public class Main {
	public static void main(String[] args) {
		var varsqr = 9801;
		System.out.println(String.format("Integer square root of %s is %s", varsqr, IntMath.sqrt(varsqr, RoundingMode.UNNECESSARY)));
		var gcd1 = 497;
		var gcd2 = 651;
		System.out.println(String.format("Gcd of %s and %s is %s", gcd1, gcd2, IntMath.gcd(gcd1, gcd2)));

		var someprime = 179424731;
		System.out.println(String.format("Number %s is %s", someprime, IntMath.isPrime(someprime) ? "prime" : "composite"));
	}
}