/*This Java program is to check whether graph is bipartite using dfs. In the mathematical field of graph theory, a bipartite graph (or bigraph) is a graph whose vertices can be divided into two disjoint sets and such that every edge connects a vertex in to one in that is, and are each independent sets. Equivalently, a bipartite graph is a graph that does not contain any odd-length cycles.*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class BipartiteDfs
{
    private int numberOfVertices;
    private Stack<Integer> stack;

    public static final int NO_COLOR = 0;
    public static final int RED = 1;
    public static final int BLUE = 2;

    public BipartiteDfs(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        stack = new Stack<Integer>();
    }

    public boolean isBipartite(int adjacencyMartix[][], int source)
    {
        int[] colored = new int[numberOfVertices + 1];
        for (int vertex = 1; vertex <= numberOfVertices; vertex++)
            {
                colored[vertex] = NO_COLOR;
            }
        stack.push(source);
        colored[source] = RED;
        int element = source;
        int neighbours = source;
        while (!stack.empty())
            {
                element = stack.peek();
                neighbours = element;
                while (neighbours <= numberOfVertices)
                    {
                        if (adjacencyMartix[element][neighbours] == 1&& colored[neighbours] == colored[element])
                            {
                                return false;
                            }
                        if (adjacencyMartix[element][neighbours] == 1 && colored[neighbours] == NO_COLOR)
                            {
                                colored[neighbours] = (colored[element] == RED) ? BLUE : RED;
                                stack.push(neighbours);
                                element = neighbours;
                                neighbours = 1;
                                continue;
                            }
                        neighbours++;
                    }
                stack.pop();
            }
        return true;
    }

    public static void main(String... arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
        try
            {
                System.out.println("Enter the number of nodes in the graph");
                scanner = new Scanner(System.in);
                number_of_nodes = scanner.nextInt();
                int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
                System.out.println("Enter the adjacency matrix");
                for (int i = 1; i <= number_of_nodes; i++)
                    {
                        for (int j = 1; j <= number_of_nodes; j++)
                            {
                                adjacency_matrix[i][j] = scanner.nextInt();
                            }
                    }
                for (int i = 1; i <= number_of_nodes; i++)
                    {
                        for (int j = 1; j <= number_of_nodes; j++)
                            {
                                if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                                    {
                                        adjacency_matrix[j][i] = 1;
                                    }
                            }
                    }
                System.out.println("Enter the source for the graph");
                source = scanner.nextInt();
                BipartiteDfs bipartiteDfs = new BipartiteDfs(number_of_nodes);
                if (bipartiteDfs.isBipartite(adjacency_matrix, source))
                    {
                        System.out.println("The given graph is bipartite");
                    }
                else
                    {
                        System.out.println("The given graph is not bipartite");
                    }
            }
        catch (InputMismatchException inputMismatch)
            {
                System.out.println("Wrong Input format");
            }
        scanner.close();
    }
}

/*
Enter the number of nodes in the graph
4
Enter the adjacency matrix
0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
Enter the source for the graph
1
The given graph is bipartite
