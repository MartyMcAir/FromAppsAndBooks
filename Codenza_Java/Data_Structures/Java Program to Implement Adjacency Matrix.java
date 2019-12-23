/*Java program to describe the implement Adjacency Matrix. The Adjacency Matrix is used to represent a graph.The adjacency matrix of a finite graph G on n vertices is the n × n matrix where the non-diagonal entry aij is the number of edges from vertex i to vertex j, and the diagonal entry aii, depending on the convention, is either once or twice the number of edges (loops) from vertex i to itself.*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdjacencyMatrix
{
    private final int MAX_NO_OF_VERTICES;
    private int adjacency_matrix[][];

    public AdjacencyMatrix(int number_of_vertices)
    {
        MAX_NO_OF_VERTICES = number_of_vertices;
        adjacency_matrix = new int[MAX_NO_OF_VERTICES + 1][MAX_NO_OF_VERTICES + 1];
    }

    public void setEdge(int from_vertex, int to_vertex, int edge)
    {
        try
            {
                adjacency_matrix[from_vertex][to_vertex] = edge;
            }
        catch (ArrayIndexOutOfBoundsException indexBounce)
            {
                System.out.println("the vertex entered is not present");
            }
    }

    public int getEdge(int from_vertex, int to_vertex)
    {
        try
            {
                return adjacency_matrix[from_vertex][to_vertex];
            }
        catch (ArrayIndexOutOfBoundsException indexBounce)
            {
                System.out.println("the vertex entered is not present")
            }
        return -1;
    }

    public static void main(String... arg)
    {
        int number_of_vertices, count = 1;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
        AdjacencyMatrix adjacencyMatrix;
        try
            {
                System.out.println("Enter the Number of Vertices");
                number_of_vertices = scan.nextInt();
                System.out.println("Enter the Number of Edges");
                int number_of_edges = scan.nextInt();
                adjacencyMatrix  = new AdjacencyMatrix(number_of_vertices);
                System.out.println("Enter The Graph Egdes :<source> <destination>");
                while (count <= number_of_edges)
                    {
                        source = scan.nextInt();
                        destination = scan.nextInt();
                        adjacencyMatrix.setEdge(source, destination, 1);
                        count++;
                    }
                System.out.println("The adjacency matrix for given graph is");
                for (int i = 1; i <= number_of_vertices; i++)
                    System.out.print(i);
                System.out.println();
                for (int i = 1; i <= number_of_vertices; i++)
                    {
                        System.out.print(i);
                        for (int j = 1; j <= number_of_vertices; j++)
                            {
                                System.out.print(adjacencyMatrix.getEdge(i, j));
                            }
                        System.out.println();
                    }
            }
        catch (InputMismatchException inputMisMatch)
            {
                System.out.println("Error in Input Format.<source index> <destination index>");
            }
        scan.close();
    }
}

/*
Enter the Number of Vertices and Edges
4 5
Enter The Graph Egdes Format : <source index> <destination index>

1 2
2 3
3 4
4 1
1 3

The adjacency matrix for given graph is

	1	2	3	4
1	0	1	1	0
2	0	0	1	0
3	0	0	0	1
4	1	0	0	0
