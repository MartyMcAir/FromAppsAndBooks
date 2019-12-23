 

import edu.princeton.cs.introcs.StdOut;

/*************************************************************************
 *  Compilation:  javac FlowEdge.java
 *  Execution:    java FlowEdge
 *
 *  Capacitated edge with a flow in a flow network.
 *
 *************************************************************************/

/**
 *  The  FlowEdge  class represents a capacitated edge with a 
  * flow in a {@link FlowNetwork}. Each edge consists of two integers
 *  (naming the two vertices), a real-valued capacity, and a real-valued
 *  flow. The data type provides methods for accessing the two endpoints
 *  of the directed edge and the weight. It also provides methods for
 *  changing the amount of flow on the edge and determining the residual
 *  capacity of the edge.
 *   
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/64maxflow">Section 6.4</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class FlowEdge {
    private final int v;             // from
    private final int w;             // to 
    private final double capacity;   // capacity
    private double flow;             // flow

    /**
     * Initializes an edge from vertex  v  to vertex  w  with
     * the given  capacity  and zero flow.
     * @param v the tail vertex
     * @param w the head vertex
     * @param capacity the capacity of the edge
     * @throws java.lang.IndexOutOfBoundsException if either  v  or  w 
     *    is a negative integer
     * @throws java.lang.IllegalArgumentException if  capacity  is negative
     */
    public FlowEdge(int v, int w, double capacity) {
        if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (!(capacity >= 0.0)) throw new IllegalArgumentException("Edge capacity must be nonnegaitve");
        this.v         = v;
        this.w         = w;  
        this.capacity  = capacity;
        this.flow      = 0.0;
    }

    /**
     * Initializes an edge from vertex  v  to vertex  w  with
     * the given  capacity  and  flow .
     * @param v the tail vertex
     * @param w the head vertex
     * @param capacity the capacity of the edge
     * @param flow the flow on the edge
     * @throws java.lang.IndexOutOfBoundsException if either  v  or  w 
     *    is a negative integer
     * @throws java.lang.IllegalArgumentException if  capacity  is negative
     * @throws java.lang.IllegalArgumentException unless  flow  is between 
     *     0.0  and  capacity .
     */
    public FlowEdge(int v, int w, double capacity, double flow) {
        if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (!(capacity >= 0.0))  throw new IllegalArgumentException("Edge capacity must be nonnegaitve");
        if (!(flow <= capacity)) throw new IllegalArgumentException("Flow exceeds capacity");
        if (!(flow >= 0.0))      throw new IllegalArgumentException("Flow must be nonnnegative");
        this.v         = v;
        this.w         = w;  
        this.capacity  = capacity;
        this.flow      = flow;
    }

    /**
     * Initializes a flow edge from another flow edge.
     * @param e the edge to copy
     */
    public FlowEdge(FlowEdge e) {
        this.v         = e.v;
        this.w         = e.w;  
        this.capacity  = e.capacity;
        this.flow      = e.flow;
    }

    /**
     * Returns the tail vertex of the edge.
     * @return the tail vertex of the edge
     */
    public int from() {
        return v;
    }  

    /**
     * Returns the head vertex of the edge.
     * @return the head vertex of the edge
     */
    public int to() {
        return w;
    }  

    /**
     * Returns the capacity of the edge.
     * @return the capacity of the edge
     */
    public double capacity() {
        return capacity;
    }

    /**
     * Returns the flow on the edge.
     * @return the flow on the edge
     */
    public double flow() {
        return flow;
    }

    /**
     * Returns the endpoint of the edge that is different from the given vertex
     * (unless the edge represents a self-loop in which case it returns the same vertex).
     * @param vertex one endpoint of the edge
     * @return the endpoint of the edge that is different from the given vertex
     *   (unless the edge represents a self-loop in which case it returns the same vertex)
     * @throws java.lang.IllegalArgumentException if  vertex  is not one of the endpoints
     *   of the edge
     */
    public int other(int vertex) {
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    /**
     * Returns the residual capacity of the edge in the direction
     *  to the given  vertex .
     * @param vertex one endpoint of the edge
     * @return the residual capacity of the edge in the direction to the given vertex
     *   If  vertex  is the tail vertex, the residual capacity equals
     *    capacity() - flow() ; if  vertex  is the head vertex, the
     *   residual capacity equals  flow() .
     * @throws java.lang.IllegalArgumentException if  vertex  is not one of the endpoints
     *   of the edge
     */
    public double residualCapacityTo(int vertex) {
        if      (vertex == v) return flow;              // backward edge
        else if (vertex == w) return capacity - flow;   // forward edge
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    /**
     * Increases the flow on the edge in the direction to the given vertex.
     *   If  vertex  is the tail vertex, this increases the flow on the edge by  delta ;
     *   if  vertex  is the head vertex, this decreases the flow on the edge by  delta .
     * @param vertex one endpoint of the edge
     * @throws java.lang.IllegalArgumentException if  vertex  is not one of the endpoints
     *   of the edge
     * @throws java.lang.IllegalArgumentException if  delta  makes the flow on
     *   on the edge either negative or larger than its capacity
     * @throws java.lang.IllegalArgumentException if  delta  is  NaN 
     */
    public void addResidualFlowTo(int vertex, double delta) {
        if      (vertex == v) flow -= delta;           // backward edge
        else if (vertex == w) flow += delta;           // forward edge
        else throw new IllegalArgumentException("Illegal endpoint");
        if (Double.isNaN(delta)) throw new IllegalArgumentException("Change in flow = NaN");
        if (!(flow >= 0.0))      throw new IllegalArgumentException("Flow is negative");
        if (!(flow <= capacity)) throw new IllegalArgumentException("Flow exceeds capacity");
    }


    /**
     * Returns a string representation of the edge.
     * @return a string representation of the edge
     */
    @Override
    public String toString() {
        return v + "->" + w + " " + flow + "/" + capacity;
    }


   /**
     * Unit tests the  FlowEdge  data type.
     */
    public static void main(String[] args) {
        FlowEdge e = new FlowEdge(12, 23, 3.14);
        StdOut.println(e);
    }

}
