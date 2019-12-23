/*This is a java program to find shortest path between all vertices using FLoyd-Warshall’s algorithm. In computer science, the Floyd–Warshall algorithm (also known as Floyd’s algorithm, Roy–Warshall algorithm, Roy–Floyd algorithm, or the WFI algorithm) is a graph analysis algorithm for finding shortest paths in a weighted graph with positive or negative edge weights (but with no negative cycles, see below) and also for finding transitive closure of a relation R. A single execution of the algorithm will find the lengths (summed weights) of the shortest paths between all pairs of vertices, though it does not return details of the paths themselves.*/


import java.util.Scanner;

public class FloydWarshallShortestPath
{
    private int             distancematrix[][];
    private int             numberofvertices;
    public static final int INFINITY = 999;

    public FloydWarshallShortestPath(int numberofvertices)
    {
        distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
        this.numberofvertices = numberofvertices;
    }

    public void floydwarshall(int adjacencymatrix[][])
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
                                if (distancematrix[source][intermediate]
                                        + distancematrix[intermediate][destination] < distancematrix[source][destination])
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
        FloydWarshallShortestPath floydwarshall = new FloydWarshallShortestPath(
            numberofvertices);
        floydwarshall.floydwarshall(adjacency_matrix);
        scan.close();
    }
}

/*

Enter the number of vertices
6
Enter the Weighted Matrix for the graph
0 4 0 0 1 0
0 0 1 0 2 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 5 0 3
0 0 0 0 0 0
The Transitive Closure of the Graph (999 represents not reachable)
	1	2	3	4	5	6
1	0	4	5	6	1	4
2	999	0	1	7	2	5
3	999	999	0	999	999	999
4	999	999	999	0	999	999
5	999	999	999	5	0	3
6	999	999	999	999	999	0
