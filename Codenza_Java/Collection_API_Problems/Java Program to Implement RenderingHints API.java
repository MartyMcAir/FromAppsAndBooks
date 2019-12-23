import java.awt.RenderingHints;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class RenderingHintsImpl
{
    private RenderingHints renderingHints;

    /**
     * Constructs a new object with keys and values initialized from the
     * specified Map object which may be null.
     **/
    public RenderingHintsImpl(Map<RenderingHints.Key, ?> init)
    {
        renderingHints = new RenderingHints(init);
    }

    /** Constructs a new object with the specified key/value pair. **/
    public RenderingHintsImpl(RenderingHints.Key key, Object value)
    {
        renderingHints = new RenderingHints(key, value);
    }

    /**
     * Adds all of the keys and corresponding values from the specified
     * RenderingHints object to this RenderingHints object.
     **/
    public void add(RenderingHints hints)
    {
        renderingHints.add(hints);
    }

    /** Clears this RenderingHints object of all key/value pairs. **/
    public void clear()
    {
        renderingHints.clear();
    }

    /**
     * Creates a clone of this RenderingHints object that has the same contents
     * as this RenderingHints object.
     **/
    public Object clone()
    {
        return renderingHints.clone();
    }

    /** Returns true if this RenderingHints contains a mapping for the specified key. **/
    public boolean containsKey(Object key)
    {
        return renderingHints.containsKey(key);
    }

    /** Returns true if this RenderingHints maps one or more keys to the specified value. **/
    public boolean containsValue(Object value)
    {
        return renderingHints.containsValue(value);
    }

    /** Returns a Set view of the mappings contained in this RenderingHints. **/
    public Set<Map.Entry<Object, Object>> entrySet()
    {
        return renderingHints.entrySet();
    }

    /** Returns the value to which the specified key is mapped. **/
    public Object get(Object key)
    {
        return renderingHints.get(key);
    }

    /** Returns true if this RenderingHints contains no key-value mappings. **/
    public boolean isEmpty()
    {
        return renderingHints.isEmpty();
    }

    /** Returns a Set view of the Keys contained in this RenderingHints. **/
    public Set<Object> keySet()
    {
        return renderingHints.keySet();
    }

    /** Maps the specified key to the specified value in this RenderingHints object. **/
    public Object put(Object key, Object value)
    {
        return renderingHints.put(key, value);
    }

    /** Copies all of the mappings from the specified Map to this RenderingHints. **/
    public void putAll(Map<?, ?> m)
    {
        renderingHints.putAll(m);
    }

    /** Removes the key and its corresponding value from this RenderingHints object. **/
    public Object remove(Object key)
    {
        return renderingHints.remove(key);
    }

    /** Returns the number of key-value mappings in this RenderingHints. **/
    public int size()
    {
        return renderingHints.size();
    }

    /** Returns a Collection view of the values contained in this RenderinHints. **/
    public Collection<Object> values()
    {
        return renderingHints.values();
    }

    public static void main(String... arg)
    {
        RenderingHintsImpl renderingHints = new RenderingHintsImpl(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        renderingHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        Map<Object, Object> anotherMap = new HashMap<Object, Object>();
        anotherMap.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        anotherMap.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        renderingHints.putAll(anotherMap);
        System.out.println("the key set of the renderingHints is ");
        Set<Object> keySet = renderingHints.keySet();
        Iterator<Object> itr = keySet.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the values of the renderingHints is ");
        Collection<Object> collectionValues = renderingHints.values();
        itr = collectionValues.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the entry set of the renderingHints is ");
        Iterator<Entry<Object, Object>> eitr;
        Set<Entry<Object, Object>> entrySet = renderingHints.entrySet();
        eitr = entrySet.iterator();
        while (eitr.hasNext())
            {
                System.out.println(eitr.next() + "\t");
            }
        System.out.println("the renderingHints contains Key  KEY_TEXT_ANTIALIASING :"
                           + renderingHints.containsKey(RenderingHints.KEY_TEXT_ANTIALIASING));
        System.out.println("the renderingHints contains Value VALUE_TEXT_ANTIALIAS_ON:"
                           + renderingHints.containsValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        System.out.println("the size of the renderingHints is " + renderingHints.size());
        renderingHints.clear();
        if (renderingHints.isEmpty())
            System.out.println("the renderingHints is empty");
        else
            System.out.println("the renderingHints is not empty");
    }
}

/*
the key set of the renderingHints is
Fractional metrics enable key   Alpha blending interpolation method key Stroke normalization control key    Color rendering quality key Text-specific antialiasing enable key   Dithering quality key
the values of the renderingHints is
Fractional text metrics mode    Highest quality alpha blending methods  Pure stroke conversion for accurate paths   Highest quality color rendering mode    Antialiased text mode   Dithered rendering mode
the entry set of the renderingHints is
Fractional metrics enable key=Fractional text metrics mode
Alpha blending interpolation method key=Highest quality alpha blending methods
Stroke normalization control key=Pure stroke conversion for accurate paths
Color rendering quality key=Highest quality color rendering mode
Text-specific antialiasing enable key=Antialiased text mode
Dithering quality key=Dithered rendering mode
the renderingHints contains Key  KEY_TEXT_ANTIALIASING :true
the renderingHints contains Value VALUE_TEXT_ANTIALIAS_ON:true
the size of the renderingHints is 6
the renderingHints is empty
