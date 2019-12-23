/*This is a java program to find topological sort of DAG. In computer science, a topological sort (sometimes abbreviated topsort or toposort) or topological ordering of a directed graph is a linear ordering of its vertices such that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering. For instance, the vertices of the graph may represent tasks to be performed, and the edges may represent constraints that one task must be performed before another; in this application, a topological ordering is just a valid sequence for the tasks. A topological ordering is possible if and only if the graph has no directed cycles, that is, if it is a directed acyclic graph (DAG). Any DAG has at least one topological ordering, and algorithms are known for constructing a topological ordering of any DAG in linear time.*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class DigraphTopologicalSortingDFS
{
    private Stack<Integer> stack;

    public DigraphTopologicalSortingDFS()
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
                DigraphTopologicalSortingDFS toposort = new DigraphTopologicalSortingDFS();
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
Enter the number of nodes in the graph
6
Enter the adjacency matrix
0 1 0 0 0 0
0 0 1 1 0 0
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 0 0 1
0 0 1 1 0 0
Enter the source for the graph
1
The Topological sort for the graph is given by
TOPOLOGICAL SORT NOT POSSIBLE

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
