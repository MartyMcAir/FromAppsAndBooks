import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTableImpl<K, V>
{
    private Hashtable<K, V> hashTable;

    /*
     * Constructs a new, empty hashtable with a default initial capacity (11)
     * and load factor (0.75).
     */
    public HashTableImpl()
    {
        hashTable = new Hashtable<K, V>();
    }

    /*
     * Constructs a new, empty hashtable with the specified initial capacity and
     * default load factor (0.75).
     */
    public HashTableImpl(int initialCapacity)
    {
        hashTable = new Hashtable<K, V>(initialCapacity);
    }

    /*
     * Constructs a new, empty hashtable with the specified initial capacity and
     * the specified load factor.
     */
    public HashTableImpl(int initialCapacity, float loadFactor)
    {
        hashTable = new Hashtable<K, V>(initialCapacity, loadFactor);
    }

    /* Constructs a new hashtable with the same mappings as the given Map. */
    public HashTableImpl(Map<? extends K, ? extends V> t)
    {
        hashTable = new Hashtable<K, V>(t);
    }

    /* Clears this hashtable so that it contains no keys. */
    public void clear()
    {
        hashTable.clear();
    }

    /* Creates a shallow copy of this hashtable. */
    public Object clone()
    {
        return hashTable.clone();
    }

    /* Tests if some key maps into the specified value in this hashtable. */
    public boolean contains(Object value)
    {
        return hashTable.contains(value);
    }

    /* Returns true if this hashtable maps one or more keys to this value. */
    public boolean containsValue(Object value)
    {
        return hashTable.containsValue(value);
    }

    /* Tests if the specified object is a key in this hashtable. */
    public boolean containsKey(Object key)
    {
        return hashTable.containsKey(key);
    }

    /* Returns an enumeration of the values in this hashtable. */
    public Enumeration<V> elements()
    {
        return hashTable.elements();
    }

    /* Returns an enumeration of the values in this hashtable. */
    public Set<Map.Entry<K, V>> entrySet()
    {
        return hashTable.entrySet();
    }

    /*
     * Compares the specified Object with this Map for equality, as per the
     * definition in the Map interface.
     */
    public boolean equals(Object o)
    {
        return hashTable.equals(o);
    }

    /*
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(Object key)
    {
        return hashTable.get(key);
    }

    /*
     * Returns the hash code value for this Map as per the definition in the Map
     * interface.
     */
    public int hashCode()
    {
        return hashTable.hashCode();
    }

    /* Tests if this hashtable maps no keys to values. */
    public boolean isEmpty()
    {
        return hashTable.isEmpty();
    }

    /* Returns an enumeration of the keys in this hashtable. */
    public Enumeration<K> keys()
    {
        return hashTable.keys();
    }

    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet()
    {
        return hashTable.keySet();
    }

    /* Maps the specified key to the specified value in this hashtable. */
    public V put(K key, V value)
    {
        return hashTable.put(key, value);
    }

    /* Returns the number of keys in this hashtable. */
    public int size()
    {
        return hashTable.size();
    }

    /*
     * Returns a string representation of this Hashtable object in the form of a
     * set of entries, enclosed in braces and separated by the ASCII characters
     * ", " (comma and space).
     */
    public String toString()
    {
        return hashTable.toString();
    }

    /* Removes the key (and its corresponding value) from this hashtable. */
    public V remove(Object key)
    {
        return hashTable.remove(key);
    }

    /* Returns a Collection view of the values contained in this map. */
    public Collection<V> values()
    {
        return hashTable.values();
    }

    public static void main(String... arg)
    {
        HashTableImpl<Integer, Integer> hashTable = new HashTableImpl<Integer, Integer>();
        hashTable.put(1, 100);
        hashTable.put(2, 200);
        hashTable.put(3, 300);
        hashTable.put(4, 100);
        System.out.println("the key set of the hashTable is ");
        Set<Integer> keySet = hashTable.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the hashTable is ");
        Collection<Integer> values = hashTable.values();
        itr = values.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the hash table is");
        Set<Entry<Integer, Integer>> entrySet = hashTable.entrySet();
        Iterator<Entry<Integer, Integer>> eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the enumeration of the elements in hash Table");
        Enumeration<Integer> enumeration = hashTable.elements();
        while (enumeration.hasMoreElements())
            {
                System.out.print(enumeration.nextElement() + "\t");
            }
        System.out.println();
        System.out.println("the enumeration of the keys in hash Table");
        enumeration = hashTable.keys();
        while (enumeration.hasMoreElements())
            {
                System.out.print(enumeration.nextElement() + "\t");
            }
        System.out.println();
        System.out.println("the value " + hashTable.remove(2) + "removed");
        System.out.println("the hash table contains 200 " + hashTable.containsValue(200));
        hashTable.clear();
        if (hashTable.isEmpty())
            System.out.println("the hash table is empty after clear");
        else
            System.out.println("the hash table is not empty after clear");
    }
}

/*
the key set of the hashTable is
4   3   2   1
the values of the hashTable is
100 300 200 100
the entry set of the hash table is
4=100
3=300
2=200
1=100
the enumeration of the elements in hash Table
100 300 200 100
the enumeration of the keys in hash Table
4   3   2   1
the value 200removed
the hash table contains 200 false
the hash table is empty after clear
