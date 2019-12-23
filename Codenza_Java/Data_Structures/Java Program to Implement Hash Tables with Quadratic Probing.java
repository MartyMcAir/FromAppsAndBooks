/*This is a Java Program to implement hash tables with Quadratic Probing. A hash table (also hash map) is a data structure used to implement an associative array, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the correct value can be found. Quadratic probing is a probe sequence in which the interval between probes is increased by adding the successive outputs of a quadratic polynomial to the starting value given by the original hash computation.*/

/**
 *   Java Program to implement Quadratic Probing Hash Table
 **/

import java.util.Scanner;

/** Class QuadraticProbingHashTable **/
class QuadraticProbingHashTable
{
    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;

    /** Constructor **/
    public QuadraticProbingHashTable(int capacity)
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
        int i = tmp, h = 1;
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
                i = (i + h * h++) % maxSize;
            }
        while (i != tmp);
    }

    /** Function to get value for a given key **/
    public String get(String key)
    {
        int i = hash(key), h = 1;
        while (keys[i] != null)
            {
                if (keys[i].equals(key))
                    return vals[i];
                i = (i + h * h++) % maxSize;
                System.out.println("i "+ i);
            }
        return null;
    }

    /** Function to remove key and its value **/
    public void remove(String key)
    {
        if (!contains(key))
            return;
        /** find position key and delete **/
        int i = hash(key), h = 1;
        while (!key.equals(keys[i]))
            i = (i + h * h++) % maxSize;
        keys[i] = vals[i] = null;
        /** rehash all keys **/
        for (i = (i + h * h++) % maxSize; keys[i] != null; i = (i + h * h++) % maxSize)
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

/** Class QuadraticProbingHashTableTest **/
public class QuadraticProbingHashTableTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        /** maxSizeake object of QuadraticProbingHashTable **/
        QuadraticProbingHashTable qpht = new QuadraticProbingHashTable(scan.nextInt() );
        char ch;
        /**  Perform QuadraticProbingHashTable operations  **/
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
                        qpht.insert(scan.next(), scan.next() );
                        break;
                    case 2 :
                        System.out.println("Enter key");
                        qpht.remove( scan.next() );
                        break;
                    case 3 :
                        System.out.println("Enter key");
                        System.out.println("Value = "+ qpht.get( scan.next() ));
                        break;
                    case 4 :
                        qpht.makeEmpty();
                        System.out.println("Hash Table Cleared\n");
                        break;
                    case 5 :
                        System.out.println("Size = "+ qpht.getSize() );
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** Display hash table **/
                qpht.printHashTable();
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
N nitrogen y 1 O oxygen y 1 C carbon y 1 Cl chlorine y 1 Zn zinc

Hash Table:
N nitrogen


Do you want to continue (Type y or n)


Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
Enter key and value

Hash Table:
N nitrogen
O oxygen


Do you want to continue (Type y or n)


Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
Enter key and value

Hash Table:
C carbon
N nitrogen
O oxygen


Do you want to continue (Type y or n)


Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
Enter key and value

Hash Table:
Cl chlorine
C carbon
N nitrogen
O oxygen


Do you want to continue (Type y or n)


Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
Enter key and value

Hash Table:
Cl chlorine
Zn zinc
C carbon
N nitrogen
O oxygen


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
Zn
i 1

Hash Table:
Cl chlorine
C carbon
N nitrogen
O oxygen


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
Cl
chloro

Hash Table:
Cl chloro
C carbon
N nitrogen
O oxygen


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
Cl

Hash Table:
C carbon
N nitrogen
O oxygen


Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
5
Size = 3

Hash Table:
C carbon
N nitrogen
O oxygen


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
