import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakHashMapImpl<K, V>
{
    private WeakHashMap<K, V> weakHashMap;

    /**
     * Constructs a new, empty WeakHashMap with the default initial capacity
     * (16) and load factor (0.75).
     **/
    public WeakHashMapImpl()
    {
        weakHashMap = new WeakHashMap<K, V>();
    }

    /**
     * Constructs a new, empty WeakHashMap with the given initial capacity and
     * the default load factor (0.75).
     **/
    public WeakHashMapImpl(int initialCapacity)
    {
        weakHashMap = new WeakHashMap<K, V>(initialCapacity);
    }

    /**
     * Constructs a new, empty WeakHashMap with the given initial capacity and
     * the given load factor.
     **/
    public WeakHashMapImpl(int initialCapacity, float loadFactor)
    {
        weakHashMap = new WeakHashMap<K, V>(initialCapacity, loadFactor);
    }

    /** Constructs a new WeakHashMap with the same mappings as the specified map. **/
    public WeakHashMapImpl(Map<? extends K, ? extends V> m)
    {
        weakHashMap = new WeakHashMap<K, V>(m);
    }

    /** Removes all of the mappings from this map. **/
    public void clear()
    {
        weakHashMap.clear();
    }

    /** Returns true if this map contains a mapping for the specified key. **/
    public boolean containsKey(Object key)
    {
        return weakHashMap.containsKey(key);
    }

    /** Returns true if this map maps one or more keys to the specified value. **/
    public boolean containsValue(Object value)
    {
        return weakHashMap.containsValue(value);
    }

    /** Returns a Set view of the mappings contained in this map. **/
    public Set<Map.Entry<K, V>> entrySet()
    {
        return weakHashMap.entrySet();
    }

    /** Returns a Set view of the keys contained in this map. **/
    public Set<K> keySet()
    {
        return weakHashMap.keySet();
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     **/
    public V get(Object key)
    {
        return weakHashMap.get(key);
    }

    /** Associates the specified value with the specified key in this map. **/
    public V put(K key, V value)
    {
        return weakHashMap.put(key, value);
    }

    /** Copies all of the mappings from the specified map to this map. **/
    public void putAll(Map<? extends K, ? extends V> map)
    {
        weakHashMap.putAll(map);
    }

    /** Removes the mapping for this key from this TreeMap if present. **/
    public V remove(Object key)
    {
        return weakHashMap.remove(key);
    }

    /** Returns the number of key-value mappings in this map. **/
    public int size()
    {
        return weakHashMap.size();
    }

    /** Returns a Collection view of the values contained in this map. **/
    public Collection<V> values()
    {
        return weakHashMap.values();
    }

    /** Returns true if this map contains no key-value mappings. **/
    public boolean isEmpty()
    {
        return weakHashMap.isEmpty();
    }

    public static void main(String... arg)
    {
        WeakHashMapImpl<Integer, Integer> weakhashMap = new WeakHashMapImpl<Integer, Integer>();
        weakhashMap.put(1, 100);
        weakhashMap.put(2, 200);
        weakhashMap.put(3, 300);
        Map<Integer, Integer> anotherMap = new HashMap<Integer, Integer>();
        anotherMap.put(4, 400);
        anotherMap.put(5, 500);
        weakhashMap.putAll(anotherMap);
        System.out.println("the key set of the weakhashmap is ");
        Set<Integer> keySet = weakhashMap.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the weakhashmap is ");
        Collection<Integer> collectionValues = weakhashMap.values();
        itr = collectionValues.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the weakhashmap is ");
        Iterator<Entry<Integer, Integer>> eitr;
        Set<Entry<Integer, Integer>> entrySet = weakhashMap.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the weakhashmap contains Key 3 :" + weakhashMap.containsKey(3));
        System.out.println("the weakhashmap contains Value 600 :" + weakhashMap.containsValue(600));
        System.out.println("the size of the weakhashmap is " + weakhashMap.size());
        weakhashMap.clear();
        if (weakhashMap.isEmpty())
            System.out.println("the weakhashmap is empty");
        else
            System.out.println("the weakhashmap is not empty");
    }
}

/*
the key set of the weakhashmap is
5   4   3   2   1
the values of the weakhashmap is
500 400 300 200 100
the entry set of the weakhashmap is
5=500
4=400
3=300
2=200
1=100
the weakhashmap contains Key 3 :true
the weakhashmap contains Value 600 :false
the size of the weakhashmap is 5
the weakhashmap is empty
