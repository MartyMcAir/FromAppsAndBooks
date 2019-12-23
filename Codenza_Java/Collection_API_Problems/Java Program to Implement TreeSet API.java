import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetImpl<E>
{
    private TreeSet<E> treeSet;

    /*
     * Constructs a new, empty tree set, sorted according to the natural
     * ordering of its elements.
     */
    public TreeSetImpl()
    {
        treeSet = new TreeSet<E>();
    }

    /*
     * Constructs a new tree set containing the elements in the specified
     * collection, sorted according to the natural ordering of its elements.
     */
    public TreeSetImpl(Collection<? extends E> c)
    {
        treeSet = new TreeSet<E>(c);
    }

    /*
     * Constructs a new, empty tree set, sorted according to the specified
     * comparator.
     */
    public TreeSetImpl(Comparator<? super E> comparator)
    {
        treeSet = new TreeSet<E>(comparator);
    }

    /*
     * Constructs a new tree set containing the same elements and using the same
     * ordering as the specified sorted set.
     */
    public TreeSetImpl(SortedSet<E> s)
    {
        treeSet = new TreeSet<E>(s);
    }

    /* Adds the specified element to this set if it is not already present. */
    public boolean add(E e)
    {
        return treeSet.add(e);
    }

    /* Adds all of the elements in the specified collection to this set. */
    public boolean addAll(Collection<? extends E> c)
    {
        return treeSet.addAll(c);
    }

    /*
     * Returns the least element in this set greater than or equal to the given
     * element, or null if there is no such element.
     */
    public E ceiling(E e)
    {
        return treeSet.ceiling(e);
    }

    /* Removes all of the elements from this set. */
    public void clear()
    {
        treeSet.clear();
    }

    /* Returns a shallow copy of this TreeSet instance. */
    public Object clone()
    {
        return treeSet.clone();
    }

    /*
     * Returns the comparator used to order the elements in this set, or null if
     * this set uses the natural ordering of its elements.
     */
    public Comparator<? super E> comparator()
    {
        return treeSet.comparator();
    }

    /* Returns true if this set contains the specified element. */
    public boolean contains(Object o)
    {
        return treeSet.contains(o);
    }

    /* Returns an iterator over the elements in this set in descending order. */
    public Iterator<E> descendingIterator()
    {
        return treeSet.descendingIterator();
    }

    /* Returns a reverse order view of the elements contained in this set. */
    public NavigableSet<E> descendingSet()
    {
        return treeSet.descendingSet();
    }

    /* Returns the first (lowest) element currently in this set. */
    public E first()
    {
        return treeSet.first();
    }

    /*
     * Returns the greatest element in this set less than or equal to the given
     * element, or null if there is no such element.
     */
    public E floor(E e)
    {
        return treeSet.floor(e);
    }

    /*
     * Returns a view of the portion of this set whose elements are strictly
     * less than toElement.
     */
    public SortedSet<E> headSet(E toElement)
    {
        return treeSet.headSet(toElement);
    }

    /*
     * Returns a view of the portion of this set whose elements are less than
     * (or equal to, if inclusive is true) toElement.
     */
    public NavigableSet<E> headSet(E toElement, boolean inclusive)
    {
        return treeSet.headSet(toElement, inclusive);
    }

    /*
     * Returns the least element in this set strictly greater than the given
     * element, or null if there is no such element.
     */
    public E higher(E e)
    {
        return treeSet.higher(e);
    }

    /* Returns true if this set contains no elements. */
    public boolean isEmpty()
    {
        return treeSet.isEmpty();
    }

    /* Returns an iterator over the elements in this set in ascending order. */
    public Iterator<E> iterator()
    {
        return treeSet.iterator();
    }

    /* Returns the last (highest) element currently in this set. */
    public E last()
    {
        return treeSet.last();
    }

    /*
     * Returns the greatest element in this set strictly less than the given
     * element, or null if there is no such element.
     */
    public E lower(E e)
    {
        return treeSet.lower(e);
    }

    /*
     * Retrieves and removes the first (lowest) element, or returns null if this
     * set is empty.
     */
    public E pollFirst()
    {
        return treeSet.pollFirst();
    }

    /*
     * Retrieves and removes the last (highest) element, or returns null if this
     * set is empty.
     */
    public E pollLast()
    {
        return treeSet.pollLast();
    }

    /* Removes the specified element from this set if it is present. */
    public boolean remove(Object o)
    {
        return treeSet.remove(o);
    }

    /* Returns the number of elements in this set (its cardinality). */
    public int size()
    {
        return treeSet.size();
    }

    /*
     * Returns a view of the portion of this set whose elements range from
     * fromElement to toElement.
     */
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive,	E toElement, boolean toInclusive)
    {
        return treeSet.subSet(fromElement, fromInclusive, toElement,toInclusive);
    }

    /*
     * Returns a view of the portion of this set whose elements range from
     * fromElement, inclusive, to toElement, exclusive.
     */
    public SortedSet<E> subSet(E fromElement, E toElement)
    {
        return treeSet.subSet(fromElement, toElement);
    }

    /*
     * Returns a view of the portion of this set whose elements are greater than
     * or equal to fromElement.
     */
    public SortedSet<E> tailSet(E fromElement)
    {
        return treeSet.tailSet(fromElement);
    }

    /*
     * Returns a view of the portion of this set whose elements are greater than
     * (or equal to, if inclusive is true) fromElement.
     */
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
    {
        return treeSet.tailSet(fromElement, inclusive);
    }

    public static void main(String... arg)
    {
        TreeSetImpl<Integer> treeSet = new TreeSetImpl<Integer>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(40);
        treeSet.add(5);
        treeSet.add(-10);
        Iterator<Integer> titerator = treeSet.iterator();
        System.out.println("the elements are");
        while (titerator.hasNext())
            {
                System.out.print(titerator.next() + "\t");
            }
        System.out.println();
        System.out.println("the size of the TreeSet is " + treeSet.size());
        System.out.println("the ceiling of -100 in the TreeSet is "+ treeSet.ceiling(-100));
        Iterator<Integer> revitr = treeSet.descendingIterator();
        System.out.println("the reverse order is ");
        while (revitr.hasNext())
            {
                System.out.print(revitr.next() + "\t");
            }
        System.out.println();
        System.out.println("the lowest element in the set is " + treeSet.first());
        System.out.println("the floor of 20 in treeSet is " + treeSet.floor(20));
        System.out.println("the last element in the set is " + treeSet.last());
        System.out.println("element 20 removed is " + treeSet.remove(20));
        if (treeSet.isEmpty())
            System.out.println("the set is empty");
        else
            System.out.println("the set is not empty");
        NavigableSet<Integer> navigableSet;
        Iterator<Integer> itr;
        System.out.println("the headSet of 40 is  ");
        navigableSet = treeSet.headSet(40, true);
        itr = navigableSet.iterator();
        while (itr.hasNext())
            {
                System.out.println(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the subset between 5 and 30 ");
        navigableSet = treeSet.subSet(5, true, 30, true);
        itr = navigableSet.iterator();
        while (itr.hasNext())
            {
                System.out.println(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the tailSet of 10 is  ");
        navigableSet = treeSet.tailSet(10, true);
        itr = navigableSet.iterator();
        while (itr.hasNext())
            {
                System.out.println(itr.next() + "\t");
            }
        System.out.println();
    }
}

/*
the elements are
-10 5   10  20  30  40
the size of the TreeSet is 6
the ceiling of -100 in the TreeSet is -10
the reverse order is
40  30  20  10  5   -10
the lowest element in the set is -10
the floor of 20 in treeSet is 20
the last element in the set is 40
element 20 removed is true
the set is not empty
the headSet of 40 is
-10
5
10
30
40

the subset between 5 and 30
5
10
30

the tailSet of 10 is
10
30
40
