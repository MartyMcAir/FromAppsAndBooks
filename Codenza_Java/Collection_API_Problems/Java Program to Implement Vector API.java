import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class VectorImpl<E>
{
    private Vector<E> vector;

    /**
       Constructs an empty vector so that its internal data array has size 10
       and its standard capacity increment is zero.
    **/
    public VectorImpl()
    {
        vector = new Vector<E>();
    }

    /**
       Constructs an empty vector so that its internal data array has size 10
       and its standard capacity increment is zero.
    **/
    public VectorImpl(Collection<? extends E> c)
    {
        vector = new Vector<E>(c);
    }

    /**
       Constructs an empty vector with the specified initial capacity and with
       its capacity increment equal to zero
    **/
    public VectorImpl(int initialCapacity)
    {
        vector = new Vector<E>(initialCapacity);
    }

    /**
       Constructs an empty vector with the specified initial capacity and
       capacity increment.
    **/
    public VectorImpl(int initialCapacity, int capacityIncrement)
    {
        vector = new Vector<E>(initialCapacity, capacityIncrement);
    }

    /** Appends the specified element to the end of this Vector. **/
    public boolean add(E e)
    {
        return vector.add(e);
    }

    /** Inserts the specified element at the specified position in this Vector. **/
    public void add(int index, E element)
    {
        vector.add(index, element);
    }

    /**
       Appends all of the elements in the specified Collection to the end of
       this Vector, in the order that they are returned by the specified
       Collection's Iterator.
    **/
    public boolean addAll(Collection<? extends E> c)
    {
        return vector.addAll(c);
    }

    /**
       Inserts all of the elements in the specified Collection into this Vector
       at the specified position.
    **/
    public boolean addAll(int index, Collection<? extends E> c)
    {
        return vector.addAll(index, c);
    }

    /** Adds the specified component to the end of this vector, increasing its size by one. **/
    public void addElement(E obj)
    {
        vector.addElement(obj);
    }

    /** Returns the current capacity of this vector. **/
    public int capacity()
    {
        return vector.capacity();
    }

    /** Removes all of the elements from this Vector. **/
    public void clear()
    {
        vector.clear();
    }

    /** Returns a clone of this vector. **/
    public Object clone()
    {
        return vector.clone();
    }

    /** Returns true if this vector contains the specified element. **/
    public boolean contains(Object o)
    {
        return vector.contains(o);
    }

    /** Returns true if this Vector contains all of the elements in the specified Collection. **/
    public boolean containsAll(Collection<?> c)
    {
        return vector.containsAll(c);
    }

    /** Copies the components of this vector into the specified array. **/
    public void copyInto(Object[] anArray)
    {
        vector.copyInto(anArray);
    }

    /** Returns the component at the specified index. **/
    public E elementAt(int index)
    {
        return vector.elementAt(index);
    }

    /** Returns an enumeration of the components of this vector. **/
    public Enumeration<E> elements()
    {
        return vector.elements();
    }

    /**
       Increases the capacity of this vector, if necessary, to ensure that it
       can hold at least the number of components specified by the minimum
       capacity argument.
    **/
    public void ensureCapacity(int minCapacity)
    {
        vector.ensureCapacity(minCapacity);
    }

    /** Compares the specified Object with this Vector for equality. **/
    public boolean equals(Object o)
    {
        return vector.equals(o);
    }

    /** Returns the first component (the item at index 0) of this vector. **/
    public E firstElement()
    {
        return vector.firstElement();
    }

    /** Returns the element at the specified position in this Vector. **/
    public E get(int index)
    {
        return vector.get(index);
    }

    /** Returns the hash code value for this Vector. **/
    public int hashCode()
    {
        return vector.hashCode();
    }

    /**
       Returns the index of the first occurrence of the specified element in
       this vector, or -1 if this vector does not contain the element.
    **/
    public int indexOf(Object o)
    {
        return vector.indexOf(o);
    }

    /**
       Returns the index of the last occurrence of the specified element in this
       vector, searching backwards from index, or returns -1 if the element is
       not found.
    **/
    public int indexOf(Object o, int index)
    {
        return vector.indexOf(o, index);
    }

    /** Inserts the specified object as a component in this vector at the specified index. **/
    public void insertElementAt(E obj, int index)
    {
        vector.insertElementAt(obj, index);
    }

    /** Tests if this vector has no components. **/
    public boolean isEmpty()
    {
        return vector.isEmpty();
    }

    /** Returns an iterator over the elements in this list in proper sequence. **/
    public Iterator<E> iterator()
    {
        return vector.iterator();
    }

    /** Returns the last component of the vector. **/
    public E lastElement()
    {
        return vector.lastElement();
    }

    /**
       Returns the index of the last occurrence of the specified element in this
       vector, or -1 if this vector does not contain the element.
    **/
    public int lastIndexOf(Object o)
    {
        return vector.lastIndexOf(o);
    }

    /**
       Returns the index of the last occurrence of the specified element in this
       vector, searching backwards from index, or returns -1 if the element is
       not found.
    **/
    public int lastIndexOf(Object o, int index)
    {
        return vector.lastIndexOf(o, index);
    }

    /**  Returns a list iterator over the elements in this list (in proper sequence). **/
    public ListIterator<E> listIterator()
    {
        return vector.listIterator();
    }

    /**
       Returns a list iterator over the elements in this list (in proper sequence),
       starting at the specified position in the list.
    **/
    public ListIterator<E> listIterator(int index)
    {
        return vector.listIterator(index);
    }

    /** Removes the element at the specified position in this Vector. **/
    public E remove(int index)
    {
        return vector.remove(index);
    }

    /*
       Removes the first occurrence of the specified element in this Vector If
       the Vector does not contain the element, it is unchanged.
    **/
    public boolean remove(Object o)
    {
        return vector.remove(o);
    }

    /*
       Removes from this Vector all of its elements that are contained in the
       specified Collection.
    **/
    public boolean removeAll(Collection<?> c)
    {
        return vector.removeAll(c);
    }

    /** Removes all components from this vector and sets its size to zero. **/
    public void removeAllElements()
    {
        vector.removeAllElements();
    }

    /** Removes the first (lowest-indexed) occurrence of the argument from this vector. **/
    public boolean removeElement(Object obj)
    {
        return vector.removeElement(obj);
    }

    /** Retains only the elements in this Vector that are contained in specified Collection. **/
    public boolean retainAll(Collection<?> c)
    {
        return vector.removeAll(c);
    }

    /** Replaces the element at the specified position in this Vector with the specified element. **/
    public E set(int index, E element)
    {
        return vector.set(index, element);
    }

    /** Sets the component at the specified index of this vector to be the specified object. **/
    public void setElementAt(E obj, int index)
    {
        vector.setElementAt(obj, index);
    }

    /** Sets the size of this vector. **/
    public void setSize(int newSize)
    {
        vector.setSize(newSize);
    }

    /** Returns the number of components in this vector. **/
    public int size()
    {
        return vector.size();
    }

    /** Returns a view of the portion of this List between fromIndex, inclusive, and toIndex, exclusive. **/
    public List<E> subList(int fromIndex, int toIndex)
    {
        return vector.subList(fromIndex, toIndex);
    }

    /** Trims the capacity of this vector to be the vector's current size. **/
    public void trimToSize()
    {
        vector.trimToSize();
    }

    public static void main(String... arg)
    {
        VectorImpl<Integer> vector = new VectorImpl<Integer>();
        vector.add(100);
        vector.add(200);
        vector.add(399);
        vector.add(120);
        vector.addElement(400);
        vector.addElement(40);
        System.out.println("the capacity of the vector is " + vector.capacity());
        System.out.println("elements of vector is ");
        Enumeration<Integer> elements = vector.elements();
        while (elements.hasMoreElements())
            {
                System.out.print(elements.nextElement() + "\t");
            }
        System.out.println();
        if (vector.contains(200))
            System.out.println("the vector contains 200");
        System.out.println("the first element is " + vector.firstElement());
        System.out.println("the last element is  " + vector.lastElement());
        System.out.println("element " + vector.remove(2) + " at index 2 removed");
        System.out.println("the size of the vector is " + vector.size());
    }
}

/*
the capacity of the vector is 10
elements of vector is
100 200 399 120 400 40
the vector contains 200
the first element is 100
the last element is  40
element 399 at index 2 removed
the size of the vector is 5
