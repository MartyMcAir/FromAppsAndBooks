/*This is a Java Program to implement Count Min Sketch. The Count–min sketch (or CM sketch) is a probabilistic sub-linear space streaming algorithm which can be used to summarize a data stream in many different ways. Count–min sketches are somewhat similar to Bloom filters; the main distinction is that Bloom filters represent sets, while CM sketches represent multi-sets and frequency tables.*/

/**
 * Java Program to Implement CountMinSketch
 **/

import java.util.Scanner;

class CountMinSketch
{
    private int[] h1;
    private int[] h2;
    private int[] h3;
    private int size;
    private static int DEFAULT_SIZE = 11;

    /** Constructor **/
    public CountMinSketch()
    {
        size = DEFAULT_SIZE;
        h1 = new int[ size ];
        h2 = new int[ size ];
        h3 = new int[ size ];
    }
    /** Function to clear al counters **/
    public void clear()
    {
        size = DEFAULT_SIZE;
        h1 = new int[ size ];
        h2 = new int[ size ];
        h3 = new int[ size ];
    }
    /** Function to insert value **/
    public void insert(int val)
    {
        int hash1 = hashFunc1(val);
        int hash2 = hashFunc2(val);
        int hash3 = hashFunc3(val);
        /** increment counters **/
        h1[ hash1 ]++;
        h2[ hash2 ]++;
        h3[ hash3 ]++;
    }
    /** Function to get sketch count **/
    public int sketchCount(int val)
    {
        int hash1 = hashFunc1(val);
        int hash2 = hashFunc2(val);
        int hash3 = hashFunc3(val);
        return min( h1[ hash1 ], h2[ hash2 ], h3[ hash3 ] );
    }
    private int min(int a, int b, int c)
    {
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;
        return min;
    }
    /** Hash function 1 **/
    private int hashFunc1(int val)
    {
        return val % size;
    }
    /** Hash function 2 **/
    private int hashFunc2(int val)
    {
        return ((val * (val + 3)) % size);
    }
    /** Hash function 3 **/
    private int hashFunc3(int val)
    {
        return (size - 1) - val % size;
    }
    /** Funtion to print all tables **/
    public void print()
    {
        System.out.println("\nCounter Tables : \n");
        System.out.print("h1 : ");
        for (int i = 0; i < size; i++)
            System.out.print(h1[i] +" ");
        System.out.print("\nh2 : ");
        for (int i = 0; i < size; i++)
            System.out.print(h2[i] +" ");
        System.out.print("\nh3 : ");
        for (int i = 0; i < size; i++)
            System.out.print(h3[i] +" ");
        System.out.println();
    }
}

public class CountMinSketchTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Count Min Sketch Test\n\n");
        /** Make object of CountMinSketch **/
        CountMinSketch cms = new CountMinSketch();
        char ch;
        /**  Perform CountMinSketch operations  **/
        do
            {
                System.out.println("\nCount Min Sketch Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. get sketch count");
                System.out.println("3. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter int value");
                        cms.insert(scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter int value");
                        int val = scan.nextInt();
                        System.out.println("\nSketch count for "+ val +" = "+ cms.sketchCount( val ));
                        break;
                    case 3 :
                        cms.clear();
                        System.out.println("Counters Cleared\n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** Display counter table **/
                cms.print();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
45

Counter Tables :

h1 : 0 1 0 0 0 0 0 0 0 0 0
h2 : 0 0 0 0 1 0 0 0 0 0 0
h3 : 0 0 0 0 0 0 0 0 0 1 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
67

Counter Tables :

h1 : 0 2 0 0 0 0 0 0 0 0 0
h2 : 0 0 0 0 2 0 0 0 0 0 0
h3 : 0 0 0 0 0 0 0 0 0 2 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
23

Counter Tables :

h1 : 0 3 0 0 0 0 0 0 0 0 0
h2 : 0 0 0 0 3 0 0 0 0 0 0
h3 : 0 0 0 0 0 0 0 0 0 3 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
47

Counter Tables :

h1 : 0 3 0 1 0 0 0 0 0 0 0
h2 : 0 0 0 0 3 0 0 1 0 0 0
h3 : 0 0 0 0 0 0 0 1 0 3 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
23

Counter Tables :

h1 : 0 4 0 1 0 0 0 0 0 0 0
h2 : 0 0 0 0 4 0 0 1 0 0 0
h3 : 0 0 0 0 0 0 0 1 0 4 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
31

Counter Tables :

h1 : 0 4 0 1 0 0 0 0 0 1 0
h2 : 0 0 0 0 4 0 0 1 0 1 0
h3 : 0 1 0 0 0 0 0 1 0 4 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
59

Counter Tables :

h1 : 0 4 0 1 1 0 0 0 0 1 0
h2 : 0 0 0 0 4 0 1 1 0 1 0
h3 : 0 1 0 0 0 0 1 1 0 4 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
13

Counter Tables :

h1 : 0 4 1 1 1 0 0 0 0 1 0
h2 : 0 0 0 0 4 0 1 1 0 1 1
h3 : 0 1 0 0 0 0 1 1 1 4 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
17

Counter Tables :

h1 : 0 4 1 1 1 0 1 0 0 1 0
h2 : 0 0 0 0 4 0 1 1 0 1 2
h3 : 0 1 0 0 1 0 1 1 1 4 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
2
Enter int value
17

Sketch count for 17 = 1

Counter Tables :

h1 : 0 4 1 1 1 0 1 0 0 1 0
h2 : 0 0 0 0 4 0 1 1 0 1 2
h3 : 0 1 0 0 1 0 1 1 1 4 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
1
Enter int value
97

Counter Tables :

h1 : 0 4 1 1 1 0 1 0 0 2 0
h2 : 0 0 0 0 4 0 1 1 0 2 2
h3 : 0 2 0 0 1 0 1 1 1 4 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
2
Enter int value
97

Sketch count for 97 = 2

Counter Tables :

h1 : 0 4 1 1 1 0 1 0 0 2 0
h2 : 0 0 0 0 4 0 1 1 0 2 2
h3 : 0 2 0 0 1 0 1 1 1 4 0

Do you want to continue (Type y or n)

y

Count Min Sketch Operations

1. insert
2. get sketch count
3. clear
3
Counters Cleared


Counter Tables :

h1 : 0 0 0 0 0 0 0 0 0 0 0
h2 : 0 0 0 0 0 0 0 0 0 0 0
h3 : 0 0 0 0 0 0 0 0 0 0 0

Do you want to continue (Type y or n)

n
