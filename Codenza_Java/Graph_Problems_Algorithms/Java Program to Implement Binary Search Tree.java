/*This is a Java Program to implement Binary Search Tree. A binary search tree (BST), sometimes also called an ordered or sorted binary tree, is a node-based binary tree data structure which has the following properties:
i) The left subtree of a node contains only nodes with keys less than the node’s key.
ii) The right subtree of a node contains only nodes with keys greater than the node’s key.
iii) The left and right subtree must each also be a binary search tree.
iv) There must be no duplicate nodes.
Generally, the information represented by each node is a record rather than a single data element. However, for sequencing purposes, nodes are compared according to their keys rather than any part of their associated records. The major advantage of binary search trees over other data structures is that the related sorting algorithms and search algorithms such as in-order traversal can be very efficient. Binary search trees are a fundamental data structure used to construct more abstract data structures such as sets, multisets, and associative arrays.*/

/*
 *  Java Program to Implement Binary Search Tree
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
    /* Function to set left node */
    public void setLeft(BSTNode n)
    {
        left = n;
    }
    /* Function to set right node */
    public void setRight(BSTNode n)
    {
        right = n;
    }
    /* Function to get left node */
    public BSTNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public BSTNode getRight()
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
class BST
{
    private BSTNode root;

    /* Constructor */
    public BST()
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
            System.out.println("Sorry "+ k +" is not present");
        else
            {
                root = delete(root, k);
                System.out.println(k+ " deleted from the tree");
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
                System.out.print(r.getData() +" ");
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
                System.out.print(r.getData() +" ");
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
                System.out.print(r.getData() +" ");
            }
    }
}

/* Class BinarySearchTree */
public class BinarySearchTree
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of BST */
        BST bst = new BST();
        System.out.println("Binary Search Tree Test\n");
        char ch;
        /*  Perform tree operations  */
        do
            {
                System.out.println("\nBinary Search Tree Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. delete");
                System.out.println("3. search");
                System.out.println("4. count nodes");
                System.out.println("5. check empty");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        bst.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to delete");
                        bst.delete( scan.nextInt() );
                        break;
                    case 3 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Search result : "+ bst.search( scan.nextInt() ));
                        break;
                    case 4 :
                        System.out.println("Nodes = "+ bst.countNodes());
                        break;
                    case 5 :
                        System.out.println("Empty status = "+ bst.isEmpty());
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
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
    }
}

/*
Binary Search Tree Test


Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
5
Empty status = true

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
1
Enter integer element to insert
8

Post order : 8
Pre order : 8
In order : 8
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
1
Enter integer element to insert
5

Post order : 5 8
Pre order : 8 5
In order : 5 8
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
1
Enter integer element to insert
3

Post order : 3 5 8
Pre order : 8 5 3
In order : 3 5 8
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
1
Enter integer element to insert
7

Post order : 3 7 5 8
Pre order : 8 5 3 7
In order : 3 5 7 8
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
1
Enter integer element to insert
10

Post order : 3 7 5 10 8
Pre order : 8 5 3 7 10
In order : 3 5 7 8 10
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
1
Enter integer element to insert
15

Post order : 3 7 5 15 10 8
Pre order : 8 5 3 7 10 15
In order : 3 5 7 8 10 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
1
Enter integer element to insert
2

Post order : 2 3 7 5 15 10 8
Pre order : 8 5 3 2 7 10 15
In order : 2 3 5 7 8 10 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
4
Nodes = 7

Post order : 2 3 7 5 15 10 8
Pre order : 8 5 3 2 7 10 15
In order : 2 3 5 7 8 10 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
3
Enter integer element to search
24
Search result : false

Post order : 2 3 7 5 15 10 8
Pre order : 8 5 3 2 7 10 15
In order : 2 3 5 7 8 10 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
3
Enter integer element to search
7
Search result : true

Post order : 2 3 7 5 15 10 8
Pre order : 8 5 3 2 7 10 15
In order : 2 3 5 7 8 10 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
2
Enter integer element to delete
2
2 deleted from the tree

Post order : 3 7 5 15 10 8
Pre order : 8 5 3 7 10 15
In order : 3 5 7 8 10 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
2
Enter integer element to delete
8
8 deleted from the tree

Post order : 3 7 5 15 10
Pre order : 10 5 3 7 15
In order : 3 5 7 10 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
2
Enter integer element to delete
10
10 deleted from the tree

Post order : 3 7 5 15
Pre order : 15 5 3 7
In order : 3 5 7 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
2
Enter integer element to delete
5
5 deleted from the tree

Post order : 3 7 15
Pre order : 15 7 3
In order : 3 7 15
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
2
Enter integer element to delete
15
15 deleted from the tree

Post order : 3 7
Pre order : 7 3
In order : 3 7
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
2
Enter integer element to delete
3
3 deleted from the tree

Post order : 7
Pre order : 7
In order : 7
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
2
Enter integer element to delete
77
Sorry 77 is not present

Post order : 7
Pre order : 7
In order : 7
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
2
Enter integer element to delete
7
7 deleted from the tree

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

y

Binary Search Tree Operations

1. insert
2. delete
3. search
4. count nodes
5. check empty
5
Empty status = true

Post order :
Pre order :
In order :
Do you want to continue (Type y or n)

n
