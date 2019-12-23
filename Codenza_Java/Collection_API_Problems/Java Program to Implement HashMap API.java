import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapImpl<K, V>
{
    private HashMap<K, V> hashMap;

    /*
     * Constructs an empty HashMap with the default initial capacity (16) and
     * the default load factor (0.75).
     */
    public HashMapImpl()
    {
        hashMap = new HashMap<K, V>();
    }

    /*
     * Constructs an empty HashMap with the specified initial capacity and the
     * default load factor (0.75).
     */
    public HashMapImpl(int initialCapacity)
    {
        hashMap = new HashMap<K, V>(initialCapacity);
    }

    /*
     * Constructs an empty HashMap with the specified initial capacity and load
     * factor.
     */
    public HashMapImpl(int initialCapacity, float loadFactor)
    {
        hashMap = new HashMap<K, V>(initialCapacity, loadFactor);
    }

    /* Constructs a new HashMap with the same mappings as the specified Map. */
    public HashMapImpl(Map<? extends K, ? extends V> m)
    {
        hashMap = new HashMap<K, V>(m);
    }

    /* Removes all of the mappings from this map. */
    public void clear()
    {
        hashMap.clear();
    }

    /*
     * Returns a shallow copy of this HashMap instance: the keys and values
     * themselves are not cloned.
     */
    public Object clone()
    {
        return hashMap.clone();
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(Object key)
    {
        return hashMap.containsKey(key);
    }

    /* Returns true if this map maps one or more keys to the specified value. */
    public boolean containsValue(Object value)
    {
        return hashMap.containsValue(value);
    }

    /* Returns a Set view of the mappings contained in this map. */
    public Set<Map.Entry<K, V>> entrySet()
    {
        return hashMap.entrySet();
    }

    /*
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(Object key)
    {
        return hashMap.get(key);
    }

    /* Returns true if this map contains no key-value mappings. */
    public boolean isEmpty()
    {
        return hashMap.isEmpty();
    }

    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet()
    {
        return hashMap.keySet();
    }

    /* Associates the specified value with the specified key in this map. */
    public V put(K key, V value)
    {
        return hashMap.put(key, value);
    }

    /* Copies all of the mappings from the specified map to this map. */
    public void putAll(Map<? extends K, ? extends V> m)
    {
        hashMap.putAll(m);
    }

    /* Removes the mapping for the specified key from this map if present. */
    public V remove(Object key)
    {
        return hashMap.remove(key);
    }

    /* Returns the number of key-value mappings in this map. */
    public int size()
    {
        return hashMap.size();
    }

    /* Returns a Collection view of the values contained in this map. */
    public Collection<V> values()
    {
        return hashMap.values();
    }

    public static void main(String... arg)
    {
        HashMapImpl<Integer, Integer> hashMap = new HashMapImpl<Integer, Integer>();
        hashMap.put(1, 100);
        hashMap.put(2, 200);
        hashMap.put(3, 300);
        Map<Integer, Integer> anotherMap = new HashMap<Integer, Integer>();
        anotherMap.put(4, 400);
        anotherMap.put(5, 500);
        hashMap.putAll(anotherMap);
        System.out.println("the key set of the map is ");
        Set<Integer> keySet = hashMap.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the map is ");
        Collection<Integer> collectionValues = hashMap.values();
        itr = collectionValues.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the map is ");
        Iterator<Entry<Integer, Integer>> eitr;
        Set<Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the hash Map contains Key 3 :" + hashMap.containsKey(3));
        System.out.println("the hash Map contains Value 600 :" + hashMap.containsValue(600));
        System.out.println("the size of the hash Map is " + hashMap.size());
        hashMap.clear();
        if (hashMap.isEmpty())
            System.out.println("the hash Map is empty");
        else
            System.out.println("the hash Map is not empty");
    }
}

/*
the key set of the map is
1   2   3   4   5
the values of the map is
100 200 300 400 500
the entry set of the map is
1=100
2=200
3=300
4=400
5=500
the hash Map contains Key 3 :true
the hash Map contains Value 600 :false
the size of the hash Map is 5
the hash Map is empty
