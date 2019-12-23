 

import edu.princeton.cs.introcs.StdOut;

/*************************************************************************
 *  Compilation:  javac DirectedEdge.java
 *  Execution:    java DirectedEdge
 *
 *  Immutable weighted directed edge.
 *
 *************************************************************************/
/**
 *  The  DirectedEdge  class represents a weighted edge in an 
 *  {@link EdgeWeightedDigraph}. Each edge consists of two integers
 *  (naming the two vertices) and a real-value weight. The data type
 *  provides methods for accessing the two endpoints of the directed edge and
 *  the weight.
 *   
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/44sp">Section 4.4</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class DirectedEdge { 
    private final int v;
    private final int w;
    private final double weight;

    /**
     * Initializes a directed edge from vertex  v  to vertex  w  with
     * the given  weight .
     * @param v the tail vertex
     * @param w the head vertex
     * @param weight the weight of the directed edge
     * @throws java.lang.IndexOutOfBoundsException if either  v  or  w 
     *    is a negative integer
     * @throws IllegalArgumentException if  weight  is  NaN 
     */
    public DirectedEdge(int v, int w, double weight) {
        if (v < 0) throw new IndexOutOfBoundsException("Vertex names must be nonnegative integers");
        if (w < 0) throw new IndexOutOfBoundsException("Vertex names must be nonnegative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * Returns the tail vertex of the directed edge.
     * @return the tail vertex of the directed edge
     */
    public int from() {
        return v;
    }

    /**
     * Returns the head vertex of the directed edge.
     * @return the head vertex of the directed edge
     */
    public int to() {
        return w;
    }

    /**
     * Returns the weight of the directed edge.
     * @return the weight of the directed edge
     */
    public double weight() {
        return weight;
    }

    /**
     * Returns a string representation of the directed edge.
     * @return a string representation of the directed edge
     */
    @Override
    public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }

    /**
     * Unit tests the  DirectedEdge  data type.
     */
    public static void main(String[] args) {
        DirectedEdge e = new DirectedEdge(12, 23, 3.14);
        StdOut.println(e);
    }
}
