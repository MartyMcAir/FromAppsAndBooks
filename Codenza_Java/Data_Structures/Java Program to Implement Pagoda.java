/*This is a Java Program to implement Pagoda. A pagoda is a priority queue implemented with a variant of a binary tree. The root points to its children, as in a binary tree. Every other node points back to its parent and down to its leftmost (if it is a right child) or rightmost (if it is a left child) descendant leaf. The basic operation is merge or meld, which maintains the heap property. An element is inserted by merging it as a singleton. The root is removed by merging its right and left children. Merging is bottom-up, merging the leftmost edge of one with the rightmost edge of the other.*/

/*
 *    Java Program to Implement Pagoda
 */

import java.util.Scanner;

/* Class PNode */
class PNode
{
    PNode left, right;
    int data;

    /* Constructor */
    public PNode(int val)
    {
        data = val;
        left = null;
        right = null;
    }
}

/* Class Pagoda */
class Pagoda
{
    private PNode root;

    /* Constructor */
    public Pagoda()
    {
        root = null;
    }
    /* Function to check if empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Function to clear */
    public void makeEmpty()
    {
        root = null;
    }
    /* Function to insert value */
    public void insert(int val)
    {
        PNode newNode = new PNode(val);
        root = insert(newNode, root);
    }
    private PNode insert(PNode newNode, PNode pq)
    {
        newNode.left = newNode;
        newNode.right = newNode;
        return (merge(pq, newNode));
    }
    /* Function to merge two nodes */
    private PNode merge(PNode a, PNode b)
    {
        PNode bota, botb, r, temp;
        if (a == null)
            return b;
        else if (b == null)
            return a;
        else
            {
                bota = a.right;
                a.right = null;
                /* bottom of b's leftmost edge */
                botb = b.left;
                b.left = null;
                r = null;
                /* Merging loop */
                while ( bota != null && botb != null )
                    if ( bota.data < botb.data )
                        {
                            temp = bota.right;
                            if ( r == null )
                                bota.right = bota;
                            else
                                {
                                    bota.right = r.right;
                                    r.right = bota;
                                }
                            r = bota;
                            bota = temp;
                        }
                    else
                        {
                            temp = botb.left;
                            if ( r == null )
                                botb.left = botb;
                            else
                                {
                                    botb.left = r.left;
                                    r.left = botb;
                                }
                            r = botb;
                            botb = temp;
                        }
                /* one edge is exhausted, finish merge */
                if ( botb == null )
                    {
                        a.right = r.right;
                        r.right = bota;
                        return( a );
                    }
                else
                    {
                        b.left = r.left;
                        r.left = botb;
                        return( b );
                    }
            }
    }
    /* Function to delete */
    public void delete()
    {
        root = delete(root);
    }
    private PNode delete(PNode pq)
    {
        PNode le, ri;
        /* Deletion on empty queue */
        if ( pq == null )
            {
                System.out.println("Empty");
                return null;
            }
        else
            {
                /* Find left descendant of root */
                if ( pq.left == pq )
                    le = null;
                else
                    {
                        le = pq.left;
                        while ( le.left != pq )
                            le = le.left;
                        le.left = pq.left;
                    }
                /* Find right descendant of root */
                if ( pq.right == pq )
                    ri = null;
                else
                    {
                        ri = pq.right;
                        while ( ri.right != pq )
                            ri = ri.right;
                        ri.right = pq.right;
                    }
                /* merge them */
                return merge(le, ri);
            }
    }
    /* Function to print root value */
    public void printPagodaRoot()
    {
        if (root != null)
            System.out.print(root.data +"\n");
        else
            System.out.print("Empty\n");
    }
}


/* Class PagodaTest */
public class PagodaTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of Pagoda */
        Pagoda pgda = new Pagoda();
        System.out.println("Pagoda Test\n");
        char ch;
        /*  Perform tree operations  */
        do
            {
                System.out.println("\nPagoda Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. delete");
                System.out.println("3. check empty");
                System.out.println("4. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        pgda.insert( scan.nextInt() );
                        break;
                    case 2 :
                        pgda.delete();
                        break;
                    case 3 :
                        System.out.println("Empty status = "+ pgda.isEmpty());
                        break;
                    case 4 :
                        System.out.println("\nCleared");
                        pgda.makeEmpty();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display tree  */
                System.out.print("\nRoot Element : ");
                pgda.printPagodaRoot();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
1
Enter integer element to insert
45

Root Element : 45

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
1
Enter integer element to insert
23

Root Element : 45

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
1
Enter integer element to insert
57

Root Element : 57

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
1
Enter integer element to insert
19

Root Element : 57

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
1
Enter integer element to insert
24

Root Element : 57

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
1
Enter integer element to insert
93

Root Element : 93

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
1
Enter integer element to insert
87

Root Element : 93

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
2

Root Element : 87

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
2

Root Element : 57

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
2

Root Element : 45

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
2

Root Element : 24

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
2

Root Element : 23

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
2

Root Element : 19

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
2

Root Element : Empty

Do you want to continue (Type y or n)

y

Pagoda Operations

1. insert
2. delete
3. check empty
4. clear
3
Empty status = true

Root Element : Empty

Do you want to continue (Type y or n)

n
