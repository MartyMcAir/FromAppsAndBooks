import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ArrayListImpl<E>
{
    private ArrayList<E> arrayList;

    /* Constructs an empty list with an initial capacity of ten. */
    public ArrayListImpl()
    {
        arrayList = new ArrayList<E>();
    }

    /*
     * Constructs a list containing the elements of the specified collection, in
     * the order they are returned by the collection's iterator.
     */
    public ArrayListImpl(Collection<? extends E> c)
    {
        arrayList = new ArrayList<E>(c);
    }

    /* Constructs an empty list with the specified initial capacity. */
    public ArrayListImpl(int initialCapacity)
    {
        arrayList = new ArrayList<E>(initialCapacity);
    }

    /* Appends the specified element to the end of this list. */
    public boolean add(E e)
    {
        return arrayList.add(e);
    }

    /* Inserts the specified element at the specified position in this list. */
    public void add(int index, E element)
    {
        arrayList.add(index, element);
    }

    /*
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's Iterator.
     */
    public boolean addAll(Collection<? extends E> c)
    {
        return arrayList.addAll(c);
    }

    /*
     * inserts all of the elements in the specified collection into this list,
     * starting at the specified position.
     */
    public boolean addAll(int index, Collection<? extends E> c)
    {
        return arrayList.addAll(index, c);
    }

    /* Removes all of the elements from this list. */
    public void clear()
    {
        arrayList.clear();
    }

    /* Returns a shallow copy of this ArrayList instance. */
    public Object clone()
    {
        return arrayList.clone();
    }

    /* Returns true if this list contains the specified element. */
    public boolean contains(Object o)
    {
        return arrayList.contains(o);
    }

    /*
     * Increases the capacity of this ArrayList instance, if necessary, to
     * ensure that it can hold at least the number of elements specified by the
     * minimum capacity argument.
     */
    public void ensureCapacity(int minCapacity)
    {
        arrayList.ensureCapacity(minCapacity);
    }

    /* Returns the element at the specified position in this list. */
    public E get(int index)
    {
        return arrayList.get(index);
    }

    /*
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     */
    public int indexOf(Object o)
    {
        return arrayList.indexOf(o);
    }

    /* Returns true if this list contains no elements. */
    public boolean isEmpty()
    {
        return arrayList.isEmpty();
    }

    /* Returns an iterator over the elements in this list in proper sequence. */
    public Iterator<E> iterator()
    {
        return arrayList.iterator();
    }

    /*
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element.
     */
    public int lastIndexOf(Object o)
    {
        return arrayList.lastIndexOf(o);
    }

    /*
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     */
    public ListIterator<E> listIterator()
    {
        return arrayList.listIterator();
    }

    /*
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     */
    public ListIterator<E> listIterator(int index)
    {
        return arrayList.listIterator(index);
    }

    /* Removes the element at the specified position in this list. */
    public E remove(int index)
    {
        return arrayList.remove(index);
    }

    /*
     * Removes the first occurrence of the specified element from this list, if
     * it is present.
     */
    public boolean remove(Object o)
    {
        return arrayList.remove(o);
    }

    /*
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     */
    public boolean removeAll(Collection<?> c)
    {
        return arrayList.removeAll(c);
    }

    /*
     * Retains only the elements in this list that are contained in the
     * specified collection.
     */
    public boolean retainAll(Collection<?> c)
    {
        return arrayList.removeAll(c);
    }

    /*
     * Replaces the element at the specified position in this list with the
     * specified element.
     */
    public E set(int index, E element)
    {
        return arrayList.set(index, element);
    }

    /* Returns the number of elements in this list. */
    public int size()
    {
        return arrayList.size();
    }

    /*
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.
     */
    public List<E> subList(int fromIndex, int toIndex)
    {
        return arrayList.subList(fromIndex, toIndex);
    }

    /*
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     */
    public Object[] toArray()
    {
        return arrayList.toArray();
    }

    /*
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
     */
    public <T> T[] toArray(T[] a)
    {
        return arrayList.toArray(a);
    }

    /*
     * Trims the capacity of this ArrayList instance to be the list's current
     * size.
     */
    public void trimToSize()
    {
        arrayList.trimToSize();
    }

    public static void main(String... arg)
    {
        ArrayListImpl<Integer> arrayList = new ArrayListImpl<Integer>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(3, 40);
        arrayList.add(-10);
        Set<Integer> addAll = new HashSet<Integer>();
        addAll.add(101);
        addAll.add(200);
        addAll.add(300);
        arrayList.addAll(addAll);
        Set<Integer> indexAddAll = new HashSet<Integer>();
        indexAddAll.add(101);
        indexAddAll.add(102);
        indexAddAll.add(103);
        arrayList.addAll(5, indexAddAll);
        if (arrayList.contains(101))
            System.out.println("the arrayList contains 101");
        else
            System.out.println("the arrayList does not contain 101");
        arrayList.ensureCapacity(15);
        System.out.println("the arrayList contains " + arrayList.get(5)+ " at index 5");
        System.out.println("the index of 101 is " + arrayList.indexOf(101));
        System.out.println("the elements of arrayList are");
        Iterator<Integer> itr = arrayList.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the last index of 101 is "+ arrayList.lastIndexOf(101));
        System.out.println("elements from index 3 are");
        ListIterator<Integer> listIterator = arrayList.listIterator(3);
        while (listIterator.hasNext())
            {
                System.out.print(listIterator.next() + "\t");
            }
        System.out.println();
        // removes element at index 5
        arrayList.remove(5);
        System.out.println("elements removed and retained");
        Set<Integer> removeAll = new HashSet<Integer>();
        removeAll.add(30);
        removeAll.add(300);
        removeAll.add(101);
        arrayList.removeAll(removeAll);
        Set<Integer> retainAll = new HashSet<Integer>();
        retainAll.add(10);
        retainAll.add(20);
        retainAll.add(200);
        retainAll.add(-10);
        retainAll.addAll(addAll);
        arrayList.retainAll(retainAll);
        arrayList.set(1, 101);
        System.out.println("the size of the arrayList is " + arrayList.size());
        System.out.println("the elements of the returned list are");
        List<Integer> list = arrayList.subList(0,1);
        for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i) + "\t");
            }
        System.out.println();
        System.out.println("the elements of returned array are");
        Object[] array = (Object[]) arrayList.toArray();
        for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + "\t");
            }
        System.out.println();
        arrayList.trimToSize();
        System.out.println("the size of the arrayList is " + arrayList.size());
        arrayList.clear();
        if (arrayList.isEmpty())
            System.out.println("the arrayList is empty");
        else
            System.out.println("the arrayList is not empty");
    }
}

/*
the arrayList contains 101
the arrayList contains 102 at index 5
the index of 101 is 7
the elements of arrayList are
10  20  30  40  -10 102 103 101 101 200 300
the last index of 101 is 8
elements from index 3 are
40  -10 102 103 101 101 200 300
elements removed and retained
the size of the arrayList is 2
the elements of the returned list are
40
the elements of returned array are
40  101
the size of the arrayList is 2
the arrayList is empty
