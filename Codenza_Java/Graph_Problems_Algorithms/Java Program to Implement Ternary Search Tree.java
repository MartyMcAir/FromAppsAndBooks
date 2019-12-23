/*This is a Java Program to Implement Ternary Search Tree. A ternary search tree is a type of prefix tree where nodes are arranged as a binary search tree. Like other prefix trees, a ternary search tree can be used as an associative map structure with the ability for incremental string search.*/

/**
 ** Java Program to Implement Ternary Search Tree
 **/

import java.util.Scanner;
import java.util.ArrayList;

/** class TSTNode **/
class TSTNode
{
    char data;
    boolean isEnd;
    TSTNode left, middle, right;

    /** Constructor **/
    public TSTNode(char data)
    {
        this.data = data;
        this.isEnd = false;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}

/** class TernarySearchTree **/
class TernarySearchTree
{
    private TSTNode root;
    private ArrayList<String> al;

    /** Constructor **/
    public TernarySearchTree()
    {
        root = null;
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return root == null;
    }
    /** function to clear **/
    public void makeEmpty()
    {
        root = null;
    }
    /** function to insert for a word **/
    public void insert(String word)
    {
        root = insert(root, word.toCharArray(), 0);
    }
    /** function to insert for a word **/
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

    /** function to delete a word **/
    public void delete(String word)
    {
        delete(root, word.toCharArray(), 0);
    }
    /** function to delete a word **/
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
                /** to delete a word just make isEnd false **/
                if (r.isEnd && ptr == word.length - 1)
                    r.isEnd = false;
                else if (ptr + 1 < word.length)
                    delete(r.middle, word, ptr + 1);
            }
    }

    /** function to search for a word **/
    public boolean search(String word)
    {
        return search(root, word.toCharArray(), 0);
    }
    /** function to search for a word **/
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
    /** function to print tree **/
    public String toString()
    {
        al = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree : "+ al;
    }
    /** function to traverse tree **/
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

/** class TernarySearchTree **/
public class TernarySearchTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of TernarySearchTree */
        TernarySearchTree tst = new TernarySearchTree();
        System.out.println("Ternary Search Tree Test\n");
        char ch;
        /*  Perform tree operations  */
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
                    case 1 :
                        System.out.println("Enter word to insert");
                        tst.insert( scan.next() );
                        break;
                    case 2 :
                        System.out.println("Enter word to search");
                        System.out.println("Search result : "+ tst.search( scan.next() ));
                        break;
                    case 3 :
                        System.out.println("Enter word to delete");
                        tst.delete( scan.next() );
                        break;
                    case 4 :
                        System.out.println("Empty Status : "+ tst.isEmpty() );
                        break;
                    case 5 :
                        System.out.println("Ternary Search Tree cleared");
                        tst.makeEmpty();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                System.out.println(tst);
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

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
apple

Ternary Search Tree : [apple]

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
pine

Ternary Search Tree : [apple, pine]

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
pineapple

Ternary Search Tree : [apple, pine, pineapple]

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
pin

Ternary Search Tree : [apple, pin, pine, pineapple]

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
in

Ternary Search Tree : [apple, in, pin, pine, pineapple]

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
i

Ternary Search Tree : [apple, i, in, pin, pine, pineapple]

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
mango

Ternary Search Tree : [apple, i, in, mango, pin, pine, pineapple]

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
man

Ternary Search Tree : [apple, i, in, man, mango, pin, pine, pineapple]

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
an

Ternary Search Tree : [an, apple, i, in, man, mango, pin, pine, pineapple]

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
a

Ternary Search Tree : [a, an, apple, i, in, man, mango, pin, pine, pineapple]

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
pin
Search result : true

Ternary Search Tree : [a, an, apple, i, in, man, mango, pin, pine, pineapple]

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
pines
Search result : false

Ternary Search Tree : [a, an, apple, i, in, man, mango, pin, pine, pineapple]

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
pine
Search result : true

Ternary Search Tree : [a, an, apple, i, in, man, mango, pin, pine, pineapple]

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
i

Ternary Search Tree : [a, an, apple, in, man, mango, pin, pine, pineapple]

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
i
Search result : false

Ternary Search Tree : [a, an, apple, in, man, mango, pin, pine, pineapple]

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
in

Ternary Search Tree : [a, an, apple, man, mango, pin, pine, pineapple]

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
apple

Ternary Search Tree : [a, an, man, mango, pin, pine, pineapple]

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
pineapple

Ternary Search Tree : [a, an, man, mango, pin, pine]

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
apple
Search result : false

Ternary Search Tree : [a, an, man, mango, pin, pine]

Do you want to continue (Type y or n)

y

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
4
Empty Status : false

Ternary Search Tree : [a, an, man, mango, pin, pine]

Do you want to continue (Type y or n)

y

Ternary Search Tree Operations

1. insert word
2. search word
3. delete word
4. check empty
5. make empty
5
Ternary Search Tree cleared

Ternary Search Tree : []

Do you want to continue (Type y or n)

n
