import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.script.SimpleBindings;

public class SimpleBindingsImpl
{
    private SimpleBindings simpleBindings;

    /** Default constructor uses a HashMap. **/
    public SimpleBindingsImpl()
    {
        simpleBindings = new SimpleBindings();
    }

    /** Constructor uses an existing Map to store the values. **/
    public SimpleBindingsImpl(Map<String, Object> m)
    {
        simpleBindings = new SimpleBindings(m);
    }

    /** Removes all of the mappings from this map. **/
    public void clear()
    {
        simpleBindings.clear();
    }

    /** Returns true if this map contains a mapping for the specified key. **/
    public boolean containsKey(Object key)
    {
        return simpleBindings.containsKey(key);
    }

    /** Returns true if this map maps one or more keys to the specified value. **/
    public boolean containsValue(Object value)
    {
        return simpleBindings.containsValue(value);
    }

    /** Returns a Set view of the mappings contained in this map. **/
    public Set<Map.Entry<String, Object>> entrySet()
    {
        return simpleBindings.entrySet();
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     **/
    public Object get(Object key)
    {
        return simpleBindings.get(key);
    }

    /** Returns true if this map contains no key-value mappings. **/
    public boolean isEmpty()
    {
        return simpleBindings.isEmpty();
    }

    /** Returns a Set view of the keys contained in this map. **/
    public Set<String> keySet()
    {
        return simpleBindings.keySet();
    }

    /** Associates the specified value with the specified key in this map. **/
    public Object put(String key, Object value)
    {
        return simpleBindings.put(key, value);
    }

    /** Copies all of the mappings from the specified map to this map. **/
    public void putAll(Map<? extends String, ? extends Object> m)
    {
        simpleBindings.putAll(m);
    }

    /** Removes the mapping for the specified key from this map if present. **/
    public Object remove(Object key)
    {
        return simpleBindings.remove(key);
    }

    /** Returns the number of key-value mappings in this map. **/
    public int size()
    {
        return simpleBindings.size();
    }

    /** Returns a Collection view of the values contained in this map. **/
    public Collection<Object> values()
    {
        return simpleBindings.values();
    }

    public static void main(String... arg)
    {
        SimpleBindingsImpl simpleBindings = new SimpleBindingsImpl();
        simpleBindings.put("one", 100);
        simpleBindings.put("two", 200);
        simpleBindings.put("three", 300);
        Map<String, Object> anotherMap = new HashMap<String, Object>();
        anotherMap.put("four", 400);
        anotherMap.put("five", 500);
        simpleBindings.putAll(anotherMap);
        System.out.println("the key set of the simpleBindings is ");
        Set<String> keySet = simpleBindings.keySet();
        Iterator<String> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the simpleBindings is ");
        Collection<Object> collectionValues = simpleBindings.values();
        Iterator<Object> citr = collectionValues.iterator();
        while (citr.hasNext())
            {
                System.out.print(citr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the simpleBindings is ");
        Iterator<Entry<String, Object>> eitr;
        Set<Entry<String, Object>> entrySet = simpleBindings.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the simpleBindings contains Key \"three\" :"
                           +  simpleBindings.containsKey("three"));
        System.out.println("the simpleBindings contains Value 600 :"
                           + simpleBindings.containsValue(600));
        System.out.println("the size of the simpleBindings is "
                           + simpleBindings.size());
        simpleBindings.clear();
        if (simpleBindings.isEmpty())
            System.out.println("the simpleBindings is empty");
        else
            System.out.println("the simpleBindings is not empty");
    }
}

/*
the key set of the simpleBindings is
two five    one three   four
the values of the simpleBindings is
200 500 100 300 400
the entry set of the simpleBindings is
two=200
five=500
one=100
three=300
four=400
the simpleBindings contains Key "three" :true
the simpleBindings contains Value 600 :false
the size of the simpleBindings is 5
the simpleBindings is empty
