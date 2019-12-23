/*This is a Java Program to implement hash tables with Double Hashing. A hash table (also hash map) is a data structure used to implement an associative array, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the correct value can be found. Double Hashing is a probe sequence in which the interval between probes is computed by another hash function.*/

/*
 * Java program to implement hash table with double hashing
 */
import java.util.Scanner;
import java.math.*;

/* Class LinkedHashEntry */
class HashEntry
{
    String key;
    int value;

    /* Constructor */
    HashEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

/* Class HashTable */
class HashTable
{
    private int TABLE_SIZE;
    private int size;
    private HashEntry[] table;
    private int primeSize;

    /* Constructor */
    public HashTable(int ts)
    {
        size = 0;
        TABLE_SIZE = ts;
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
        primeSize = getPrime();
    }
    /* Function to get prime number less than table size for myhash2 function */
    public int getPrime()
    {
        for (int i = TABLE_SIZE - 1; i >= 1; i--)
            {
                int fact = 0;
                for (int j = 2; j <= (int) Math.sqrt(i); j++)
                    if (i % j == 0)
                        fact++;
                if (fact == 0)
                    return i;
            }
        /* Return a prime number */
        return 3;
    }
    /* Function to get number of key-value pairs */
    public int getSize()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    /* Function to clear hash table */
    public void makeEmpty()
    {
        size = 0;
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    /* Function to get value of a key */
    public int get(String key)
    {
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );
        while (table[hash1] != null && !table[hash1].key.equals(key))
            {
                hash1 += hash2;
                hash1 %= TABLE_SIZE;
            }
        return table[hash1].value;
    }
    /* Function to insert a key value pair */
    public void insert(String key, int value)
    {
        if (size == TABLE_SIZE)
            {
                System.out.println("Table full");
                return;
            }
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );
        while (table[hash1] != null)
            {
                hash1 += hash2;
                hash1 %= TABLE_SIZE;
            }
        table[hash1] = new HashEntry(key, value);
        size++;
    }
    /* Function to remove a key */
    public void remove(String key)
    {
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );
        while (table[hash1] != null && !table[hash1].key.equals(key))
            {
                hash1 += hash2;
                hash1 %= TABLE_SIZE;
            }
        table[hash1] = null;
        size--;
    }
    /* Function myhash which gives a hash value for a given string */
    private int myhash1(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return hashVal;
    }
    /* Function myhash function for double hashing */
    private int myhash2(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return primeSize - hashVal % primeSize;
    }
    /* Function to print hash table */
    public void printHashTable()
    {
        System.out.println("\nHash Table");
        for (int i = 0; i < TABLE_SIZE; i++)
            if (table[i] != null)
                System.out.println(table[i].key +" "+table[i].value);
    }
}

/* Class DoubleHashingHashTableTest */
public class DoubleHashingHashTableTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        /* Make object of HashTable */
        HashTable ht = new HashTable(scan.nextInt() );
        char ch;
        /*  Perform HashTable operations  */
        do
            {
                System.out.println("\nHash Table Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. remove");
                System.out.println("3. get");
                System.out.println("4. check empty");
                System.out.println("5. clear");
                System.out.println("6. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter key and value");
                        ht.insert(scan.next(), scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter key");
                        ht.remove( scan.next() );
                        break;
                    case 3 :
                        System.out.println("Enter key");
                        System.out.println("Value = "+ ht.get( scan.next() ));
                        break;
                    case 4 :
                        System.out.println("Empty Status " +ht.isEmpty());
                        break;
                    case 5 :
                        ht.makeEmpty();
                        System.out.println("Hash Table Cleared\n");
                        break;
                    case 6 :
                        System.out.println("Size = "+ ht.getSize() );
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* Display hash table */
                ht.printHashTable();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter size
100

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
1
Enter key and value
prime 97

Hash Table
prime 97

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
1
Enter key and value
even 24

Hash Table
prime 97
even 24

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
1
Enter key and value
odd 63

Hash Table
prime 97
even 24
odd 63

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
1
Enter key and value
composite 6

Hash Table
prime 97
even 24
odd 63
composite 6

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
1
Enter key and value
armstrong 153

Hash Table
prime 97
even 24
odd 63
armstrong 153
composite 6

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
3
Enter key
prime
Value = 97

Hash Table
prime 97
even 24
odd 63
armstrong 153
composite 6

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
3
Enter key
even
Value = 24

Hash Table
prime 97
even 24
odd 63
armstrong 153
composite 6

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
2
Enter key
composite

Hash Table
prime 97
even 24
odd 63
armstrong 153

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
6
Size = 4

Hash Table
prime 97
even 24
odd 63
armstrong 153

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
5
Hash Table Cleared


Hash Table

Do you want to continue (Type y or n)

y

Hash Table Operations

1. insert
2. remove
3. get
4. check empty
5. clear
6. size
4
Empty Status true

Hash Table

Do you want to continue (Type y or n)

n
