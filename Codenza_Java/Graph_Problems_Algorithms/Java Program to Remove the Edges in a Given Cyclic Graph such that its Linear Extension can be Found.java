/*This is a java program to set of edges upon removal of which linear extension can be found. In simple terms this version of code finds the feedbackarc set, which when removed from graph leads to DAG for which we can find the topological sorting.*/


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class GraphLE
{
    private Map<Integer, List<Integer>> adjacencyList;

    public GraphLE(int v)
    {
        adjacencyList = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= v; i++)
            adjacencyList.put(i, new LinkedList<Integer>());
    }

    public void setEdge(int from, int to)
    {
        if (to > adjacencyList.size() || from > adjacencyList.size())
            System.out.println("The vertices does not exists");
        /*
         * List<Integer> sls = adjacencyList.get(to);
         * sls.add(from);
         */
        List<Integer> dls = adjacencyList.get(from);
        dls.add(to);
    }

    public List<Integer> getEdge(int to)
    {
        /*
         * if (to > adjacencyList.size())
         * {
         * System.out.println("The vertices does not exists");
         * return null;
         * }
         */
        return adjacencyList.get(to);
    }

    public GraphLE checkDAG()
    {
        Integer count = 0;
        Iterator<Integer> iteratorI = this.adjacencyList.keySet().iterator();
        Integer size = this.adjacencyList.size() - 1;
        while (iteratorI.hasNext())
            {
                Integer i = iteratorI.next();
                List<Integer> adjList = this.adjacencyList.get(i);
                if (count == size)
                    {
                        return this;
                    }
                if (adjList.size() == 0)
                    {
                        count++;
                        Iterator<Integer> iteratorJ = this.adjacencyList.keySet()
                                                      .iterator();
                        while (iteratorJ.hasNext())
                            {
                                Integer j = iteratorJ.next();
                                List<Integer> li = this.adjacencyList.get(j);
                                if (li.contains(i))
                                    {
                                        li.remove(i);
                                    }
                            }
                        this.adjacencyList.remove(i);
                        iteratorI = this.adjacencyList.keySet().iterator();
                    }
            }
        return this;
    }

    public void printGraph()
    {
        System.out.println("The Graph is: ");
        Iterator<Integer> iterator = this.adjacencyList.keySet().iterator();
        while (iterator.hasNext())
            {
                Integer i = iterator.next();
                List<Integer> edgeList = this.getEdge(i);
                if (edgeList.size() != 0)
                    {
                        System.out.print(i);
                        for (int j = 0; j < edgeList.size(); j++)
                            {
                                System.out.print(" -> " + edgeList.get(j));
                            }
                        System.out.println();
                    }
            }
    }

    public boolean removeEdgesToGetLinearExtension(int v)
    {
        boolean flag = false;
        int[] visited = new int[v + 1];
        Iterator<Integer> iterator = this.adjacencyList.keySet().iterator();
        System.out.print("The set of edges in feedback arc set: ");
        while (iterator.hasNext())
            {
                Integer i = iterator.next();
                List<Integer> list = this.adjacencyList.get(i);
                visited[i] = 1;
                if (list.size() != 0)
                    {
                        for (int j = 0; j < list.size(); j++)
                            {
                                if (visited[list.get(j)] == 1)
                                    {
                                        flag = true;
                                        System.out.println(i + " - " + list.get(j));
                                    }
                                else
                                    {
                                        visited[list.get(j)] = 1;
                                    }
                            }
                    }
            }
        return flag;
    }
}

public class RemoveEdgesLinearExtension
{
    public static void main(String args[])
    {
        int v, e, count = 1, to, from;
        Scanner sc = new Scanner(System.in);
        GraphLE glist;
        try
            {
                System.out.println("Enter the number of vertices: ");
                v = sc.nextInt();
                System.out.println("Enter the number of edges: ");
                e = sc.nextInt();
                glist = new GraphLE(v);
                System.out.println("Enter the edges in the graph : <from> <to>");
                while (count <= e)
                    {
                        to = sc.nextInt();
                        from = sc.nextInt();
                        glist.setEdge(to, from);
                        count++;
                    }
                glist.printGraph();
                GraphLE modified = glist.checkDAG();
                if (modified.removeEdgesToGetLinearExtension(v) == false)
                    {
                        System.out.println("None");
                    }
            }
        catch (Exception E)
            {
                System.out
                .println("You are trying to access empty adjacency list of a node.");
            }
        sc.close();
    }
}

/*
Enter the number of vertices:
6
Enter the number of edges:
7
Enter the edges in the graph : <from> <to>
1 2
2 3
2 4
4 5
5 6
6 4
6 3
The Graph is:
1 -> 2
2 -> 3 -> 4
4 -> 5
5 -> 6
6 -> 4 -> 3
The set of edges in feedback arc set: 6 - 4
