/*This is a java program to construct a undirected graph and check whether path exists between two vertices, if it exists class return true, false otherwise. Class implements standard Breadth First Search algorithm to traverse from given source node to destination node.*/

//This is a sample program to check that there exists a path between source node and destination node
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Path_Between_Nodes
{
    private Map<String, LinkedHashSet<String>> map = new HashMap();

    public void addEdge(String node1, String node2)
    {
        LinkedHashSet<String> adjacent = map.get(node1);
        if (adjacent == null)
            {
                adjacent = new LinkedHashSet();
                map.put(node1, adjacent);
            }
        adjacent.add(node2);
    }

    public void addTwoWayVertex(String node1, String node2)
    {
        addEdge(node1, node2);
        addEdge(node2, node1);
    }

    public boolean isConnected(String node1, String node2)
    {
        Set adjacent = map.get(node1);
        if (adjacent == null)
            {
                return false;
            }
        return adjacent.contains(node2);
    }

    public LinkedList<String> adjacentNodes(String last)
    {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null)
            {
                return new LinkedList();
            }
        return new LinkedList<String>(adjacent);
    }

    private static String  START;
    private static String  END;
    private static boolean flag;

    public static void main(String[] args)
    {
        // this graph is directional
        Path_Between_Nodes graph = new Path_Between_Nodes();
        // graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "A");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("C", "A");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("D", "B");
        graph.addEdge("E", "C");
        graph.addEdge("E", "F");
        // graph.addEdge("F", "B");
        graph.addEdge("F", "C");
        graph.addEdge("F", "E");
        LinkedList<String> visited = new LinkedList();
        System.out.println("Enter the source node:");
        Scanner sc = new Scanner(System.in);
        START = sc.next();
        System.out.println("Enter the destination node:");
        END = sc.next();
        visited.add(START);
        new Path_Between_Nodes().breadthFirst(graph, visited);
        sc.close();
    }

    private void breadthFirst(Path_Between_Nodes graph,
                              LinkedList<String> visited)
    {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        for (String node : nodes)
            {
                if (visited.contains(node))
                    {
                        continue;
                    }
                if (node.equals(END))
                    {
                        visited.add(node);
                        printPath(visited);
                        flag = true;
                        visited.removeLast();
                        break;
                    }
            }
        for (String node : nodes)
            {
                if (visited.contains(node) || node.equals(END))
                    {
                        continue;
                    }
                visited.addLast(node);
                breadthFirst(graph, visited);
                visited.removeLast();
            }
        if (flag == false)
            {
                System.out.println("No path Exists between " + START + " and "
                                   + END);
                flag = true;
            }
    }

    private void printPath(LinkedList<String> visited)
    {
        if (flag == false)
            System.out.println("Yes there exists a path between " + START
                               + " and " + END);
        for (String node : visited)
            {
                System.out.print(node);
                System.out.print(" ");
            }
        System.out.println();
    }
}

/*
Enter the source node:
E
Enter the destination node:
B
No path Exists between E and B

Enter the source node:
A
Enter the destination node:
E
Yes there exists a path between A and E
A C E
A C F E
