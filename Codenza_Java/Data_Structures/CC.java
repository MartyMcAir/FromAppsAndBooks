 

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/*************************************************************************
 *  Compilation:  javac CC.java
 *  Execution:    java CC filename.txt
 *  Dependencies: Graph.java StdOut.java Queue.java
 *  Data files:   http://algs4.cs.princeton.edu/41undirected/tinyG.txt
 *
 *  Compute connected components using depth first search.
 *  Runs in O(E + V) time.
 *
 *  % java CC tinyG.txt
 *  3 components
 *  0 1 2 3 4 5 6
 *  7 8 
 *  9 10 11 12
 *
 *  % java CC mediumG.txt 
 *  1 components
 *  0 1 2 3 4 5 6 7 8 9 10 ...
 *
 *  % java -Xss50m CC largeG.txt 
 *  1 components
 *  0 1 2 3 4 5 6 7 8 9 10 ...
 *
 *************************************************************************/

/**
 *  The  CC  class represents a data type for 
 *  determining the connected components in an undirected graph.
 *  The  id  operation determines in which connected component
 *  a given vertex lies; the  areConnected  operation
 *  determines whether two vertices are in the same connected component;
 *  the  count  operation determines the number of connected
 *  components; and the  size  operation determines the number
 *  of vertices in the connect component containing a given vertex.

 *  The  component identifier  of a connected component is one of the
 *  vertices in the connected component: two vertices have the same component
 *  identifier if and only if they are in the same connected component.

 *   
 *  This implementation uses depth-first search.
 *  The constructor takes time proportional to  V  +  E 
 *  (in the worst case),
 *  where  V  is the number of vertices and  E  is the number of edges.
 *  Afterwards, the  id ,  count ,  areConnected ,
 *  and  size  operations take constant time.
 *   
 *  For additional documentation, see <a href="/algs4/41graph">Section 4.1</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class CC {
    private boolean[] marked;   // marked[v] = has vertex v been marked?
    private int[] id;           // id[v] = id of connected component containing v
    private int[] size;         // size[id] = number of vertices in given component
    private int count;          // number of connected components

    /**
     * Computes the connected components of the undirected graph  G .
     * @param G the graph
     */
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    // depth-first search
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * Returns the component id of the connected component containing vertex  v .
     * @param v the vertex
     * @return the component id of the connected component containing vertex  v 
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * Returns the number of vertices in the connected component containing vertex  v .
     * @param v the vertex
     * @return the number of vertices in the connected component containing vertex  v 
     */
    public int size(int v) {
        return size[id[v]];
    }

    /**
     * Returns the number of connected components.
     * @return the number of connected components
     */
    public int count() {
        return count;
    }

    /**
     * Are vertices  v  and  w  in the same connected component?
     * @param v one vertex
     * @param w the other vertex
     * @return  true  if vertices  v  and  w  are in the same
     *     connected component, and  false  otherwise
     */
    public boolean areConnected(int v, int w) {
        return id(v) == id(w);
    }


    /**
     * Unit tests the  CC  data type.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        // number of connected components
        int M = cc.count();
        StdOut.println(M + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].enqueue(v);
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
