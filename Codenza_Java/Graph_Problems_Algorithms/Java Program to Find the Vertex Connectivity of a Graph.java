/*This is a java program to find the vertex connectivity of a graph. Vertex connectivity simply means number of articulations points in a graph, articulation points are vertices of a graph whem removed makes graph disconnected.*/


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

class VCBag<Item> implements Iterable<Item>
{
    private int N;    // number of elements in VCBag
    private Node<Item> first;    // beginning of VCBag

    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    public VCBag()
    {
        first = null;
        N = 0;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return N;
    }

    public void add(Item item)
    {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    @SuppressWarnings("hiding")
    private class ListIterator<Item> implements Iterator<Item>
    {
        private Node<Item> current;

        public ListIterator(Node<Item> first)
        {
            current = first;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

class VCGraph
{
    private final int V;
    private int E;
    private VCBag<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public VCGraph(int V)
    {
        if (V < 0)
            throw new IllegalArgumentException(
                "Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (VCBag<Integer>[]) new VCBag[V];
        for (int v = 0; v < V; v++)
            {
                adj[v] = new VCBag<Integer>();
            }
        System.out.println("Enter the number of edges: ");
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        if (E < 0)
            {
                sc.close();
                throw new IllegalArgumentException(
                    "Number of edges must be nonnegative");
            }
        System.out.println("Enter the edges: <from> <to>");
        for (int i = 0; i < E; i++)
            {
                int v = sc.nextInt();
                int w = sc.nextInt();
                addEdge(v, w);
            }
        sc.close();
    }

    public VCGraph(VCGraph G)
    {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++)
            {
                // reverse so that adjacency list is in same order as original
                Stack<Integer> reverse = new Stack<Integer>();
                for (int w : G.adj[v])
                    {
                        reverse.push(w);
                    }
                for (int w : reverse)
                    {
                        adj[v].add(w);
                    }
            }
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public void addEdge(int v, int w)
    {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V)
            throw new IndexOutOfBoundsException();
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v)
    {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException();
        return adj[v];
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++)
            {
                s.append(v + ": ");
                for (int w : adj[v])
                    {
                        s.append(w + " ");
                    }
                s.append(NEWLINE);
            }
        return s.toString();
    }
}

public class VertexConnectivity
{
    private int[] low;
    private int[] pre;
    private int cnt;
    private boolean[] articulation;

    public VertexConnectivity(VCGraph G)
    {
        low = new int[G.V()];
        pre = new int[G.V()];
        articulation = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            low[v] = -1;
        for (int v = 0; v < G.V(); v++)
            pre[v] = -1;
        for (int v = 0; v < G.V(); v++)
            if (pre[v] == -1)
                dfs(G, v, v);
    }

    private void dfs(VCGraph G, int u, int v)
    {
        int children = 0;
        pre[v] = cnt++;
        low[v] = pre[v];
        for (int w : G.adj(v))
            {
                if (pre[w] == -1)
                    {
                        children++;
                        dfs(G, v, w);
                        // update low number
                        low[v] = Math.min(low[v], low[w]);
                        // non-root of DFS is an articulation point if low[w] >= pre[v]
                        if (low[w] >= pre[v] && u != v)
                            articulation[v] = true;
                    }
                // update low number - ignore reverse of edge leading to v
                else if (w != u)
                    low[v] = Math.min(low[v], pre[w]);
            }
        // root of DFS is an articulation point if it has more than 1 child
        if (u == v && children > 1)
            articulation[v] = true;
    }

    // is vertex v an articulation point?
    public boolean isArticulation(int v)
    {
        return articulation[v];
    }

    // test client
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        VCGraph G = new VCGraph(sc.nextInt());
        System.out.println(G);
        VertexConnectivity bic = new VertexConnectivity(G);
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            if (bic.isArticulation(v))
                count++;
        System.out.println("Vertex Connectivity: " + count);
        sc.close();
    }
}

/*
Enter the number of vertices:
6
Enter the number of edges:
7
Enter the edges: <from> <to>
0 1
1 2
1 3
3 4
4 5
5 3
5 2
6 vertices, 7 edges
0: 1
1: 3 2 0
2: 5 1
3: 5 4 1
4: 5 3
5: 2 3 4

Vertex Connectivity: 1
