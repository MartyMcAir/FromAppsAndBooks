/*This is a Java Program to implement hash tables with Linear Probing. A hash table (also hash map) is a data structure used to implement an associative array, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the correct value can be found. Linear probing is a probe sequence in which the interval between probes is fixed (usually 1).*/

/**
 *   Java Program to implement Linear Probing Hash Table
 **/

import java.util.Scanner;


/** Class LinearProbingHashTable **/
class LinearProbingHashTable
{
    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;

    /** Constructor **/
    public LinearProbingHashTable(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    /** Function to clear hash table **/
    public void makeEmpty()
    {
        currentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    /** Function to get size of hash table **/
    public int getSize()
    {
        return currentSize;
    }

    /** Function to check if hash table is full **/
    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    /** Function to check if hash table is empty **/
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    /** Fucntion to check if hash table contains a key **/
    public boolean contains(String key)
    {
        return get(key) !=  null;
    }

    /** Functiont to get hash code of a given key **/
    private int hash(String key)
    {
        return key.hashCode() % maxSize;
    }

    /** Function to insert key-value pair **/
    public void insert(String key, String val)
    {
        int tmp = hash(key);
        int i = tmp;
        do
            {
                if (keys[i] == null)
                    {
                        keys[i] = key;
                        vals[i] = val;
                        currentSize++;
                        return;
                    }
                if (keys[i].equals(key))
                    {
                        vals[i] = val;
                        return;
                    }
                i = (i + 1) % maxSize;
            }
        while (i != tmp);
    }

    /** Function to get value for a given key **/
    public String get(String key)
    {
        int i = hash(key);
        while (keys[i] != null)
            {
                if (keys[i].equals(key))
                    return vals[i];
                i = (i + 1) % maxSize;
            }
        return null;
    }

    /** Function to remove key and its value **/
    public void remove(String key)
    {
        if (!contains(key))
            return;
        /** find position key and delete **/
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % maxSize;
        keys[i] = vals[i] = null;
        /** rehash all keys **/
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize)
            {
                String tmp1 = keys[i], tmp2 = vals[i];
                keys[i] = vals[i] = null;
                currentSize--;
                insert(tmp1, tmp2);
            }
        currentSize--;
    }

    /** Function to print HashTable **/
    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] +" "+ vals[i]);
        System.out.println();
    }
}

/** Class LinearProbingHashTableTest **/
public class LinearProbingHashTableTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        /** maxSizeake object of LinearProbingHashTable **/
        LinearProbingHashTable lpht = new LinearProbingHashTable(scan.nextInt() );
        char ch;
        /**  Perform LinearProbingHashTable operations  **/
        do
            {
                System.out.println("\nHash Table Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. remove");
                System.out.println("3. get");
                System.out.println("4. clear");
                System.out.println("5. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter key and value");
                        lpht.insert(scan.next(), scan.next() );
                        break;
                    case 2 :
                        System.out.println("Enter key");
                        lpht.remove( scan.next() );
                        break;
                    case 3 :
                        System.out.println("Enter key");
                        System.out.println("Value = "+ lpht.get( scan.next() ));
                        break;
                    case 4 :
                        lpht.makeEmpty();
                        System.out.println("Hash Table Cleared\n");
                        break;
                    case 5 :
                        System.out.println("Size = "+ lpht.getSize() );
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** Display hash table **/
                lpht.printHashTable();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter size
5

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
1
Enter key and value
Na sodium

Hash Table:
Na sodium


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
1
Enter key and value
K potassium

Hash Table:
Na sodium
K potassium


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
1
Enter key and value
Fe iron

Hash Table:
Na sodium
K potassium
Fe iron


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
1
Enter key and value
H hydrogen

Hash Table:
Na sodium
K potassium
Fe iron
H hydrogen


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
1
Enter key and value
He helium

Hash Table:
Na sodium
K potassium
Fe iron
H hydrogen
He helium


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
1
Enter key and value
Ag silver

Hash Table:
Na sodium
K potassium
Fe iron
H hydrogen
He helium


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
3
Enter key
Fe
Value = iron

Hash Table:
Na sodium
K potassium
Fe iron
H hydrogen
He helium


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
2
Enter key
H

Hash Table:
Na sodium
K potassium
Fe iron
He helium


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
3
Enter key
H
Value = null

Hash Table:
Na sodium
K potassium
Fe iron
He helium


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
1
Enter key and value
Au gold

Hash Table:
Na sodium
K potassium
Fe iron
He helium
Au gold


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
5
Size = 5

Hash Table:
Na sodium
K potassium
Fe iron
He helium
Au gold


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
4
Hash Table Cleared


Hash Table:


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
5
Size = 0

Hash Table:


Do you want to continue (Type y or n)

n
