/*This is a Java Program to implement a Sorted Singly Linked List. A linked list is a data structure consisting of a group of nodes which together represent a sequence. Under the simplest form, each node is composed of a data and a reference (in other words, a link) to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any position in the sequence. In a sorted singly linked list each node has only one link pointing to the next node and insertion of an element into the list is done in a sorted fashion.*/

/*
 *  Java Program to Implement Sorted Singly Linked List
 */

import java.util.Scanner;

/*  Class Node  */
class Node
{
    protected int data;
    protected Node link;

    /*  Constructor  */
    public Node()
    {
        link = null;
        data = 0;
    }
    /*  Constructor  */
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}
class linkedList
{
    protected Node start;
    public int size;
    public linkedList()
    {
        start=null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to check size of list  */
    public int getSize()
    {
        return size;
    }
    /*  Function to insert an element  */
    public void insert(int val)
    {
        Node nptr, ptr, tmp = null;
        nptr = new Node(val, null);
        boolean ins = false;
        if (start == null)
            start = nptr;
        else if (val <= start.getData())
            {
                nptr.setLink(start);
                start = nptr;
            }
        else
            {
                tmp = start;
                ptr = start.getLink();
                while(ptr != null)
                    {
                        if (val >= tmp.getData() && val <= ptr.getData())
                            {
                                tmp.setLink(nptr);
                                nptr.setLink(ptr);
                                ins = true;
                                break;
                            }
                        else
                            {
                                tmp = ptr;
                                ptr = ptr.getLink();
                            }
                    }
                if (ins == false)
                    {
                        tmp.setLink(nptr);
                    }
            }
        size++;
    }
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {
        if (pos == 1)
            {
                start = start.getLink();
                size--;
                return ;
            }
        if (pos == size)
            {
                Node ptr = start;
                for (int i = 1; i < size - 1; i++)
                    ptr = ptr.getLink();
                ptr.setLink(null);
                size --;
                return;
            }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++)
            {
                if (i == pos)
                    {
                        Node tmp = ptr.getLink();
                        tmp = tmp.getLink();
                        ptr.setLink(tmp);
                        break;
                    }
                ptr = ptr.getLink();
            }
        size-- ;
    }
    /*  Function to display elements  */
    public void display()
    {
        System.out.print("Sorted Singly Linked List = ");
        if (size == 0)
            {
                System.out.print("empty\n");
                return;
            }
        if (start.getLink() == null)
            {
                System.out.println(start.getData() );
                return;
            }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
            {
                System.out.print(ptr.getData()+ "->");
                ptr = ptr.getLink();
            }
        System.out.print(ptr.getData()+ "\n");
    }
}
public class SortedSinglyLinkedList
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
        linkedList list = new linkedList();
        System.out.println("Sorted Singly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do
            {
                System.out.println("\nSorted Singly Linked List Operations\n");
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

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
3
Empty status = true

Sorted Singly Linked List = empty

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
24
Sorted Singly Linked List = 24

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
6
Sorted Singly Linked List = 6->24

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
19
Sorted Singly Linked List = 6->19->24

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
94
Sorted Singly Linked List = 6->19->24->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
1
Sorted Singly Linked List = 1->6->19->24->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
7
Sorted Singly Linked List = 1->6->7->19->24->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
1
Enter integer element to insert
12
Sorted Singly Linked List = 1->6->7->12->19->24->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
4
Size = 7

Sorted Singly Linked List = 1->6->7->12->19->24->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
3
Sorted Singly Linked List = 1->6->12->19->24->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
1
Sorted Singly Linked List = 6->12->19->24->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
4
Sorted Singly Linked List = 6->12->19->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
3
Sorted Singly Linked List = 6->12->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
1
Sorted Singly Linked List = 12->94

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
2
Sorted Singly Linked List = 12

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
2
Enter position
1
Sorted Singly Linked List = empty

Do you want to continue (Type y or n)

y

Sorted Singly Linked List Operations

1. insert
2. delete at position
3. check empty
4. get size
3
Empty status = true

Sorted Singly Linked List = empty

Do you want to continue (Type y or n)

n
