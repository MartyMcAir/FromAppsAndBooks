import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListImpl<E>
{
    private LinkedList<E> linkedList;

    public LinkedListImpl()
    {
        linkedList = new LinkedList<E>();
    }

    public LinkedListImpl(Collection<? extends E> c)
    {
        linkedList = new LinkedList<E>(c);
    }

    /* Appends the specified element to the end of this list. */
    public boolean add(E e)
    {
        return linkedList.add(e);
    }

    /* Inserts the specified element at the specified position in this list. */
    public void add(int index, E element)
    {
        linkedList.add(index, element);
    }

    /*
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's Iterator.
     */
    public boolean addAll(Collection<? extends E> c)
    {
        return linkedList.addAll(c);
    }

    /*
     * inserts all of the elements in the specified collection into this list,
     * starting at the specified position.
     */
    public boolean addAll(int index, Collection<? extends E> c)
    {
        return linkedList.addAll(index, c);
    }

    /* Inserts the specified element at the beginning of this list. */
    public void addFirst(E e)
    {
        linkedList.addFirst(e);
    }

    /* Appends the specified element to the end of this list. */
    public void addLast(E e)
    {
        linkedList.addLast(e);
    }

    /* Removes all of the elements from this list. */
    public void clear()
    {
        linkedList.clear();
    }

    /* Returns a shallow copy of this ArrayList instance. */
    public Object clone()
    {
        return linkedList.clone();
    }

    /* Returns true if this list contains the specified element. */
    public boolean contains(Object o)
    {
        return linkedList.contains(o);
    }

    /*
     * Returns an iterator over the elements in this deque in reverse sequential
     * order.
     */
    public Iterator<E> descendingIterator()
    {
        return linkedList.descendingIterator();
    }

    /* Retrieves, but does not remove, the head (first element) of this list. */
    public E element()
    {
        return linkedList.element();
    }

    /* Returns the element at the specified position in this list. */
    public E get(int index)
    {
        return linkedList.get(index);
    }

    /* Returns the first element in this list. */
    public E getFirst()
    {
        return linkedList.getFirst();
    }

    /* Returns the last element in this list. */
    public E getLast()
    {
        return linkedList.getLast();
    }

    /*
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     */
    public int indexOf(Object o)
    {
        return linkedList.indexOf(o);
    }

    /* Returns true if this list contains no elements. */
    public boolean isEmpty()
    {
        return linkedList.isEmpty();
    }

    /* Returns an iterator over the elements in this list in proper sequence. */
    public Iterator<E> iterator()
    {
        return linkedList.iterator();
    }

    /*
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element.
     */
    public int lastIndexOf(Object o)
    {
        return linkedList.lastIndexOf(o);
    }

    /*
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     */
    public ListIterator<E> listIterator()
    {
        return linkedList.listIterator();
    }

    /*
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     */
    public ListIterator<E> listIterator(int index)
    {
        return linkedList.listIterator(index);
    }

    /* Adds the specified element as the tail (last element) of this list. */
    public boolean offer(E e)
    {
        return linkedList.offer(e);
    }

    /* Inserts the specified element at the front of this list. */
    public boolean offerFirst(E e)
    {
        return linkedList.offerFirst(e);
    }

    /* Inserts the specified element at the end of this list. */
    public boolean offerLast(E e)
    {
        return linkedList.offerLast(e);
    }

    /* Retrieves, but does not remove, the head (first element) of this list. */
    public E peek()
    {
        return linkedList.peek();
    }

    /*
     * Retrieves, but does not remove, the first element of this list, or
     * returns null if this list is empty.
     */
    public E peekFirst()
    {
        return linkedList.peekFirst();
    }

    /*
     * Retrieves, but does not remove, the last element of this list, or returns
     * null if this list is empty.
     */
    public E peekLast()
    {
        return linkedList.peekLast();
    }

    /* Retrieves and removes the head (first element) of this list. */
    public E poll()
    {
        return linkedList.poll();
    }

    /*
     * Retrieves and removes the first element of this list, or returns null if
     * this list is empty.
     */
    public E pollFirst()
    {
        return linkedList.pollFirst();
    }

    /*
     * Retrieves and removes the last element of this list, or returns null if
     * this list is empty.
     */
    public E pollLast()
    {
        return linkedList.peekLast();
    }

    /* Pops an element from the stack represented by this list. */
    public E pop()
    {
        return linkedList.pop();
    }

    /* Pushes an element onto the stack represented by this list. */
    public void push(E e)
    {
        linkedList.push(e);
    }

    /* Removes the element at the specified position in this list. */
    public E remove(int index)
    {
        return linkedList.remove(index);
    }

    /*
     * Removes the first occurrence of the specified element from this list, if
     * it is present.
     */
    public boolean remove(Object o)
    {
        return linkedList.remove(o);
    }

    /*
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     */
    public boolean removeAll(Collection<?> c)
    {
        return linkedList.removeAll(c);
    }

    /* Removes and returns the first element from this list. */
    public E removeFirst()
    {
        return linkedList.removeFirst();
    }

    /*
     * Removes the first occurrence of the specified element in this list (when
     * traversing the list from head to tail).
     */
    public boolean removeFirstOccurence(Object o)
    {
        return linkedList.removeFirstOccurrence(o);
    }

    /* Removes and returns the last element from this list. */
    public E removeLast()
    {
        return linkedList.removeLast();
    }

    /*
     * Removes the last occurrence of the specified element in this list (when
     * traversing the list from head to tail).
     */
    public boolean removeLastOccurence(Object o)
    {
        return linkedList.removeLastOccurrence(o);
    }

    /*
     * Retains only the elements in this list that are contained in the
     * specified collection.
     */
    public boolean retainAll(Collection<?> c)
    {
        return linkedList.removeAll(c);
    }

    /*
     * Replaces the element at the specified position in this list with the
     * specified element.
     */
    public E set(int index, E element)
    {
        return linkedList.set(index, element);
    }

    /* Returns the number of elements in this list. */
    public int size()
    {
        return linkedList.size();
    }

    /*
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.
     */
    public List<E> subList(int fromIndex, int toIndex)
    {
        return linkedList.subList(fromIndex, toIndex);
    }

    /*
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     */
    public Object[] toArray()
    {
        return linkedList.toArray();
    }

    /*
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
     */
    public <T> T[] toArray(T[] a)
    {
        return linkedList.toArray(a);
    }

    public static void main(String...arg)
    {
        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(100);
        linkedList.add(20);
        linkedList.addFirst(101);
        linkedList.addLast(200);
        Set<Integer> set = new HashSet<Integer>();
        set.add(101);
        set.add(30);
        set.add(32);
        linkedList.addAll(4, set);
        if (linkedList.contains(300))
            System.out.println("the linked list contains 300");
        else
            System.out.println("the linked list does not contain 300");
        System.out.println("the elements in descending order is");
        Iterator<Integer> descendingitr = linkedList.descendingIterator();
        while (descendingitr.hasNext())
            {
                System.out.print(descendingitr.next() + "\t");
            }
        System.out.println();
        System.out.println("the head of this list is " + linkedList.element());
        System.out.println("the element at index 2 is " + linkedList.get(2));
        System.out.println("the element first pos is  " + linkedList.getFirst());
        System.out.println("the element at last pos is" + linkedList.getLast());
        System.out.println("the index of element 200 is "+ linkedList.indexOf(200));
        System.out.println("the last index of element 101 is "+ linkedList.lastIndexOf(101));
        System.out.println("the elements of list are");
        Iterator<Integer> itr = linkedList.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        linkedList.offer(45);
        linkedList.offerFirst(32);
        linkedList.offerLast(19);
        System.out.println("the head of the linkedlist is " + linkedList.peek());
        System.out.println("the first element of linkedList is "+ linkedList.peekFirst());
        System.out.println("the last element of linked List is "+ linkedList.peekLast());
        System.out.println("the elements of list are");
        itr = linkedList.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        System.out.println("the first element of linkedList is (poll) "+ linkedList.poll());
        System.out.println("the first element polled is "+ linkedList.pollFirst());
        System.out.println("the last element polled is "+ linkedList.pollLast());
        linkedList.push(36);
        System.out.println("the element poped from linked List is "+ linkedList.pop());
        System.out.println("index 3 element removed from list "+ linkedList.remove(3));
        System.out.println("last occurence of 101 removed "+ linkedList.removeLastOccurence(101));
        linkedList.clear();
        if (linkedList.isEmpty())
            System.out.println("the linkedList is empty");
        else
            System.out.println("the linked list is not empty");
    }
}

/*
the linked list does not contain 300
the elements in descending order is
30  101 32  200 20  100 101
the head of this list is 101
the element at index 2 is 20
the element first pos is  101
the element at last pos is30
the index of element 200 is 3
the last index of element 101 is 5
the elements of list are
101 100 20  200 32  101 30
the head of the linkedlist is 32
the first element of linkedList is 32
the last element of linked List is 19
the elements of list are
32  101 100 20  200 32  101 30  45  19
the first element of linkedList is (poll) 32
the first element polled is 101
the last element polled is 19
the element poped from linked List is 36
index 3 element removed from list 32
last occurence of 101 removed true
the linkedList is empty
