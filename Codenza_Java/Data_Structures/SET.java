 

/*************************************************************************
 *  Compilation:  javac SET.java
 *  Execution:    java SET
 *  
 *  Set implementation using Java's TreeSet library.
 *  Does not allow duplicates.
 *
 *  % java SET
 *  128.112.136.11
 *  208.216.181.15
 *  null
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import edu.princeton.cs.introcs.StdOut;

/**
 *  The  SET  class represents an ordered set of comparable keys.
 *  It supports the usual  add ,  contains , and  delete 
 *  methods. It also provides ordered methods for finding the  minimum ,
 *   maximum ,  floor , and  ceiling  and set methods
 *  for  union ,  intersection , and  equality .
 *   
 *  This implementation uses a balanced binary search tree. It requires that
 *  the key type implements the  Comparable  interface and calls the
 *   compareTo()  and method to compare two keys. It does not call either
 *   equals()  or  hashCode() .
 *  The  add ,  contains ,  delete ,  minimum ,
 *   maximum ,  ceiling , and  floor  methods take
 *  logarithmic time in the worst case.
 *  The  size , and  is-empty  operations take constant time.
 *  Construction takes constant time.
 *   
 *  For additional documentation, see
 *  <a href="http://algs4.cs.princeton.edu/35applications">Section 3.5</a> of
 *   Algorithms in Java, 4th Edition  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

    /**
     * Initializes an empty set.
     */
    public SET() {
        set = new TreeSet<Key>();
    }

    /**
     * Adds the key to the set if it is not already present.
     * @param key the key to add
     * @throws NullPointerException if  key  is  null 
     */
    public void add(Key key) {
        if (key == null) throw new NullPointerException("called add() with a null key");
        set.add(key);
    }


    /**
     * Does the set contain the given key?
     * @param key the key
     * @return  true  if the set contains  key  and
     *      false  otherwise
     * @throws NullPointerException if  key  is  null 
     */
    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("called contains() with a null key");
        return set.contains(key);
    }

    /**
     * Removes the key from the set if the key is present.
     * @param key the key
     * @throws NullPointerException if  key  is  null 
     */
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("called delete() with a null key");
        set.remove(key);
    }

    /**
     * Returns the number of keys in the set.
     * @return the number of keys in the set
     */
    public int size() {
        return set.size();
    }

    /**
     * Is the set empty?
     * @return  true  if the set is empty, and  false  otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
 
    /**
     * Returns all of the keys in the set, as an iterator.
     * To iterate over all of the keys in a set named  set , use the
     * foreach notation:  for (Key key : set) .
     * @return an iterator to all of the keys in the set
     */
    public Iterator<Key> iterator() {
        return set.iterator();
    }

    /**
     * Returns the largest key in the set.
     * @return the largest key in the set
     * @throws NoSuchElementException if the set is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty set");
        return set.last();
    }

    /**
     * Returns the smallest key in the set.
     * @return the smallest key in the set
     * @throws NoSuchElementException if the set is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty set");
        return set.first();
    }


    /**
     * Returns the smallest key in the set greater than or equal to  key .
     * @return the smallest key in the set greater than or equal to  key 
     * @param key the key
     * @throws NoSuchElementException if there is no such key
     * @throws NullPointerException if  key  is  null 
     */
    public Key ceiling(Key key) {
        if (key == null) throw new NullPointerException("called ceiling() with a null key");
        Key k = set.ceiling(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /**
     * Returns the largest key in the set less than or equal to  key .
     * @return the largest key in the set table less than or equal to  key 
     * @param key the key
     * @throws NoSuchElementException if there is no such key
     * @throws NullPointerException if  key  is  null 
     */
    public Key floor(Key key) {
        if (key == null) throw new NullPointerException("called floor() with a null key");
        Key k = set.floor(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    /**
     * Returns the union of this set and that set.
     * @param that the other set
     * @return the union of this set and that set
     * @throws NullPointerException if  that  is  null 
     */
    public SET<Key> union(SET<Key> that) {
        if (that == null) throw new NullPointerException("called union() with a null argument");
        SET<Key> c = new SET<Key>();
        for (Key x : this) { c.add(x); }
        for (Key x : that) { c.add(x); }
        return c;
    }

    /**
     * Returns the intersection of this set and that set.
     * @param that the other set
     * @return the intersection of this set and that set
     * @throws NullPointerException if  that  is  null 
     */
    public SET<Key> intersects(SET<Key> that) {
        if (that == null) throw new NullPointerException("called intersects() with a null argument");
        SET<Key> c = new SET<Key>();
        if (this.size() < that.size()) {
            for (Key x : this) {
                if (that.contains(x)) c.add(x);
            }
        }
        else {
            for (Key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }
        return c;
    }

    /**
     * Does this set equal  y ?
     * Note that this method declares two empty sets to be equal
     * even if they are parameterized by different generic types.
     * This is consistent with the behavior of  equals()  
     * within Java's Collections framework.
     * @param y the other set
     * @return  true  if the two sets are equal;  false  otherwise
     */
    @Override
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        SET<Key> that = (SET<Key>) y;
        if (this.size() != that.size()) return false;
        try {
            for (Key k : this)
                if (!that.contains(k)) return false;
        }
        catch (ClassCastException exception) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of this set.
     * @return a string representation of this set, with the keys separated
     *   by single spaces
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Key key : this)
            s.append(key + " ");
        return s.toString();
    }

    /**
     * Unit tests the  SET  data type.
     */
    public static void main(String[] args) {
        SET<String> set = new SET<String>();


        // insert some keys
        set.add("www.cs.princeton.edu");
        set.add("www.cs.princeton.edu");    // overwrite old value
        set.add("www.princeton.edu");
        set.add("www.math.princeton.edu");
        set.add("www.yale.edu");
        set.add("www.amazon.com");
        set.add("www.simpsons.com");
        set.add("www.stanford.edu");
        set.add("www.google.com");
        set.add("www.ibm.com");
        set.add("www.apple.com");
        set.add("www.slashdot.com");
        set.add("www.whitehouse.gov");
        set.add("www.espn.com");
        set.add("www.snopes.com");
        set.add("www.movies.com");
        set.add("www.cnn.com");
        set.add("www.iitb.ac.in");


        StdOut.println(set.contains("www.cs.princeton.edu"));
        StdOut.println(!set.contains("www.harvardsucks.com"));
        StdOut.println(set.contains("www.simpsons.com"));
        StdOut.println();

        StdOut.println("ceiling(www.simpsonr.com) = " + set.ceiling("www.simpsonr.com"));
        StdOut.println("ceiling(www.simpsons.com) = " + set.ceiling("www.simpsons.com"));
        StdOut.println("ceiling(www.simpsont.com) = " + set.ceiling("www.simpsont.com"));
        StdOut.println("floor(www.simpsonr.com)   = " + set.floor("www.simpsonr.com"));
        StdOut.println("floor(www.simpsons.com)   = " + set.floor("www.simpsons.com"));
        StdOut.println("floor(www.simpsont.com)   = " + set.floor("www.simpsont.com"));
        StdOut.println();


        // print out all keys in the set in lexicographic order
        for (String s : set) {
            StdOut.println(s);
        }

    }

}
