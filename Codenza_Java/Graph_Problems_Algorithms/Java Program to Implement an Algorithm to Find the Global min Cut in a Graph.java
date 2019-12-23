/*This is a java program to find global min cut of the graph. In computer science and graph theory, Karger’s algorithm is a randomized algorithm to compute a minimum cut of a connected graph.*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class GlobalMinCut
{
    private static class Graph
    {
        private final Map<Integer, Vertex> vertices = new TreeMap<Integer, Vertex>(
            new Comparator<Integer>()
        {
            @Override
            public int compare(Integer arg0, Integer arg1)
            {
                return arg0.compareTo(arg1);
            }
        });
        private final List<Edge> edges = new ArrayList<Edge>();

        public void addVertex(Vertex v)
        {
            vertices.put(v.lbl, v);
        }

        public Vertex getVertex(int lbl)
        {
            Vertex v;
            if ((v = vertices.get(lbl)) == null)
                {
                    v = new Vertex(lbl);
                    addVertex(v);
                }
            return v;
        }
    }

    private static class Vertex
    {
        private final int lbl;
        private final Set<Edge> edges = new HashSet<Edge>();

        public Vertex(int lbl)
        {
            this.lbl = lbl;
        }

        public void addEdge(Edge edge)
        {
            edges.add(edge);
        }

        public Edge getEdgeTo(Vertex v2)
        {
            for (Edge edge : edges)
                {
                    if (edge.contains(this, v2))
                        return edge;
                }
            return null;
        }
    }

    private static class Edge
    {
        private final List<Vertex> ends = new ArrayList<Vertex>();

        public Edge(Vertex fst, Vertex snd)
        {
            if (fst == null || snd == null)
                {
                    throw new IllegalArgumentException("Both vertices are required");
                }
            ends.add(fst);
            ends.add(snd);
        }

        public boolean contains(Vertex v1, Vertex v2)
        {
            return ends.contains(v1) && ends.contains(v2);
        }

        public Vertex getOppositeVertex(Vertex v)
        {
            if (!ends.contains(v))
                {
                    throw new IllegalArgumentException("Vertex " + v.lbl);
                }
            return ends.get(1 - ends.indexOf(v));
        }

        public void replaceVertex(Vertex oldV, Vertex newV)
        {
            if (!ends.contains(oldV))
                {
                    throw new IllegalArgumentException("Vertex " + oldV.lbl);
                }
            ends.remove(oldV);
            ends.add(newV);
        }
    }

    public static int minCut(Graph gr)
    {
        Random rnd = new Random();
        while (gr.vertices.size() > 2)
            {
                Edge edge = gr.edges.remove(rnd.nextInt(gr.edges.size()));
                Vertex v1 = cleanVertex(gr, edge.ends.get(0), edge);
                Vertex v2 = cleanVertex(gr, edge.ends.get(1), edge);
                // contract
                Vertex mergedVertex = new Vertex(v1.lbl);
                redirectEdges(gr, v1, mergedVertex);
                redirectEdges(gr, v2, mergedVertex);
                gr.addVertex(mergedVertex);
            }
        return gr.edges.size();
    }

    private static Vertex cleanVertex(Graph gr, Vertex v, Edge e)
    {
        gr.vertices.remove(v.lbl);
        v.edges.remove(e);
        return v;
    }

    private static void redirectEdges(Graph gr, Vertex fromV, Vertex toV)
    {
        for (Iterator<Edge> it = fromV.edges.iterator(); it.hasNext();)
            {
                Edge edge = it.next();
                it.remove();
                if (edge.getOppositeVertex(fromV) == toV)
                    {
                        // remove self-loop
                        toV.edges.remove(edge);
                        gr.edges.remove(edge);
                    }
                else
                    {
                        edge.replaceVertex(fromV, toV);
                        toV.addEdge(edge);
                    }
            }
    }

    public static int[][] getArray(String relPath)
    {
        Map<Integer, List<Integer>> vertices = new LinkedHashMap<Integer, List<Integer>>();
        FileReader fr;
        try
            {
                fr = new FileReader(relPath);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null)
                    {
                        String[] split = line.trim().split("(\\s)+");
                        List<Integer> adjList = new ArrayList<Integer>();
                        for (int i = 1; i < split.length; i++)
                            {
                                adjList.add(Integer.parseInt(split[i]) - 1);
                            }
                        vertices.put(Integer.parseInt(split[0]) - 1, adjList);
                    }
                fr.close();
            }
        catch (Exception e)
            {
                e.printStackTrace();
            }
        int[][] array = new int[vertices.size()][];
        for (Map.Entry<Integer, List<Integer>> entry : vertices.entrySet())
            {
                List<Integer> adjList = entry.getValue();
                int[] adj = new int[adjList.size()];
                for (int i = 0; i < adj.length; i++)
                    {
                        adj[i] = adjList.get(i);
                    }
                array[entry.getKey()] = adj;
            }
        return array;
    }

    private static Graph createGraph(int[][] array)
    {
        Graph gr = new Graph();
        for (int i = 0; i < array.length; i++)
            {
                Vertex v = gr.getVertex(i);
                for (int edgeTo : array[i])
                    {
                        Vertex v2 = gr.getVertex(edgeTo);
                        Edge e;
                        if ((e = v2.getEdgeTo(v)) == null)
                            {
                                e = new Edge(v, v2);
                                gr.edges.add(e);
                                v.addEdge(e);
                                v2.addEdge(e);
                            }
                    }
            }
        return gr;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int[][] arr = getArray("GlobalMinCut.txt");
        Map<Integer, Integer> statistics = new LinkedHashMap<Integer, Integer>();
        int min = arr.length;
        int iter = arr.length * arr.length;
        Graph g = createGraph(arr);
        printGraph(g);
        for (int i = 0; i < iter; i++)
            {
                Graph gr = createGraph(arr);
                int currMin = minCut(gr);
                min = Math.min(min, currMin);
                Integer counter;
                if ((counter = statistics.get(currMin)) == null)
                    {
                        counter = 0;
                    }
                statistics.put(currMin, counter + 1);
            }
        System.out.println("Min: " + min + " stat: "
                           + (statistics.get(min) * 100 / iter) + "%");
    }

    private static void printGraph(Graph gr)
    {
        System.out.println("Printing graph");
        for (Vertex v : gr.vertices.values())
            {
                System.out.print(v.lbl + ":");
                for (Edge edge : v.edges)
                    {
                        System.out.print(" " + edge.getOppositeVertex(v).lbl);
                    }
                System.out.println();
            }
    }
}

/*

Printing graph
0: 35 38 17 18 14 22
1: 35 8 17 3 25 22
2: 34 15 5 10
3: 23 1 17 22
4: 7 20 13 28
5: 2 33 15 34
6: 32 27 37 29
7: 13 11 30 4 28
8: 38 16 12 1 9 19
9: 28 8 11 13 19
10: 15 32 2 25 29
11: 19 13 7 9
12: 8 23 38 19
13: 11 7 9 4
14: 18 35 25 0
15: 34 31 2 10 29 16 5
16: 8 15 39 37 27 31
17: 0 38 23 1 3
18: 14 25 0 26
19: 11 12 8 9
20: 28 4 24 36
21: 31 33 39 34
22: 35 0 1 3
23: 3 17 12 38
24: 30 28 36 20
25: 26 18 14 10 1 30
26: 25 36 28 30 18
27: 31 6 37 16
28: 9 26 20 24 7 4
29: 36 15 32 6 10
30: 7 24 26 25 36
31: 15 21 27 39 16
32: 6 10 29 37
33: 21 5 39 34
34: 15 2 21 5 33
35: 0 1 14 22
36: 29 26 24 30 20
37: 39 16 6 27 32
38: 0 8 17 12 23
39: 37 31 21 16 33
Min: 3 stat: 6%
