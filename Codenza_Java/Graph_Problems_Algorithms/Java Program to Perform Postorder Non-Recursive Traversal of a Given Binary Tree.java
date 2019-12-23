/*This is a java program to construct a binary tree and perform postorder traversal of the constructed binary tree.
Nodes visited are in the order:
visit Left node
visit Right node
visit Root node*/

//This is a java program to implement non recursive post order traversal of Binary Search Tree
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

    public void postorder()
    {
        postorder(root);
    }

    private void postorder(BinarySearchTreeNodes r)
    {
        if (root == null)
            return;
        final Stack<BinarySearchTreeNodes> stack = new Stack<BinarySearchTreeNodes>();
        BinarySearchTreeNodes node = root;
        while (!stack.isEmpty() || node != null)
            {
                while (node != null)
                    {
                        if (node.right != null)
                            stack.add(node.right);
                        stack.add(node);
                        node = node.left;
                    }
                node = stack.pop();
                if (node.right != null && !stack.isEmpty()
                        && node.right == stack.peek())
                    {
                        BinarySearchTreeNodes nodeRight = stack.pop();
                        stack.push(node);
                        node = nodeRight;
                    }
                else
                    {
                        System.out.print(node.data + " ");
                        node = null;
                    }
            }
    }
}

public class Postorder_NonRecursive_BST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BinarySearchTreeOperations bst = new BinarySearchTreeOperations();
        System.out.println("Enter the first 10 elements of the tree\n");
        int N = 10;
        for (int i = 0; i < N; i++)
            bst.insert(scan.nextInt());
        System.out.print("\nPost order : ");
        bst.postorder();
        scan.close();
    }
}

/*

Enter the first 10 elements of the tree

12 4 10 13 15 46 78 98 45 12

Post order : 12 10 4 45 98 78 46 15 13 12
