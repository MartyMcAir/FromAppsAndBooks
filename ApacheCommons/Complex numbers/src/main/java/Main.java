import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;

public class Main {

	private static Complex[] solvequadeq_ex(double a, double b, double c) {
		Complex sqrtD = Complex.valueOf(Math.pow(b, 2) - 4 * a * c).sqrt();
		if (sqrtD.equals(Complex.ZERO)) {
			return new Complex[] {new Complex(-b / (2 * a))};
		} else {
			Complex xreal = Complex.valueOf((-b) / (2 * a));
			Complex x1 = xreal.add(sqrtD.divide(2 * a));
			Complex x2 = xreal.subtract(sqrtD.divide(2 * a));
			return new Complex[] {x1, x2};
		}
	}

	public static void main(String[] args) {
		double a = 1;
		double b = 4;
		double c = 5;
		System.out.printf("Equation: %f*x^2 + %f*x + %f = 0\n", a, b, c);
		Complex[] ret = solvequadeq_ex(a, b, c);
		System.out.println(ret.length + " solution(s) found");
		var fmter = new ComplexFormat();
		if (ret.length > 0)
			System.out.println("x1 = " + fmter.format(ret[0]));
		if (ret.length > 1)
			System.out.println("x2 = " + fmter.format(ret[1]));
	}
}