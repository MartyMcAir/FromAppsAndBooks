/*This is a Java Program to implement Triply Linked List. Triply linked list is a list in which each node has 3 pointers pointing to three other nodes. Here a binary search tree is implemented using a triply linked list.*/

/*
 * Java Program to Implement Triply Linked List
 */

import java.util.Scanner;

/* class TLLNode */
class TLLNode
{
    TLLNode left, right, middle;
    int data;

    /* Constructor */
    public TLLNode(int x)
    {
        data = x;
        left = null;
        right = null;
        middle = null;
    }
}

/* class TriplyLinkedList */
class TriplyLinkedList
{
    TLLNode root, tmp;

    /* Constructor */
    public TriplyLinkedList()
    {
        root = null;
        tmp = null;
    }
    /* function to check if empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* function to clear list */
    public void makeEmpty()
    {
        root = null;
        tmp = null;
    }
    /* function to insert */
    public void insert(int x)
    {
        root = insert(root, x);
    }
    /* function to insert element */
    public TLLNode insert(TLLNode r, int x)
    {
        if (r == null)
            {
                r = new TLLNode(x);
                r.middle = tmp;
            }
        else
            {
                tmp = r;
                if (r.data >= x)
                    r.left = insert(r.left, x);
                else
                    r.right = insert(r.right, x);
            }
        return r;
    }
    /* Function for print */
    public void printList()
    {
        printList(root);
    }
    private void printList(TLLNode r)
    {
        if (r != null)
            {
                printList(r.left);
                System.out.print(r.data +" ");
                printList(r.right);
            }
    }
}

/* class TriplyLinkedListTest */
public class TriplyLinkedListTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Triply Linked List Test\n");
        TriplyLinkedList tll = new TriplyLinkedList();
        char ch;
        /*  Perform list operations  */
        do
            {
                System.out.println("\nTriply Linked List Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. check empty");
                System.out.println("3. make empty");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        tll.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Empty status = "+ tll.isEmpty());
                        break;
                    case 3 :
                        System.out.println("\nList Cleared\n");
                        tll.makeEmpty();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display list */
                System.out.print("\nList : ");
                tll.printList();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*


Triply Linked List Operations

1. insert
2. check empty
3. make empty
1
Enter integer element to insert
97

List : 97
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
1
Enter integer element to insert
24

List : 24 97
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
1
Enter integer element to insert
6

List : 6 24 97
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
1
Enter integer element to insert
19

List : 6 19 24 97
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
1
Enter integer element to insert
94

List : 6 19 24 94 97
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
1
Enter integer element to insert
57

List : 6 19 24 57 94 97
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
1
Enter integer element to insert
23

List : 6 19 23 24 57 94 97
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
2
Empty status = false

List : 6 19 23 24 57 94 97
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
3

List Cleared


List :
Do you want to continue (Type y or n)

y

Triply Linked List Operations

1. insert
2. check empty
3. make empty
2
Empty status = true

List :
Do you want to continue (Type y or n)

n
