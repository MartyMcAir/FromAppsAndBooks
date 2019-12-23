/**
 **  Java Program to Implement Sorted Vector
 **/

import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;

class SortedVector
{
    private Vector<Integer> vect;

    /**  Constructor  **/
    public SortedVector()
    {
        vect = new Vector<Integer>();
    }
    /**  Function to check if vector is empty  **/
    public boolean isEmpty()
    {
        return vect.size() == 0 || vect == null;
    }
    /** Function to clear vector  **/
    public void clear()
    {
        vect = new Vector<Integer>();
    }
    /**  Function to get size of vector  **/
    public int size()
    {
        return vect.size();
    }
    /**  Function to add element to vector  **/
    public void add(int ele)
    {
        int pos = vect.size();
        vect.add(ele);
        while (pos > 0 && ele < vect.get(pos - 1))
            {
                vect.set(pos, vect.get(pos - 1));
                pos--;
            }
        vect.set(pos, ele);
    }
    /** Function to remove element at index **/
    public void remove(int ind)
    {
        vect.remove(ind);
    }
    /** Function to perform binary search  **/
    public int binarySearch(int ele)
    {
        return Collections.binarySearch(vect, ele);
    }
    /**  Function to check if element is present in vector  **/
    public boolean contains(int ele)
    {
        return binarySearch(ele) >= 0;
    }
    /** Function to string  **/
    public String toString()
    {
        return vect.toString();
    }
}

/**  Class SortedVector  **/
public class SortedVectorTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class SortedVector */
        SortedVector sv = new SortedVector();
        System.out.println("Sorted Vector Test\n");
        char ch;
        /*  Perform vector operations  */
        do
            {
                System.out.println("\nSorted Vector Operations\n");
                System.out.println("1. insert");
                System.out.println("2. remove ");
                System.out.println("3. binary search");
                System.out.println("4. contains");
                System.out.println("5. check empty");
                System.out.println("6. get size");
                System.out.println("7. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to add");
                        sv.add( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter index");
                        sv.remove(scan.nextInt() );
                        break;
                    case 3 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Binary search result : "+ sv.binarySearch(scan.nextInt() ));
                        break;
                    case 4 :
                        System.out.println("Enter integer element ");
                        System.out.println("Contains result : "+ sv.contains(scan.nextInt() ));
                        break;
                    case 5 :
                        System.out.println("Empty status = "+ sv.isEmpty());
                        break;
                    case 6 :
                        System.out.println("Size = "+ sv.size() +" \n");
                        break;
                    case 7 :
                        System.out.println("Sorted Vector cleared");
                        sv.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display Vector  */
                System.out.println(sv);
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
24
[24]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
5
[5, 24]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
63
[5, 24, 63]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
94
[5, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
19
[5, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
1
[1, 5, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
17
[1, 5, 17, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
14
[1, 5, 14, 17, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
2
Enter index
3
[1, 5, 14, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
6
Size = 7

[1, 5, 14, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
3
Enter integer element to search
14
Binary search result : 2
[1, 5, 14, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
3
Enter integer element to search
45
Binary search result : -6
[1, 5, 14, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
4
Enter integer element
24
Contains result : true
[1, 5, 14, 19, 24, 63, 94]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
7
Sorted Vector cleared
[]

Do you want to continue (Type y or n)

y

Sorted Vector Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
5
Empty status = true
[]

Do you want to continue (Type y or n)

n
