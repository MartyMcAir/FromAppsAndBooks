/*This is a Java Program to implement Lloyd’s Algorithm. The LBG-algorithm or Lloyd’s algorithm allows clustering of vectors of any dimension. This is helpful for example for image classification when using the SIFT or SURF algorithms. It might be also useful if you want to cluster a large amount of points on a map.*/

//This is a java program to implement Lloyd’s Algorithm
import java.util.ArrayList;

public class GenLloyd
{
    protected double[][] samplePoints;
    protected double[][] clusterPoints;

    int[] pointApproxIndices;
    int pointDimension = 0;
    protected double epsilon = 0.0005;
    protected double avgDistortion = 0.0;

    /**
     * Create Generalized Lloyd object with an array of sample points
     */
    public GenLloyd(double[][] samplePoints)
    {
        this.setSamplePoints(samplePoints);
    }

    /**
     * Return epsilon parameter (accuracy)
     */
    public double getEpsilon()
    {
        return epsilon;
    }

    /**
     * Set epsilon parameter (accuracy). Should be a small number 0.0 < epsilon
     * < 0.1
     */
    public void setEpsilon(double epsilon)
    {
        this.epsilon = epsilon;
    }

    /**
     * Set array of sample points
     */
    public void setSamplePoints(double[][] samplePoints)
    {
        if (samplePoints.length > 0)
            {
                this.samplePoints = samplePoints;
                this.pointDimension = samplePoints[0].length;
            }
    }

    /**
     * Get array of sample points
     */
    public double[][] getSamplePoints()
    {
        return samplePoints;
    }

    /**
     * Get calculated cluster points. <numClusters> cluster points will be
     * calculated and returned
     */
    public double[][] getClusterPoints(int numClusters)
    {
        this.calcClusters(numClusters);
        return clusterPoints;
    }

    protected void calcClusters(int numClusters)
    {
        // initialize with first cluster
        clusterPoints = new double[1][pointDimension];
        double[] newClusterPoint = initializeClusterPoint(samplePoints);
        clusterPoints[0] = newClusterPoint;
        if (numClusters > 1)
            {
                // calculate initial average distortion
                avgDistortion = 0.0;
                for (double[] samplePoint : samplePoints)
                    {
                        avgDistortion += calcDist(samplePoint, newClusterPoint);
                    }
                avgDistortion /= (double) (samplePoints.length * pointDimension);
                // set up array of point approximization indices
                pointApproxIndices = new int[samplePoints.length];
                // split the clusters
                int i = 1;
                do
                    {
                        i = splitClusters();
                    }
                while (i < numClusters);
            }
    }

    protected int splitClusters()
    {
        int newClusterPointSize = 2;
        if (clusterPoints.length != 1)
            {
                newClusterPointSize = clusterPoints.length * 2;
            }
        // split clusters
        double[][] newClusterPoints = new double[newClusterPointSize][pointDimension];
        int newClusterPointIdx = 0;
        for (double[] clusterPoint : clusterPoints)
            {
                newClusterPoints[newClusterPointIdx] = createNewClusterPoint(
                        clusterPoint, -1);
                newClusterPoints[newClusterPointIdx + 1] = createNewClusterPoint(
                            clusterPoint, +1);
                newClusterPointIdx += 2;
            }
        clusterPoints = newClusterPoints;
        // iterate to approximate cluster points
        // int iteration = 0;
        double curAvgDistortion = 0.0;
        do
            {
                curAvgDistortion = avgDistortion;
                // find the min values
                for (int pointIdx = 0; pointIdx < samplePoints.length; pointIdx++)
                    {
                        double minDist = Double.MAX_VALUE;
                        for (int clusterPointIdx = 0; clusterPointIdx < clusterPoints.length; clusterPointIdx++)
                            {
                                double newMinDist = calcDist(samplePoints[pointIdx],
                                                             clusterPoints[clusterPointIdx]);
                                if (newMinDist < minDist)
                                    {
                                        minDist = newMinDist;
                                        pointApproxIndices[pointIdx] = clusterPointIdx;
                                    }
                            }
                    }
                // update codebook
                for (int clusterPointIdx = 0; clusterPointIdx < clusterPoints.length; clusterPointIdx++)
                    {
                        double[] newClusterPoint = new double[pointDimension];
                        int num = 0;
                        for (int pointIdx = 0; pointIdx < samplePoints.length; pointIdx++)
                            {
                                if (pointApproxIndices[pointIdx] == clusterPointIdx)
                                    {
                                        addPointValues(newClusterPoint, samplePoints[pointIdx]);
                                        num++;
                                    }
                            }
                        if (num > 0)
                            {
                                multiplyPointValues(newClusterPoint, 1.0 / (double) num);
                                clusterPoints[clusterPointIdx] = newClusterPoint;
                            }
                    }
                // update average distortion
                avgDistortion = 0.0;
                for (int pointIdx = 0; pointIdx < samplePoints.length; pointIdx++)
                    {
                        avgDistortion += calcDist(samplePoints[pointIdx],
                                                  clusterPoints[pointApproxIndices[pointIdx]]);
                    }
                avgDistortion /= (double) (samplePoints.length * pointDimension);
            }
        while (((curAvgDistortion - avgDistortion) / curAvgDistortion) > epsilon);
        return clusterPoints.length;
    }

