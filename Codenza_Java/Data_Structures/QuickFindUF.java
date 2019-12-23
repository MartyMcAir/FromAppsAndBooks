 

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/****************************************************************************
 *  Compilation:  javac QuickFindUF.java
 *  Execution:  java QuickFindUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Quick-find algorithm.
 *
 ****************************************************************************/

/**
 *  The  QuickFindUF  class represents a union-find data structure.
 *  It supports the  union  and  find  operations, along with
 *  methods for determinig whether two objects are in the same component
 *  and the total number of components.
 *   
 *  This implementation uses quick find.
 *  Initializing a data structure with  N  objects takes linear time.
 *  Afterwards,  find ,  connected , and  count 
 *  takes constant time but  union  takes linear time.
 *   
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *     
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class QuickFindUF {
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    /**
     * Returns the number of components.
     * @return the number of components (between 1 and N)
     */
    public int count() {
        return count;
    }

    /**
     * Returns the component identifier for the component containing site  p .
     * @param p the integer representing one site
     * @return the component identifier for the component containing site  p 
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * Are the two sites  p  and  q/tt> in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return  true  if the two sites  p  and  q  are in
     *    the same component, and  false  otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
  
    /**
     * Merges the component containing site p  with the component
     * containing site  q .
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        if (connected(p, q)) return;
        int pid = id[p];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = id[q]; 
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input, 
     * where each integer represents some object;
     * if the objects are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}
