/*This is a Java Program to implement Binary Tree. A binary tree is a tree data structure in which each node has at most two child nodes, usually distinguished as “left” and “right”. Nodes with children are parent nodes, and child nodes may contain references to their parents. Outside the tree, there is often a reference to the “root” node (the ancestor of all nodes), if it exists. Any node in the data structure can be reached by starting at root node and repeatedly following references to either the left or right child. A tree which does not have any node other than root node is called a null tree. In a binary tree, a degree of every node is maximum two. A tree with n nodes has exactly n−1 branches or degree.
Binary trees are used to implement binary search trees and binary heaps, finding applications in efficient searching and sorting algorithms.*/

/*
 *  Java Program to Implement Binary Tree
 */

import java.util.Scanner;

/* Class BTNode */
class BTNode
{
    BTNode left, right;
    int data;

    /* Constructor */
    public BTNode()
    {
        left = null;
        right = null;
        data = 0;
    }
    /* Constructor */
    public BTNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }
    /* Function to set left node */
    public void setLeft(BTNode n)
    {
        left = n;
    }
    /* Function to set right node */
    public void setRight(BTNode n)
    {
        right = n;
    }
    /* Function to get left node */
    public BTNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public BTNode getRight()
    {
        return right;
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

/* Class BT */
class BT
{
    private BTNode root;

    /* Constructor */
    public BT()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private BTNode insert(BTNode node, int data)
    {
        if (node == null)
            node = new BTNode(data);
        else
            {
                if (node.getRight() == null)
                    node.right = insert(node.right, data);
                else
                    node.left = insert(node.left, data);
            }
        return node;
    }
    /* Function to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(BTNode r)
    {
        if (r == null)
            return 0;
        else
            {
                int l = 1;
                l += countNodes(r.getLeft());
                l += countNodes(r.getRight());
                return l;
            }
    }
    /* Function to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }
    /* Function to search for an element recursively */
    private boolean search(BTNode r, int val)
    {
        if (r.getData() == val)
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), val))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), val))
                return true;
        return false;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BTNode r)
    {
        if (r != null)
            {
                inorder(r.getLeft());
                System.out.print(r.getData() +" ");
                inorder(r.getRight());
            }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(BTNode r)
    {
        if (r != null)
            {
                System.out.print(r.getData() +" ");
                preorder(r.getLeft());
                preorder(r.getRight());
            }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(BTNode r)
    {
        if (r != null)
            {
                postorder(r.getLeft());
                postorder(r.getRight());
                System.out.print(r.getData() +" ");
            }
    }
}

/* Class BinaryTree */
public class BinaryTree
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of BT */
        BT bt = new BT();
        /*  Perform tree operations  */
        System.out.println("Binary Tree Test\n");
        char ch;
        do
            {
                System.out.println("\nBinary Tree Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. search");
                System.out.println("3. count nodes");
                System.out.println("4. check empty");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        bt.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Search result : "+ bt.search( scan.nextInt() ));
                        break;
                    case 3 :
                        System.out.println("Nodes = "+ bt.countNodes());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ bt.isEmpty());
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display tree  */
                System.out.print("\nPost order : ");
                bt.postorder();
                System.out.print("\nPre order : ");
                bt.preorder();
                System.out.print("\nIn order : ");
                bt.inorder();
                System.out.println("\n\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Binary Tree Test


Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
4
Empty status = true

Post order :
Pre order :
In order :

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
6

Post order : 6
Pre order : 6
In order : 6

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
24

Post order : 24 6
Pre order : 6 24
In order : 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
19

Post order : 19 24 6
Pre order : 6 19 24
In order : 19 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
94

Post order : 94 19 24 6
Pre order : 6 19 94 24
In order : 19 94 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
5

Post order : 5 94 19 24 6
Pre order : 6 19 5 94 24
In order : 5 19 94 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
1

Post order : 1 5 94 19 24 6
Pre order : 6 19 5 1 94 24
In order : 5 1 19 94 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
10

Post order : 10 1 5 94 19 24 6
Pre order : 6 19 5 10 1 94 24
In order : 10 5 1 19 94 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
3

Post order : 3 10 1 5 94 19 24 6
Pre order : 6 19 5 10 3 1 94 24
In order : 10 3 5 1 19 94 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
1
Enter integer element to insert
8

Post order : 8 3 10 1 5 94 19 24 6
Pre order : 6 19 5 10 8 3 1 94 24
In order : 8 10 3 5 1 19 94 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
3
Nodes = 9

Post order : 8 3 10 1 5 94 19 24 6
Pre order : 6 19 5 10 8 3 1 94 24
In order : 8 10 3 5 1 19 94 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
2
Enter integer element to search
24
Search result : true

Post order : 8 3 10 1 5 94 19 24 6
Pre order : 6 19 5 10 8 3 1 94 24
In order : 8 10 3 5 1 19 94 6 24

Do you want to continue (Type y or n)

y

Binary Tree Operations

1. insert
2. search
3. count nodes
4. check empty
2
Enter integer element to search
7
Search result : false

Post order : 8 3 10 1 5 94 19 24 6
Pre order : 6 19 5 10 8 3 1 94 24
In order : 8 10 3 5 1 19 94 6 24

Do you want to continue (Type y or n)

n
