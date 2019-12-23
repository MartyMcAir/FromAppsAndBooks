/*This Java program,finds the transpose of graph matrix.In the mathematical and algorithmic study of graph theory, the converse,[1] transpose[2] or reverse[3] of a directed graph G is another directed graph on the same set of vertices with all of the edges reversed compared to the orientation of the corresponding edges in G. That is, if G contains an edge (u,v) then the converse/transpose/reverse of G contains an edge (v,u) and vice versa.*/

import java.util.Scanner;

public class TransposeOfGraph
{
    private int transposeMatrix[][];
    private int numberOfVertices;

    public TransposeOfGraph(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        transposeMatrix = new int[numberOfVertices + 1][numberOfVertices + 1];
    }

    public int[][] transpose(int adjacencyMatrix[][])
    {
        for (int source = 1; source <= numberOfVertices; source++)
            {
                for (int destination = 1; destination <= numberOfVertices; destination++)
                    {
                        transposeMatrix[source][destination] = adjacencyMatrix[destination][source];
                    }
            }
        return transposeMatrix;
    }

    public static void main(String... arg)
    {
        int number_of_nodes;
        Scanner scanner = null;
        System.out.println("Enter the number of nodes in the graph");
        scanner = new Scanner(System.in);
        number_of_nodes = scanner.nextInt();
        int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
        int transpose_matrix[][];
        System.out.println("Enter the adjacency matrix");
        for (int i = 1; i <= number_of_nodes; i++)
            for (int j = 1; j <= number_of_nodes; j++)
                adjacency_matrix[i][j] = scanner.nextInt();
        TransposeOfGraph transposeOfGraph = new TransposeOfGraph(number_of_nodes);
        transpose_matrix = transposeOfGraph.transpose(adjacency_matrix);
        System.out.println("The transpose of the given graph");
        for (int i = 1; i <= number_of_nodes; i++)
            System.out.print("\t" + i);
        System.out.println();
        for (int source = 1; source <= number_of_nodes; source++)
            {
                System.out.print(source +"\t");
                for (int destination = 1; destination <= number_of_nodes; destination++)
                    {
                        System.out.print(transpose_matrix[source][destination] + "\t");
                    }
                System.out.println();
            }
        scanner.close();
    }
}

/*
Enter the number of nodes in the graph
4
Enter the adjacency matrix
0 0 3 0
2 0 0 0
0 7 0 1
6 0 0 0
The transpose of the given graph
	1	2	3	4
1	0	2	0	6
2	0	0	7	0
3	3	0	0	0
4	0	0	1	0
