import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class DirectedConnectivityDfs
{
    private Stack<Integer> stack;

    public DirectedConnectivityDfs()
    {
        stack = new Stack<Integer>();
    }

    public void dfs(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int visited[] = new int[number_of_nodes + 1];
        int element = source;
        int i = source;
        visited[source] = 1;
        stack.push(source);
        while (!stack.isEmpty())
            {
                element = stack.peek();
                i = element;
                while (i <= number_of_nodes)
                    {
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
                stack.pop();
            }
        boolean connected = false;
        for (int vertex = 1; vertex <= number_of_nodes; vertex++)
            {
                if (visited[vertex] == 1)
                    {
                        connected = true;
                    }
                else
                    {
                        connected = false;
                        break;
                    }
            }
        if (connected)
            {
                System.out.println("The graph is connected");
            }
        else
            {
                System.out.println("The graph is disconnected");
            }
    }

    public static void main(String...arg)
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
                    for (int j = 1; j <= number_of_nodes; j++)
                        adjacency_matrix[i][j] = scanner.nextInt();
                System.out.println("Enter the source for the graph");
                source = scanner.nextInt();
                DirectedConnectivityDfs directedConnectivity= new DirectedConnectivityDfs();
                directedConnectivity.dfs(adjacency_matrix, source);
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
0 0 0 0 0
0 1 0 0 0
0 0 0 0 0
Enter the source for the graph
1
The graph is disconnected
