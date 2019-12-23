import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.jar.Attributes;

public class AttributesImpl
{
    private Attributes attributes;

    /** Constructs a new, empty Attributes object with default size. **/
    public AttributesImpl()
    {
        attributes = new Attributes();
    }

    /**
     * Constructs a new Attributes object with the same attribute name-value
     * mappings as in the specified Attributes.
     **/
    public AttributesImpl(Attributes attr)
    {
        attributes = new Attributes(attr);
    }

    /**
     * Constructs a new, empty Attributes object with the specified initial
     * size.
     **/
    public AttributesImpl(int size)
    {
        attributes = new Attributes(size);
    }

    /** Removes all attributes from this Map. **/
    public void clear()
    {
        attributes.clear();
    }

    /** Returns a copy of the Attributes **/
    public Object clone()
    {
        return attributes.clone();
    }

    /** Returns true if this Map contains the specified attribute name (key). **/
    public boolean containsKey(Object key)
    {
        return attributes.containsKey(key);
    }

    /**
     * Returns true if this Map maps one or more attribute names (keys) to the
     * specified value.
     **/
    public boolean containsValue(Object value)
    {
        return attributes.containsValue(value);
    }

    /**
     * Returns a Collection view of the attribute name-value mappings contained
     * in this Map.
     **/
    public Set<Map.Entry<Object, Object>> entrySet()
    {
        return attributes.entrySet();
    }

    /**
     * Returns the value of the specified attribute name, or null if the
     * attribute name was not found.
     **/
    public Object get(Object key)
    {
        return attributes.get(key);
    }

    /**
     * Returns the value of the specified Attributes.Name, or null if the
     * attribute was not found.
     **/
    public String getValue(Attributes.Name name)
    {
        return attributes.getValue(name);
    }

    /**
     * Returns the value of the specified attribute name, specified as a string,
     * or null if the attribute was not found.
     **/
    public String getValue(String name)
    {
        return attributes.getValue(name);
    }

    /** Returns true if this Map contains no attributes. **/
    public boolean isEmpty()
    {
        return attributes.isEmpty();
    }

    /** Returns a Set view of the attribute names (keys) contained in this Map. **/
    public Set<Object> keySet()
    {
        return attributes.keySet();
    }

    /**
     * Associates the specified value with the specified attribute name (key) in
     * this Map.
     **/
    public Object put(Object key, Object value)
    {
        return attributes.put(key, value);
    }

    /**
     * Copies all of the attribute name-value mappings from the specified
     * Attributes to this Map.
     **/
    public void putAll(Map<?, ?> m)
    {
        attributes.putAll(m);
    }

    /**
     * Associates the specified value with the specified attribute name,
     * specified as a String.
     **/
    public String putValue(String name, String value)
    {
        return attributes.putValue(name, value);
    }

    /** Removes the attribute with the specified name (key) from this Map **/
    public Object remove(Object key)
    {
        return attributes.remove(key);
    }

    /** Returns the number of attributes in this Map. **/
    public int size()
    {
        return attributes.size();
    }

    /** Returns a Collection view of the attribute values contained in this Map. **/
    public Collection<Object> values()
    {
        return attributes.values();
    }

    public static void main(String... arg)
    {
        Attributes.Name CLASS_PATH = new Attributes.Name("CLASS_PATH");
        Attributes.Name CONTENT_TYPE = new Attributes.Name("CONTENT_TYPE");
        Attributes.Name MANIFEST_VERSION = new Attributes.Name("MANIFEST_VERSION");
        AttributesImpl attribute = new AttributesImpl();
        attribute.put(CLASS_PATH, "root/sub_dir/class_path");
        attribute.put(CONTENT_TYPE, "UTF-8");
        attribute.put(MANIFEST_VERSION, "2");
        attribute.putValue("MAIN_CLASS", "TESTMAIN.java");
        System.out.println("the key set of the Attributes is ");
        Set<Object> keySet = attribute.keySet();
        Iterator<Object> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the Attributes is ");
        Collection<Object> collectionValues = attribute.values();
        itr = collectionValues.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the Attributes is ");
        Iterator<Entry<Object, Object>> eitr;
        Set<Entry<Object, Object>> entrySet = attribute.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the Attributes contains Key CLASS_PATH:" + attribute.containsKey(CLASS_PATH));
        System.out.println("the Attributes contains Value TESTMAIN.java :"
                           + attribute.containsValue("TESTMAIN.java"));
        System.out.println("the size of the Attributes is " + attribute.size());
        attribute.clear();
        if (attribute.isEmpty())
            System.out.println("the Attributes is empty");
        else
            System.out.println("the Attributes is not empty");
    }
}

/*
the key set of the Attributes is
MAIN_CLASS  MANIFEST_VERSION    CONTENT_TYPE    CLASS_PATH
the values of the Attributes is
TESTMAIN.java   2   UTF-8   root/sub_dir/class_path
the entry set of the Attributes is
MAIN_CLASS=TESTMAIN.java
MANIFEST_VERSION=2
CONTENT_TYPE=UTF-8
CLASS_PATH=root/sub_dir/class_path
the Attributes contains Key CLASS_PATH:true
the Attributes contains Value TESTMAIN.java :true
the size of the Attributes is 4
the Attributes is empty
