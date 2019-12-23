 

import edu.princeton.cs.introcs.StdOut;

/*************************************************************************
 *  Compilation:  javac Topoological.java
 *  Dependencies: Digraph.java DepthFirstOrder.java DirectedCycle.java
 *                EdgeWeightedDigraph.java EdgeWeightedDirectedCycle.java
 *                SymbolDigraph.java
 *  Data files:   http://algs4.cs.princeton.edu/42directed/jobs.txt
 *
 *  Compute topological ordering of a DAG or edge-weighted DAG.
 *  Runs in O(E + V) time.
 *
 *  % java Topological jobs.txt "/"
 *  Calculus
 *  Linear Algebra
 *  Introduction to CS
 *  Programming Systems
 *  Algorithms
 *  Theoretical CS
 *  Artificial Intelligence
 *  Machine Learning
 *  Neural Networks
 *  Robotics
 *  Scientific Computing
 *  Computational Biology
 *  Databases
 *
 *
 *************************************************************************/

/**
 *  The  Topological  class represents a data type for 
 *  determining a topological order of a directed acyclic graph (DAG).
 *  Recall, a digraph has a topological order if and only if it is a DAG.
 *  The  hasOrder  operation determines whether the digraph has
 *  a topological order, and if so, the  order  operation
 *  returns one.
 *   
 *  This implementation uses depth-first search.
 *  The constructor takes time proportional to  V  +  E 
 *  (in the worst case),
 *  where  V  is the number of vertices and  E  is the number of edges.
 *  Afterwards, the  hasOrder  operation takes constant time;
 *  the  order  operation takes time proportional to  V .
 *   
 *  See {@link DirectedCycle} and {@link EdgeWeightedDirectedCycle} to compute a
 *  directed cycle if the digraph is not a DAG.
 *   
 *  For additional documentation, see <a href="/algs4/42digraph">Section 4.2</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Topological {
    private Iterable<Integer> order;    // topological order

    /**
     * Determines whether the digraph  G  has a topological order and, if so,
     * finds such a topological order.
     * @param G the digraph
     */
    public Topological(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    /**
     * Determines whether the edge-weighted digraph  G  has a topological
     * order and, if so, finds such an order.
     * @param G the edge-weighted digraph
     */
    public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    /**
     * Returns a topological order if the digraph has a topologial order,
     * and  null  otherwise.
     * @return a topological order of the vertices (as an interable) if the
     *    digraph has a topological order (or equivalently, if the digraph is a DAG),
     *    and  null  otherwise
     */
    public Iterable<Integer> order() {
        return order;
    }

    /**
     * Does the digraph have a topological order?
     * @return  true  if the digraph has a topological order (or equivalently,
     *    if the digraph is a DAG), and  false  otherwise
     */
    public boolean hasOrder() {
        return order != null;
    }

    /**
     * Unit tests the  Topological  data type.
     */
    public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, delimiter);
        Topological topological = new Topological(sg.G());
        for (int v : topological.order()) {
            StdOut.println(sg.name(v));
        }
    }

}
