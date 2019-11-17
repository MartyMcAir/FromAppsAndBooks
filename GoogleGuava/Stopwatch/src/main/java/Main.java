import com.google.common.base.Stopwatch;
import com.google.common.math.BigIntegerMath;

public class Main {

	public static void slowFunction() {
		// Could be any time-consuming function
		BigIntegerMath.factorial(100000);
	}

	public static void main(String[] args) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		slowFunction();
		stopwatch.stop();
		System.out.println("slowFunction took " + stopwatch);
	}
}