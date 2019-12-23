/*This is a Java Program to implement Cartesian Tree. A Cartesian tree is a binary tree derived from a sequence of numbers. It can be uniquely defined from the properties that it is heap-ordered and that a symmetric (in-order) traversal of the tree returns the original sequence. Introduced by Vuillemin (1980) in the context of geometric range searching data structures, Cartesian trees have also been used in the definition of the treap and randomized binary search tree data structures for binary search problems. The Cartesian tree for a sequence may be constructed in linear time using a stack-based algorithm for finding all nearest smaller values in a sequence.*/

/*
 *  Java Program to Implement Cartesian Tree
 */

import java.util.Scanner;

/* Class CTNode */
class CTNode
{
    CTNode left, right;
    int value;

    /* Constructor */
    public CTNode()
    {
        left = null;
        right = null;
        value = 0;
    }
}

/* Class CartesianTree */
class CartesianTree
{
    private CTNode root;

    /* Constructor */
    public CartesianTree(int[] data)
    {
        root = build(data);
    }
    /* Function to build Cartesian Tree from array */
    public CTNode build(int[] data)
    {
        if (data == null || data.length == 0)
            return null;
        return build(data, 0, data.length - 1);
    }
    /* Function to build Cartesian Tree from array */
    private CTNode build(int[] data, int start, int end)
    {
        if (end < start)
            return null;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = start; i <= end; i++)
            {
                if (data[i] < min)
                    {
                        min = data[i];
                        minIndex = i;
                    }
            }
        CTNode node = new CTNode();
        node.value = min;
        node.left = build(data, start, minIndex - 1);
        node.right = build(data, minIndex + 1, end);
        return node;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(CTNode r)
    {
        if (r == null)
            return 0;
        else
            {
                int l = 1;
                l += countNodes(r.left);
                l += countNodes(r.right);
                return l;
            }
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(CTNode r)
    {
        if (r != null)
            {
                inorder(r.left);
                System.out.print(r.value +" ");
                inorder(r.right);
            }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(CTNode r)
    {
        if (r != null)
            {
                System.out.print(r.value +" ");
                preorder(r.left);
                preorder(r.right);
            }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(CTNode r)
    {
        if (r != null)
            {
                postorder(r.left);
                postorder(r.right);
                System.out.print(r.value +" ");
            }
    }
}

/* Class CartesianTreeTest */
public class CartesianTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Cartesian Tree Test\n");
        System.out.println("Enter number of integer values");
        int N = scan.nextInt();
        int arr[] = new int[N];
        System.out.println("\nEnter "+ N +" integer values");
        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();
        /* Make cartesian tree from given array */
        CartesianTree ct = new CartesianTree(arr);
        /* Print tree details */
        System.out.println("\nTree Details :");
        System.out.println("Empty status - "+ ct.isEmpty());
        System.out.println("No of nodes - "+ ct.countNodes());
        System.out.print("Post order : ");
        ct.postorder();
        System.out.print("\nPre order : ");
        ct.preorder();
        System.out.print("\nIn order : ");
        ct.inorder();
        System.out.println();
    }
}

/*
Enter number of integer values
11

Enter 11 integer values
9 3 7 1 8 12 10 20 15 18 5

Tree Details :
Empty status - false
No of nodes - 11
Post order : 9 7 3 12 20 18 15 10 8 5 1
Pre order : 1 3 9 7 5 8 10 12 15 20 18
In order : 9 3 7 1 8 12 10 20 15 18 5



Cartesian Tree Test

Enter number of integer values
0

Enter 0 integer values

Tree Details :
Empty status - true
No of nodes - 0
Post order :
Pre order :
In order :
