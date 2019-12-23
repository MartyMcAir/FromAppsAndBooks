//This is a java program to insert elements in a Binary Search Tree
import java.util.Scanner;

class BSTNode
{
    BSTNode left, right;
    int     data;

    public BSTNode()
    {
        left = null;
        right = null;
        data = 0;
    }

    public BSTNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BSTNode n)
    {
        left = n;
    }

    public void setRight(BSTNode n)
    {
        right = n;
    }

    public BSTNode getLeft()
    {
        return left;
    }

    public BSTNode getRight()
    {
        return right;
    }

    public void setData(int d)
    {
        data = d;
    }

    public int getData()
    {
        return data;
    }
}

class BSTree
{
    private BSTNode root;

    public BSTree()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void insert(int data)
    {
        root = insert(root, data);
    }

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

public class Insertion_BST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BSTree bst = new BSTree();
        System.out.println("Binary Search Tree Insertion Test\n");
        int N = 10;
        for (int i = 0; i < N; i++)
            {
                bst.insert(scan.nextInt());
                System.out.print("\nPost order : ");
                bst.postorder();
                System.out.print("\nPre order  : ");
                bst.preorder();
                System.out.print("\nIn order   : ");
                bst.inorder();
            }
        scan.close();
    }
}

/*
Binary Search Tree Insertion Test

Add element: 3

Post order : 3
Pre order  : 3
In order   : 3

Add element: 5

Post order : 5 3
Pre order  : 3 5
In order   : 3 5

Add element: 4

Post order : 4 5 3
Pre order  : 3 5 4
In order   : 3 4 5

Add element: 4

Post order : 4 4 5 3
Pre order  : 3 5 4 4
In order   : 3 4 4 5

Add element: 6

Post order : 4 4 6 5 3
Pre order  : 3 5 4 4 6
In order   : 3 4 4 5 6

Add element: 45

Post order : 4 4 45 6 5 3
Pre order  : 3 5 4 4 6 45
In order   : 3 4 4 5 6 45

Add element: 7578

Post order : 4 4 7578 45 6 5 3
Pre order  : 3 5 4 4 6 45 7578
In order   : 3 4 4 5 6 45 7578

Add element: 54651

Post order : 4 4 54651 7578 45 6 5 3
Pre order  : 3 5 4 4 6 45 7578 54651
In order   : 3 4 4 5 6 45 7578 54651

Add element: 22

Post order : 4 4 22 54651 7578 45 6 5 3
Pre order  : 3 5 4 4 6 45 22 7578 54651
In order   : 3 4 4 5 6 22 45 7578 54651

Add element: 34

Post order : 4 4 34 22 54651 7578 45 6 5 3
Pre order  : 3 5 4 4 6 45 22 34 7578 54651
In order   : 3 4 4 5 6 22 34 45 7578 54651
