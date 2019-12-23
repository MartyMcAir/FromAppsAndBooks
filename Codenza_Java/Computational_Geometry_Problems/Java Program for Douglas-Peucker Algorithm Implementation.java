/*This is a Java Program to implement Douglas-Peucker Algorithm. The Ramer–Douglas–Peucker algorithm (RDP) is an algorithm for reducing the number of points in a curve that is approximated by a series of points. This algorithm is also known under the names Douglas–Peucker algorithm, iterative end-point fit algorithm and split-and-merge algorithm. The purpose of the algorithm is, given a curve composed of line segments, to find a similar curve with fewer points. The algorithm defines ‘dissimilar’ based on the maximum distance between the original curve and the simplified curve. The simplified curve consists of a subset of the points that defined the original curve.*/

//This is a java program to filter out points using Douglas Peucker Algorithm
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Random;

class RamerDouglasPeuckerFilter
{

    private double epsilon;

    public RamerDouglasPeuckerFilter(double epsilon)
    {
        if (epsilon <= 0)
            {
                throw new IllegalArgumentException("Epsilon nust be > 0");
            }
        this.epsilon = epsilon;
    }

    public double[] filter(double[] data)
    {
        return ramerDouglasPeuckerFunction(data, 0, data.length - 1);
    }

    public double getEpsilon()
    {
        return epsilon;
    }

    protected double[] ramerDouglasPeuckerFunction(double[] points,
            int startIndex, int endIndex)
    {
        double dmax = 0;
        int idx = 0;
        double a = endIndex - startIndex;
        double b = points[endIndex] - points[startIndex];
        double c = -(b * startIndex - a * points[startIndex]);
        double norm = sqrt(pow(a, 2) + pow(b, 2));
        for (int i = startIndex + 1; i < endIndex; i++)
            {
                double distance = abs(b * i - a * points[i] + c) / norm;
                if (distance > dmax)
                    {
                        idx = i;
                        dmax = distance;
                    }
            }
        if (dmax >= epsilon)
            {
                double[] recursiveResult1 = ramerDouglasPeuckerFunction(points,
                                            startIndex, idx);
                double[] recursiveResult2 = ramerDouglasPeuckerFunction(points,
                                            idx, endIndex);
                double[] result = new double[(recursiveResult1.length - 1)
                                             + recursiveResult2.length];
                System.arraycopy(recursiveResult1, 0, result, 0,
                                 recursiveResult1.length - 1);
                System.arraycopy(recursiveResult2, 0, result,
                                 recursiveResult1.length - 1, recursiveResult2.length);
                return result;
            }
        else
            {
                return new double[] { points[startIndex], points[endIndex] };
            }
    }

    public void setEpsilon(double epsilon)
    {
        if (epsilon <= 0)
            {
                throw new IllegalArgumentException("Epsilon nust be > 0");
            }
        this.epsilon = epsilon;
    }

}

public class Douglas_Peucker_Algorithm
{
    public static void main(String args[])
    {
        Random random = new Random();
        double[] points = new double[20];
        double[] fpoints;
        for (int i = 0; i < points.length; i++)
            points[i] = random.nextInt(10);
        RamerDouglasPeuckerFilter rdpf = new RamerDouglasPeuckerFilter(1);
        fpoints = rdpf.filter(points);
        System.out.println("Orginal points");
        for (int i = 0; i < points.length; i++)
            System.out.print(points[i] + " ");
        System.out.println("\nFiltered points");
        for (int i = 0; i < fpoints.length; i++)
            System.out.print(fpoints[i] + " ");
    }
}

/*
Orginal points
5.0 0.0 8.0 7.0 2.0 9.0 4.0 4.0 0.0 7.0 4.0 1.0 9.0 6.0 8.0 9.0 6.0 6.0 9.0 6.0
Filtered points
5.0 0.0 8.0 2.0 9.0 0.0 7.0 1.0 9.0 6.0 9.0 6.0 9.0 6.0
