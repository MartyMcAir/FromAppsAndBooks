/*This is a java program to construct a binary tree and perform in-order traversal of the constructed binary tree.
Nodes visited are in the order:
visit Left node
visit Root node
visit Right node*/

//This is a java program to implement non recursive in order traversal of Binary Search Tree
import java.util.Scanner;
import java.util.Stack;

class BinarySearchTreeNode
{
    BinarySearchTreeNode left, right;
    int                  data;

    public BinarySearchTreeNode()
    {
        left = null;
        right = null;
        data = 0;
    }

    public BinarySearchTreeNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BinarySearchTreeNode n)
    {
        left = n;
    }

    public void setRight(BinarySearchTreeNode n)
    {
        right = n;
    }

    public BinarySearchTreeNode getLeft()
    {
        return left;
    }

    public BinarySearchTreeNode getRight()
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

class BinarySearchTreeOperations
{
    private BinarySearchTreeNodes root;

    public BinarySearchTreeOperations()
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
        if (r == null)
            return;
        Stack<BinarySearchTreeNodes> stack = new Stack<BinarySearchTreeNodes>();
        while (!stack.isEmpty() || r != null)
            {
                if (r != null)
                    {
                        stack.push(r);
                        r = r.left;
                    }
                else
                    {
                        r = stack.pop();
                        System.out.print(r.data + " ");
                        r = r.right;
                    }
            }
    }
}

public class Inorder_NonRecursive_BST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BinarySearchTreeOperations bst = new BinarySearchTreeOperations();
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

12 4 10 13 15 46 78 98 45 12

In order   : 4 10 12 12 13 15 45 46 78 98
