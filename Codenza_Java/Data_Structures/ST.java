 

/*************************************************************************
 *  Compilation:  javac ST.java
 *  Execution:    java ST
 *  
 *  Sorted symbol table implementation using a java.util.TreeMap.
 *  Does not allow duplicates.
 *
 *  % java ST
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

 
public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    /**
     * Initializes an empty symbol table.
     */
    public ST() {
        st = new TreeMap<Key, Value>();
    }


    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and  null  if the key is not in the symbol table
     * @throws NullPointerException if  key  is  null 
     */
    public Value get(Key key) {
        if (key == null) throw new NullPointerException("called get() with null key");
        return st.get(key);
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is  null , this effectively deletes the key from the symbol table.
     * @param key the key
     * @param val the value
     * @throws NullPointerException if  key  is  null 
     */
    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("called put() with null key");
        if (val == null) st.remove(key);
        else             st.put(key, val);
    }

    /**
     * Removes the key and associated value from the symbol table
     * (if the key is in the symbol table).
     * @param key the key
     * @throws NullPointerException if  key  is  null 
     */
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("called delete() with null key");
        st.remove(key);
    }

    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return  true  if this symbol table contains  key  and
     *      false  otherwise
     * @throws NullPointerException if  key  is  null 
     */
    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("called contains() with null key");
        return st.containsKey(key);
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return st.size();
    }

    /**
     * Is this symbol table empty?
     * @return  true  if this symbol table is empty and  false  otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns all keys in the symbol table as an  Iterable .
     * To iterate over all of the keys in the symbol table named  st ,
     * use the foreach notation:  for (Key key : st.keys()) .
     * @return all keys in the sybol table as an  Iterable 
     */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    /**
     * Returns all of the keys in the symbol table as an iterator.
     * To iterate over all of the keys in a symbol table named  st , use the
     * foreach notation:  for (Key key : st) .
     * @deprecated Use {@link #keys} instead.
     * This method is provided for backward compatibility with the version from
     *  Introduction to Programming in Java: An Interdisciplinary Approach. 
     * @return an iterator to all of the keys in the symbol table
     */
    @Deprecated
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /**
     * Returns the smallest key in the symbol table.
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return st.firstKey();
    }

    /**
     * Returns the largest key in the symbol table.
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return st.lastKey();
    }

    /**
     * Returns the smallest key in the symbol table greater than or equal to  key .
     * @return the smallest key in the symbol table greater than or equal to  key 
     * @param key the key
     * @throws NoSuchElementException if there is no such key
     * @throws NullPointerException if  key  is  null 
     */
    public Key ceiling(Key key) {
        if (key == null) throw new NullPointerException("called ceiling() with null key");
        Key k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /**
     * Returns the largest key in the symbol table less than or equal to  key .
     * @return the largest key in the symbol table less than or equal to  key 
     * @param key the key
     * @throws NoSuchElementException if there is no such key
     * @throws NullPointerException if  key  is  null 
     */
    public Key floor(Key key) {
        if (key == null) throw new NullPointerException("called floor() with null key");
        Key k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    /**
     * Unit tests the  ST  data type.
     */
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
