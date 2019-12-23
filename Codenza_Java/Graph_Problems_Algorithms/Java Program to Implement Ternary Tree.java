/*This Java program is to Implement ternary tree. In computer science, a ternary tree is a tree data structure in which each node has at most three child nodes, usually distinguished as “left”, “mid” and “right”. Nodes with children are parent nodes, and child nodes may contain references to their parents. Outside the tree, there is often a reference to the “root” node (the ancestor of all nodes), if it exists. Any node in the data structure can be reached by starting at root node and repeatedly following references to either the left, mid or right child.*/

//This is a java program to implement Ternary Tree
import java.util.Scanner;
import java.util.ArrayList;

class TSTNode
{
    char    data;
    boolean isEnd;
    TSTNode left, middle, right;

    public TSTNode(char data)
    {
        this.data = data;
        this.isEnd = false;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}

class TernarySearchTree
{
    private TSTNode           root;
    private ArrayList<String> al;

    public TernarySearchTree()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void makeEmpty()
    {
        root = null;
    }

    public void insert(String word)
    {
        root = insert(root, word.toCharArray(), 0);
    }

    public TSTNode insert(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            r = new TSTNode(word[ptr]);
        if (word[ptr] < r.data)
            r.left = insert(r.left, word, ptr);
        else if (word[ptr] > r.data)
            r.right = insert(r.right, word, ptr);
        else
            {
                if (ptr + 1 < word.length)
                    r.middle = insert(r.middle, word, ptr + 1);
                else
                    r.isEnd = true;
            }
        return r;
    }

    public void delete(String word)
    {
        delete(root, word.toCharArray(), 0);
    }

    private void delete(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return;
        if (word[ptr] < r.data)
            delete(r.left, word, ptr);
        else if (word[ptr] > r.data)
            delete(r.right, word, ptr);
        else
            {
                if (r.isEnd && ptr == word.length - 1)
                    r.isEnd = false;
                else if (ptr + 1 < word.length)
                    delete(r.middle, word, ptr + 1);
            }
    }

    public boolean search(String word)
    {
        return search(root, word.toCharArray(), 0);
    }

    private boolean search(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return false;
        if (word[ptr] < r.data)
            return search(r.left, word, ptr);
        else if (word[ptr] > r.data)
            return search(r.right, word, ptr);
        else
            {
                if (r.isEnd && ptr == word.length - 1)
                    return true;
                else if (ptr == word.length - 1)
                    return false;
                else
                    return search(r.middle, word, ptr + 1);
            }
    }

    public String toString()
    {
        al = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree : " + al;
    }

    private void traverse(TSTNode r, String str)
    {
        if (r != null)
            {
                traverse(r.left, str);
                str = str + r.data;
                if (r.isEnd)
                    al.add(str);
                traverse(r.middle, str);
                str = str.substring(0, str.length() - 1);
                traverse(r.right, str);
            }
    }
}

public class TernaryTree
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        TernarySearchTree tst = new TernarySearchTree();
        System.out.println("Ternary Search Tree Test\n");
        char ch;
        do
            {
                System.out.println("\nTernary Search Tree Operations\n");
                System.out.println("1. insert word");
                System.out.println("2. search word");
                System.out.println("3. delete word");
                System.out.println("4. check empty");
                System.out.println("5. make empty");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1:
                        System.out.println("Enter word to insert");
                        tst.insert(scan.next());
                        break;
                    case 2:
                        System.out.println("Enter word to search");
                        System.out.println("Search result : "
                                           + tst.search(scan.next()));
                        break;
                    case 3:
                        System.out.println("Enter word to delete");
                        tst.delete(scan.next());
                        break;
                    case 4:
                        System.out.println("Empty Status : " + tst.isEmpty());
                        break;
                    case 5:
                        System.out.println("Ternary Search Tree cleared");
                        tst.makeEmpty();
                        break;
                    default:
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                System.out.println(tst);
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y' || ch == 'y');
        scan.close();
    }
}

/*
Ternary Tree Test

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
4
Empty Status : true

Ternary Search Tree : []

Do you want to continue (Type y or n)

y

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
1
Enter word to insert
Sanfoundry

Ternary Search Tree : [Sanfoundry]

Do you want to continue (Type y or n)

 y

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
1
Enter word to insert
Technology

Ternary Search Tree : [Sanfoundry, Technology]

Do you want to continue (Type y or n)

y

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
1
Enter word to insert
Solutions

Ternary Search Tree : [Sanfoundry, Solutions, Technology]

Do you want to continue (Type y or n)

y

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
3
Enter word to delete
Solutions

Ternary Search Tree : [Sanfoundry, Technology]

Do you want to continue (Type y or n)

y

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
1
Enter word to insert
Blog

Ternary Search Tree : [Blog, Sanfoundry, Technology]

Do you want to continue (Type y or n)

y

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
2
Enter word to search
Sanfoundry
Search result : true

Ternary Search Tree : [Blog, Sanfoundry, Technology]

Do you want to continue (Type y or n)

n
