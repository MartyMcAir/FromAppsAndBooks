//This is a java program to delete elements from Binary Search Tree
import java.util.Random;
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

    public boolean search(int val)
    {
        return search(root, val);
    }

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

public class Deletion_BST
{
    public static void main(String[] args)
    {
        BSTree bst = new BSTree();
        System.out.println("Binary Search Tree Deletion Test\n");
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = 15;
        for (int i = 0; i < n; i++)
            bst.insert(Math.abs(random.nextInt(100)));
        char ch;
        do
            {
                System.out.print("\nPost order : ");
                bst.postorder();
                System.out.print("\nPre order  : ");
                bst.preorder();
                System.out.print("\nIn order   : ");
                bst.inorder();
                System.out.println("Enter integer element to delete");
                bst.delete(sc.nextInt());
                System.out.println("Continue deleting? <y>/<n>");
                ch = sc.next().charAt(0);
            }
        while (ch == 'y' || ch == 'Y');
        sc.close();
    }
}

/*
Binary Search Tree Deletion Test


Post order : 17 11 22 26 24 41 46 52 54 42 86 85 74 72 23
Pre order  : 23 22 11 17 72 42 41 24 26 54 52 46 74 85 86
In order   : 11 17 22 23 24 26 41 42 46 52 54 72 74 85 86
Enter integer element to delete
17
17 deleted from the tree
Continue deleting? <y>/<n>
y

Post order : 11 22 26 24 41 46 52 54 42 86 85 74 72 23
Pre order  : 23 22 11 72 42 41 24 26 54 52 46 74 85 86
In order   : 11 22 23 24 26 41 42 46 52 54 72 74 85 86
Enter integer element to delete
23
23 deleted from the tree
Continue deleting? <y>/<n>
y

Post order : 11 22 26 24 41 46 52 54 42 86 85 74 72
Pre order  : 72 42 41 24 22 11 26 54 52 46 74 85 86
In order   : 11 22 24 26 41 42 46 52 54 72 74 85 86
Enter integer element to delete
11
11 deleted from the tree
Continue deleting? <y>/<n>
n