    protected double[] initializeClusterPoint(double[][] pointsInCluster)
    {
        // calculate point sum
        double[] clusterPoint = new double[pointDimension];
        for (int numPoint = 0; numPoint < pointsInCluster.length; numPoint++)
            {
                addPointValues(clusterPoint, pointsInCluster[numPoint]);
            }
        // calculate average
        multiplyPointValues(clusterPoint, 1.0 / (double) pointsInCluster.length);
        return clusterPoint;
    }

    protected double[] createNewClusterPoint(double[] clusterPoint,
            int epsilonFactor)
    {
        double[] newClusterPoint = new double[pointDimension];
        addPointValues(newClusterPoint, clusterPoint);
        multiplyPointValues(newClusterPoint, 1.0 + (double) epsilonFactor
                            * epsilon);
        return newClusterPoint;
    }

    protected double calcDist(double[] v1, double[] v2)
    {
        double distSum = 0.0;
        for (int pointIdx = 0; pointIdx < v1.length; pointIdx++)
            {
                double absDist = Math.abs(v1[pointIdx] - v2[pointIdx]);
                distSum += absDist * absDist;
            }
        return distSum;
    }

    protected void addPointValues(double[] v1, double[] v2)
    {
        for (int pointIdx = 0; pointIdx < v1.length; pointIdx++)
            {
                v1[pointIdx] += v2[pointIdx];
            }
    }

    protected void multiplyPointValues(double[] v1, double f)
    {
        for (int pointIdx = 0; pointIdx < v1.length; pointIdx++)
            {
                v1[pointIdx] *= f;
            }
    }

    public static void main(String[] args)
    {
        ArrayList<double[]> points = new ArrayList<double[]>();
        // points.add(arrayOf(-1.5, -1.5));
        points.add(arrayOf(-1.5, 2.0, 5.0));
        points.add(arrayOf(-2.0, -2.0, 0.0));
        points.add(arrayOf(1.0, 1.0, 2.0));
        points.add(arrayOf(1.5, 1.5, 1.2));
        points.add(arrayOf(1.0, 2.0, 5.6));
        points.add(arrayOf(1.0, -2.0, -2.0));
        points.add(arrayOf(1.0, -3.0, -2.0));
        points.add(arrayOf(1.0, -2.5, -4.5));
        GenLloyd gl = new GenLloyd(points.toArray(new double[points.size()][2]));
        double[][] results = gl.getClusterPoints(4);
        for (double[] point : results)
            {
                System.out.println("Cluster " + point[0] + ", " + point[1] + ", "
                                   + point[2]);
            }
    }

    private static double[] arrayOf(double x, double y, double z)
    {
        double[] a = new double[3];
        a[0] = x;
        a[1] = y;
        a[2] = z;
        return a;
    }
}

/*
Cluster -2.0, -2.0, 0.0
Cluster 1.0, -2.5, -2.833333333333333
Cluster 1.25, 1.25, 1.6
Cluster -0.25, 2.0, 5.3
