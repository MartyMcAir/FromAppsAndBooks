import java.util.Collection;
import java.util.List;
import javax.management.Attribute;
import javax.management.AttributeList;

public class AttributeListImpl
{
    private AttributeList attributeList;

    /** Constructs an empty AttributeList. **/
    public AttributeListImpl()
    {
        attributeList = new AttributeList();
    }

    /**
     * Constructs an AttributeList containing the elements of the AttributeList
     * specified, in the order in which they are returned by the AttributeList's
     * iterator.
    **/
    public AttributeListImpl(AttributeList list)
    {
        attributeList = new AttributeList();
    }

    /** Constructs an empty AttributeList with the initial capacity specified. **/
    public AttributeListImpl(int initialCapacity)
    {
        attributeList = new AttributeList(initialCapacity);
    }

    /**
     * Constructs an AttributeList containing the elements of the List
     * specified, in the order in which they are returned by the List's
     * iterator.
     **/
    public AttributeListImpl(List<Attribute> list)
    {
        attributeList = new AttributeList();
    }

    /** Adds the Attribute specified as the last element of the list. **/
    public void add(Attribute object)
    {
        attributeList.add(object);
    }

    /** Inserts the attribute specified as an element at the position specified. **/
    public void add(int index, Attribute object)
    {
        attributeList.add(index, object);
    }

    /** Inserts the specified element at the specified position in this list. **/
    public void add(int index, Object element)
    {
        attributeList.add(index, element);
    }

    /** Appends the specified element to the end of this list. **/
    public boolean add(Object element)
    {
        return attributeList.add(element);
    }

    /**
     * Appends all the elements in the AttributeList specified to the end of the
     * list, in the order in which they are returned by the Iterator of the
     * AttributeList specified.
    **/
    public boolean addAll(AttributeList list)
    {
        return attributeList.addAll(list);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's Iterator.
     **/
    public boolean addAll(Collection<?> c)
    {
        return attributeList.addAll(c);
    }

    /**
     * Inserts all of the elements in the AttributeList specified into this
     * list, starting at the specified position, in the order in which they are
     * returned by the Iterator of the AttributeList specified.
     **/
    public boolean addAll(int index, AttributeList list)
    {
        return attributeList.addAll(index, list);
    }

    /**
     * Inserts all of the elements in the specified collection into this list,
     * starting at the specified position.
    **/
    public boolean addAll(int index, Collection<?> c)
    {
        return attributeList.addAll(index, c);
    }

    /** Return a view of this list as a List<Attribute>. **/
    public List<Attribute> asList()
    {
        return attributeList.asList();
    }

    /** Sets the element at the position specified to be the attribute specified. **/
    public void set(int index, Attribute element)
    {
        attributeList.set(index, element);
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
    **/
    public Object set(int index, Object element)
    {
        return attributeList.set(index, element);
    }

    public static void main(String... arg)
    {
        AttributeListImpl attributeList = new AttributeListImpl();
        attributeList.add(new Attribute("one", 1));
        attributeList.add(new Attribute("two", 2));
        attributeList.add(new Attribute("three", 3));
        attributeList.add(new Attribute("four", 4));
        attributeList.add(new Attribute("five", 5));
        attributeList.add(new Attribute("six", 7));
        System.out.println("the elements of the attributelist are");
        List<Attribute> list = attributeList.asList();
        int index = 0;
        while (index < list.size())
            {
                System.out.print(list.get(index++) + "\t");
            }
        System.out.println();
        attributeList.set(5, new Attribute("six", 6));
        System.out.println("after setting index 5");
        System.out.println("the elements of the attributelist are");
        list = attributeList.asList();
        index = 0;
        while (index < list.size())
            {
                System.out.print(list.get(index++) + "\t");
            }
    }
}

/*
the elements of the attributelist are
one = 1 two = 2 three = 3   four = 4    five = 5    six = 7
after setting index 5
the elements of the attributelist are
one = 1 two = 2 three = 3   four = 4    five = 5    six = 6
