 

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/****************************************************************************
 *  Compilation:  javac UF.java
 *  Execution:    java UF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                http://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                http://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Weighted quick-union by rank with path compression by halving.
 *
 *  % java UF < tinyUF.txt
 *  4 3
 *  3 8
 *  6 5
 *  9 4
 *  2 1
 *  5 0
 *  7 2
 *  6 1
 *  2 components
 *
 ****************************************************************************/


/**
 *  The  UF  class represents a  union-find data type 
 *  (also known as the  disjoint-sets data type ).
 *  It supports the  union  and  find  operations,
 *  along with a  connected  operation for determinig whether
 *  two sites in the same component and a  count  operation that
 *  returns the total number of components.
 *   
 *  The union-find data type models connectivity among a set of  N 
 *  sites, named 0 through  N  &ndash; 1.
 *  The  is-connected-to  relation must be an 
 *   equivalence relation :
 *  <ul>
 *   <li>  Reflexive :  p  is connected to  p .
 *   <li>  Symmetric : If  p  is connected to  q ,
 *           q  is connected to  p .
 *   <li>  Transitive : If  p  is connected to  q 
 *          and  q  is connected to  r , then
 *           p  is connected to  r .
 *  </ul>
 *  An equivalence relation partitions the sites into
 *   equivalence classes  (or  components ). In this case,
 *  two sites are in the same component if and only if they are connected.
 *  Both sites and components are identified with integers between 0 and
 *   N  &ndash; 1. 
 *  Initially, there are  N  components, with each site in its
 *  own component.  The  component identifier  of a component
 *  (also known as the  root ,  canonical element ,  leader ,
 *  or  set representative ) is one of the sites in the component:
 *  two sites have the same component identifier if and only if they are
 *  in the same component.
 *  <ul>
 *   <li> union ( p ,  q ) adds a
 *         connection between the two sites  p  and  q .
 *         If  p  and  q  are in different components,
 *         then it replaces
 *         these two components with a new component that is the union of
 *         the two.
 *   <li> find ( p ) returns the component
 *         identifier of the component containing  p .
 *   <li> connected ( p ,  q )
 *         returns true if both  p  and  q 
 *         are in the same component, and false otherwise.
 *   <li> count () returns the number of components.
 *  </ul>
 *  The component identifier of a component can change
 *  only when the component itself changes during a call to
 *   union &mdash;it cannot change during a call
 *  to  find ,  connected , or  count .
 *   
 *  This implementation uses weighted quick union by rank with path compression
 *  by halving.
 *  Initializing a data structure with  N  sites takes linear time.
 *  Afterwards, the  union ,  find , and  connected  
 *  operations take logarithmic time (in the worst case) and the
 *   count  operation takes constant time.
 *  Moreover, the amortized time per  union ,  find ,
 *  and  connected  operation has inverse Ackermann complexity.
 *  For alternate implementations of the same API, see
 *  {@link QuickUnionUF}, {@link QuickFindUF}, and {@link WeightedQuickUnionUF}.
 *
 *   
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *   Algorithms, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class UF {
    private int[] id;     // id[i] = parent of i
    private byte[] rank;  // rank[i] = rank of subtree rooted at i (cannot be more than 31)
    private int count;    // number of components

    /**
     * Initializes an empty union-find data structure with  N 
     * isolated components  0  through  N-1 
     * @throws java.lang.IllegalArgumentException if  N &lt; 0 
     * @param N the number of sites
     */
    public UF(int N) {
        if (N < 0) throw new IllegalArgumentException();
        count = N;
        id = new int[N];
        rank = new byte[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * Returns the component identifier for the component containing site  p .
     * @param p the integer representing one object
     * @return the component identifier for the component containing site  p 
     * @throws java.lang.IndexOutOfBoundsException unless  0 &le; p &lt; N 
     */
    public int find(int p) {
        if (p < 0 || p >= id.length) throw new IndexOutOfBoundsException();
        while (p != id[p]) {
            id[p] = id[id[p]];    // path compression by halving
            p = id[p];
        }
        return p;
    }

    /**
     * Returns the number of components.
     * @return the number of components (between  1  and  N )
     */
    public int count() {
        return count;
    }
  
    /**
     * Are the two sites  p  and  q  in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return true if the two sites  p  and  q  are in the same component; false otherwise
     * @throws java.lang.IndexOutOfBoundsException unless
     *      both  0 &le; p &lt; N  and  0 &le; q &lt; N 
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
    /**
     * Merges the component containing site  p  with the 
     * the component containing site  q .
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless
     *      both  0 &le; p &lt; N  and  0 &le; q &lt; N 
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make root of smaller rank point to root of larger rank
        if      (rank[i] < rank[j]) id[i] = j;
        else if (rank[i] > rank[j]) id[j] = i;
        else {
            id[j] = i;
            rank[i]++;
        }
        count--;
    }


    /**
     * Reads in a an integer  N  and a sequence of pairs of integers
     * (between  0  and  N-1 ) from standard input, where each integer
     * in the pair represents some site;
     * if the sites are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
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
