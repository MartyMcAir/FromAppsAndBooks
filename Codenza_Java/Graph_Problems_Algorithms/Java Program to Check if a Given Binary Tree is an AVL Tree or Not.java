/*This is a Java Program to implement a binary tree and check whether it is AVL Tree or not. An AVL tree is a self-balancing binary search tree. It was the first such data structure to be invented. In an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more than one, rebalancing is done to restore this property. Lookup, insertion, and deletion all take O(log n) time in both the average and worst cases, where n is the number of nodes in the tree prior to the operation. Insertions and deletions may require the tree to be rebalanced by one or more tree rotations.
A tree is AVL if and only if it is Binary Search Tree and is Balanced.*/

//This is a java program to check whether a tree is AVL tree or not
class BSTAVLTreeNode
{
    int            value;
    BSTAVLTreeNode Left;
    BSTAVLTreeNode Right;

    BSTAVLTreeNode(int k)
    {
        value = k;
    }
}

class BST_AVL
{
    public static boolean isBST(BSTAVLTreeNode node)
    {
        return (isBSTUtil(node, 0, 100));
    }

    public static boolean isBSTUtil(BSTAVLTreeNode node, int min, int max)
    {
        if (node == null)
            return true;
        if (node.value < min || node.value > max)
            return false;
        return (isBSTUtil(node.Left, min, node.value - 1) && isBSTUtil(
                    node.Right, node.value + 1, max));
    }

    public static boolean isBalanced(BSTAVLTreeNode root)
    {
        int lh; /* for height of left subtree */
        int rh; /* for height of right subtree */
        if (root == null)
            return true;
        lh = height(root.Left);
        rh = height(root.Right);
        if (Math.abs(lh - rh) <= 1 && isBalanced(root.Left)
                && isBalanced(root.Right))
            return true;
        return false;
    }

    public static int max(int a, int b)
    {
        return (a >= b) ? a : b;
    }

    public static int height(BSTAVLTreeNode node)
    {
        if (node == null)
            return 0;
        return 1 + max(height(node.Left), height(node.Right));
    }

    public static void main(String args[])
    {
        BSTAVLTreeNode t1 = new BSTAVLTreeNode(1);
        t1.Left = new BSTAVLTreeNode(2);
        t1.Right = new BSTAVLTreeNode(3);
        t1.Right.Left = new BSTAVLTreeNode(4);
        t1.Right.Right = new BSTAVLTreeNode(5);
        BSTAVLTreeNode t2 = new BSTAVLTreeNode(15);
        t2.Left = new BSTAVLTreeNode(5);
        t2.Right = new BSTAVLTreeNode(20);
        t2.Right.Left = new BSTAVLTreeNode(18);
        t2.Right.Right = new BSTAVLTreeNode(23);
        t2.Left.Left = new BSTAVLTreeNode(4);
        t2.Left.Right = new BSTAVLTreeNode(6);
        if (isBST(t1) && isBalanced(t1))
            System.out.println("Tree t1 is AVL tree");
        else
            System.out.println("Tree t1 is not AVL tree");
        if (isBST(t2) && isBalanced(t2))
            System.out.println("Tree t1 is AVL tree");
        else
            System.out.println("Tree t1 is not AVL tree");
    }
}

/*
Tree t1 is not AVL tree
Tree t1 is AVL tree
