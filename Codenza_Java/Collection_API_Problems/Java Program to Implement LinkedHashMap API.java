import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class LinkedHashMapImpl<K, V>
{
    private LinkedHashMap<K, V> linkedHashMap;

    /*
     * Constructs an empty insertion-ordered LinkedHashMap instance with the
     * default initial capacity (16) and load factor (0.75).
     */
    public LinkedHashMapImpl()
    {
        linkedHashMap = new LinkedHashMap<K, V>();
    }

    /*
     * Constructs an empty insertion-ordered LinkedHashMap instance with the
     * specified initial capacity and a default load factor (0.75).
     */
    public LinkedHashMapImpl(int initialCapacity)
    {
        linkedHashMap = new LinkedHashMap<K, V>(initialCapacity);
    }

    /*
     * Constructs an empty insertion-ordered LinkedHashMap instance with the
     * specified initial capacity and load factor.
     */
    public LinkedHashMapImpl(int initialCapacity, float loadFactor)
    {
        linkedHashMap = new LinkedHashMap<K, V>(initialCapacity, loadFactor);
    }

    /*
     * Constructs an empty LinkedHashMap instance with the specified initial
     * capacity, load factor and ordering mode.
     */
    public LinkedHashMapImpl(int initialCapacity, float loadFactor, boolean accessOrder)
    {
        linkedHashMap = new LinkedHashMap<K, V>(initialCapacity, loadFactor, accessOrder);
    }

    /*
     * Constructs an insertion-ordered LinkedHashMap instance with the same
     * mappings as the specified map.
     */
    public LinkedHashMapImpl(Map<? extends K, ? extends V> m)
    {
        linkedHashMap = new LinkedHashMap<K, V>(m);
    }

    /* Removes all of the mappings from this map. */
    public void clear()
    {
        linkedHashMap.clear();
    }

    /*
     * Returns a shallow copy of this LinkedHashMap instance: the keys and values
     * themselves are not cloned.
     */
    public Object clone()
    {
        return linkedHashMap.clone();
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(Object key)
    {
        return linkedHashMap.containsKey(key);
    }

    /* Returns true if this map maps one or more keys to the specified value. */
    public boolean containsValue(Object value)
    {
        return linkedHashMap.containsValue(value);
    }

    /* Returns a Set view of the mappings contained in this map. */
    public Set<Map.Entry<K, V>> entrySet()
    {
        return linkedHashMap.entrySet();
    }

    /*
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(Object key)
    {
        return linkedHashMap.get(key);
    }

    /* Returns true if this map contains no key-value mappings. */
    public boolean isEmpty()
    {
        return linkedHashMap.isEmpty();
    }

    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet()
    {
        return linkedHashMap.keySet();
    }

    /* Associates the specified value with the specified key in this map. */
    public V put(K key, V value)
    {
        return linkedHashMap.put(key, value);
    }

    /* Copies all of the mappings from the specified map to this map. */
    public void putAll(Map<? extends K, ? extends V> m)
    {
        linkedHashMap.putAll(m);
    }

    /* Removes the mapping for the specified key from this map if present. */
    public V remove(Object key)
    {
        return linkedHashMap.remove(key);
    }

    /* Returns the number of key-value mappings in this map. */
    public int size()
    {
        return linkedHashMap.size();
    }

    /* Returns a Collection view of the values contained in this map. */
    public Collection<V> values()
    {
        return linkedHashMap.values();
    }

    public static void main(String... arg)
    {
        LinkedHashMapImpl<Integer, Integer> linkedHashMap = new LinkedHashMapImpl<Integer, Integer>();
        linkedHashMap.put(1, 100);
        linkedHashMap.put(2, 200);
        linkedHashMap.put(3, 300);
        linkedHashMap.put(4, 400);
        Map<Integer, Integer> anotherMap = new HashMap<Integer, Integer>();
        linkedHashMap.putAll(anotherMap);
        System.out.println("the key set of the linked hashmap is ");
        Set<Integer> keySet = linkedHashMap.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the linkedhash map is ");
        Collection<Integer> collectionValues = linkedHashMap.values();
        itr = collectionValues.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the linkedhash map is ");
        Iterator<Entry<Integer, Integer>> eitr;
        Set<Entry<Integer, Integer>> entrySet = linkedHashMap.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the hash Map contains Key 3 :" + linkedHashMap.containsKey(3));
        System.out.println("the hash Map contains Value 600 :" + linkedHashMap.containsValue(600));
        System.out.println("the size of the hash Map is " + linkedHashMap.size());
        linkedHashMap.clear();
        if (linkedHashMap.isEmpty())
            System.out.println("the linked hash Map is empty");
        else
            System.out.println("the hash Map is not empty");
    }

}

/*
the key set of the linked hash map is
1   2   3   4
the values of the linked hash map is
100 200 300 400
the entry set of the linked hash map is
1=100
2=200
3=300
4=400
the linked hash Map contains Key 3 :true
the linked hash Map contains Value 600 :false
the size of the linked hash Map is 4
the linked hash Map is empty
