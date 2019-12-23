import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetImpl<E>
{
    private CopyOnWriteArraySet<E> copyOnWriteArraySet;

    /** Creates an empty set. **/
    public CopyOnWriteArraySetImpl()
    {
        copyOnWriteArraySet = new CopyOnWriteArraySet<E>();
    }

    /**
     * Creates a set containing all of the elements of the specified collection.
    **/
    public CopyOnWriteArraySetImpl(Collection<? extends E> c)
    {
        copyOnWriteArraySet = new CopyOnWriteArraySet<E>(c);
    }

    /** adds the specified element if not already present **/
    public boolean add(E eobj)
    {
        return copyOnWriteArraySet.add(eobj);
    }

    /** return true if this set contains the specified element **/
    public boolean contains(Object obj)
    {
        return copyOnWriteArraySet.contains(obj);
    }

    /** returns true if the set is empty **/
    public boolean isEmpty()
    {
        return copyOnWriteArraySet.isEmpty();
    }

    /** returns an iterator over the elements in the set **/
    public Iterator<E> iterator()
    {
        return copyOnWriteArraySet.iterator();
    }

    /** removes the specified element from this set if present **/
    public boolean remove(Object obj)
    {
        return copyOnWriteArraySet.remove(obj);
    }

    /** returns the number of elements in set **/
    public int size()
    {
        return copyOnWriteArraySet.size();
    }

    /** removes all elements from this set **/
    public void clear()
    {
        copyOnWriteArraySet.clear();
    }

    /** Returns an array containing all of the elements in this set. **/
    public Object[] toArray()
    {
        return copyOnWriteArraySet.toArray();
    }

    /**
     * Adds all of the elements in the specified collection to this set if
     * they're not already present
    **/
    public boolean addAll(Collection<? extends E> c)
    throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException
    {
        return copyOnWriteArraySet.addAll(c);
    }

    /**
     * Retains only the elements in this set that are contained in the specified
     * collection
    **/
    public boolean retainAll(Collection<?> c)
    throws UnsupportedOperationException, ClassCastException, NullPointerException
    {
        return copyOnWriteArraySet.retainAll(c);
    }

    /**
     * Removes from this set all of its elements that are contained in the
     * specified collection
    **/
    public boolean removeAll(Collection<?> c)
    throws UnsupportedOperationException, NullPointerException, ClassCastException
    {
        return copyOnWriteArraySet.retainAll(c);
    }

    /**
     * Returns an array containing all of the elements in this set; the runtime
     * type of the returned array is that of the specified array
    **/
    public <T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException
    {
        return copyOnWriteArraySet.toArray(a);
    }

    public static void main(String... arg)
    {
        CopyOnWriteArraySetImpl<Integer> copyOnWriteArraySet = new CopyOnWriteArraySetImpl<Integer>();
        if (copyOnWriteArraySet.add(10))
            System.out.println("element 10 added");
        if (copyOnWriteArraySet.add(20))
            System.out.println("element 20 added");
        if (copyOnWriteArraySet.add(30))
            System.out.println("element 30 added");
        System.out.println("the size of copyOnWriteArraySet is " + copyOnWriteArraySet.size());
        if (copyOnWriteArraySet.contains(40))
            System.out.println("copyOnWriteArraySet contains 40");
        else
            System.out.println("copyOnWriteArraySet does not contain 40");
        if (copyOnWriteArraySet.remove(20))
            System.out.println("element 20 removed");
        else
            System.out.println("element 20 not removed");
        System.out.println("the element of copyOnWriteArraySet are");
        Iterator<Integer> iterator = copyOnWriteArraySet.iterator();
        while (iterator.hasNext())
            {
                System.out.print(iterator.next() + "\t");
            }
        System.out.println();
        Set<Integer> removedSet = new HashSet<Integer>();
        removedSet.add(10);
        removedSet.add(20);
        System.out.println("the elements after removing");
        copyOnWriteArraySet.removeAll(removedSet);
        Iterator<Integer> riterator = copyOnWriteArraySet.iterator();
        while (riterator.hasNext())
            {
                System.out.print(riterator.next() + "\t");
            }
        System.out.println();
        copyOnWriteArraySet.clear();
        System.out.println("copyOnWriteArraySet cleared");
        if (copyOnWriteArraySet.isEmpty())
            System.out.println("copyOnWriteArraySet is empty");
        else
            System.out.println("copyOnWriteArraySet is not empty");
    }
}

/*
element 10 added
element 20 added
element 30 added
the size of copyOnWriteArraySet is 3
copyOnWriteArraySet does not contain 40
element 20 removed
the element of copyOnWriteArraySet are
10  30
the elements after removing
10
copyOnWriteArraySet cleared
copyOnWriteArraySet is empty
