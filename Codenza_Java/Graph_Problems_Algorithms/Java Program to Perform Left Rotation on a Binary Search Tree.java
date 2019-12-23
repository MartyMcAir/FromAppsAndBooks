/*This is a Java Program to implement Self Balancing Binary Search Tree. A self-balancing (or height-balanced) binary search tree is any node-based binary search tree that automatically keeps its height (maximal number of levels below the root) small in the face of arbitrary item insertions and deletions.
These structures provide efficient implementations for mutable ordered lists, and can be used for other abstract data structures such as associative arrays, priority queues and sets. The implementation of self balancing binary search tree is similar to that of a AVL Tree data structure.*/

//This is a java program to implement self balancing binary search trees and indicate when left rotation is performed
import java.util.Scanner;

class SBBST
{
    SBBST left, right;
    int   data;
    int   height;

    public SBBST()
    {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }

    public SBBST(int n)
    {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}

class SelfBalancingBinarySearchTree
{
    private SBBST root;

    public SelfBalancingBinarySearchTree()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void clear()
    {
        root = null;
    }

    public void insert(int data)
    {
        root = insert(data, root);
    }

    private int height(SBBST t)
    {
        return t == null ? -1 : t.height;
    }

    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }

    private SBBST insert(int x, SBBST t)
    {
        if (t == null)
            t = new SBBST(x);
        else if (x < t.data)
            {
                t.left = insert(x, t.left);
                if (height(t.left) - height(t.right) == 2)
                    if (x < t.left.data)
                        t = rotateWithLeftChild(t);
                    else
                        t = doubleWithLeftChild(t);
            }
        else if (x > t.data)
            {
                t.right = insert(x, t.right);
                if (height(t.right) - height(t.left) == 2)
                    if (x > t.right.data)
                        t = rotateWithRightChild(t);
                    else
                        t = doubleWithRightChild(t);
            }
        else
            ;
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private SBBST rotateWithLeftChild(SBBST k2)
    {
        System.out.println("Left Rotation Performed");
        SBBST k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private SBBST rotateWithRightChild(SBBST k1)
    {
        //System.out.println("Right Rotation Performed");
        SBBST k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private SBBST doubleWithLeftChild(SBBST k3)
    {
        System.out.println("Left Rotation Performed");
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private SBBST doubleWithRightChild(SBBST k1)
    {
        //System.out.println("Right Rotation Performed");
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    public int countNodes()
    {
        return countNodes(root);
    }

    private int countNodes(SBBST r)
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

    public boolean search(int val)
    {
        return search(root, val);
    }

    private boolean search(SBBST r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
            {
                int rval = r.data;
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

    public void inorder()
    {
        inorder(root);
    }

    private void inorder(SBBST r)
    {
        if (r != null)
            {
                inorder(r.left);
                System.out.print(r.data + " ");
                inorder(r.right);
            }
    }

    public void preorder()
    {
        preorder(root);
    }

    private void preorder(SBBST r)
    {
        if (r != null)
            {
                System.out.print(r.data + " ");
                preorder(r.left);
                preorder(r.right);
            }
    }

    public void postorder()
    {
        postorder(root);
    }

    private void postorder(SBBST r)
    {
        if (r != null)
            {
                postorder(r.left);
                postorder(r.right);
                System.out.print(r.data + " ");
            }
    }
}

public class Left_Rotation_BST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        SelfBalancingBinarySearchTree sbbst = new SelfBalancingBinarySearchTree();
        System.out.println("Self Balancing Tree\n");
        System.out.println("Inset first 10 Elements");
        int N = 10;
        for (int i = 0; i < N; i++)
            {
                sbbst.insert(scan.nextInt());
                System.out.println("\nPre-order  :");
                sbbst.preorder();
                System.out.println("\nIn-order   :");
                sbbst.inorder();
                System.out.println("\nPost-order :");
                sbbst.postorder();
                System.out.println();
            }
        scan.close();
    }
}

/*
Self Balancing Tree

Inset first 10 Elements
10

Pre-order  :
10
In-order   :
10
Post-order :
10
9

Pre-order  :
10 9
In-order   :
9 10
Post-order :
9 10
8
Left Rotation Performed

Pre-order  :
9 8 10
In-order   :
8 9 10
Post-order :
8 10 9
7

Pre-order  :
9 8 7 10
In-order   :
7 8 9 10
Post-order :
7 8 10 9
6
Left Rotation Performed

Pre-order  :
9 7 6 8 10
In-order   :
6 7 8 9 10
Post-order :
6 8 7 10 9
5
Left Rotation Performed

Pre-order  :
7 6 5 9 8 10
In-order   :
5 6 7 8 9 10
Post-order :
5 6 8 10 9 7
4
Left Rotation Performed

Pre-order  :
7 5 4 6 9 8 10
In-order   :
4 5 6 7 8 9 10
Post-order :
4 6 5 8 10 9 7
3

Pre-order  :
7 5 4 3 6 9 8 10
In-order   :
3 4 5 6 7 8 9 10
Post-order :
3 4 6 5 8 10 9 7
2
Left Rotation Performed

Pre-order  :
7 5 3 2 4 6 9 8 10
In-order   :
2 3 4 5 6 7 8 9 10
Post-order :
2 4 3 6 5 8 10 9 7
1
Left Rotation Performed

Pre-order  :
7 3 2 1 5 4 6 9 8 10
In-order   :
1 2 3 4 5 6 7 8 9 10
Post-order :
1 2 4 6 5 3 8 10 9 7
