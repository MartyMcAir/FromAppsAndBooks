//This is a java program to represent graph as a adjacency list
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Represent_Graph_Adjacency_List
{
    private Map<Integer, List<Integer>> adjacencyList;

    public Represent_Graph_Adjacency_List(int v)
    {
        adjacencyList = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= v; i++)
            adjacencyList.put(i, new LinkedList<Integer>());
    }

    public void setEdge(int to, int from)
    {
        if (to > adjacencyList.size() || from > adjacencyList.size())
            System.out.println("The vertices does not exists");
        List<Integer> sls = adjacencyList.get(to);
        sls.add(from);
        List<Integer> dls = adjacencyList.get(from);
        dls.add(to);
    }

    public List<Integer> getEdge(int to)
    {
        if (to > adjacencyList.size())
            {
                System.out.println("The vertices does not exists");
                return null;
            }
        return adjacencyList.get(to);
    }

    public static void main(String args[])
    {
        int v, e, count = 1, to, from;
        Scanner sc = new Scanner(System.in);
        Represent_Graph_Adjacency_List glist;
        try
            {
                System.out.println("Enter the number of vertices: ");
                v = sc.nextInt();
                System.out.println("Enter the number of edges: ");
                e = sc.nextInt();
                glist = new Represent_Graph_Adjacency_List(v);
                System.out.println("Enter the edges in the graph : <to> <from>");
                while (count <= e)
                    {
                        to = sc.nextInt();
                        from = sc.nextInt();
                        glist.setEdge(to, from);
                        count++;
                    }
                System.out
                .println("The Adjacency List Representation of the graph is: ");
                for (int i = 1; i <= v; i++)
                    {
                        System.out.print(i + "->");
                        List<Integer> edgeList = glist.getEdge(i);
                        for (int j = 1;; j++)
                            {
                                if (j != edgeList.size())
                                    System.out.print(edgeList.get(j - 1) + " -> ");
                                else
                                    {
                                        System.out.print(edgeList.get(j - 1));
                                        break;
                                    }
                            }
                        System.out.println();
                    }
            }
        catch (Exception E)
            {
                System.out.println("Something went wrong");
            }
        sc.close();
    }
}

/*

Enter the number of vertices:
4 5
Enter the number of edges:
Enter the edges in the graph : <to> <from>
1 2
2 3
3 4
4 1
1 3
The Adjacency List Representation of the graph is:
1 -> 2 -> 4 -> 3
2 -> 1 -> 3
3 -> 2 -> 4 -> 1
4 -> 3 -> 1
