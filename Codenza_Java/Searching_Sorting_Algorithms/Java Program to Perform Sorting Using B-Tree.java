/*Java Program to Perform Sorting Using B-Tree

This is a java program to implement sorting using B-Trees. Binary Search Trees are the type of B trees that self organizes. Inorder traversal of BSTs results in the sorted sequence of elements in the tree.*/

//This is a java program to perform sorting using BTree, Inorder traversal of BST results in sorting of numbers
import java.util.Random;

/* Class BSTNode */
class BSTNodes
{
    BSTNodes left, right;
    int data;

    /* Constructor */
    public BSTNodes()
    {
        left = null;
        right = null;
        data = 0;
    }

    /* Constructor */
    public BSTNodes(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    /* Function to set left node */
    public void setLeft(BSTNodes n)
    {
        left = n;
    }

    /* Function to set right node */
    public void setRight(BSTNodes n)
    {
        right = n;
    }

    /* Function to get left node */
    public BSTNodes getLeft()
    {
        return left;
    }

    /* Function to get right node */
    public BSTNodes getRight()
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

/* Class BST */
class BT
{
    private BSTNode root;

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
    private BSTNode insert(BSTNode node, int data)
    {
        if (node == null)
            node = new BSTNode(data);
        else
            {
                if (data <= node.getData())
                    node.left = insert(node.left, data);
                else
                    node.right = insert(node.right, data);
            }
        return node;
    }

    /* Functions to delete data */
    public void delete(int k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry " + k + " is not present");
        else
            {
                root = delete(root, k);
                System.out.println(k + " deleted from the tree");
            }
    }

    private BSTNode delete(BSTNode root, int k)
    {
        BSTNode p, p2, n;
        if (root.getData() == k)
            {
                BSTNode lt, rt;
                lt = root.getLeft();
                rt = root.getRight();
                if (lt == null && rt == null)
                    return null;
                else if (lt == null)
                    {
                        p = rt;
                        return p;
                    }
                else if (rt == null)
                    {
                        p = lt;
                        return p;
                    }
                else
                    {
                        p2 = rt;
                        p = rt;
                        while (p.getLeft() != null)
                            p = p.getLeft();
                        p.setLeft(lt);
                        return p2;
                    }
            }
        if (k < root.getData())
            {
                n = delete(root.getLeft(), k);
                root.setLeft(n);
            }
        else
            {
                n = delete(root.getRight(), k);
                root.setRight(n);
            }
        return root;
    }

    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r)
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

    /* Functions to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }

    /* Function to search for an element recursively */
    private boolean search(BSTNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
            {
                int rval = r.getData();
                if (val < rval)
                    r = r.getLeft();
                else if (val > rval)
                    r = r.getRight();
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
        inorder(root);
    }

    private void inorder(BSTNode r)
    {
        if (r != null)
            {
                inorder(r.getLeft());
                System.out.print(r.getData() + " ");
                inorder(r.getRight());
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
                System.out.print(r.getData() + " ");
                preorder(r.getLeft());
                preorder(r.getRight());
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
                postorder(r.getLeft());
                postorder(r.getRight());
                System.out.print(r.getData() + " ");
            }
    }
}

public class Sort_BTree
{
    public static int N = 20;

    public static void main(String args[])
    {
        Random random = new Random();
        BT bt = new BT();
        System.out
        .println("Sorting of randomly generated numbers using B TREE");
        for (int i = 0; i < N; i++)
            bt.insert(Math.abs(random.nextInt(100)));
        System.out.println("The elements of the tree: ");
        bt.preorder();
        System.out.println("\nThe sorted sequence is: ");
        bt.inorder();
    }
}

/*
Sorting of randomly generated numbers using B TREE
The elements of the tree:
45 23 3 4 26 39 32 30 32 83 64 50 47 54 64 67 75 88 94 95
The sorted sequence is:
3 4 23 26 30 32 32 39 45 47 50 54 64 64 67 75 83 88 94 95
