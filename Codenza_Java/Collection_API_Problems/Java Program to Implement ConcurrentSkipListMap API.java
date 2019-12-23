import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapImpl<K, V>
{
    private ConcurrentSkipListMap<K, V> concurrentSkipListMap;

    /**
     * Constructs a new, empty map, sorted according to the natural ordering of
     * the keys.
     **/
    public ConcurrentSkipListMapImpl()
    {
        concurrentSkipListMap = new ConcurrentSkipListMap<K, V>();
    }

    /**
     * Constructs a new, empty map, sorted according to the specified
     * comparator.
     **/
    public ConcurrentSkipListMapImpl(Comparator<? super K> comparator)
    {
        concurrentSkipListMap = new ConcurrentSkipListMap<K, V>(comparator);
    }

    /**
     * Constructs a new map containing the same mappings as the given map,
     * sorted according to the natural ordering of the keys.
     **/
    public ConcurrentSkipListMapImpl(Map<? extends K, ? extends V> m)
    {
        concurrentSkipListMap = new ConcurrentSkipListMap<K, V>(m);
    }

    /**
     * Constructs a new map containing the same mappings and using the same
     * ordering as the specified sorted map.
     **/
    public ConcurrentSkipListMapImpl(SortedMap<K, ? extends V> m)
    {
        concurrentSkipListMap = new ConcurrentSkipListMap<K, V>(m);
    }

    /**
     * Returns a key-value mapping associated with the least key greater than or
     * equal to the given key, or null if there is no such key.
     **/
    public Map.Entry<K, V> ceilingEntry(K key)
    {
        return concurrentSkipListMap.ceilingEntry(key);
    }

    /**
     * Returns the least key greater than or equal to the given key, or null if
     * there is no such key.
     **/
    public K ceilingKey(K key)
    {
        return concurrentSkipListMap.ceilingKey(key);
    }

    /** Removes all of the mappings from this map. **/
    public void clear()
    {
        concurrentSkipListMap.clear();
    }

    /** Returns a shallow copy of this ConcurrentSkipListMap instance. **/
    public ConcurrentSkipListMap<K, V> clone()
    {
        return concurrentSkipListMap.clone();
    }

    /**
     * Returns the comparator used to order the keys in this map, or null if
     * this map uses the natural ordering of its keys.
     **/
    public Comparator<? super K> comparator()
    {
        return concurrentSkipListMap.comparator();
    }

    /** Returns true if this map contains a mapping for the specified key. **/
    public boolean containsKey(Object key)
    {
        return concurrentSkipListMap.containsKey(key);
    }

    /** Returns true if this map maps one or more keys to the specified value. **/
    public boolean containsValue(Object value)
    {
        return concurrentSkipListMap.containsValue(value);
    }

    /** Returns a reverse order NavigableSet view of the keys contained in this map. **/
    public NavigableSet<K> descendingKeySet()
    {
        return concurrentSkipListMap.descendingKeySet();
    }

    /** Returns a reverse order view of the mappings contained in this map. **/
    public ConcurrentNavigableMap<K, V> descendingMap()
    {
        return concurrentSkipListMap.descendingMap();
    }

    /** Returns a Set view of the mappings contained in this map. **/
    public Set<Map.Entry<K, V>> entrySet()
    {
        return concurrentSkipListMap.entrySet();
    }

    /**
     * Returns a key-value mapping associated with the least key in this map, or
     * null if the map is empty.
     **/
    public Map.Entry<K, V> firstEntry()
    {
        return concurrentSkipListMap.firstEntry();
    }

    /** Returns the first (lowest) key currently in this map. **/
    public K firstKey()
    {
        return concurrentSkipListMap.firstKey();
    }

    /**
     * Returns the greatest key less than or equal to the given key, or null if
     * there is no such key.
     **/
    public K floorKey(K key)
    {
        return concurrentSkipListMap.floorKey(key);
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     **/
    public V get(Object key)
    {
        return concurrentSkipListMap.get(key);
    }

    /**
     * Returns a view of the portion of this map whose keys are strictly less
     * than toKey.
     **/
    public ConcurrentNavigableMap<K, V> headMap(K toKey)
    {
        return concurrentSkipListMap.headMap(toKey);
    }

    /**
     * Returns a view of the portion of this map whose keys are less than (or
     * equal to, if inclusive is true) toKey.
     **/
    public ConcurrentNavigableMap<K, V> headMap(K toKey, boolean inclusive)
    {
        return concurrentSkipListMap.headMap(toKey, inclusive);
    }

    /**
     * Returns a key-value mapping associated with the least key strictly
     * greater than the given key, or null if there is no such key.
     **/
    public Map.Entry<K, V> higherEntry(K key)
    {
        return concurrentSkipListMap.higherEntry(key);
    }

    /**
     * Returns the least key strictly greater than the given key, or null if
     * there is no such key.
     **/
    public K higherKey(K key)
    {
        return concurrentSkipListMap.higherKey(key);
    }

    /** Returns a Set view of the keys contained in this map. **/
    public Set<K> keySet()
    {
        return concurrentSkipListMap.keySet();
    }

    /**
     * Returns a key-value mapping associated with the greatest key in this map,
     * or null if the map is empty.
     **/
    public Map.Entry<K, V> lastEntry()
    {
        return concurrentSkipListMap.lastEntry();
    }

    /** Returns the last (highest) key currently in this map. **/
    public K lastKey()
    {
        return concurrentSkipListMap.lastKey();
    }

    /**
     * Returns a key-value mapping associated with the greatest key strictly
     * less than the given key, or null if there is no such key.
     **/
    public Map.Entry<K, V> lowerEntry(K key)
    {
        return concurrentSkipListMap.lowerEntry(key);
    }

    /**
     * Returns the greatest key strictly less than the given key, or null if
     * there is no such key.
     **/
    public K lowerKey(K key)
    {
        return concurrentSkipListMap.lowerKey(key);
    }

    /** Returns a NavigableSet view of the keys contained in this map. **/
    public NavigableSet<K> navigableKeySet()
    {
        return concurrentSkipListMap.navigableKeySet();
    }

    /**
     * Removes and returns a key-value mapping associated with the least key in
     * this map, or null if the map is empty.
     **/
    public Map.Entry<K, V> pollFirstEntry()
    {
        return concurrentSkipListMap.pollFirstEntry();
    }

    /**
     * Removes and returns a key-value mapping associated with the greatest key
     * in this map, or null if the map is empty.
     **/
    public Map.Entry<K, V> pollLastEntry()
    {
        return concurrentSkipListMap.pollLastEntry();
    }

    /** Associates the specified value with the specified key in this map. **/
    public V put(K key, V value)
    {
        return concurrentSkipListMap.put(key, value);
    }

    /** Copies all of the mappings from the specified map to this map. **/
    public void putAll(Map<? extends K, ? extends V> map)
    {
        concurrentSkipListMap.putAll(map);
    }

    /** Removes the mapping for this key from this TreeMap if present. **/
    public V remove(Object key)
    {
        return concurrentSkipListMap.remove(key);
    }

    /** Replaces the entry for a key only if currently mapped to some value. **/
    public V replace(K key, V value)
    {
        return concurrentSkipListMap.replace(key, value);
    }

    /** Replaces the entry for a key only if currently mapped to a given value. **/
    public boolean replace(K key, V oldValue, V newValue)
    {
        return concurrentSkipListMap.replace(key, oldValue, newValue);
    }

    /** Returns the number of key-value mappings in this map. **/
    public int size()
    {
        return concurrentSkipListMap.size();
    }

    /**
     * Returns a view of the portion of this map whose keys range from fromKey
     * to toKey.
     **/
    public ConcurrentNavigableMap<K, V> subMap(K fromKey, boolean fromInclusive,
            K toKey, boolean toInclusive)
    {
        return concurrentSkipListMap.subMap(fromKey, fromInclusive, toKey, toInclusive);
    }

    /**
     * Returns a view of the portion of this map whose keys range from fromKey,
     * inclusive, to toKey, exclusive.
     **/
    public ConcurrentNavigableMap<K, V> subMap(K fromKey, K toKey)
    {
        return concurrentSkipListMap.subMap(fromKey, toKey);
    }

    /** Returns a Collection view of the values contained in this map. **/
    public Collection<V> values()
    {
        return concurrentSkipListMap.values();
    }

    public static void main(String... arg)
    {
        ConcurrentSkipListMapImpl<Integer, Integer> concurrentSkipListMap
            = new ConcurrentSkipListMapImpl<Integer, Integer>();
        concurrentSkipListMap.put(10, 100);
        concurrentSkipListMap.put(89, -89);
        concurrentSkipListMap.put(45, 345);
        concurrentSkipListMap.put(90, 23);
        Map<Integer, Integer> anotherMap = new HashMap<Integer, Integer>();
        anotherMap.put(34, 9);
        anotherMap.put(23, 00);
        concurrentSkipListMap.putAll(anotherMap);
        System.out.println("the key set of the concurrentSkipListMap map is ");
        Set<Integer> keySet = concurrentSkipListMap.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the concurrentSkipListMap is ");
        Collection<Integer> collectionValues = concurrentSkipListMap.values();
        itr = collectionValues.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("poll first entry of the map ");
        Map.Entry<Integer, Integer> pollFirstEntry = concurrentSkipListMap.pollFirstEntry();
        System.out.println("key = " + pollFirstEntry.getKey() + " value = " + pollFirstEntry.getValue());
        System.out.println("poll last entry of the map ");
        Map.Entry<Integer, Integer> pollLastEntry = concurrentSkipListMap.pollLastEntry();
        System.out.println("key = " + pollLastEntry.getKey() + " value = " + pollLastEntry.getValue());
        System.out.println("the entry set of the concurrentSkipListMap is ");
        Iterator<Entry<Integer, Integer>> eitr;
        Set<Entry<Integer, Integer>> entrySet = concurrentSkipListMap.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the concurrentSkipListMap contains Key 34 :"
                           + concurrentSkipListMap.containsKey(34));
        System.out.println("the  concurrentSkipListMap contains Value 600 :"
                           + concurrentSkipListMap.containsValue(600));
        System.out.println("the size of the concurrentSkipListMap is " + concurrentSkipListMap.size());
        concurrentSkipListMap.clear();
    }
}

/*
the key set of the concurrentSkipListMap map is
10  23  34  45  89  90
the values of the concurrentSkipListMap is
100 0   9   345 -89 23
poll first entry of the map
key = 10 value = 100
poll last entry of the map
key = 90 value = 23
the entry set of the concurrentSkipListMap is
23=0
34=9
45=345
89=-89
the concurrentSkipListMap contains Key 34 :true
the  concurrentSkipListMap contains Value 600 :false
the size of the concurrentSkipListMap is 4
