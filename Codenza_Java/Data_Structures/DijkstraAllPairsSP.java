 

/*************************************************************************
 *  Compilation:  javac DijkstraAllPairsSP.java
 *  Dependencies: EdgeWeightedDigraph.java Dijkstra.java
 *
 *  Dijkstra's algorithm run from each vertex. 
 *  Takes time proportional to E V log V and space proportional to EV.
 *
 *************************************************************************/

/**
 *  The  DijkstraAllPairsSP  class represents a data type for solving the
 *  all-pairs shortest paths problem in edge-weighted digraphs
 *  where the edge weights are nonnegative.
 *   
 *  This implementation runs Dijkstra's algorithm from each vertex.
 *  The constructor takes time proportional to  V  ( E  log  V )
 *  and uses space proprtional to  V <sup>2</sup>,
 *  where  V  is the number of vertices and  E  is the number of edges.
 *  Afterwards, the  dist()  and  hasPath()  methods take
 *  constant time and the  path()  method takes time proportional to the
 *  number of edges in the shortest path returned.
 *   
 *  For additional documentation, see <a href="/algs4/44sp">Section 4.4</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class DijkstraAllPairsSP {
    private DijkstraSP[] all;

    /**
     * Computes a shortest paths tree from each vertex to to every other vertex in
     * the edge-weighted digraph  G .
     * @param G the edge-weighted digraph
     * @throws IllegalArgumentException if an edge weight is negative
     * @throws IllegalArgumentException unless 0 &le;  s  &le;  V  - 1
     */
    public DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all  = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++)
            all[v] = new DijkstraSP(G, v);
    }

    /**
     * Returns a shortest path from vertex  s  to vertex  t .
     * @param s the source vertex
     * @param t the destination vertex
     * @return a shortest path from vertex  s  to vertex  t 
     *    as an iterable of edges, and  null  if no such path
     */
    public Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    /**
     * Is there a path from the vertex  s  to vertex  t ?
     * @param s the source vertex
     * @param t the destination vertex
     * @return  true  if there is a path from vertex  s  
     *    to vertex  t , and  false  otherwise
     */
    public boolean hasPath(int s, int t) {
        return dist(s, t) < Double.POSITIVE_INFINITY;
    }

    /**
     * Returns the length of a shortest path from vertex  s  to vertex  t .
     * @param s the source vertex
     * @param t the destination vertex
     * @return the length of a shortest path from vertex  s  to vertex  t ;
     *     Double.POSITIVE_INFINITY  if no such path
     */
    public double dist(int s, int t) {
        return all[s].distTo(t);
    }
}
