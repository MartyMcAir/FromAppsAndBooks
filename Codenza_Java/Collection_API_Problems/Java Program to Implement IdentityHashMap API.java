import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IdentityHashMapImpl<K, V>
{
    private IdentityHashMap<K, V> identityHashMap;

    /**
     * Constructs a new, empty identity hash map with a default expected maximum
     * size (21).
     **/
    public IdentityHashMapImpl()
    {
        identityHashMap = new IdentityHashMap<K, V>();
    }

    /** Constructs a new, empty map with the specified expected maximum size. **/
    public IdentityHashMapImpl(int expectedMaxSize)
    {
        identityHashMap = new IdentityHashMap<>(expectedMaxSize);
    }

    /**
     * Constructs a new identity hash map containing the keys-value mappings in
     * the specified map.
     **/
    public IdentityHashMapImpl(Map<? extends K, ? extends V> m)
    {
        identityHashMap = new IdentityHashMap<>(m);
    }

    /** Removes all of the mappings from this map. **/
    public void clear()
    {
        identityHashMap.clear();
    }

    /** Returns true if this map contains a mapping for the specified key. **/
    public boolean containsKey(Object key)
    {
        return identityHashMap.containsKey(key);
    }

    /** Returns true if this map maps one or more keys to the specified value. **/
    public boolean containsValue(Object value)
    {
        return identityHashMap.containsValue(value);
    }

    /** Returns a Set view of the mappings contained in this map. **/
    public Set<Map.Entry<K, V>> entrySet()
    {
        return identityHashMap.entrySet();
    }

    /** Returns a Set view of the keys contained in this map. **/
    public Set<K> keySet()
    {
        return identityHashMap.keySet();
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     **/
    public V get(Object key)
    {
        return identityHashMap.get(key);
    }

    /** Associates the specified value with the specified key in this map. **/
    public V put(K key, V value)
    {
        return identityHashMap.put(key, value);
    }

    /** Copies all of the mappings from the specified map to this map. **/
    public void putAll(Map<? extends K, ? extends V> map)
    {
        identityHashMap.putAll(map);
    }

    /** Removes the mapping for this key from this TreeMap if present. **/
    public V remove(Object key)
    {
        return identityHashMap.remove(key);
    }

    /** Returns the number of key-value mappings in this map. **/
    public int size()
    {
        return identityHashMap.size();
    }

    /** Returns a Collection view of the values contained in this map. **/
    public Collection<V> values()
    {
        return identityHashMap.values();
    }

    /** Returns true if this map contains no key-value mappings. **/
    public boolean isEmpty()
    {
        return identityHashMap.isEmpty();
    }

    public static void main(String... arg)
    {
        IdentityHashMapImpl<Integer, Integer> identityhashMap = new IdentityHashMapImpl<Integer, Integer>();
        identityhashMap.put(1, 100);
        identityhashMap.put(2, 200);
        identityhashMap.put(3, 300);
        Map<Integer, Integer> anotherMap = new HashMap<Integer, Integer>();
        anotherMap.put(4, 400);
        anotherMap.put(5, 500);
        identityhashMap.putAll(anotherMap);
        System.out.println("the key set of the identityhashmap is ");
        Set<Integer> keySet = identityhashMap.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the identityhashmap is ");
        Collection<Integer> collectionValues = identityhashMap.values();
        itr = collectionValues.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the identityhashmap is ");
        Iterator<Entry<Integer, Integer>> eitr;
        Set<Entry<Integer, Integer>> entrySet = identityhashMap.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the identityhashmap contains Key 3 :" + identityhashMap.containsKey(3));
        System.out.println("the identityhashmap contains Value 600 :" + identityhashMap.containsValue(600));
        System.out.println("the size of the identityhashmap is " + identityhashMap.size());
        identityhashMap.clear();
        if (identityhashMap.isEmpty())
            System.out.println("the identityhashmap is empty");
        else
            System.out.println("the identityhashmap is not empty");
    }
}

/*
the key set of the identityhashmap is
1   4   3   5   2
the values of the identityhashmap is
100 400 300 500 200
the entry set of the identityhashmap is
1=100
4=400
3=300
5=500
2=200
the identityhashmap contains Key 3 :true
the identityhashmap contains Value 600 :false
the size of the identityhashmap is 5
the identityhashmap is empty
