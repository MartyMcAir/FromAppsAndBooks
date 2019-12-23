/*This is a java program to find the edges other than feedback arc set so that all the edges contribute to directed acyclic graph.*/


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Graph
{
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph(int v)
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

    public Graph checkDAG()
    {
        Integer count = 0;
        Iterator<Integer> iteratorI = this.adjacencyList.keySet().iterator();
        Integer size = this.adjacencyList.size() - 1;
        System.out.println("Minimal set of edges: ");
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
                                        System.out.println(i + " -> " + j);
                                    }
                            }
                        this.adjacencyList.remove(i);
                        iteratorI = this.adjacencyList.keySet().iterator();
                    }
            }
        return this;
    }

    public Map<Integer, List<Integer>> getFeedbackArcSet(int v)
    {
        int[] visited = new int[v + 1];
        Iterator<Integer> iterator = this.adjacencyList.keySet().iterator();
        Map<Integer, List<Integer>> l = new HashMap<Integer, List<Integer>>();
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
                                        l.put(i, new LinkedList<Integer>());
                                        l.get(i).add(j);
                                    }
                                else
                                    {
                                        visited[list.get(j)] = 1;
                                    }
                            }
                    }
            }
        return l;
    }

    public void printAllEdges(Graph copyG, int v)
    {
        Map<Integer, List<Integer>> edges = this.getFeedbackArcSet(v);
        Iterator<Integer> iterator = copyG.adjacencyList.keySet().iterator();
        while (iterator.hasNext())
            {
                Integer i = iterator.next();
                List<Integer> edgeList = this.getEdge(i);
                if (edgeList.size() != 0)
                    {
                        for (int j = 0; j < edgeList.size(); j++)
                            {
                                if (edges.containsKey(i) && edges.get(i).contains(j))
                                    continue;
                                else
                                    {
                                        System.out.print(i + " -> " + edgeList.get(j));
                                    }
                            }
                        System.out.println();
                    }
            }
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
}

public class MinimalSetofEdgesforDAG
{
    public static void main(String args[])
    {
        int v, e, count = 1, to, from;
        Scanner sc = new Scanner(System.in);
        Graph glist;
        try
            {
                System.out.println("Enter the number of vertices: ");
                v = sc.nextInt();
                System.out.println("Enter the number of edges: ");
                e = sc.nextInt();
                glist = new Graph(v);
                System.out.println("Enter the edges in the graph : <from> <to>");
                while (count <= e)
                    {
                        to = sc.nextInt();
                        from = sc.nextInt();
                        glist.setEdge(to, from);
                        count++;
                    }
                Graph copyofGlist = new Graph(v);
                copyofGlist = glist;
                glist.printGraph();
                Graph modified = glist.checkDAG();
                modified.printAllEdges(copyofGlist, v);
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
6 3
6 4
The Graph is:
1 -> 2
2 -> 3 -> 4
4 -> 5
5 -> 6
6 -> 3 -> 4
Minimal set of edges:
3 -> 2
3 -> 6
1 -> 2
2 -> 4
4 -> 5
5 -> 6
