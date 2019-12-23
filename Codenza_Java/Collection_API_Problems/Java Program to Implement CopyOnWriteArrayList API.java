import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListImpl<E>
{
    private CopyOnWriteArrayList<E> copyOnWriteArrayList;

    /** Creates an empty list. **/
    public CopyOnWriteArrayListImpl()
    {
        copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    }

    /**
     * Creates a list containing the elements of the specified collection, in
     * the order they are returned by the collection's iterator.
     **/
    public CopyOnWriteArrayListImpl(Collection<? extends E> c)
    {
        copyOnWriteArrayList = new CopyOnWriteArrayList<E>(c);
    }

    /** Creates a list holding a copy of the given array. **/
    public CopyOnWriteArrayListImpl(E[] tocopyIn)
    {
        copyOnWriteArrayList = new CopyOnWriteArrayList<E>(tocopyIn);
    }

    /** Appends the specified element to the end of this list. **/
    public boolean add(E e)
    {
        return copyOnWriteArrayList.add(e);
    }

    /** Inserts the specified element at the specified position in this list. **/
    public void add(int index, E element)
    {
        copyOnWriteArrayList.add(index, element);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.
    **/
    public boolean addAll(Collection<? extends E> c)
    {
        return copyOnWriteArrayList.addAll(c);
    }

    /**
     * Inserts all of the elements in the specified collection into this list,
     * starting at the specified position.
    **/
    public boolean addAll(int index, Collection<? extends E> c)
    {
        return copyOnWriteArrayList.addAll(index, c);
    }

    /**
     * Appends all of the elements in the specified collection that are not
     * already contained in this list, to the end of this list, in the order
     * that they are returned by the specified collection's iterator.
    **/
    public int addAllAbsent(Collection<? extends E> c)
    {
        return copyOnWriteArrayList.addAllAbsent(c);
    }

    /** Append the element if not present. **/
    public boolean addIfAbsent(E e)
    {
        return copyOnWriteArrayList.addIfAbsent(e);
    }

    /** Removes all of the elements from this list. **/
    public void clear()
    {
        copyOnWriteArrayList.clear();
    }

    /** Returns a shallow copy of this ArrayList instance. **/
    public Object clone()
    {
        return copyOnWriteArrayList.clone();
    }

    /** Returns true if this list contains the specified element. **/
    public boolean contains(Object o)
    {
        return copyOnWriteArrayList.contains(o);
    }

    /** Returns the element at the specified position in this list. **/
    public E get(int index)
    {
        return copyOnWriteArrayList.get(index);
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
    **/
    public int indexOf(Object o)
    {
        return copyOnWriteArrayList.indexOf(o);
    }

    /** Returns true if this list contains no elements. **/
    public boolean isEmpty()
    {
        return copyOnWriteArrayList.isEmpty();
    }

    /** Returns an iterator over the elements in this list in proper sequence. **/
    public Iterator<E> iterator()
    {
        return copyOnWriteArrayList.iterator();
    }

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element.
    **/
    public int lastIndexOf(Object o)
    {
        return copyOnWriteArrayList.lastIndexOf(o);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
    **/
    public ListIterator<E> listIterator()
    {
        return copyOnWriteArrayList.listIterator();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
    **/
    public ListIterator<E> listIterator(int index)
    {
        return copyOnWriteArrayList.listIterator(index);
    }

    /** Removes the element at the specified position in this list. **/
    public E remove(int index)
    {
        return copyOnWriteArrayList.remove(index);
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present.
    **/
    public boolean remove(Object o)
    {
        return copyOnWriteArrayList.remove(o);
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection.
    **/
    public boolean removeAll(Collection<?> c)
    {
        return copyOnWriteArrayList.removeAll(c);
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection.
    **/
    public boolean retainAll(Collection<?> c)
    {
        return copyOnWriteArrayList.removeAll(c);
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
    **/
    public E set(int index, E element)
    {
        return copyOnWriteArrayList.set(index, element);
    }

    /** Returns the number of elements in this list. **/
    public int size()
    {
        return copyOnWriteArrayList.size();
    }

    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.
    **/
    public List<E> subList(int fromIndex, int toIndex)
    {
        return copyOnWriteArrayList.subList(fromIndex, toIndex);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
    **/
    public Object[] toArray()
    {
        return copyOnWriteArrayList.toArray();
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
    **/
    public <T> T[] toArray(T[] a)
    {
        return copyOnWriteArrayList.toArray(a);
    }

    public static void main(String...arg)
    {
        CopyOnWriteArrayListImpl<Integer> copyOnWriteArrayList = new CopyOnWriteArrayListImpl<Integer>();
        copyOnWriteArrayList.add(10);
        copyOnWriteArrayList.add(20);
        copyOnWriteArrayList.add(30);
        copyOnWriteArrayList.add(3, 40);
        copyOnWriteArrayList.add(-10);
        Set<Integer> addAll = new HashSet<Integer>();
        addAll.add(101);
        addAll.add(200);
        addAll.add(300);
        copyOnWriteArrayList.addAll(addAll);
        Set<Integer> indexAddAll = new HashSet<Integer>();
        indexAddAll.add(101);
        indexAddAll.add(102);
        indexAddAll.add(103);
        copyOnWriteArrayList.addAll(5, indexAddAll);
        if (copyOnWriteArrayList.contains(101))
            System.out.println("the copyOnWriteArrayList contains 101");
        else
            System.out.println("the copyOnWriteArrayList does not contain 101");
        System.out.println("the copyOnWriteArrayList contains " + copyOnWriteArrayList.get(5)
                           + " at index 5");
        System.out.println("the index of 101 is " + copyOnWriteArrayList.indexOf(101));
        System.out.println("the elements of copyOnWriteArrayList are");
        Iterator<Integer> itr = copyOnWriteArrayList.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the last index of 101 is " + copyOnWriteArrayList.lastIndexOf(101));
        System.out.println("elements from index 3 are");
        ListIterator<Integer> listIterator = copyOnWriteArrayList.listIterator(3);
        while (listIterator.hasNext())
            {
                System.out.print(listIterator.next() + "\t");
            }
        System.out.println();
        // removes element at index 5
        copyOnWriteArrayList.remove(5);
        System.out.println("elements removed and retained");
        Set<Integer> removeAll = new HashSet<Integer>();
        removeAll.add(30);
        removeAll.add(300);
        removeAll.add(101);
        copyOnWriteArrayList.removeAll(removeAll);
        Set<Integer> retainAll = new HashSet<Integer>();
        retainAll.add(10);
        retainAll.add(20);
        retainAll.add(200);
        retainAll.add(-10);
        retainAll.addAll(addAll);
        copyOnWriteArrayList.retainAll(retainAll);
        copyOnWriteArrayList.set(1, 101);
        System.out.println("the size of the copyOnWriteArrayList is " + copyOnWriteArrayList.size());
        System.out.println("the elements of the returned list are");
        List<Integer> list = copyOnWriteArrayList.subList(0,1);
        for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i) + "\t");
            }
        System.out.println();
        System.out.println("the elements of returned array are");
        Object[] array = (Object[]) copyOnWriteArrayList.toArray();
        for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + "\t");
            }
        System.out.println();
        System.out.println("the size of the copyOnWriteArrayList is " + copyOnWriteArrayList.size());
        copyOnWriteArrayList.clear();
        if (copyOnWriteArrayList.isEmpty())
            System.out.println("the copyOnWriteArrayList is empty");
        else
            System.out.println("the copyOnWriteArrayList is not empty");
    }
}

/*
the copyOnWriteArrayList contains 101
the copyOnWriteArrayList contains 102 at index 5
the index of 101 is 7
the elements of copyOnWriteArrayList are
10  20  30  40  -10 102 103 101 101 200 300
the last index of 101 is 8
elements from index 3 are
40  -10 102 103 101 101 200 300
elements removed and retained
the size of the copyOnWriteArrayList is 2
the elements of the returned list are
40

the elements of returned array are
40  101
the size of the copyOnWriteArrayList is 2
the copyOnWriteArrayList is empty
