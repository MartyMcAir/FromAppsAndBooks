 

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/****************************************************************************
 *  Compilation:  javac WeightedQuickUnionUF.java
 *  Execution:  java WeightedQuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Weighted quick-union (without path compression).
 *
 ****************************************************************************/

/**
 *  The  WeightedQuickUnionUF  class represents a union-find data structure.
 *  It supports the  union  and  find  operations, along with
 *  methods for determinig whether two objects are in the same component
 *  and the total number of components.
 *   
 *  This implementation uses weighted quick union by size (without path compression).
 *  Initializing a data structure with  N  objects takes linear time.
 *  Afterwards,  union ,  find , and  connected  take
 *  logarithmic time (in the worst case) and  count  takes constant
 *  time.
 *   
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *     
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class WeightedQuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
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
        while (p != id[p])
            p = id[p];
        return p;
    }

    /**
     * Are the two sites  p  and  q  in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return  true  if the two sites  p  and  q 
     *    are in the same component, and  false  otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
    /**
     * Merges the component containing site p  with the component
     * containing site  q .
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if   (sz[rootP] < sz[rootQ]) { id[rootP] = rootQ; sz[rootQ] += sz[rootP]; }
        else                         { id[rootQ] = rootP; sz[rootP] += sz[rootQ]; }
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
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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

