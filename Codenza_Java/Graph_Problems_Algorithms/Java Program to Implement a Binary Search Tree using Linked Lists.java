/*This is a Java Program to implement Binary Search Tree using Linked Lists. A binary search tree (BST), sometimes also called an ordered or sorted binary tree, is a node-based binary tree data structure which has the following properties:
i) The left subtree of a node contains only nodes with keys less than the node’s key.
ii) The right subtree of a node contains only nodes with keys greater than the node’s key.
iii) The left and right subtree must each also be a binary search tree.
iv) There must be no duplicate nodes.
Here BST is implemented using Linked List.*/

/*
 *  Java Program to Implement a Binary Search Tree using Linked Lists
 */

import java.util.Scanner;

/* Class Node */
class Node
{
    Node left, right;
    int data;

    /* Constructor */
    public Node(int n)
    {
        left = null;
        right = null;
        data = n;
    }
}

/* Class BST */
class BST
{
    private Node root;

    /* Constructor */
    public BST()
    {
        root = null;
    }
    /* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private Node insert(Node node, int data)
    {
        if (node == null)
            node = new Node(data);
        else
            {
                if (data <= node.data)
                    node.left = insert(node.left, data);
                else
                    node.right = insert(node.right, data);
            }
        return node;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node r)
    {
        if (r != null)
            {
                inorder(r.left);
                System.out.print(r.data +" ");
                inorder(r.right);
            }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(Node r)
    {
        if (r != null)
            {
                System.out.print(r.data +" ");
                preorder(r.left);
                preorder(r.right);
            }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node r)
    {
        if (r != null)
            {
                postorder(r.left);
                postorder(r.right);
                System.out.print(r.data +" ");
            }
    }
}

/* Class LinkedListBST */
public class LinkedListBST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of BST */
        BST bst = new BST();
        System.out.println("Linked List Binary Search Tree Test\n");
        char ch;
        /*  Accept input  */
        do
            {
                System.out.println("Enter integer element to insert");
                bst.insert( scan.nextInt() );
                /*  Display tree  */
                System.out.print("\nPost order : ");
                bst.postorder();
                System.out.print("\nPre order : ");
                bst.preorder();
                System.out.print("\nIn order : ");
                bst.inorder();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}


/*
Enter integer element to insert
45

Post order : 45
Pre order : 45
In order : 45
Do you want to continue (Type y or n)

y
Enter integer element to insert
12

Post order : 12 45
Pre order : 45 12
In order : 12 45
Do you want to continue (Type y or n)

y
Enter integer element to insert
67

Post order : 12 67 45
Pre order : 45 12 67
In order : 12 45 67
Do you want to continue (Type y or n)

y
Enter integer element to insert
23

Post order : 23 12 67 45
Pre order : 45 12 23 67
In order : 12 23 45 67
Do you want to continue (Type y or n)

y
Enter integer element to insert
96

Post order : 23 12 96 67 45
Pre order : 45 12 23 67 96
In order : 12 23 45 67 96
Do you want to continue (Type y or n)

y
Enter integer element to insert
32

Post order : 32 23 12 96 67 45
Pre order : 45 12 23 32 67 96
In order : 12 23 32 45 67 96
Do you want to continue (Type y or n)

y
Enter integer element to insert
24

Post order : 24 32 23 12 96 67 45
Pre order : 45 12 23 32 24 67 96
In order : 12 23 24 32 45 67 96
Do you want to continue (Type y or n)

n
