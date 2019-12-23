/*This is a java program to construct a binary tree and perform inorder traversal of the constructed binary tree.
Nodes visited are in the order:
visit Left node
visit Root node
visit Right node*/

//This is a java program to implement recursive inorder traversal of the Binary Search Tree
import java.util.Scanner;

class BinarySearchTreeNodes
{
    BinarySearchTreeNodes left, right;
    int      data;

    public BinarySearchTreeNodes()
    {
        left = null;
        right = null;
        data = 0;
    }

    public BinarySearchTreeNodes(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BinarySearchTreeNodes n)
    {
        left = n;
    }

    public void setRight(BinarySearchTreeNodes n)
    {
        right = n;
    }

    public BinarySearchTreeNodes getLeft()
    {
        return left;
    }

    public BinarySearchTreeNodes getRight()
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

class BinarySearchTree
{
    private BinarySearchTreeNodes root;

    public BinarySearchTree()
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

    private BinarySearchTreeNodes insert(BinarySearchTreeNodes node, int data)
    {
        if (node == null)
            node = new BinarySearchTreeNodes(data);
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

    private void inorder(BinarySearchTreeNodes r)
    {
        if (r != null)
            {
                inorder(r.getLeft());
                System.out.print(r.getData() + " ");
                inorder(r.getRight());
            }
    }
}

public class Inorder_Recursive_BST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("Enter the first 10 elements of the tree\n");
        int N = 10;
        for (int i = 0; i < N; i++)
            bst.insert(scan.nextInt());
        System.out.print("\nIn order   : ");
        bst.inorder();
        scan.close();
    }
}

/*
Enter the first 10 elements of the tree

12 10 11 03 15 19 02 01 04 70

In order   : 1 2 3 4 10 11 12 15 19 70
