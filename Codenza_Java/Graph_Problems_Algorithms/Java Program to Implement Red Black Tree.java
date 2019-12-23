/*This is a Java Program to implement Red Black Tree. A red–black tree is a type of self-balancing binary search tree. The self-balancing is provided by painting each node with one of two colors (these are typically called ‘red’ and ‘black’, hence the name of the trees) in such a way that the resulting painted tree satisfies certain properties that don’t allow it to become significantly unbalanced. When the tree is modified, the new tree is subsequently rearranged and repainted to restore the coloring properties. The properties are designed in such a way that this rearranging and recoloring can be performed efficiently. This program is based on the implementation by Mark Allen Weiss.*/

/*
 *  Java Program to Implement Red Black Tree
 */

import java.util.Scanner;

/* Class Node */
class RedBlackNode
{
    RedBlackNode left, right;
    int element;
    int color;

    /* Constructor */
    public RedBlackNode(int theElement)
    {
        this( theElement, null, null );
    }
    /* Constructor */
    public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }
}

/* Class RBTree */
class RBTree
{
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    private RedBlackNode header;
    private static RedBlackNode nullNode;
    /* static initializer for nullNode */
    static
    {
        nullNode = new RedBlackNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }
    /* Black - 1  RED - 0 */
    static final int BLACK = 1;
    static final int RED   = 0;

    /* Constructor */
    public RBTree(int negInf)
    {
        header = new RedBlackNode(negInf);
        header.left = nullNode;
        header.right = nullNode;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return header.right == nullNode;
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        header.right = nullNode;
    }
    /* Function to insert item */
    public void insert(int item )
    {
        current = parent = grand = header;
        nullNode.element = item;
        while (current.element != item)
            {
                great = grand;
                grand = parent;
                parent = current;
                current = item < current.element ? current.left : current.right;
                // Check if two red children and fix if so
                if (current.left.color == RED && current.right.color == RED)
                    handleReorient( item );
            }
        // Insertion fails if already present
        if (current != nullNode)
            return;
        current = new RedBlackNode(item, nullNode, nullNode);
        // Attach to parent
        if (item < parent.element)
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }
    private void handleReorient(int item)
    {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;
        if (parent.color == RED)
            {
                // Have to rotate
                grand.color = RED;
                if (item < grand.element != item < parent.element)
                    parent = rotate( item, grand );  // Start dbl rotate
                current = rotate(item, great );
                current.color = BLACK;
            }
        // Make root black
        header.right.color = BLACK;
    }
    private RedBlackNode rotate(int item, RedBlackNode parent)
    {
        if(item < parent.element)
            return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;
        else
            return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
    }
    /* Rotate binary tree node with left child */
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
    {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    /* Rotate binary tree node with right child */
    private RedBlackNode rotateWithRightChild(RedBlackNode k1)
    {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(header.right);
    }
    private int countNodes(RedBlackNode r)
    {
        if (r == nullNode)
            return 0;
        else
            {
                int l = 1;
                l += countNodes(r.left);
                l += countNodes(r.right);
                return l;
            }
    }
    /* Functions to search for an element */
    public boolean search(int val)
    {
        return search(header.right, val);
    }
    private boolean search(RedBlackNode r, int val)
    {
        boolean found = false;
        while ((r != nullNode) && !found)
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
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(header.right);
    }
    private void inorder(RedBlackNode r)
    {
        if (r != nullNode)
            {
                inorder(r.left);
                char c = 'B';
                if (r.color == 0)
                    c = 'R';
                System.out.print(r.element +""+c+" ");
                inorder(r.right);
            }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(header.right);
    }
    private void preorder(RedBlackNode r)
    {
        if (r != nullNode)
            {
                char c = 'B';
                if (r.color == 0)
                    c = 'R';
                System.out.print(r.element +""+c+" ");
                preorder(r.left);
                preorder(r.right);
            }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(header.right);
    }
    private void postorder(RedBlackNode r)
    {
        if (r != nullNode)
            {
                postorder(r.left);
                postorder(r.right);
                char c = 'B';
                if (r.color == 0)
                    c = 'R';
                System.out.print(r.element +""+c+" ");
            }
    }
}

/* Class RedBlackTreeTest */
public class RedBlackTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of RedBlack Tree */
        RBTree rbt = new RBTree(Integer.MIN_VALUE);
        System.out.println("Red Black Tree Test\n");
        char ch;
        /*  Perform tree operations  */
        do
            {
                System.out.println("\nRed Black Tree Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. search");
                System.out.println("3. count nodes");
                System.out.println("4. check empty");
                System.out.println("5. clear tree");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        rbt.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Search result : "+ rbt.search( scan.nextInt() ));
                        break;
                    case 3 :
                        System.out.println("Nodes = "+ rbt.countNodes());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ rbt.isEmpty());
                        break;
                    case 5 :
                        System.out.println("\nTree Cleared");
                        rbt.makeEmpty();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display tree  */
                System.out.print("\nPost order : ");
                rbt.postorder();
                System.out.print("\nPre order : ");
                rbt.preorder();
                System.out.print("\nIn order : ");
                rbt.inorder();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
4
Empty status = true

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
1
Enter integer element to insert
8

Post order : 8B
Pre order : 8B
In order : 8B
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
1
Enter integer element to insert
3

Post order : 3R 8B
Pre order : 8B 3R
In order : 3R 8B
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
1
Enter integer element to insert
5

Post order : 3R 8R 5B
Pre order : 5B 3R 8R
In order : 3R 5B 8R
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
1
Enter integer element to insert
2

Post order : 2R 3B 8B 5B
Pre order : 5B 3B 2R 8B
In order : 2R 3B 5B 8B
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
1
Enter integer element to insert
1

Post order : 1R 3R 2B 8B 5B
Pre order : 5B 2B 1R 3R 8B
In order : 1R 2B 3R 5B 8B
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
1
Enter integer element to insert
9

Post order : 1R 3R 2B 9R 8B 5B
Pre order : 5B 2B 1R 3R 8B 9R
In order : 1R 2B 3R 5B 8B 9R
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
1
Enter integer element to insert
10

Post order : 1R 3R 2B 8R 10R 9B 5B
Pre order : 5B 2B 1R 3R 9B 8R 10R
In order : 1R 2B 3R 5B 8R 9B 10R
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
3
Nodes = 7

Post order : 1R 3R 2B 8R 10R 9B 5B
Pre order : 5B 2B 1R 3R 9B 8R 10R
In order : 1R 2B 3R 5B 8R 9B 10R
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
2
Enter integer element to search
4
Search result : false

Post order : 1R 3R 2B 8R 10R 9B 5B
Pre order : 5B 2B 1R 3R 9B 8R 10R
In order : 1R 2B 3R 5B 8R 9B 10R
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
2
Enter integer element to search
6
Search result : false

Post order : 1R 3R 2B 8R 10R 9B 5B
Pre order : 5B 2B 1R 3R 9B 8R 10R
In order : 1R 2B 3R 5B 8R 9B 10R
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
2
Enter integer element to search
3
Search result : true

Post order : 1R 3R 2B 8R 10R 9B 5B
Pre order : 5B 2B 1R 3R 9B 8R 10R
In order : 1R 2B 3R 5B 8R 9B 10R
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
5

Tree Cleared

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

y

Red Black Tree Operations

1. insert
2. search
3. count nodes
4. check empty
5. clear tree
4
Empty status = true

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

n
