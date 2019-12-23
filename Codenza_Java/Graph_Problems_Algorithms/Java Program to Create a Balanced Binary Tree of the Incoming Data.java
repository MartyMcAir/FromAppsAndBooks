/*This is a Java Program to implement Self Balancing Binary Tree. A self-balancing (or height-balanced) binary tree is any node-based binary tree that automatically keeps its height (maximal number of levels below the root) small in the face of arbitrary item insertions and deletions.
These structures provide efficient implementations for mutable ordered lists, and can be used for other abstract data structures such as associative arrays, priority queues and sets. The implementation of self balancing binary tree is similar to that of a AVL Tree data structure.*/

//This is a java program to make a self balancing binary tree for the input data
import java.util.Scanner;

class SBBSTNodes
{
    SBBSTNodes left, right;
    int        data;
    int        height;

    public SBBSTNodes()
    {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }

    public SBBSTNodes(int n)
    {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}

class SelfBalancingBinarySearchTrees
{
    private SBBSTNodes root;

    public SelfBalancingBinarySearchTrees()
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

    private int height(SBBSTNodes t)
    {
        return t == null ? -1 : t.height;
    }

    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }

    private SBBSTNodes insert(int x, SBBSTNodes t)
    {
        if (t == null)
            t = new SBBSTNodes(x);
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

    private SBBSTNodes rotateWithLeftChild(SBBSTNodes k2)
    {
        SBBSTNodes k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private SBBSTNodes rotateWithRightChild(SBBSTNodes k1)
    {
        SBBSTNodes k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private SBBSTNodes doubleWithLeftChild(SBBSTNodes k3)
    {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private SBBSTNodes doubleWithRightChild(SBBSTNodes k1)
    {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    public int countNodes()
    {
        return countNodes(root);
    }

    private int countNodes(SBBSTNodes r)
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

    private boolean search(SBBSTNodes r, int val)
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

    private void inorder(SBBSTNodes r)
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

    private void preorder(SBBSTNodes r)
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

    private void postorder(SBBSTNodes r)
    {
        if (r != null)
            {
                postorder(r.left);
                postorder(r.right);
                System.out.print(r.data + " ");
            }
    }
}

public class Balanced_B_Tree
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        SelfBalancingBinarySearchTrees sbbst = new SelfBalancingBinarySearchTrees();
        System.out.println("Self Balancing Tree\n");
        int N = 10;
        for (int i = 0; i < N; i++)
            sbbst.insert(scan.nextInt());
        System.out.println("\nPre-order  :");
        sbbst.preorder();
        System.out.println("\nIn-order   :");
        sbbst.inorder();
        System.out.println("\nPost-order :");
        sbbst.postorder();
        scan.close();
    }
}

/*
Self Balancing Tree

45
46
48
98
23
34
65
59
21
10

Pre-order  :
46 34 21 10 23 45 65 48 59 98
In-order   :
10 21 23 34 45 46 48 59 65 98
Post-order :
10 23 21 45 34 59 48 98 65 46
