/*This is a Java Program to implement hash tables chaining with List Heads. A hash table (also hash map) is a data structure used to implement an associative array, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the correct value can be found. Some chaining implementations store the first record of each chain in the slot array itself. The number of pointer traversals is decreased by one for most cases. The purpose is to increase cache efficiency of hash table access.
The disadvantage is that an empty bucket takes the same space as a bucket with one entry. To save memory space, such hash tables often have about as many slots as stored entries, meaning that many slots have two or more entries.*/

/*
 *    Java Program to Implement Hash Tables Chaining with List Heads
 */
import java.util.Scanner;

/* Class LinkedHashEntry */
class LinkedHashEntry
{
    String key;
    int value;
    LinkedHashEntry next;

    /* Constructor */
    LinkedHashEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

/* Class HashTable */
class HashTable
{
    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table;

    /* Constructor */
    public HashTable(int ts)
    {
        size = 0;
        TABLE_SIZE = ts;
        table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    /* Function to get number of key-value pairs */
    public int getSize()
    {
        return size;
    }
    /* Function to clear hash table */
    public void makeEmpty()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    /* Function to get value of a key */
    public int get(String key)
    {
        int hash = (myhash( key ) % TABLE_SIZE);
        if (table[hash] == null)
            return -1;
        else
            {
                LinkedHashEntry entry = table[hash];
                while (entry != null && !entry.key.equals(key))
                    entry = entry.next;
                if (entry == null)
                    return -1;
                else
                    return entry.value;
            }
    }
    /* Function to insert a key value pair */
    public void insert(String key, int value)
    {
        int hash = (myhash( key ) % TABLE_SIZE);
        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(key, value);
        else
            {
                LinkedHashEntry entry = table[hash];
                while (entry.next != null && !entry.key.equals(key))
                    entry = entry.next;
                if (entry.key.equals(key))
                    entry.value = value;
                else
                    entry.next = new LinkedHashEntry(key, value);
            }
        size++;
    }

    public void remove(String key)
    {
        int hash = (myhash( key ) % TABLE_SIZE);
        if (table[hash] != null)
            {
                LinkedHashEntry prevEntry = null;
                LinkedHashEntry entry = table[hash];
                while (entry.next != null && !entry.key.equals(key))
                    {
                        prevEntry = entry;
                        entry = entry.next;
                    }
                if (entry.key.equals(key))
                    {
                        if (prevEntry == null)
                            table[hash] = entry.next;
                        else
                            prevEntry.next = entry.next;
                        size--;
                    }
            }
    }
    /* Function myhash which gives a hash value for a given string */
    private int myhash(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return hashVal;
    }
    /* Function to print hash table */
    public void printHashTable()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
            {
                System.out.print("\nBucket "+ (i + 1) +" : ");
                LinkedHashEntry entry = table[i];
                while (entry != null)
                    {
                        System.out.print(entry.value +" ");
                        entry = entry.next;
                    }
            }
    }
}

/* Class HashTablesChainingListHeadsTest */
public class HashTablesChainingListHeadsTest
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
                System.out.println("4. clear");
                System.out.println("5. size");
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
                        ht.makeEmpty();
                        System.out.println("Hash Table Cleared\n");
                        break;
                    case 5 :
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
5

Hash Table Operations

1. insert
2. remove
3. get
4. clear
5. size
1
Enter key and value
water 100

Bucket 1 :
Bucket 2 :
Bucket 3 : 100
Bucket 4 :
Bucket 5 :
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
apple 5

Bucket 1 : 5
Bucket 2 :
Bucket 3 : 100
Bucket 4 :
Bucket 5 :
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
mango 24

Bucket 1 : 5 24
Bucket 2 :
Bucket 3 : 100
Bucket 4 :
Bucket 5 :
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
guava 13

Bucket 1 : 5 24
Bucket 2 :
Bucket 3 : 100 13
Bucket 4 :
Bucket 5 :
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
pineapple 17

Bucket 1 : 5 24
Bucket 2 : 17
Bucket 3 : 100 13
Bucket 4 :
Bucket 5 :
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
strawberry 37

Bucket 1 : 5 24
Bucket 2 : 17
Bucket 3 : 100 13
Bucket 4 : 37
Bucket 5 :
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
apple
Value = 5

Bucket 1 : 5 24
Bucket 2 : 17
Bucket 3 : 100 13
Bucket 4 : 37
Bucket 5 :
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
mango
Value = 24

Bucket 1 : 5 24
Bucket 2 : 17
Bucket 3 : 100 13
Bucket 4 : 37
Bucket 5 :
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
guava

Bucket 1 : 5 24
Bucket 2 : 17
Bucket 3 : 100
Bucket 4 : 37
Bucket 5 :
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

Bucket 1 : 5 24
Bucket 2 : 17
Bucket 3 : 100
Bucket 4 : 37
Bucket 5 :
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


Bucket 1 :
Bucket 2 :
Bucket 3 :
Bucket 4 :
Bucket 5 :
Do you want to continue (Type y or n)

n
