import java.util.InputMismatchException;
import java.util.Scanner;

public class GraphIncidenceMatrix
{
    private final int MAX_ROWS ;
    private final int MAX_COLUMS;
    private int Incidence_Matrix[][];

    public GraphIncidenceMatrix(int number_of_vertices, int number_of_edges)
    {
        MAX_COLUMS = number_of_edges;
        MAX_ROWS = number_of_vertices;
        Incidence_Matrix = new int[MAX_ROWS + 1][MAX_COLUMS + 1];
    }

    public void setVertices(int from_vertex, int to_vertex, int edge, int edge_num)
    {
        try
            {
                Incidence_Matrix[from_vertex][edge_num] = edge;
                Incidence_Matrix[to_vertex][edge_num] = edge;
            }
        catch(ArrayIndexOutOfBoundsException indexBounce)
            {
                System.out.println("the vertex entered is not present");
            }
    }

    public int  getVertices(int edge_num, int vertex)
    {
        try
            {
                return Incidence_Matrix[vertex][edge_num];
            }
        catch(ArrayIndexOutOfBoundsException indexBounce)
            {
                System.out.println("the vertex entered is not present");
            }
        return -1;
    }

    public static void main(String...arg)
    {
        int number_of_vertices;
        int number_of_edges;
        int edge_count = 1;
        int edge_number ;
        int source;
        int destination;
        GraphIncidenceMatrix incedenceMatrix = null;
        Scanner scan = new Scanner(System.in);
        try
            {
                System.out.println("Enter The Number Of Vertices and Edges \n");
                number_of_vertices = scan.nextInt();
                number_of_edges = scan.nextInt();
                incedenceMatrix = new GraphIncidenceMatrix(number_of_vertices, number_of_edges);
                System.out.println("Enter the Egdes Format :<edge-number> <source index> <destination index> \n");
                while (edge_count <= number_of_edges)
                    {
                        edge_number = scan.nextInt();
                        source = scan.nextInt();
                        destination = scan.nextInt();
                        edge_count++;
                        incedenceMatrix.setVertices(source, destination, 1, edge_number);
                    }
                System.out.println("The Incendence Matrix for the given graph is ");
                for (int i = 1; i <= number_of_edges; i++)
                    {
                        System.out.print("\t" + i);
                    }
                System.out.println();
                for (int i = 1; i <= number_of_vertices; i++)
                    {
                        System.out.print(i + "\t");
                        for (int j = 1; j<= number_of_edges; j++)
                            {
                                System.out.print(incedenceMatrix.getVertices(j, i) + "\t");
                            }
                        System.out.println();
                    }
            }
        catch(InputMismatchException inputMismatch)
            {
                System.out.println("the vertex entered is not present");
            }
        scan.close();
    }
}

/*
Enter The Number Of Vertices and Edges
4 5
Enter the Egdes Format :<edge-number> <source index> <destination index>

1 1 2
2 2 3
3 3 4
4 4 1
5 1 3
The Incendence Matrix for the given graph is
    1   2   3   4   5
1   1   0   0   1   1
2   1   1   0   0   0
3   0   1   1   0   1
4   0   0   1   1   0
