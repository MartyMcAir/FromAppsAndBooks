/*This Java program,to find the single source shortest path in directed acyclic graph by Dijkstra’s algorithm.Dijkstra’s algorithm is a graph search algorithm that solves the single-source shortest path problem for a graph with non-negative edge path costs, producing a shortest path tree.*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class DijkstraShortestPath
{
    private boolean settled[];
    private boolean unsettled[];
    private int distances[];
    private int adjacencymatrix[][];
    private int numberofvertices;

    public DijkstraShortestPath(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        this.settled = new boolean[numberofvertices + 1];
        this.unsettled = new boolean[numberofvertices + 1];
        this.distances = new int[numberofvertices + 1];
        this.adjacencymatrix = new int[numberofvertices + 1][numberofvertices + 1];
    }

    public void dijkstraShortestPath(int source, int adjacencymatrix[][])
    {
        int evaluationnode;
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
            {
                distances[vertex] = Integer.MAX_VALUE;
            }
        for (int sourcevertex = 1; sourcevertex <= numberofvertices; sourcevertex++)
            {
                for (int destinationvertex = 1; destinationvertex <= numberofvertices; destinationvertex++)
                    {
                        this.adjacencymatrix[sourcevertex][destinationvertex]
                            = adjacencymatrix[sourcevertex][destinationvertex];
                    }
            }
        unsettled[source] = true;
        distances[source] = 0;
        while (getUnsettledCount(unsettled) != 0)
            {
                evaluationnode = getNodeWithMinimumDistanceFromUnsettled(unsettled);
                unsettled[evaluationnode] = false;
                settled[evaluationnode] = true;
                evaluateNeighbours(evaluationnode);
            }
    }

    public int getUnsettledCount(boolean unsettled[])
    {
        int count = 0;
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
            {
                if (unsettled[vertex] == true)
                    {
                        count++;
                    }
            }
        return count;
    }

    public int getNodeWithMinimumDistanceFromUnsettled(boolean unsettled[])
    {
        int min = Integer.MAX_VALUE;
        int node = 0;
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
            {
                if (unsettled[vertex] == true && distances[vertex] < min)
                    {
                        node = vertex;
                        min = distances[vertex];
                    }
            }
        return node;
    }

    public void evaluateNeighbours(int evaluationNode)
    {
        int edgeDistance = -1;
        int newDistance = -1;
        for (int destinationNode = 1; destinationNode <= numberofvertices; destinationNode++)
            {
                if (settled[destinationNode] == false)
                    {
                        if (adjacencymatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                            {
                                edgeDistance = adjacencymatrix[evaluationNode][destinationNode];
                                newDistance = distances[evaluationNode] + edgeDistance;
                                if (newDistance < distances[destinationNode])
                                    {
                                        distances[destinationNode] = newDistance;
                                    }
                                unsettled[destinationNode] = true;
                            }
                    }
            }
    }

    public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        int source = 0;
        Scanner scan = new Scanner(System.in);
        try
            {
                System.out.println("Enter the number of vertices");
                number_of_vertices = scan.nextInt();
                adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];
                System.out.println("Enter the Weighted Matrix for the graph");
                for (int i = 1; i <= number_of_vertices; i++)
                    {
                        for (int j = 1; j <= number_of_vertices; j++)
                            {
                                adjacency_matrix[i][j] = scan.nextInt();
                                if (i == j)
                                    {
                                        adjacency_matrix[i][j] = 0;
                                        continue;
                                    }
                                if (adjacency_matrix[i][j] == 0)
                                    {
                                        adjacency_matrix[i][j] =  Integer.MAX_VALUE;
                                    }
                            }
                    }
                System.out.println("Enter the source ");
                source = scan.nextInt();
                DijkstraShortestPath dijkstrasAlgorithm = new DijkstraShortestPath(number_of_vertices);
                dijkstrasAlgorithm.dijkstraShortestPath(source, adjacency_matrix);
                System.out.println("The Shorted Path to all nodes are ");
                for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)
                    {
                        System.out.println(source + " to " + i + " is "+ dijkstrasAlgorithm.distances[i]);
                    }
            }
        catch (InputMismatchException inputMismatch)
            {
                System.out.println("Wrong Input Format");
            }
        scan.close();
    }
}

/*
Enter the number of vertices
5
Enter the Weighted Matrix for the graph
0 9 6 5 3
0 0 0 0 0
0 2 0 4 0
0 0 0 0 0
0 0 0 0 0
Enter the source
1
The Shorted Path to all nodes are
1 to 1 is 0
1 to 2 is 8
1 to 3 is 6
1 to 4 is 5
1 to 5 is 3
