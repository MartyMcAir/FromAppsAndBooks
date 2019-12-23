import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetImp<E>
{
    private LinkedHashSet<E> linkedHashSet;

    /*
     * Constructs a new, empty linked hash set with the default initial capacity
     * (16) and load factor (0.75).
     */
    public LinkedHashSetImp()
    {
        linkedHashSet = new LinkedHashSet<E>();
    }

    /*
     * Constructs a new linked hash set with the same elements as the specified
     * collection.
     */
    public LinkedHashSetImp(Collection<? extends E> c)
    {
        linkedHashSet = new LinkedHashSet<E>(c);
    }

    /*
     * Constructs a new, empty linked hash set with the specified initial
     * capacity and the default load factor (0.75).
     */
    public LinkedHashSetImp(int initialCapacity)
    {
        linkedHashSet = new LinkedHashSet<E>(initialCapacity);
    }

    /*
     * Constructs a new, empty linked hash set with the specified initial
     * capacity and load factor.
     */
    public LinkedHashSetImp(int initialCapacity, float loadFactor)
    {
        linkedHashSet = new LinkedHashSet<E>(initialCapacity, loadFactor);
    }

    /* Returns the number of elements in this set (its cardinality). */
    public int size()
    {
        return linkedHashSet.size();
    }

    /* Returns true if this set contains no elements. */
    public boolean isEmpty()
    {
        return linkedHashSet.isEmpty();
    }

    /*
     * Returns true if this set contains the specified element i.e
     * returns true if and only if this set contains an element e such that
     * (o==null ? e==null : o.equals(e)).
     */
    public boolean contains(Object o)
    throws ClassCastException,NullPointerException
    {
        return linkedHashSet.contains(o);
    }

    /* Returns an iterator over the elements in this set */
    public Iterator<E> iterator()
    {
        return linkedHashSet.iterator();
    }

    /* Returns an array containing all of the elements in this set. */
    public Object[] toArray()
    {
        return linkedHashSet.toArray();
    }

    /*
     * Returns an array containing all of the elements in this set; the runtime
     * type of the returned array is that of the specified array
     */
    public <T> T[] toArray(T[] a)
    throws ArrayStoreException,NullPointerException
    {
        return linkedHashSet.toArray(a);
    }

    /* Adds the specified element to this set if it is not already present */
    public boolean add(E e)
    throws UnsupportedOperationException,ClassCastException, NullPointerException, IllegalArgumentException
    {
        return linkedHashSet.add(e);
    }

    /* Removes the specified element from this set if it is present */
    public boolean remove(Object o)
    throws ClassCastException,NullPointerException, UnsupportedOperationException
    {
        return linkedHashSet.remove(o);
    }

    /*
     * Returns true if this set contains all of the elements of the specified
     * collection
     */
    public boolean containsAll(Collection<?> c)
    throws ClassCastException,NullPointerException
    {
        return linkedHashSet.containsAll(c);
    }

    /*
     * Adds all of the elements in the specified collection to this set if
     * they're not already present
     */
    public boolean addAll(Collection<? extends E> c)
    throws UnsupportedOperationException, ClassCastException,NullPointerException, IllegalArgumentException
    {
        return linkedHashSet.addAll(c);
    }

    /*
     * Retains only the elements in this set that are contained in the specified
     * collection
     */
    public boolean retainAll(Collection<?> c)
    throws UnsupportedOperationException, ClassCastException,NullPointerException
    {
        return linkedHashSet.retainAll(c);
    }

    /*
     * Removes from this set all of its elements that are contained in the
     * specified collection
     */
    public boolean removeAll(Collection<?> c)
    throws UnsupportedOperationException, NullPointerException,ClassCastException
    {
        return linkedHashSet.retainAll(c);
    }

    /* Removes all of the elements from this set */
    public void clear()
    throws UnsupportedOperationException
    {
        linkedHashSet.clear();
    }

    /* Compares the specified object with this set for equality */
    public boolean equals(Object o)
    {
        return linkedHashSet.equals(o);
    }

    /* Returns the hash code value for this set */
    public int hashCode()
    {
        return linkedHashSet.hashCode();
    }

    public static void main(String... arg)
    {
        LinkedHashSetImp<Integer> linkedHashSet = new LinkedHashSetImp<Integer>();
        linkedHashSet.add(10);
        linkedHashSet.add(20);
        linkedHashSet.add(30);
        linkedHashSet.add(40);
        linkedHashSet.add(50);
        System.out.println("the size of the linkedhashset is : " + linkedHashSet.size());
        System.out.println("the elements in linkedhashset are :");
        Iterator<Integer> iterator = linkedHashSet.iterator();
        while(iterator.hasNext())
            {
                System.out.print(iterator.next() + "\t");
            }
        System.out.println();
        System.out.println("element 40 removed is " + linkedHashSet.remove(40));
        if(linkedHashSet.isEmpty())
            System.out.println("the linkedHashset is empty");
        else
            System.out.println("the linkedhashset is not empty");
        Set<Integer> retainedSet = new HashSet<Integer>();
        retainedSet.add(10);
        retainedSet.add(20);
        System.out.println("the elements retained in LinkedhashSet");
        linkedHashSet.retainAll(retainedSet);
        Iterator<Integer> riterator = linkedHashSet.iterator();
        while(riterator.hasNext())
            {
                System.out.print(riterator.next() + "\t");
            }
        System.out.println();
        linkedHashSet.clear();
        System.out.println("the linkedHashSet cleared");
        if(linkedHashSet.isEmpty())
            System.out.println("the linkedHashSet is empty");
        else
            System.out.println("the linkedHashSet is not empty");
    }
}

/*
the size of the linkedhashset is : 5
the elements in linkedhashset are :
 10 20  30  40  50
element 40 removed is true
the linkedhashset is not empty
the elements retained in LinkedhashSet
10  20
the linkedHashSet cleared
the linkedHashSet is empty
