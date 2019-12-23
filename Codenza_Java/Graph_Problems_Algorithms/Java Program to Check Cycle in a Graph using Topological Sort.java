/*This Java program,to perform the topological Sort on a given graph by the DFS method.The topological sort is performed on a directed acyclic graph.*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class TopoCycle
{
    private Stack<Integer> stack;

    public TopoCycle()
    {
        stack = new Stack<Integer>();
    }

    public boolean checkCycle(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] topological_sort = new int [number_of_nodes + 1];
        int pos = 1;
        int j;
        boolean cycle = false;
        int visited[] = new int[number_of_nodes + 1];
        int element = source;
        int i = source;
        visited[source] = 1;
        stack.push(source);
        while (!stack.isEmpty())
            {
                element = stack.peek();
                while (i <= number_of_nodes)
                    {
                        if (adjacency_matrix[element][i] == 1 && visited[i] == 1)
                            {
                                if (stack.contains(i))
                                    {
                                        System.out.println("The Graph Contains a cycle");
                                        cycle = true;
                                        return cycle;
                                    }
                            }
                        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                            {
                                stack.push(i);
                                visited[i] = 1;
                                element = i;
                                i = 1;
                                continue;
                            }
                        i++;
                    }
                j = stack.pop();
                topological_sort[pos++] = j;
                i = ++j;
            }
        System.out.println("The Graph does not Contain cycle");
        return cycle;
    }

    public static void main(String...arg)
    {
        int number_no_nodes, source;
        Scanner scanner = null;
        try
            {
                System.out.println("Enter the number of nodes in the graph");
                scanner = new Scanner(System.in);
                number_no_nodes = scanner.nextInt();
                int adjacency_matrix[][] = new int[number_no_nodes + 1][number_no_nodes + 1];
                System.out.println("Enter the adjacency matrix");
                for (int i = 1; i <= number_no_nodes; i++)
                    for (int j = 1; j <= number_no_nodes; j++)
                        adjacency_matrix[i][j] = scanner.nextInt();
                System.out.println("Enter the source for the graph");
                source = scanner.nextInt();
                TopoCycle topoCycle = new TopoCycle();
                topoCycle.checkCycle(adjacency_matrix, source);
            }
        catch(InputMismatchException inputMismatch)
            {
                System.out.println("Wrong Input format");
            }
        scanner.close();
    }
}

/*
Enter the number of nodes in the graph
5
Enter the adjacency matrix
0 1 0 1 0
0 0 1 0 0
0 0 0 0 1
0 1 0 0 1
0 0 0 1 0
Enter the source for the graph
1
The Graph contains a cycle
