/*This is a Java Program to find nearest neighbor using linear search. The simplest solution to the NNS problem is to compute the distance from the query point to every other point in the database, keeping track of the “best so far”. This algorithm, sometimes referred to as the naive approach, has a running time of O(Nd) where N is the cardinality of S and d is the dimensionality of M. There are no search data structures to maintain, so linear search has no space complexity beyond the storage of the database. Naive search can, on average, outperform space partitioning approaches on higher dimensional spaces.*/

//This is a java program to find nearest neighbor using a simple linear search
import java.util.Random;
import java.util.Scanner;

public class Linear_Search_Nearest
{
    public static void main(String args[])
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int datasetSize = 10;
        double[][] data = new double[10][2];
        for (int i = 0; i < datasetSize; i++)
            for (int j = 0; j < 2; j++)
                data[i][j] = random.nextDouble() * 10;
        System.out.println("Randomly generated Data set: ");
        for (int i = 0; i < datasetSize; i++)
            for (int j = 0; j < 2; j++)
                System.out.println(data[i][j++] + " ," + data[i][j]);
        System.out.println();
        System.out.println("Enter the co-ordinates of the point: <x> <y>");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double xmin = data[0][0], ymin = data[0][1], xclose = 0, yclose = 0;
        for (int i = 0; i < datasetSize; i++)
            {
                if (Math.abs(data[i][0] - x) < xmin)
                    {
                        xmin = data[i][0] - x;
                        xclose = data[i][0];
                    }
            }
        for (int i = 0; i < datasetSize; i++)
            {
                if (Math.abs(data[i][1] - y) < ymin)
                    {
                        ymin = data[i][1] - x;
                        yclose = data[i][1];
                    }
            }
        System.out.println("The nearest neighbor is : (" + xclose + ", "
                           + yclose + ")");
        sc.close();
    }
}
/*
Randomly generated Data set:
3.171455377670047 ,1.052119263026371
3.949033565232699 ,8.565344250655025
0.0208421026579253 ,5.963319480178625
5.9198056196163495 ,4.424992495072658
6.083654323496389 ,2.592835352360611
5.996752857974297 ,2.1046723166354777
3.165362843381636 ,5.1640243122381415
4.175425572150399 ,2.965443123350698
8.734700795907905 ,3.3650152184786064
5.5317982332184235 ,1.5076066489140683

Enter the co-ordinates of the point: <x> <y>
1 2
The nearest neighbor is : (0.0208421026579253, 1.052119263026371)
