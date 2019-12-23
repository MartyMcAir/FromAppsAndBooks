/*This is a Java Program to implement Hash Trie. A trie is an ordered tree data structure that is used to store a dynamic set or associative array where the keys are usually strings. Unlike a binary search tree, no node in the tree stores the key associated with that node, instead, its position in the tree defines the key with which it is associated. All the descendants of a node have a common prefix of the string associated with that node, and the root is associated with the empty string. Values are normally not associated with every node, only with leaves and some inner nodes that correspond to keys of interest.*/

/**
 *   Java Program to Implement Hash Trie
 **/

import java.io.*;
import java.util.*;

class HashTrie
{
    private HashMap<Character, HashMap> root;

    /** Constructor **/
    public HashTrie()
    {
        root = new HashMap<Character, HashMap>();
    }
    /** Parameterised Constructor **/
    public HashTrie(String[] arr)
    {
        root = new HashMap<Character, HashMap>();
        for (String s: arr)
            add(s);
    }

    /** Function to add a string to hash trie **/
    public void add(String str)
    {
        HashMap<Character, HashMap> node = root;
        for (int i = 0; i < str.length(); i++)
            {
                if (node.containsKey(str.charAt(i)))
                    node = node.get(str.charAt(i));
                else
                    {
                        node.put(str.charAt(i), new HashMap<Character, HashMap>());
                        node = node.get(str.charAt(i));
                    }
            }
        /** end of string **/
        node.put('\0', new HashMap<Character, HashMap>(0));
    }

    /** Function to check if hash trie contains a given word **/
    public boolean contains(String str)
    {
        HashMap<Character, HashMap> currentNode = root;
        for (int i = 0; i < str.length(); i++)
            {
                if (currentNode.containsKey(str.charAt(i)))
                    currentNode = currentNode.get(str.charAt(i));
                else
                    return false;
            }
        return currentNode.containsKey('\0') ? true : false;
    }
}

/** Class HashTrieTest **/
public class HashTrieTest
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /** Accept words **/
        System.out.println("Trie Test\n");
        System.out.println ("Enter words to be entered into trie");
        String input = br.readLine();
        String[] s = input.split(" ");
        /** Create Trie with accepted words **/
        HashTrie t = new HashTrie(s);
        /** Trie Test **/
        char ch = 'n';
        do
            {
                System.out.println("\nEnter word to search ");
                String key = br.readLine();
                System.out.println("Search status : "+ t.contains(key));
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = br.readLine().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}
/*
Enter words to be entered into trie
trie tree test branch leaf root fruit key lock hash

Enter word to search
trie
Search status : true

Do you want to continue (Type y or n)

y

Enter word to search
tree
Search status : true

Do you want to continue (Type y or n)

y

Enter word to search
trench
Search status : false

Do you want to continue (Type y or n)

y

Enter word to search
triee
Search status : false

Do you want to continue (Type y or n)

y

Enter word to search
trei
Search status : false

Do you want to continue (Type y or n)

y

Enter word to search
branch
Search status : true

Do you want to continue (Type y or n)

n
