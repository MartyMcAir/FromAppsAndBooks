/*This is a java program to create a random linear extension of DAG. Linear extension of DAG is nothing but topological sorting in simple terms.*/


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class DAGLinearExtension
{
    private Stack<Integer> stack;

    public DAGLinearExtension()
    {
        stack = new Stack<Integer>();
    }

    public int[] topological(int adjacency_matrix[][], int source)
    throws NullPointerException
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] topological_sort = new int[number_of_nodes + 1];
        int pos = 1;
        int j;
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
                                        System.out.println("TOPOLOGICAL SORT NOT POSSIBLE");
                                        return null;
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
        return topological_sort;
    }

    public static void main(String... arg)
    {
        int number_no_nodes, source;
        Scanner scanner = null;
        int topological_sort[] = null;
        System.out
        .println("Linear extension of a DAG is its topological reperesentation.");
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
                System.out
                .println("The Topological sort for the graph is given by ");
                DAGLinearExtension toposort = new DAGLinearExtension();
                topological_sort = toposort.topological(adjacency_matrix, source);
                for (int i = topological_sort.length - 1; i > 0; i--)
                    {
                        if (topological_sort[i] != 0)
                            System.out.print(topological_sort[i] + "\t");
                    }
            }
        catch (InputMismatchException inputMismatch)
            {
                System.out.println("Wrong Input format");
            }
        catch (NullPointerException nullPointer)
            {
            }
        scanner.close();
    }
}

/*
Linear extension of a DAG is its topological reperesentation.
Enter the number of nodes in the graph
6
Enter the adjacency matrix
0 1 0 0 0 1
0 0 1 1 0 0
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 0 0 1
0 0 1 0 0 0
Enter the source for the graph
1
The Topological sort for the graph is given by
1	2	4	5	6	3
