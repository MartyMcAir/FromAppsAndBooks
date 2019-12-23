import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapImpl<K, V>
{
    private ConcurrentHashMap<K, V> concurrentHashMap;

    /**
     * Constructs an empty insertion-ordered LinkedHashMap instance with the
     * default initial capacity (16) and load factor (0.75).
     **/
    public ConcurrentHashMapImpl()
    {
        concurrentHashMap = new ConcurrentHashMap<K, V>();
    }

    /**
     * Constructs an empty insertion-ordered LinkedHashMap instance with the
     * specified initial capacity and a default load factor (0.75).
     **/
    public ConcurrentHashMapImpl(int initialCapacity)
    {
        concurrentHashMap = new ConcurrentHashMap<K, V>(initialCapacity);
    }

    /**
     * Constructs an empty insertion-ordered LinkedHashMap instance with the
     * specified initial capacity and load factor.
     **/
    public ConcurrentHashMapImpl(int initialCapacity, float loadFactor)
    {
        concurrentHashMap = new ConcurrentHashMap<K, V>(initialCapacity, loadFactor);
    }

    /**
     * Constructs an empty LinkedHashMap instance with the specified initial
     * capacity, load factor and ordering mode.
     **/
    public ConcurrentHashMapImpl(int initialCapacity, float loadFactor, int concurrencyLevel)
    {
        concurrentHashMap = new ConcurrentHashMap<K, V>(initialCapacity, loadFactor, concurrencyLevel);
    }

    /**
     * Constructs an insertion-ordered LinkedHashMap instance with the same
     * mappings as the specified map.
     **/
    public ConcurrentHashMapImpl(Map<? extends K, ? extends V> m)
    {
        concurrentHashMap = new ConcurrentHashMap<K, V>(m);
    }

    /** Removes all of the mappings from this map. **/
    public void clear()
    {
        concurrentHashMap.clear();
    }

    /** Returns true if this map contains a mapping for the specified key. **/
    public boolean containsKey(Object key)
    {
        return concurrentHashMap.containsKey(key);
    }

    /** Returns true if this map maps one or more keys to the specified value. **/
    public boolean containsValue(Object value)
    {
        return concurrentHashMap.containsValue(value);
    }

    /** Returns a Set view of the mappings contained in this map. **/
    public Set<Map.Entry<K, V>> entrySet()
    {
        return concurrentHashMap.entrySet();
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     **/
    public V get(Object key)
    {
        return concurrentHashMap.get(key);
    }

    /** Returns true if this map contains no key-value mappings. **/
    public boolean isEmpty()
    {
        return concurrentHashMap.isEmpty();
    }

    /** Returns a Set view of the keys contained in this map. **/
    public Set<K> keySet()
    {
        return concurrentHashMap.keySet();
    }

    /** Associates the specified value with the specified key in this map. **/
    public V put(K key, V value)
    {
        return concurrentHashMap.put(key, value);
    }

    /** Copies all of the mappings from the specified map to this map. **/
    public void putAll(Map<? extends K, ? extends V> m)
    {
        concurrentHashMap.putAll(m);
    }

    /** Removes the mapping for the specified key from this map if present. **/
    public V remove(Object key)
    {
        return concurrentHashMap.remove(key);
    }

    /** Returns the number of key-value mappings in this map. **/
    public int size()
    {
        return concurrentHashMap.size();
    }

    /** Returns a Collection view of the values contained in this map. **/
    public Collection<V> values()
    {
        return concurrentHashMap.values();
    }

    /** Returns an enumeration of the values in this table. **/
    public Enumeration<V> elements()
    {
        return concurrentHashMap.elements();
    }

    /**
     * If the specified key is not already associated with a value, associate it
     * with the given value.
     **/
    public V putIfAbsent(K key, V value)
    {
        return concurrentHashMap.putIfAbsent(key, value);
    }

    /** Replaces the entry for a key only if currently mapped to some value. **/
    public V replace(K key, V value)
    {
        return concurrentHashMap.replace(key, value);
    }

    /** Replaces the entry for a key only if currently mapped to a given value. **/
    public boolean replace(K key, V oldValue, V newValue)
    {
        return concurrentHashMap.replace(key, oldValue, newValue);
    }

    public static void main(String... arg)
    {
        ConcurrentHashMapImpl<Integer, Integer> concurrentHashMap
            = new ConcurrentHashMapImpl<Integer, Integer>();
        concurrentHashMap.put(1, 100);
        concurrentHashMap.put(2, 200);
        concurrentHashMap.put(3, 300);
        concurrentHashMap.put(4, 400);
        Map<Integer, Integer> anotherMap = new HashMap<Integer, Integer>();
        concurrentHashMap.putAll(anotherMap);
        System.out.println("the key set of the concurrentHashMap is ");
        Set<Integer> keySet = concurrentHashMap.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the concurrentHashMap is ");
        Collection<Integer> collectionValues = concurrentHashMap.values();
        itr = collectionValues.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the concurrentHashMap is ");
        Iterator<Entry<Integer, Integer>> eitr;
        Set<Entry<Integer, Integer>> entrySet = concurrentHashMap.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the concurrentHashMap contains Key 3 :" + concurrentHashMap.containsKey(3));
        System.out.println("the concurrentHashMap contains Value 600 :"
                           +courrentHashMap.containsValue(600));
        System.out.println("Put the key 10 with value 1000  if not asscociated : "
                           + concurrentHashMap.putIfAbsent(10, 1000));
        System.out.println("replace key 3 oldvalue of 300 and newvalue 500 :"
                           + concurrentHashMap.replace(3, 300, 500));
        System.out.println("the size of the concurrentHashMap is "
                           + concurrentHashMap.size());
        concurrentHashMap.clear();
        if (concurrentHashMap.isEmpty())
            System.out.println("the concurrentHashMap is empty");
        else
            System.out.println("the concurrentHashMap is not empty");
    }
}

/*
the key set of the concurrentHashMap is
2   1   3   4
the values of the concurrentHashMap is
200 100 300 400
the entry set of the concurrentHashMap is
2=200
1=100
3=300
4=400
the concurrentHashMap contains Key 3 :true
the concurrentHashMap contains Value 600 :false
Put the key 10 with value 1000  if not asscociated : null
replace key 3 oldvalue of 300 and newvalue 500 :true
the size of the concurrentHashMap is 5
the concurrentHashMap is empty
