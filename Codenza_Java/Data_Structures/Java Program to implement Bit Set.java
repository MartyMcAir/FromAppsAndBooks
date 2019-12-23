/*This is a Java Program to implement Bit Set. Bit Set is an array data structure used to implement a simple set data structure.*/

/**
 **  Java Program to implement Bit Set
 **/

import java.util.Scanner;

/** class bit set */
class BitSet
{
    private byte[] bits;
    private int bitSetSize;

    /** constructor **/
    public BitSet(int size)
    {
        bitSetSize = size;
        bits = new byte[1 + size/8];
    }

    /** constructor **/
    public BitSet(BitSet bs)
    {
        bitSetSize = bs.bitSetSize;
        bits = new byte[bs.bits.length];
        System.arraycopy(bs.bits, 0, bits, 0, bs.bits.length);
    }

    /** function to clear all bits **/
    public void clear()
    {
        bits = new byte[bits.length];
    }

    /** function setBit - bit to be set **/
    public void setBit(int n)
    {
        bits[n / 8] |= (1 << (n % 8));
    }

    /** function getBit **/
    public boolean getBit(int n)
    {
        return ((bits[n / 8] & (1 << (n % 8))) != 0);
    }

    /** function clearBit **/
    public void clearBit(int n)
    {
        bits[n / 8] &= ((1 << (n % 8)) ^ ((1 << 8) - 1));
    }

    /** function for or **/
    public void or(BitSet set)
    {
        for (int i = 0; i < bits.length; i++)
            {
                if (i < set.bits.length)
                    bits[i] |= set.bits[i];
                else
                    break;
            }
    }

    /** function for  and **/
    public void and(BitSet set)
    {
        for (int i = 0; i < bits.length; i++)
            {
                if (i < set.bits.length)
                    bits[i] &= set.bits[i];
                else
                    bits[i] = 0;
            }
    }

    /** function to display bitset */
    public void display()
    {
        System.out.print("\nBit Set : ");
        for (int i = 0; i < bitSetSize; i++)
            if (getBit(i))
                System.out.print(i +" ");
        System.out.println();
    }
}

/** Class BitSetTest **/
public class BitSetTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bit Set Test\n");
        System.out.println("Enter max size of Bit Set 1");
        BitSet bs1 = new BitSet(scan.nextInt() );
        char ch;
        /*  Perform bitset operations  */
        do
            {
                System.out.println("\nBit Set Operations\n");
                System.out.println("1. set bit");
                System.out.println("2. get bit");
                System.out.println("3. clear bit");
                System.out.println("4. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to set");
                        bs1.setBit(scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to get status");
                        System.out.println("Bit Status : "+ bs1.getBit(scan.nextInt() ));
                        break;
                    case 3 :
                        System.out.println("Enter integer element to clear");
                        bs1.clearBit(scan.nextInt() );
                        break;
                    case 4 :
                        System.out.println("Bit Set Cleared");
                        bs1.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                bs1.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
        System.out.println("\n\nEnter max size of Bit Set 2");
        BitSet bs2 = new BitSet(scan.nextInt() );
        /*  Perform bitset operations  */
        do
            {
                System.out.println("\nBit Set Operations\n");
                System.out.println("1. set bit");
                System.out.println("2. get bit");
                System.out.println("3. clear bit");
                System.out.println("4. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to set");
                        bs2.setBit(scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to get status");
                        System.out.println("Bit Status : "+ bs2.getBit(scan.nextInt() ));
                        break;
                    case 3 :
                        System.out.println("Enter integer element to clear");
                        bs2.clearBit(scan.nextInt() );
                        break;
                    case 4 :
                        System.out.println("Bit Set Cleared");
                        bs2.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                bs2.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
        BitSet temp = new BitSet(bs1);
        temp.or(bs2);
        System.out.println("\n\nBitSet1 OR BitSet2");
        temp.display();
        temp = new BitSet(bs1);
        temp.and(bs2);
        System.out.println("\nBitSet1 AND BitSet2");
        temp.display();
    }
}

/*
Enter max size of Bit Set 1
50

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
24

Bit Set : 24

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
6

Bit Set : 6 24

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
28

Bit Set : 6 24 28

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
5

Bit Set : 5 6 24 28

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
14

Bit Set : 5 6 14 24 28

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
2
Enter integer element to get status
14
Bit Status : true

Bit Set : 5 6 14 24 28

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
3
Enter integer element to clear
14

Bit Set : 5 6 24 28

Do you want to continue (Type y or n)

n


Enter max size of Bit Set 2
50

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
14

Bit Set : 14

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
7

Bit Set : 7 14

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
1

Bit Set : 1 7 14

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
28

Bit Set : 1 7 14 28

Do you want to continue (Type y or n)

y

Bit Set Operations

1. set bit
2. get bit
3. clear bit
4. clear
1
Enter integer element to set
5

Bit Set : 1 5 7 14 28

Do you want to continue (Type y or n)

n


BitSet1 OR BitSet2

Bit Set : 1 5 6 7 14 24 28

BitSet1 AND BitSet2

Bit Set : 5 28

