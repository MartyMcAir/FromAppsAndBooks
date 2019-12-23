 

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/*************************************************************************
 *  Compilation:  javac TarjanSCC.java
 *  Execution:    Java TarjanSCC V E
 *  Dependencies: Digraph.java Stack.java TransitiveClosure.java StdOut.java
 *
 *  Compute the strongly-connected components of a digraph using 
 *  Tarjan's algorithm.
 *
 *  Runs in O(E + V) time.
 *
 *  % java TarjanSCC tinyDG.txt
 *  5 components
 *  1 
 *  0 2 3 4 5
 *  9 10 11 12
 *  6 8
 *  7 
 *
 *************************************************************************/

/**
 *  The  TarjanSCC  class represents a data type for 
 *  determining the strong components in a digraph.
 *  The  id  operation determines in which strong component
 *  a given vertex lies; the  areStronglyConnected  operation
 *  determines whether two vertices are in the same strong component;
 *  and the  count  operation determines the number of strong
 *  components.

 *  The  component identifier  of a component is one of the
 *  vertices in the strong component: two vertices have the same component
 *  identifier if and only if they are in the same strong component.

 *   
 *  This implementation uses Tarjan's algorithm.
 *  The constructor takes time proportional to  V  +  E 
 *  (in the worst case),
 *  where  V  is the number of vertices and  E  is the number of edges.
 *  Afterwards, the  id ,  count , and  areStronglyConnected 
 *  operations take constant time.
 *  For alternate implementations of the same API, see
 *  {@link KosarajuSharirSCC} and {@link GabowSCC}.
 *   
 *  For additional documentation, see <a href="/algs4/42digraph">Section 4.2</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class TarjanSCC {

    private boolean[] marked;        // marked[v] = has v been visited?
    private int[] id;                // id[v] = id of strong component containing v
    private int[] low;               // low[v] = low number of v
    private int pre;                 // preorder number counter
    private int count;               // number of strongly-connected components
    private Stack<Integer> stack;


    /**
     * Computes the strong components of the digraph  G .
     * @param G the digraph
     */
    public TarjanSCC(Digraph G) {
        marked = new boolean[G.V()];
        stack = new Stack<Integer>();
        id = new int[G.V()]; 
        low = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }

        // check that id[] gives strong components
        assert check(G);
    }

    private void dfs(Digraph G, int v) { 
        marked[v] = true;
        low[v] = pre++;
        int min = low[v];
        stack.push(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
            if (low[w] < min) min = low[w];
        }
        if (min < low[v]) { low[v] = min; return; }
        int w;
        do {
            w = stack.pop();
            id[w] = count;
            low[w] = G.V();
        } while (w != v);
        count++;
    }


    /**
     * Returns the number of strong components.
     * @return the number of strong components
     */
    public int count() {
        return count;
    }


    /**
     * Are vertices  v  and  w  in the same strong component?
     * @param v one vertex
     * @param w the other vertex
     * @return  true  if vertices  v  and  w  are in the same
     *     strong component, and  false  otherwise
     */
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * Returns the component id of the strong component containing vertex  v .
     * @param v the vertex
     * @return the component id of the strong component containing vertex  v 
     */
    public int id(int v) {
        return id[v];
    }

    // does the id[] array contain the strongly connected components?
    private boolean check(Digraph G) {
        TransitiveClosure tc = new TransitiveClosure(G);
        for (int v = 0; v < G.V(); v++) {
            for (int w = 0; w < G.V(); w++) {
                if (stronglyConnected(v, w) != (tc.reachable(v, w) && tc.reachable(w, v)))
                    return false;
            }
        }
        return true;
    }

    /**
     * Unit tests the  TarjanSCC  data type.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        TarjanSCC scc = new TarjanSCC(G);

        // number of connected components
        int M = scc.count();
        StdOut.println(M + " components");

        // compute list of vertices in each strong component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[scc.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

    }

}
