/*This is a java program to implement Hungarian Algorithm for Bipartite Matching. The Hungarian method is a combinatorial optimization algorithm that solves the assignment problem in polynomial time and which anticipated later primal-dual methods.*/


import java.util.Arrays;
import java.util.Scanner;

public class HungarianBipartiteMatching
{
    private final double[][] costMatrix;
    private final int        rows, cols, dim;
    private final double[]   labelByWorker, labelByJob;
    private final int[]      minSlackWorkerByJob;
    private final double[]   minSlackValueByJob;
    private final int[]      matchJobByWorker, matchWorkerByJob;
    private final int[]      parentWorkerByCommittedJob;
    private final boolean[]  committedWorkers;

    public HungarianBipartiteMatching(double[][] costMatrix)
    {
        this.dim = Math.max(costMatrix.length, costMatrix[0].length);
        this.rows = costMatrix.length;
        this.cols = costMatrix[0].length;
        this.costMatrix = new double[this.dim][this.dim];
        for (int w = 0; w < this.dim; w++)
            {
                if (w < costMatrix.length)
                    {
                        if (costMatrix[w].length != this.cols)
                            {
                                throw new IllegalArgumentException("Irregular cost matrix");
                            }
                        this.costMatrix[w] = Arrays.copyOf(costMatrix[w], this.dim);
                    }
                else
                    {
                        this.costMatrix[w] = new double[this.dim];
                    }
            }
        labelByWorker = new double[this.dim];
        labelByJob = new double[this.dim];
        minSlackWorkerByJob = new int[this.dim];
        minSlackValueByJob = new double[this.dim];
        committedWorkers = new boolean[this.dim];
        parentWorkerByCommittedJob = new int[this.dim];
        matchJobByWorker = new int[this.dim];
        Arrays.fill(matchJobByWorker, -1);
        matchWorkerByJob = new int[this.dim];
        Arrays.fill(matchWorkerByJob, -1);
    }

    protected void computeInitialFeasibleSolution()
    {
        for (int j = 0; j < dim; j++)
            {
                labelByJob[j] = Double.POSITIVE_INFINITY;
            }
        for (int w = 0; w < dim; w++)
            {
                for (int j = 0; j < dim; j++)
                    {
                        if (costMatrix[w][j] < labelByJob[j])
                            {
                                labelByJob[j] = costMatrix[w][j];
                            }
                    }
            }
    }

    public int[] execute()
    {
        /*
         * Heuristics to improve performance: Reduce rows and columns by their
         * smallest element, compute an initial non-zero dual feasible solution
         * and
         * create a greedy matching from workers to jobs of the cost matrix.
         */
        reduce();
        computeInitialFeasibleSolution();
        greedyMatch();
        int w = fetchUnmatchedWorker();
        while (w < dim)
            {
                initializePhase(w);
                executePhase();
                w = fetchUnmatchedWorker();
            }
        int[] result = Arrays.copyOf(matchJobByWorker, rows);
        for (w = 0; w < result.length; w++)
            {
                if (result[w] >= cols)
                    {
                        result[w] = -1;
                    }
            }
        return result;
    }

    protected void executePhase()
    {
        while (true)
            {
                int minSlackWorker = -1, minSlackJob = -1;
                double minSlackValue = Double.POSITIVE_INFINITY;
                for (int j = 0; j < dim; j++)
                    {
                        if (parentWorkerByCommittedJob[j] == -1)
                            {
                                if (minSlackValueByJob[j] < minSlackValue)
                                    {
                                        minSlackValue = minSlackValueByJob[j];
                                        minSlackWorker = minSlackWorkerByJob[j];
                                        minSlackJob = j;
                                    }
                            }
                    }
                if (minSlackValue > 0)
                    {
                        updateLabeling(minSlackValue);
                    }
                parentWorkerByCommittedJob[minSlackJob] = minSlackWorker;
                if (matchWorkerByJob[minSlackJob] == -1)
                    {
                        /*
                         * An augmenting path has been found.
                         */
                        int committedJob = minSlackJob;
                        int parentWorker = parentWorkerByCommittedJob[committedJob];
                        while (true)
                            {
                                int temp = matchJobByWorker[parentWorker];
                                match(parentWorker, committedJob);
                                committedJob = temp;
                                if (committedJob == -1)
                                    {
                                        break;
                                    }
                                parentWorker = parentWorkerByCommittedJob[committedJob];
                            }
                        return;
                    }
                else
                    {
                        /*
                         * Update slack values since we increased the size of the
                         * committed
                         * workers set.
                         */
                        int worker = matchWorkerByJob[minSlackJob];
                        committedWorkers[worker] = true;
                        for (int j = 0; j < dim; j++)
                            {
                                if (parentWorkerByCommittedJob[j] == -1)
                                    {
                                        double slack = costMatrix[worker][j]
                                                       - labelByWorker[worker] - labelByJob[j];
                                        if (minSlackValueByJob[j] > slack)
                                            {
                                                minSlackValueByJob[j] = slack;
                                                minSlackWorkerByJob[j] = worker;
                                            }
                                    }
                            }
                    }
            }
    }

