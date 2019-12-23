/*This Java program,Implements Depth Limited Search.Like the normal depth-first search, depth-limited search is an uninformed search. It works exactly like depth-first search, but avoids its drawbacks regarding completeness by imposing a maximum limit on the depth of the search. Even if the search could still expand a vertex beyond that depth, it will not do so and thereby it will not follow infinitely deep paths or get stuck in cycles. Therefore depth-limited search will find a solution if it is within the depth limit, which guarantees at least completeness on all graphs.*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class DepthLimitedSearch
{
    private Stack<Integer> stack;
    private int numberOfNodes;
    private static final int MAX_DEPTH = 3;

    public DepthLimitedSearch(int numberOfNodes)
    {
        this.numberOfNodes = numberOfNodes;
        this.stack = new Stack<Integer>();
    }

    public void depthLimitedSearch(int adjacencyMatrix[][], int source)
    {
        int visited[] = new int[numberOfNodes + 1];
        int element, destination;
        int depth = 0;
        System.out.println(source + " at depth " + depth);
        stack.push(source);
        visited[source] = 1;
        depth = 0;
        while (!stack.isEmpty())
            {
                element = stack.peek();
                destination = element;
                while (destination <= numberOfNodes)
                    {
                        if (depth < MAX_DEPTH)
                            {
                                if (adjacencyMatrix[element][destination] == 1 && visited[destination] == 0)
                                    {
                                        stack.push(destination);
                                        visited[destination] = 1;
                                        depth++;
                                        System.out.println(destination + " at depth " + depth);
                                        element = destination;
                                        destination = 1;
                                    }
                            }
                        else
                            {
                                return;
                            }
                        destination++;
                    }
                stack.pop();
                depth--;
            }
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
                    for (int j = 1; j <= number_of_nodes; j++)
                        adjacency_matrix[i][j] = scanner.nextInt();
                System.out.println("Enter the source for the graph");
                source = scanner.nextInt();
                System.out.println("The Depth limited Search Traversal of Max Depth 3 is");
                DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch(number_of_nodes);
                depthLimitedSearch.depthLimitedSearch(adjacency_matrix, source);
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
5
Enter the adjacency matrix
0 1 0 0 0
0 0 1 0 0
0 0 0 1 0
0 0 0 0 1
0 0 0 0 0
Enter the source for the graph
1
The Depth limited Search Traversal  of Max Depth 3 for the graph is given by
1 at depth 0
2 at depth 1
3 at depth 2
4 at depth 3
