/*This Java program is to find the transitive closure of a graph.Given a directed graph, find out if a vertex j is reachable from another vertex i for all vertex pairs (i, j) in the given graph. Here reachable mean that there is a path from vertex i to j. The reach-ability matrix is called transitive closure of a graph.*/

import java.util.Scanner;

public class TransitiveClosure
{
    private int transitiveMatrix[][];
    private int numberofvertices;
    public static final int INFINITY = 999;

    public TransitiveClosure(int numberofvertices)
    {
        transitiveMatrix= new int[numberofvertices + 1][numberofvertices + 1];
        this.numberofvertices = numberofvertices;
    }

    public void transitiveClosure(int adjacencymatrix[][])
    {
        for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                    {
                        transitiveMatrix[source][destination] = adjacencymatrix[source][destination];
                    }
            }
        for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
            {
                for (int source = 1; source <= numberofvertices; source++)
                    {
                        for (int destination = 1; destination <= numberofvertices; destination++)
                            {
                                if (transitiveMatrix[source][intermediate] + transitiveMatrix[intermediate][destination]
                                        < transitiveMatrix[source][destination])
                                    transitiveMatrix[source][destination] = transitiveMatrix[source][intermediate]
                                                                            + transitiveMatrix[intermediate][destination];
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
                        System.out.print(transitiveMatrix[source][destination] + "\t");
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
        TransitiveClosure transitiveClosure = new TransitiveClosure(numberofvertices);
        transitiveClosure.transitiveClosure(adjacency_matrix);
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
