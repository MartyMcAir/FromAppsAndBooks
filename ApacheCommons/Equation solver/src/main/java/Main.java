import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver;

public class Main {
	public static void main(String[] args) {
		UnivariateFunction function = x -> Math.pow(x, 2) - x - 1;
		var solver = new BracketingNthOrderBrentSolver();
		var root = solver.solve(100, function, 0, 100, AllowedSolution.ANY_SIDE);
		System.out.println("Approximate root for the given function is " + root);
	}
}