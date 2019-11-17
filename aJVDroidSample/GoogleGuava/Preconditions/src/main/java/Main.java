import com.google.common.base.Preconditions;

public class Main {

	public static double sqrt_checked(double v) {
		Preconditions.checkArgument(v >= 0, "negative number provided to sqrt_checked " + v);
		return Math.sqrt(v);
	}

	public static void main(String[] args) {
		for (var i : new double[] {1., 4., 9., -1.})
			System.out.println(String.format("Sqrt of %s is %s", i, sqrt_checked(i)));
	}
}