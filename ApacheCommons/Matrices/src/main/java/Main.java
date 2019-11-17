import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealMatrixFormat;

public class Main {
	public static void main(String[] args) {
		var fmter = new RealMatrixFormat();
		RealMatrix A = new Array2DRowRealMatrix(new double[][] {
			{ 1, 2 , 3 },
			{ 0, 1 , 5 },
			{ 5, 6, 0 }
		});
		RealMatrix B = new Array2DRowRealMatrix(new double[][] {
			{ 1, 0 , 0 },
			{ 0, 1 , 0 },
			{ 0, 0 , 1}
		});
		System.out.println("A: " + fmter.format(A));
		System.out.println("B: " + fmter.format(B));
		DecompositionSolver solver = new LUDecomposition(A).getSolver();
		System.out.println("AX = B solution: " + fmter.format(solver.solve(B)));
	}
}