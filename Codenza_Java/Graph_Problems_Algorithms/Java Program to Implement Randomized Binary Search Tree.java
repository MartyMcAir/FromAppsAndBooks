/*This is a Java Program to implement Randomized Binary Search Tree. The randomized binary search tree stores the same nodes with the same random distribution of tree shape, but maintains different information within the nodes of the tree in order to maintain its randomized structure. The implementation of randomized binary search tree is similar to that of a Treap data structure.*/

/**
 *  Java Program to Implement RandomizedBinarySearchTree
 **/

import java.util.Scanner;
import java.util.Random;

/** Class RBSTNode **/
class RBSTNode
{
    RBSTNode left, right;
    int priority, element;

    /** Constructor **/
    public RBSTNode()
    {
        this.element = 0;
        this.left = this;
        this.right = this;
        this.priority = Integer.MAX_VALUE;
    }

    /** Constructor **/
    public RBSTNode(int ele)
    {
        this(ele, null, null);
    }

    /** Constructor **/
    public RBSTNode(int ele, RBSTNode left, RBSTNode right)
    {
        this.element = ele;
        this.left = left;
        this.right = right;
        this.priority = new Random().nextInt( );
    }
}

/** Class RandomizedBinarySearchTree **/
class RandomizedBinarySearchTree
{
    private RBSTNode root;
    private static RBSTNode nil = new RBSTNode();

    /** Constructor **/
    public RandomizedBinarySearchTree()
    {
        root = nil;
    }

    /** Function to check if tree is empty **/
    public boolean isEmpty()
    {
        return root == nil;
    }

    /** Make the tree logically empty **/
    public void makeEmpty()
    {
        root = nil;
    }

    /** Functions to insert data **/
    public void insert(int X)
    {
        root = insert(X, root);
    }
    private RBSTNode insert(int X, RBSTNode T)
    {
        if (T == nil)
            return new RBSTNode(X, nil, nil);
        else if (X < T.element)
            {
                T.left = insert(X, T.left);
                if (T.left.priority < T.priority)
                    {
                        RBSTNode L = T.left;
                        T.left = L.right;
                        L.right = T;
                        return L;
                    }
            }
        else if (X > T.element)
            {
                T.right = insert(X, T.right);
                if (T.right.priority < T.priority)
                    {
                        RBSTNode R = T.right;
                        T.right = R.left;
                        R.left = T;
                        return R;
                    }
            }
        return T;
    }

    /** Functions to count number of nodes **/
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(RBSTNode r)
    {
        if (r == nil)
            return 0;
        else
            {
                int l = 1;
                l += countNodes(r.left);
                l += countNodes(r.right);
                return l;
            }
    }

    /** Functions to search for an element **/
    public boolean search(int val)
    {
        return search(root, val);
    }
    private boolean search(RBSTNode r, int val)
    {
        boolean found = false;
        while ((r != nil) && !found)
            {
                int rval = r.element;
                if (val < rval)
                    r = r.left;
                else if (val > rval)
                    r = r.right;
                else
                    {
                        found = true;
                        break;
                    }
                found = search(r, val);
            }
        return found;
    }

    /** Function for inorder traversal **/
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(RBSTNode r)
    {
        if (r != nil)
            {
                inorder(r.left);
                System.out.print(r.element +" ");
                inorder(r.right);
            }
    }

    /** Function for preorder traversal **/
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(RBSTNode r)
    {
        if (r != nil)
            {
                System.out.print(r.element +" ");
                preorder(r.left);
                preorder(r.right);
            }
    }

    /** Function for postorder traversal **/
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(RBSTNode r)
    {
        if (r != nil)
            {
                postorder(r.left);
                postorder(r.right);
                System.out.print(r.element +" ");
            }
    }
}

/** Class RandomizedBinarySearchTreeTest **/
public class RandomizedBinarySearchTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /** Creating object of RandomizedBinarySearchTree **/
        RandomizedBinarySearchTree rbst = new RandomizedBinarySearchTree();
        System.out.println("Randomized Binary SearchTree Test\n");
        char ch;
        /**  Perform tree operations  **/
        do
            {
                System.out.println("\nRandomized Binary SearchTree Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. search");
                System.out.println("3. count nodes");
                System.out.println("4. check empty");
                System.out.println("5. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        rbst.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Search result : "+ rbst.search( scan.nextInt() ));
                        break;
                    case 3 :
                        System.out.println("Nodes = "+ rbst.countNodes());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ rbst.isEmpty());
                        break;
                    case 5 :
                        System.out.println("\nRandomizedBinarySearchTree Cleared");
                        rbst.makeEmpty();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /**  Display tree  **/
                System.out.print("\nPost order : ");
                rbst.postorder();
                System.out.print("\nPre order : ");
                rbst.preorder();
                System.out.print("\nIn order : ");
                rbst.inorder();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert
28

Post order : 28
Pre order : 28
In order : 28
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert
5

Post order : 5 28
Pre order : 28 5
In order : 5 28
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert
63

Post order : 5 28 63
Pre order : 63 28 5
In order : 5 28 63
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert
24

Post order : 5 24 28 63
Pre order : 63 28 24 5
In order : 5 24 28 63
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert
64

Post order : 5 24 28 64 63
Pre order : 63 28 24 5 64
In order : 5 24 28 63 64
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert
19

Post order : 5 24 28 19 64 63
Pre order : 63 19 5 28 24 64
In order : 5 19 24 28 63 64
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert
94

Post order : 5 24 28 19 64 94 63
Pre order : 63 19 5 28 24 94 64
In order : 5 19 24 28 63 64 94
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
2
Enter integer element to search
24
Search result : true

Post order : 5 24 28 19 64 94 63
Pre order : 63 19 5 28 24 94 64
In order : 5 19 24 28 63 64 94
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
2
Enter integer element to search
25
Search result : false

Post order : 5 24 28 19 64 94 63
Pre order : 63 19 5 28 24 94 64
In order : 5 19 24 28 63 64 94
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
5

RandomizedBinarySearchTree Cleared

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

y

Randomized Binary SearchTree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear
4
Empty status = true

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

n
