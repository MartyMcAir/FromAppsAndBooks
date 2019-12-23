import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetImpl<E>
{
    private Set<E> hashSet;

    /*
     * Constructs a new, empty set; the backing HashMap instance has default
     * initial capacity (16) and load factor (0.75).
     */
    public HashSetImpl()
    {
        hashSet = new HashSet<E>();
    }

    /* Constructs a new set containing the elements in the specified collection. */
    public HashSetImpl(Collection<? extends E> c)
    {
        hashSet = new HashSet<E>(c);
    }

    /*
     * constructs a new, empty set; the backing HashMap instance has the
     * specified initial capacity and the specified load factor.
     */
    public HashSetImpl(int initialCapacity, float loadFactor)
    {
        hashSet = new HashSet<E>(initialCapacity, loadFactor);
    }

    /*
     * Constructs a new, empty set; the backing HashMap instance has the
     * specified initial capacity and default load factor (0.75).
     */
    public HashSetImpl(int initialCapacity)
    {
        hashSet = new HashSet<E>(initialCapacity);
    }

    /* adds the specified element if not already present */
    public boolean add(E eobj)
    {
        return hashSet.add(eobj);
    }

    /* return true if this set contains the specified element */
    public boolean contains(Object obj)
    {
        return hashSet.contains(obj);
    }

    /* returns true if the set is empty */
    public boolean isEmpty()
    {
        return hashSet.isEmpty();
    }

    /* returns an iterator over the elements in the set */
    public Iterator<E> iterator()
    {
        return hashSet.iterator();
    }

    /* removes the specified element from this set if present */
    public boolean remove(Object obj)
    {
        return hashSet.remove(obj);
    }

    /* returns the number of elements in set */
    public int size()
    {
        return hashSet.size();
    }

    /* removes all elements from this set */
    public void clear()
    {
        hashSet.clear();
    }

    /* Returns an array containing all of the elements in this set. */
    public Object[] toArray()
    {
        return hashSet.toArray();
    }

    /*
     * Adds all of the elements in the specified collection to this set if
     * they're not already present
     */
    public boolean addAll(Collection<? extends E> c)
    throws UnsupportedOperationException, ClassCastException,NullPointerException,IllegalArgumentException
    {
        return hashSet.addAll(c);
    }

    /*
     * Retains only the elements in this set that are contained in the specified
     * collection
     */
    public boolean retainAll(Collection<?> c)
    throws UnsupportedOperationException, ClassCastException,NullPointerException
    {
        return hashSet.retainAll(c);
    }

    /*
     * Removes from this set all of its elements that are contained in the
     * specified collection
     */
    public boolean removeAll(Collection<?> c)
    throws UnsupportedOperationException, NullPointerException,ClassCastException
    {
        return hashSet.retainAll(c);
    }

    /*
     * Returns an array containing all of the elements in this set; the runtime
     * type of the returned array is that of the specified array
     */
    public <T> T[] toArray(T[] a)
    throws ArrayStoreException,NullPointerException
    {
        return hashSet.toArray(a);
    }

    public static void main(String... arg)
    {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (hashSet.add(10))
            System.out.println("element 10 added");
        if (hashSet.add(20))
            System.out.println("element 20 added");
        if (hashSet.add(30))
            System.out.println("element 30 added");
        System.out.println("the size of set is " + hashSet.size());
        if (hashSet.contains(40))
            System.out.println("set contains 40");
        else
            System.out.println("set does not contain 40");
        if (hashSet.remove(20))
            System.out.println("element 20 removed");
        else
            System.out.println("element 20 not removed");
        System.out.println("the element of set are");
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext())
            {
                System.out.print(iterator.next() + "\t");
            }
        System.out.println();
        Set<Integer> removedSet = new HashSet<Integer>();
        removedSet.add(10);
        removedSet.add(20);
        System.out.println("the elements after removing");
        hashSet.removeAll(removedSet);
        Iterator<Integer> riterator = hashSet.iterator();
        while(riterator.hasNext())
            {
                System.out.print(riterator.next() + "\t");
            }
        System.out.println();
        hashSet.clear();
        System.out.println("hashSet cleared");
        if (hashSet.isEmpty())
            System.out.println("hashSet is empty");
        else
            System.out.println("hashSet is not empty");
    }
}

/*
element 10 added
element 20 added
element 30 added
the size of set is 3
set does not contain 40
element 20 removed
the element of set are
10  30
the elements after removing
30
hashSet cleared
hashSet is empty
