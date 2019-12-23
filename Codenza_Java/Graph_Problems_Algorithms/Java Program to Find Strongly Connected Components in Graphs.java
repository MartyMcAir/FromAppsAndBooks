import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StrongConnectedComponents
{
    private int leader = 0;
    private int[] leader_node;
    private int explore[];
    private int finishing_time_of_node[];
    private int finishing_time = 1;
    private int number_of_nodes;
    private Stack<Integer> stack;
    private Map<Integer, Integer> finishing_time_map;

    public StrongConnectedComponents(int number_of_nodes)
    {
        this.number_of_nodes = number_of_nodes;
        leader_node = new int[number_of_nodes + 1];
        explore = new int[number_of_nodes + 1];
        finishing_time_of_node = new int[number_of_nodes + 1];
        stack = new Stack<Integer>();
        finishing_time_map = new HashMap<Integer, Integer>();
    }

    public void strongConnectedComponent(int adjacency_matrix[][])
    {
        for (int i = number_of_nodes; i > 0; i--)
            {
                if (explore[i] == 0)
                    {
                        dfs_1(adjacency_matrix, i);
                    }
            }
        int rev_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
        for (int i = 1; i <= number_of_nodes; i++)
            {
                for (int j = 1; j <= number_of_nodes; j++)
                    {
                        if (adjacency_matrix[i][j] == 1)
                            rev_matrix[finishing_time_of_node[j]][finishing_time_of_node[i]] = adjacency_matrix[i][j];
                    }
            }
        for (int i = 1; i <= number_of_nodes; i++)
            {
                explore[i] = 0;
                leader_node[i] = 0;
            }
        for (int i = number_of_nodes; i > 0; i--)
            {
                if (explore[i] == 0)
                    {
                        leader = i;
                        dfs_2(rev_matrix, i);
                    }
            }
    }

    public void dfs_1(int adjacency_matrix[][], int source)
    {
        explore[source] = 1;
        stack.push(source);
        int i = 1;
        int element = source;
        while (!stack.isEmpty())
            {
                element = stack.peek();
                i = 1;
                while (i <= number_of_nodes)
                    {
                        if (adjacency_matrix[element][i] == 1 && explore[i] == 0)
                            {
                                stack.push(i);
                                explore[i] = 1;
                                element = i;
                                i = 1;
                                continue;
                            }
                        i++;
                    }
                int poped = stack.pop();
                int time = finishing_time++;
                finishing_time_of_node[poped] = time;
                finishing_time_map.put(time, poped);
            }
    }

    public void dfs_2(int rev_matrix[][], int source)
    {
        explore[source] = 1;
        leader_node[finishing_time_map.get(source)] = leader;
        stack.push(source);
        int i = 1;
        int element = source;
        while (!stack.isEmpty())
            {
                element = stack.peek();
                i = 1;
                while (i <= number_of_nodes)
                    {
                        if (rev_matrix[element][i] == 1 && explore[i] == 0)
                            {
                                if (leader_node[finishing_time_map.get(i)] == 0)
                                    leader_node[finishing_time_map.get(i)] = leader;
                                stack.push(i);
                                explore[i] = 1;
                                element = i;
                                i = 1;
                                continue;
                            }
                        i++;
                    }
                stack.pop();
            }
    }

    public static void main(String... arg)
    {
        int number_of_nodes;
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
                StrongConnectedComponents strong = new StrongConnectedComponents(number_of_nodes);
                strong.strongConnectedComponent(adjacency_matrix);
                System.out.println("The Strong Connected Components are");
                for (int i = 1; i < strong.leader_node.length; i++)
                    {
                        System.out.println( "Node " + i+ "belongs to SCC"
                                            + strong.finishing_time_map.get(strong.leader_node[i]));
                    }
            }
        catch (InputMismatchException inputMismatch)
            {
                System.out.println("Wrong Input Format");
            }
    }
}

/*
Enter the number of nodes in the graph
8
Enter the adjacency matrix
0 1 0 0 0 0 0 0
0 0 0 0 0 0 1 0
0 0 0 1 1 0 0 0
0 1 0 0 0 0 1 0
0 0 0 0 0 0 0 1
1 1 0 0 0 0 0 0
0 0 0 0 0 1 0 0
0 0 1 1 0 0 0 0
The Strong Connected Components are
Node 1 belongs to SCC 2
Node 2 belongs to SCC 2
Node 3 belongs to SCC 8
Node 4 belongs to SCC 4
Node 5 belongs to SCC 8
Node 6 belongs to SCC 2
Node 7 belongs to SCC 2
Node 8 belongs to SCC 8
