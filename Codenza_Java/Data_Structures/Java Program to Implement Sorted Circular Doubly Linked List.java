/*This is a Java Program to implement a Sorted Circular Doubly Linked List. A linked list is a data structure consisting of a group of nodes which together represent a sequence. Under the simplest form, each node is composed of a data and a reference (in other words, a link) to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any position in the sequence. In a sorted circular doubly linked list each node has two links, one pointing to the next node and one pointing to the previous node and last node’s ‘next link’ points to first node and first node’s ‘previous link points to last node and insertion of an element into the list is done in a sorted fashion.*/

/*
 * Java Program to Implement Sorted Circular Doubly Linked List
 */

import java.util.Scanner;

/*  Class Node  */
class Node
{
    protected int data;
    protected Node next, prev;

    /* Constructor */
    public Node()
    {
        next = null;
        prev = null;
        data = 0;
    }
    /* Constructor */
    public Node(int d, Node n, Node p)
    {
        data = d;
        next = n;
        prev = p;
    }
    /* Function to set link to next node */
    public void setLinkNext(Node n)
    {
        next = n;
    }
    /* Function to set link to previous node */
    public void setLinkPrev(Node p)
    {
        prev = p;
    }
    /* Funtion to get link to next node */
    public Node getLinkNext()
    {
        return next;
    }
    /* Function to get link to previous node */
    public Node getLinkPrev()
    {
        return prev;
    }
    /* Function to set data to node */
    public void setData(int d)
    {
        data = d;
    }
    /* Function to get data from node */
    public int getData()
    {
        return data;
    }
}

/* Class linkedList */
class linkedList
{
    protected Node start, end;
    public int size;

    /* Constructor */
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }
    /* Function to get size of list */
    public int getSize()
    {
        return size;
    }
    /* Function to insert element */
    public void insert(int val)
    {
        Node nptr = new Node(val, null, null);
        Node tmp, ptr;
        boolean ins = false;
        if (start == null)
            {
                nptr.setLinkNext(nptr);
                nptr.setLinkPrev(nptr);
                start = nptr;
                end = start;
            }
        else if (val <= start.getData())
            {
                nptr.setLinkPrev(end);
                end.setLinkNext(nptr);
                start.setLinkPrev(nptr);
                nptr.setLinkNext(start);
                start = nptr;
            }
        else if (val >= end.getData())
            {
                end.setLinkNext(nptr);
                nptr.setLinkPrev(end);
                nptr.setLinkNext(start);
                start.setLinkPrev(nptr);
                end = nptr;
            }
        else
            {
                tmp = start;
                ptr = start.getLinkNext();
                while (ptr != null)
                    {
                        if (val >= tmp.getData() && val <= ptr.getData())
                            {
                                tmp.setLinkNext(nptr);
                                nptr.setLinkPrev(tmp);
                                nptr.setLinkNext(ptr);
                                ptr.setLinkPrev(nptr);
                                ins = true;
                                break;
                            }
                        else
                            {
                                tmp = ptr;
                                ptr = ptr.getLinkNext();
                            }
                    }
                if (!ins)
                    {
                        tmp.setLinkNext(nptr);
                        nptr.setLinkPrev(tmp);
                    }
            }
        size++;
    }
    /* Function to delete node at position */
    public void deleteAtPos(int pos)
    {
        if (pos == 1)
            {
                if (size == 1)
                    {
                        start = null;
                        end = null;
                        size = 0;
                        return;
                    }
                start = start.getLinkNext();
                start.setLinkPrev(end);
                end.setLinkNext(start);
                size--;
                return ;
            }
        if (pos == size)
            {
                end = end.getLinkPrev();
                end.setLinkNext(start);
                start.setLinkPrev(end);
                size-- ;
            }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++)
            {
                if (i == pos)
                    {
                        Node p = ptr.getLinkPrev();
                        Node n = ptr.getLinkNext();
                        p.setLinkNext(n);
                        n.setLinkPrev(p);
                        size-- ;
                        return;
                    }
                ptr = ptr.getLinkNext();
            }
    }
    /* Function to display status of list */
    public void display()
    {
        System.out.print("Sorted Circular Doubly Linked List = ");
        Node ptr = start;
        if (size == 0)
            {
                System.out.print("empty\n");
                return;
            }
        if (start.getLinkNext() == start)
            {
                System.out.print(start.getData()+ " <-> "+ptr.getData()+ "\n");
                return;
            }
        System.out.print(start.getData()+ " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != start)
            {
                System.out.print(ptr.getData()+ " <-> ");
                ptr = ptr.getLinkNext();
            }
        System.out.print(ptr.getData()+ " <-> ");
        ptr = ptr.getLinkNext();
        System.out.print(ptr.getData()+ "\n");
    }
}

/* Class SortedCircularDoublyLinkedList */
public class SortedCircularDoublyLinkedList
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        linkedList list = new linkedList();
        System.out.println("Sorted Circular Doubly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do
            {
                System.out.println("\nSorted Circular Doubly Linked List Operations\n");
                System.out.println("1. insert");
                System.out.println("2. delete at position");
                System.out.println("3. check empty");
                System.out.println("4. get size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        list.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter position");
                        int p = scan.nextInt() ;
                        if (p < 1 || p > list.getSize() )
                            System.out.println("Invalid position\n");
                        else
                            list.deleteAtPos(p);
                        break;
                    case 3 :
                        System.out.println("Empty status = "+ list.isEmpty()+"\n");
                        break;
                    case 4 :
                        System.out.println("Size = "+ list.getSize() +" \n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display List  */
                list.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
3
Empty status = true

Sorted Circular Doubly Linked List = empty

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
24
Sorted Circular Doubly Linked List = 24 <-> 24

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
6
Sorted Circular Doubly Linked List = 6 <-> 24 <-> 6

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
1
Sorted Circular Doubly Linked List = 1 <-> 6 <-> 24 <-> 1

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
19
Sorted Circular Doubly Linked List = 1 <-> 6 <-> 19 <-> 24 <-> 1

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
3
Sorted Circular Doubly Linked List = 1 <-> 3 <-> 6 <-> 19 <-> 24 <-> 1

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
4
Size = 5

Sorted Circular Doubly Linked List = 1 <-> 3 <-> 6 <-> 19 <-> 24 <-> 1

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
1
Sorted Circular Doubly Linked List = 3 <-> 6 <-> 19 <-> 24 <-> 3

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
1
Sorted Circular Doubly Linked List = 6 <-> 19 <-> 24 <-> 6

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
3
Sorted Circular Doubly Linked List = 6 <-> 19 <-> 6

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
2
Sorted Circular Doubly Linked List = 6 <-> 6

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
1
Sorted Circular Doubly Linked List = empty

Do you want to continue (Type y or n)

y

Sorted Circular Doubly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
3
Empty status = true

Sorted Circular Doubly Linked List = empty

Do you want to continue (Type y or n)

n
