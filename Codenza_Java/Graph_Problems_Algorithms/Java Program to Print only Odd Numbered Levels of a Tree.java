/*This is a Java Program to implement a Binary Tree and print the level order traversal of the same, such that only odd levels are considered. At current level check nodes in next to next level and put them in Queue, dequeue them one by one and print them.*/

//This is a java program to print only odd levels of the given tree
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreePrintOddLevels
{
    private static class Node<T>
    {
        public Node<T> left;
        public Node<T> right;
        public T       data;

        public Node(T data)
        {
            this.data = data;
        }

        public Node<T> getLeft()
        {
            return this.left;
        }

        public void setLeft(Node<T> left)
        {
            this.left = left;
        }

        public Node<T> getRight()
        {
            return this.right;
        }

        public void setRight(Node<T> right)
        {
            this.right = right;
        }
    }

    public static void preorder(Node<?> n)
    {
        if (n != null)
            {
                System.out.print(n.data + " ");
                preorder(n.getLeft());
                preorder(n.getRight());
            }
    }

    public static void inorder(Node<?> n)
    {
        if (n != null)
            {
                inorder(n.getLeft());
                System.out.print(n.data + " ");
                inorder(n.getRight());
            }
    }

    public static void postorder(Node<?> n)
    {
        if (n != null)
            {
                postorder(n.getLeft());
                postorder(n.getRight());
                System.out.print(n.data + " ");
            }
    }

    public static void levelorder(Node<?> n)
    {
        Queue<Node<?>> nodequeue = new LinkedList<Node<?>>();
        if (n != null)
            nodequeue.add(n);
        while (!nodequeue.isEmpty())
            {
                Node<?> next = nodequeue.remove();
                System.out.print(next.data + " ");
                if (next.getLeft() != null)
                    {
                        if (next.getLeft().getLeft() != null)
                            nodequeue.add(next.getLeft().getLeft());
                        if (next.getLeft().getRight() != null)
                            nodequeue.add(next.getLeft().getRight());
                    }
                if (next.getRight() != null)
                    {
                        if (next.getRight().getLeft() != null)
                            nodequeue.add(next.getRight().getLeft());
                        if (next.getRight().getRight() != null)
                            nodequeue.add(next.getRight().getRight());
                    }
            }
    }

    public static void main(final String[] args)
    {
        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> two = new Node<Integer>(2);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> five = new Node<Integer>(5);
        Node<Integer> six = new Node<Integer>(6);
        Node<Integer> seven = new Node<Integer>(7);
        Node<Integer> eight = new Node<Integer>(8);
        Node<Integer> nine = new Node<Integer>(9);
        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        four.setLeft(seven);
        six.setLeft(eight);
        six.setRight(nine);
        System.out.println("\nPre-Order of the Tree");
        preorder(one);
        System.out.println("\nIn-Order of the Tree");
        inorder(one);
        System.out.println("\nPost-Order of the Tree");
        postorder(one);
        System.out.println("\nLevel-Order Odd Levels of the Tree");
        levelorder(one);
    }
}

/*

Pre-Order of the Tree
1 2 4 7 5 3 6 8 9
In-Order of the Tree
7 4 2 5 1 8 6 9 3
Post-Order of the Tree
7 4 5 2 8 9 6 3 1
Level-Order Odd Levels of the Tree
1 4 5 6