    protected int fetchUnmatchedWorker()
    {
        int w;
        for (w = 0; w < dim; w++)
            {
                if (matchJobByWorker[w] == -1)
                    {
                        break;
                    }
            }
        return w;
    }

    protected void greedyMatch()
    {
        for (int w = 0; w < dim; w++)
            {
                for (int j = 0; j < dim; j++)
                    {
                        if (matchJobByWorker[w] == -1
                                && matchWorkerByJob[j] == -1
                                && costMatrix[w][j] - labelByWorker[w] - labelByJob[j] == 0)
                            {
                                match(w, j);
                            }
                    }
            }
    }

    protected void initializePhase(int w)
    {
        Arrays.fill(committedWorkers, false);
        Arrays.fill(parentWorkerByCommittedJob, -1);
        committedWorkers[w] = true;
        for (int j = 0; j < dim; j++)
            {
                minSlackValueByJob[j] = costMatrix[w][j] - labelByWorker[w]
                                        - labelByJob[j];
                minSlackWorkerByJob[j] = w;
            }
    }

    protected void match(int w, int j)
    {
        matchJobByWorker[w] = j;
        matchWorkerByJob[j] = w;
    }

    protected void reduce()
    {
        for (int w = 0; w < dim; w++)
            {
                double min = Double.POSITIVE_INFINITY;
                for (int j = 0; j < dim; j++)
                    {
                        if (costMatrix[w][j] < min)
                            {
                                min = costMatrix[w][j];
                            }
                    }
                for (int j = 0; j < dim; j++)
                    {
                        costMatrix[w][j] -= min;
                    }
            }
        double[] min = new double[dim];
        for (int j = 0; j < dim; j++)
            {
                min[j] = Double.POSITIVE_INFINITY;
            }
        for (int w = 0; w < dim; w++)
            {
                for (int j = 0; j < dim; j++)
                    {
                        if (costMatrix[w][j] < min[j])
                            {
                                min[j] = costMatrix[w][j];
                            }
                    }
            }
        for (int w = 0; w < dim; w++)
            {
                for (int j = 0; j < dim; j++)
                    {
                        costMatrix[w][j] -= min[j];
                    }
            }
    }

    protected void updateLabeling(double slack)
    {
        for (int w = 0; w < dim; w++)
            {
                if (committedWorkers[w])
                    {
                        labelByWorker[w] += slack;
                    }
            }
        for (int j = 0; j < dim; j++)
            {
                if (parentWorkerByCommittedJob[j] != -1)
                    {
                        labelByJob[j] -= slack;
                    }
                else
                    {
                        minSlackValueByJob[j] -= slack;
                    }
            }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimentsions of the cost matrix: ");
        System.out.println("r:");
        int r = sc.nextInt();
        System.out.println("c:");
        int c = sc.nextInt();
        System.out.println("Enter the cost matrix: <row wise>");
        double[][] cost = new double[r][c];
        for (int i = 0; i < r; i++)
            {
                for (int j = 0; j < c; j++)
                    {
                        cost[i][j] = sc.nextDouble();
                    }
            }
        HungarianBipartiteMatching hbm = new HungarianBipartiteMatching(cost);
        int[] result = hbm.execute();
        System.out.println("Bipartite Matching: " + Arrays.toString(result));
        sc.close();
    }
}

/*
Enter the dimentsions of the cost matrix:
r: 4
c: 4
Enter the cost matrix: <row wise>
82 	83 	69 	92
77 	37 	49 	92
11 	69 	5 	86
8 	9 	98 	23
Bipartite Matching: [2, 1, 0, 3] //worker 1 should perform job 3, worker 2 should perform job 2 and so on...
