/*This is a Java Program to find minimum value of a Binary Search Tree. A binary search tree (BST), sometimes also called an ordered or sorted binary tree, is a node-based binary tree data structure which has the following properties:
i) The left subtree of a node contains only nodes with keys less than the node’s key.
ii) The right subtree of a node contains only nodes with keys greater than the node’s key.
iii) The left and right subtree must each also be a binary search tree.
iv) There must be no duplicate nodes.*/

/*
 *  Java Program to Find the Minimum value of Binary Search Tree
 */

import java.util.Scanner;

/* Class BSTNode */
class BSTNode
{
    BSTNode left, right;
    int data;

    /* Constructor */
    public BSTNode()
    {
        left = null;
        right = null;
        data = 0;
    }
    /* Constructor */
    public BSTNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }
}

/* Class BST */
class BST
{
    private BSTNode root;

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
    private BSTNode insert(BSTNode node, int data)
    {
        if (node == null)
            node = new BSTNode(data);
        else
            {
                if (data <= node.data)
                    node.left = insert(node.left, data);
                else
                    node.right = insert(node.right, data);
            }
        return node;
    }
    /* Function to return least value */
    public int minValue()
    {
        return minValue(root);
    }
    /* Function to return least value recursively */
    private int minValue(BSTNode r)
    {
        if (r.left == null)
            return r.data;
        return minValue(r.left);
    }

    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BSTNode r)
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
    private void preorder(BSTNode r)
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
    private void postorder(BSTNode r)
    {
        if (r != null)
            {
                postorder(r.left);
                postorder(r.right);
                System.out.print(r.data +" ");
            }
    }
}

/* Class MinValueBST */
public class MinValueBST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of BST */
        BST bst = new BST();
        System.out.println("Minimum Value of Binary Search Tree Test\n");
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
        System.out.println("\nMnimum value of the Binary Search Tree is : "+ bst.minValue());
    }
}

/*
Minimum Value of Binary Search Tree Test

Enter integer element to insert
56

Post order : 56
Pre order : 56
In order : 56
Do you want to continue (Type y or n)

y
Enter integer element to insert
23

Post order : 23 56
Pre order : 56 23
In order : 23 56
Do you want to continue (Type y or n)

y
Enter integer element to insert
80

Post order : 23 80 56
Pre order : 56 23 80
In order : 23 56 80
Do you want to continue (Type y or n)

y
Enter integer element to insert
12

Post order : 12 23 80 56
Pre order : 56 23 12 80
In order : 12 23 56 80
Do you want to continue (Type y or n)

y
Enter integer element to insert
234

Post order : 12 23 234 80 56
Pre order : 56 23 12 80 234
In order : 12 23 56 80 234
Do you want to continue (Type y or n)

y
Enter integer element to insert
546

Post order : 12 23 546 234 80 56
Pre order : 56 23 12 80 234 546
In order : 12 23 56 80 234 546
Do you want to continue (Type y or n)

y
Enter integer element to insert
6

Post order : 6 12 23 546 234 80 56
Pre order : 56 23 12 6 80 234 546
In order : 6 12 23 56 80 234 546
Do you want to continue (Type y or n)

y
Enter integer element to insert
32

Post order : 6 12 32 23 546 234 80 56
Pre order : 56 23 12 6 32 80 234 546
In order : 6 12 23 32 56 80 234 546
Do you want to continue (Type y or n)

n

Mnimum value of the Binary Search Tree is : 6
