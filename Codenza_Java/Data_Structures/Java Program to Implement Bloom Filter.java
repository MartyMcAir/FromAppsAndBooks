/*This is a Java Program to implement Bloom Filter. A Bloom filter is a space-efficient probabilistic data structure that is used to test whether an element is a member of a set. False positive matches are possible, but false negatives are not; i.e. a query returns either “inside set (may be wrong)” or “definitely not in set”. Elements can be added to the set, but not removed (though this can be addressed with a “counting” filter). The more elements that are added to the set, the larger the probability of false positives.*/

/*
 *    Java Program to Implement Bloom Filter
 */

import java.util.*;
import java.security.*;
import java.math.*;
import java.nio.*;

/* Class BloomFilter */
class BloomFilter
{
    private byte[] set;
    private int keySize, setSize, size;
    private MessageDigest md;

    /* Constructor */
    public BloomFilter(int capacity, int k)
    {
        setSize = capacity;
        set = new byte[setSize];
        keySize = k;
        size = 0;
        try
            {
                md = MessageDigest.getInstance("MD5");
            }
        catch (NoSuchAlgorithmException e)
            {
                throw new IllegalArgumentException("Error : MD5 Hash not found");
            }
    }
    /* Function to clear bloom set */
    public void makeEmpty()
    {
        set = new byte[setSize];
        size = 0;
        try
            {
                md = MessageDigest.getInstance("MD5");
            }
        catch (NoSuchAlgorithmException e)
            {
                throw new IllegalArgumentException("Error : MD5 Hash not found");
            }
    }
    /* Function to check is empty */
    public boolean isEmpty()
    {
        return size == 0;
    }
    /* Function to get size of objects added */
    public int getSize()
    {
        return size;
    }
    /* Function to get hash - MD5 */
    private int getHash(int i)
    {
        md.reset();
        byte[] bytes = ByteBuffer.allocate(4).putInt(i).array();
        md.update(bytes, 0, bytes.length);
        return Math.abs(new BigInteger(1, md.digest()).intValue()) % (set.length - 1);
    }
    /* Function to add an object */
    public void add(Object obj)
    {
        int[] tmpset = getSetArray(obj);
        for (int i : tmpset)
            set[i] = 1;
        size++;
    }
    /* Function to check is an object is present */
    public boolean contains(Object obj)
    {
        int[] tmpset = getSetArray(obj);
        for (int i : tmpset)
            if (set[i] != 1)
                return false;
        return true;
    }
    /* Function to get set array for an object */
    private int[] getSetArray(Object obj)
    {
        int[] tmpset = new int[keySize];
        tmpset[0] = getHash(obj.hashCode());
        for (int i = 1; i < keySize; i++)
            tmpset[i] = (getHash(tmpset[i - 1]));
        return tmpset;
    }
}

/* Class BloomFilterTest */
public class BloomFilterTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bloom Filter Test\n");
        System.out.println("Enter set capacity and key size");
        BloomFilter bf = new BloomFilter(scan.nextInt(), scan.nextInt());
        char ch;
        /*  Perform bloom filter operations  */
        do
            {
                System.out.println("\nBloomFilter Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. contains");
                System.out.println("3. check empty");
                System.out.println("4. clear");
                System.out.println("5. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        bf.add( new Integer(scan.nextInt()) );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Search result : "+ bf.contains( new Integer(scan.nextInt()) ));
                        break;
                    case 3 :
                        System.out.println("Empty status = "+ bf.isEmpty());
                        break;
                    case 4 :
                        System.out.println("\nBloom set Cleared");
                        bf.makeEmpty();
                        break;
                    case 5 :
                        System.out.println("\nSize = "+ bf.getSize() );
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter set capacity and key size
1000 1000

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
1
Enter integer element to insert
57

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
1
Enter integer element to insert
97

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
1
Enter integer element to insert
91

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
1
Enter integer element to insert
23

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
1
Enter integer element to insert
67

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
2
Enter integer element to search
67
Search result : true

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
2
Enter integer element to search
25
Search result : false

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
2
Enter integer element to search
33
Search result : false

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
2
Enter integer element to search
97
Search result : true

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
5

Size = 5

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
4

Bloom set Cleared

Do you want to continue (Type y or n)

y

BloomFilter Operations

1. insert
2. contains
3. check empty
4. clear
5. size
3
Empty status = true

Do you want to continue (Type y or n)

n
