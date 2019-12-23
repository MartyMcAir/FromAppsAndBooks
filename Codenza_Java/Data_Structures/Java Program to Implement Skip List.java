/*This is a Java Program to implement a Skip List. A skip list is a data structure for storing a sorted list of items using a hierarchy of linked lists that connect increasingly sparse subsequences of the items. These auxiliary lists allow item lookup with efficiency comparable to balanced binary search trees (that is, with number of probes proportional to log n instead of n). This program is based on the implementation by Mark Allen Weiss.*/

/*
 * Java program to implement SkipList
 */
import java.util.Scanner;

/* Class SkipNode */
class SkipNode
{
    int element;
    SkipNode right;
    SkipNode down;

    /* Constructor */
    public SkipNode(int x)
    {
        this(x, null, null);
    }
    /* Constructor */
    public SkipNode(int x, SkipNode rt, SkipNode dt)
    {
        element = x;
        right = rt;
        down = dt;
    }
}

/* Class SkipList */
class SkipList
{
    private SkipNode header;
    private int infinity;
    private SkipNode bottom = null;
    private SkipNode tail = null;

    /* Constructor */
    public SkipList(int inf)
    {
        infinity = inf;
        bottom = new SkipNode(0);
        bottom.right = bottom.down = bottom;
        tail = new SkipNode(infinity);
        tail.right = tail;
        header = new SkipNode(infinity, tail, bottom);
    }
    /* Function to insert element */
    public void insert(int x)
    {
        SkipNode current = header;
        bottom.element = x;
        while (current != bottom)
            {
                while (current.element < x)
                    current = current.right;
                /*  If gap size is 3 or at bottom level and must insert, then promote middle element */
                if (current.down.right.right.element < current.element)
                    {
                        current.right = new SkipNode(current.element, current.right, current.down.right.right);
                        current.element = current.down.right.element;
                    }
                else
                    current = current.down;
            }
        /* Raise height of skiplist if necessary */
        if (header.right != tail)
            header = new SkipNode(infinity, tail, header);
    }
    /* Function to clear list */
    public void makeEmpty()
    {
        header.right = tail;
        header.down = bottom;
    }
    /* Function to check if empty */
    public boolean isEmpty()
    {
        return header.right == tail && header.down == bottom;
    }
    /* Function to get node at a position */
    private int elementAt(SkipNode t)
    {
        return t == bottom ? 0 : t.element;
    }
    /* Function to print list */
    public void printList()
    {
        System.out.print("\nSkiplist = ");
        SkipNode current = header;
        while( current.down != bottom )
            current = current.down;
        while (current.right != tail )
            {
                System.out.print(current.element +" ");
                current = current.right;
            }
        System.out.println();
    }
}

/* Class SkipListTest */
public class SkipListTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of SkipList */
        SkipList sl = new SkipList(100000000);
        System.out.println("SkipList List Test\n");
        char ch;
        /*  Perform list operations  */
        do
            {
                System.out.println("\nSkipList List Operations\n");
                System.out.println("1. insert");
                System.out.println("2. check empty");
                System.out.println("3. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        sl.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Empty status = "+ sl.isEmpty());
                        break;
                    case 3 :
                        System.out.println("List cleared\n");
                        sl.makeEmpty();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display List  */
                sl.printList();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
SkipList List Operations

1. insert
2. check empty
3. clear
1
Enter integer element to insert
45

Skiplist = 45

Do you want to continue (Type y or n)

y

SkipList List Operations

1. insert
2. check empty
3. clear
1
Enter integer element to insert
23

Skiplist = 23 45

Do you want to continue (Type y or n)

y

SkipList List Operations

1. insert
2. check empty
3. clear
1
Enter integer element to insert
87

Skiplist = 23 45 87

Do you want to continue (Type y or n)

y

SkipList List Operations

1. insert
2. check empty
3. clear
1
Enter integer element to insert
56

Skiplist = 23 45 56 87

Do you want to continue (Type y or n)

y

SkipList List Operations

1. insert
2. check empty
3. clear
1
Enter integer element to insert
19

Skiplist = 19 23 45 56 87

Do you want to continue (Type y or n)

y

SkipList List Operations

1. insert
2. check empty
3. clear
1
Enter integer element to insert
81

Skiplist = 19 23 45 56 81 87

Do you want to continue (Type y or n)

y

SkipList List Operations

1. insert
2. check empty
3. clear
1
Enter integer element to insert
23

Skiplist = 19 23 45 56 81 87

Do you want to continue (Type y or n)

y

SkipList List Operations

1. insert
2. check empty
3. clear
3
List cleared


Skiplist =

Do you want to continue (Type y or n)

y

SkipList List Operations

1. insert
2. check empty
3. clear
2
Empty status = true

Skiplist =

Do you want to continue (Type y or n)

n
