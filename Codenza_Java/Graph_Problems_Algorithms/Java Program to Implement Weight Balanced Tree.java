/*This is a Java Program to implement Weight Balanced Tree. A weight-balanced binary tree is a binary tree which is balanced based on knowledge of the probabilities of searching for each individual node. Within each subtree, the node with the highest weight appears at the root. This can result in more efficient searching performance.
Construction of such a tree is similar to that of a Treap, but node weights are chosen randomly in the latter.*/

/**
 *  Java Program to Implement Weight Balanced Tree
 **/

import java.util.Scanner;
import java.util.Random;

/** Class WBTNode **/
class WBTNode
{
    WBTNode left, right;
    int weight, element;

    /** Constructor **/
    public WBTNode(int ele, int wt)
    {
        this(ele, wt, null, null);
    }
    /** Constructor **/
    public WBTNode(int ele, int wt, WBTNode left, WBTNode right)
    {
        this.element = ele;
        this.left = left;
        this.right = right;
        this.weight = wt;
    }
}

/** Class WeightBalancedTree **/
class WeightBalancedTree
{
    private WBTNode root;
    private static WBTNode nil = new WBTNode(0, Integer.MAX_VALUE);

    /** Constructor **/
    public WeightBalancedTree()
    {
        root = nil;
    }

    /** Function to check if tree is empty **/
    public boolean isEmpty()
    {
        return root == nil;
    }

    /** clear tree **/
    public void clear()
    {
        root = nil;
    }

    /** Functions to insert data **/
    public void insert(int X, int WT)
    {
        root = insert(X, WT, root);
    }
    private WBTNode insert(int X, int WT, WBTNode T)
    {
        if (T == nil)
            return new WBTNode(X, WT, nil, nil);
        else if (X < T.element)
            {
                T.left = insert(X, WT, T.left);
                if (T.left.weight < T.weight)
                    {
                        WBTNode L = T.left;
                        T.left = L.right;
                        L.right = T;
                        return L;
                    }
            }
        else if (X > T.element)
            {
                T.right = insert(X, WT, T.right);
                if (T.right.weight < T.weight)
                    {
                        WBTNode R = T.right;
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
    private int countNodes(WBTNode r)
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
    private boolean search(WBTNode r, int val)
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
    private void inorder(WBTNode r)
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
    private void preorder(WBTNode r)
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
    private void postorder(WBTNode r)
    {
        if (r != nil)
            {
                postorder(r.left);
                postorder(r.right);
                System.out.print(r.element +" ");
            }
    }
}

/** Class WeightBalancedTreeTest **/
public class WeightBalancedTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /** Creating object of WeightBalancedTree**/
        WeightBalancedTree wbt = new WeightBalancedTree();
        System.out.println("Weight Balanced TreeTest\n");
        char ch;
        /**  Perform tree operations  **/
        do
            {
                System.out.println("\nWeight Balanced TreeOperations\n");
                System.out.println("1. insert ");
                System.out.println("2. search");
                System.out.println("3. count nodes");
                System.out.println("4. check empty");
                System.out.println("5. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert and weight of the element");
                        wbt.insert( scan.nextInt(), scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Search result : "+ wbt.search( scan.nextInt() ));
                        break;
                    case 3 :
                        System.out.println("Nodes = "+ wbt.countNodes());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ wbt.isEmpty());
                        break;
                    case 5 :
                        System.out.println("\nWeightBalancedTreeCleared");
                        wbt.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /**  Display tree  **/
                System.out.print("\nPost order : ");
                wbt.postorder();
                System.out.print("\nPre order : ");
                wbt.preorder();
                System.out.print("\nIn order : ");
                wbt.inorder();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert and weight of the element
24 28

Post order : 24
Pre order : 24
In order : 24
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert and weight of the element
5 6

Post order : 24 5
Pre order : 5 24
In order : 5 24
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert and weight of the element
63 94

Post order : 63 24 5
Pre order : 5 24 63
In order : 5 24 63
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert and weight of the element
14 6

Post order : 63 24 14 5
Pre order : 5 14 24 63
In order : 5 14 24 63
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert and weight of the element
1 17

Post order : 1 63 24 14 5
Pre order : 5 1 14 24 63
In order : 1 5 14 24 63
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
1
Enter integer element to insert and weight of the element
70 91

Post order : 1 63 70 24 14 5
Pre order : 5 1 14 24 70 63
In order : 1 5 14 24 63 70
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
2
Enter integer element to search
24
Search result : true

Post order : 1 63 70 24 14 5
Pre order : 5 1 14 24 70 63
In order : 1 5 14 24 63 70
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
3
Nodes = 6

Post order : 1 63 70 24 14 5
Pre order : 5 1 14 24 70 63
In order : 1 5 14 24 63 70
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

1. insert
2. search
3. count nodes
4. check empty
5. clear
5

WeightBalancedTreeCleared

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

y

Weight Balanced TreeOperations

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
