/*This Java program is to find all pairs shortest path.This program finds the shortest distance between every pair of vertex in the graph.*/

import java.util.Scanner;

public class AllPairShortestPath
{
    private int distancematrix[][];
    private int numberofvertices;
    public static final int INFINITY = 999;

    public AllPairShortestPath(int numberofvertices)
    {
        distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
        this.numberofvertices = numberofvertices;
    }

    public void allPairShortestPath(int adjacencymatrix[][])
    {
        for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                    {
                        distancematrix[source][destination] = adjacencymatrix[source][destination];
                    }
            }
        for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
            {
                for (int source = 1; source <= numberofvertices; source++)
                    {
                        for (int destination = 1; destination <= numberofvertices; destination++)
                            {
                                if (distancematrix[source][intermediate] + distancematrix[intermediate][destination]
                                        < distancematrix[source][destination])
                                    distancematrix[source][destination] = distancematrix[source][intermediate]
                                                                          + distancematrix[intermediate][destination];
                            }
                    }
            }
        for (int source = 1; source <= numberofvertices; source++)
            System.out.print("\t" + source);
        System.out.println();
        for (int source = 1; source <= numberofvertices; source++)
            {
                System.out.print(source + "\t");
                for (int destination = 1; destination <= numberofvertices; destination++)
                    {
                        System.out.print(distancematrix[source][destination] + "\t");
                    }
                System.out.println();
            }
    }

    public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int numberofvertices;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        numberofvertices = scan.nextInt();
        adjacency_matrix = new int[numberofvertices + 1][numberofvertices + 1];
        System.out.println("Enter the Weighted Matrix for the graph");
        for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                    {
                        adjacency_matrix[source][destination] = scan.nextInt();
                        if (source == destination)
                            {
                                adjacency_matrix[source][destination] = 0;
                                continue;
                            }
                        if (adjacency_matrix[source][destination] == 0)
                            {
                                adjacency_matrix[source][destination] = INFINITY;
                            }
                    }
            }
        System.out.println("The Transitive Closure of the Graph");
        AllPairShortestPath allPairShortestPath= new AllPairShortestPath(numberofvertices);
        allPairShortestPath.allPairShortestPath(adjacency_matrix);
        scan.close();
    }
}

/*
Enter the number of vertices
4

Enter the Weighted Matrix for the graph
0 0 3 0
2 0 0 0
0 7 0 1
6 0 0 0

The Transitive Closure of the Graph

	1	2	3	4
1	0	10	3	4
2	2	0	5	6
3	7	7	0	1
4	6	16	9	0
