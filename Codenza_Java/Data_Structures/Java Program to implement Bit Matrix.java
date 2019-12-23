/**
 ** Java Program to implement Bit MatrixThis is a Java Program to implement Bit Matrix. Here bit matrix is implemented as an array of bit sets.
 **/

import java.util.Scanner;
import java.util.BitSet;

/** class bit Matrix */
class BitMatrix
{
    private BitSet[] bitArr;

    /** constructor **/
    public BitMatrix(int rows, int cols)
    {
        bitArr = new BitSet[rows];
        for (int i = 0; i < rows; i++)
            bitArr[i] = new BitSet(cols);
    }
    /** function to clear **/
    public void clear()
    {
        int rows = bitArr.length;
        int cols = bitArr[0].size();
        bitArr = new BitSet[rows];
        for (int i = 0; i < rows; i++)
            bitArr[i] = new BitSet(cols);
    }
    /** function to clear a particular row **/
    public void clear(int r)
    {
        bitArr[r].clear();
    }
    /** function to clear a particular bit **/
    public void clear(int r, int c)
    {
        bitArr[r].clear(c);
    }
    /** function to get a particular bit **/
    public boolean get(int r, int c)
    {
        return bitArr[r].get(c);
    }
    /** function to set a particular bit **/
    public void set(int r, int c)
    {
        bitArr[r].set(c);
    }
    /** function to OR two rows **/
    public void or(int r1, int r2)
    {
        bitArr[r1].or(bitArr[r2]);
    }
    /** function to And two rows **/
    public void and(int r1, int r2)
    {
        bitArr[r1].and(bitArr[r2]);
    }
    /** function to XOR two rows **/
    public void xor(int r1, int r2)
    {
        bitArr[r1].xor(bitArr[r2]);
    }
    /** function to display bitset */
    public void display()
    {
        System.out.println("\nBit Matrix : ");
        for (BitSet bs : bitArr)
            System.out.println(bs);
        System.out.println();
    }
}

/** BitMatrixTest **/
public class BitMatrixTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bit Matrix Test\n");
        System.out.println("Enter row and column dimensions");
        BitMatrix bm = new BitMatrix(scan.nextInt(), scan.nextInt() );
        char ch;
        /*  Perform Bit Matrix operations */
        do
            {
                System.out.println("\nBit Matrix Operations\n");
                System.out.println("1. or ");
                System.out.println("2. and");
                System.out.println("3. xor");
                System.out.println("4. clear");
                System.out.println("5. set");
                System.out.println("6. get");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter row1 and row2 to OR");
                        bm.or(scan.nextInt(), scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter row1 and row2 to AND");
                        bm.and(scan.nextInt(), scan.nextInt() );
                        break;
                    case 3 :
                        System.out.println("Enter row1 and row2 to XOR");
                        bm.xor(scan.nextInt(), scan.nextInt() );
                        break;
                    case 4 :
                        System.out.println("\nBit matrix Cleared");
                        bm.clear();
                        break;
                    case 5 :
                        System.out.println("Enter row and column to set bit");
                        bm.set(scan.nextInt(), scan.nextInt() );
                        break;
                    case 6 :
                        System.out.println("Enter row and column to get bit status");
                        System.out.println("\nStatus : "+ bm.get(scan.nextInt(), scan.nextInt()));
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                bm.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter row and column dimensions
4 4

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
5
Enter row and column to set bit
0 24

Bit Matrix :
{24}
{}
{}
{}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
5
Enter row and column to set bit
0 6

Bit Matrix :
{6, 24}
{}
{}
{}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
5
Enter row and column to set bit
1 28

Bit Matrix :
{6, 24}
{28}
{}
{}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
5
Enter row and column to set bit
1 5

Bit Matrix :
{6, 24}
{5, 28}
{}
{}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
1
Enter row1 and row2 to OR
2 0

Bit Matrix :
{6, 24}
{5, 28}
{6, 24}
{}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
2
Enter row1 and row2 to AND
0 3

Bit Matrix :
{}
{5, 28}
{6, 24}
{}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
3
Enter row1 and row2 to XOR
3 2

Bit Matrix :
{}
{5, 28}
{6, 24}
{6, 24}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
3
Enter row1 and row2 to XOR
3 1

Bit Matrix :
{}
{5, 28}
{6, 24}
{5, 6, 24, 28}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
6
Enter row and column to get bit status
0 3

Status : false

Bit Matrix :
{}
{5, 28}
{6, 24}
{5, 6, 24, 28}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
6
Enter row and column to get bit status
1 28

Status : true

Bit Matrix :
{}
{5, 28}
{6, 24}
{5, 6, 24, 28}


Do you want to continue (Type y or n)

y

Bit Matrix Operations

1. or
2. and
3. xor
4. clear
5. set
6. get
4

Bit matrix Cleared

Bit Matrix :
{}
{}
{}
{}


Do you want to continue (Type y or n)

n
