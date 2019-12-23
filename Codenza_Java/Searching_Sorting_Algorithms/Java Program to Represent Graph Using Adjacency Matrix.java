/*This is a java program to represent graph as a adjacency matrix. Nodes are arranged in matrix and at an index of i, j zero is displayed if nodes i and j are not connected, one otherwise.*/

//This is a java program to represent graph as a adjacency matrix
import java.util.Scanner;

public class Represent_Graph_Adjacency_Matrix
{
    private final int vertices;
    private int[][] adjacency_matrix;

    public Represent_Graph_Adjacency_Matrix(int v)
    {
        vertices = v;
        adjacency_matrix = new int[vertices + 1][vertices + 1];
    }

    public void makeEdge(int to, int from, int edge)
    {
        try
            {
                adjacency_matrix[to][from] = edge;
            }
        catch (ArrayIndexOutOfBoundsException index)
            {
                System.out.println("The vertices does not exists");
            }
    }

    public int getEdge(int to, int from)
    {
        try
            {
                return adjacency_matrix[to][from];
            }
        catch (ArrayIndexOutOfBoundsException index)
            {
                System.out.println("The vertices does not exists");
            }
        return -1;
    }

    public static void main(String args[])
    {
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        Represent_Graph_Adjacency_Matrix graph;
        try
            {
                System.out.println("Enter the number of vertices: ");
                v = sc.nextInt();
                System.out.println("Enter the number of edges: ");
                e = sc.nextInt();
                graph = new Represent_Graph_Adjacency_Matrix(v);
                System.out.println("Enter the edges: <to> <from>");
                while (count <= e)
                    {
                        to = sc.nextInt();
                        from = sc.nextInt();
                        graph.makeEdge(to, from, 1);
                        count++;
                    }
                System.out.println("The adjacency matrix for the given graph is: ");
                System.out.print("  ");
                for (int i = 1; i <= v; i++)
                    System.out.print(i + " ");
                System.out.println();
                for (int i = 1; i <= v; i++)
                    {
                        System.out.print(i + " ");
                        for (int j = 1; j <= v; j++)
                            System.out.print(graph.getEdge(i, j) + " ");
                        System.out.println();
                    }
            }
        catch (Exception E)
            {
                System.out.println("Somthing went wrong");
            }
        sc.close();
    }
}

/*
Enter the number of vertices:
5
Enter the number of edges:
7
Enter the edges: <to> <from>
1 1
2 3
3 4
4 5
3 5
1 4
2 4
The adjacency matrix for the given graph is:
  1 2 3 4 5
1 1 0 0 1 0
2 0 0 1 1 0
3 0 0 0 1 1
4 0 0 0 0 1
5 0 0 0 0 0
