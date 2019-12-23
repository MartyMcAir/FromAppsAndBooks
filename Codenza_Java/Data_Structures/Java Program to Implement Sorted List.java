/**
 **  Java Program to Implement Sorted List
 **/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class SortedList
{
    private ArrayList<Integer> list;

    /**  Constructor  **/
    public SortedList()
    {
        list = new ArrayList<Integer>();
    }
    /**  Function to check if list is empty  **/
    public boolean isEmpty()
    {
        return list.size() == 0 || list == null;
    }
    /** Function to clear list  **/
    public void clear()
    {
        list = new ArrayList<Integer>();
    }
    /**  Function to get size of list  **/
    public int size()
    {
        return list.size();
    }
    /**  Function to add element to list  **/
    public void add(int ele)
    {
        int pos = list.size();
        list.add(ele);
        while (pos > 0 && ele < list.get(pos - 1))
            {
                list.set(pos, list.get(pos - 1));
                pos--;
            }
        list.set(pos, ele);
    }
    /** Function to remove element at index **/
    public void remove(int ind)
    {
        list.remove(ind);
    }
    /** Function to perform binary search  **/
    public int binarySearch(int ele)
    {
        return Collections.binarySearch(list, ele);
    }
    /**  Function to check if element is present in list  **/
    public boolean contains(int ele)
    {
        return binarySearch(ele) >= 0;
    }
    /** Function to string  **/
    public String toString()
    {
        return list.toString();
    }
}

/**  Class SortedList  **/
public class SortedListTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class SortedList */
        SortedList list = new SortedList();
        System.out.println("Sorted List Test\n");
        char ch;
        /*  Perform list operations  */
        do
            {
                System.out.println("\nSorted List Operations\n");
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
                        list.add( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter index");
                        list.remove(scan.nextInt() );
                        break;
                    case 3 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Binary search result : "+ list.binarySearch(scan.nextInt() ));
                        break;
                    case 4 :
                        System.out.println("Enter integer element ");
                        System.out.println("Contains result : "+ list.contains(scan.nextInt() ));
                        break;
                    case 5 :
                        System.out.println("Empty status = "+ list.isEmpty());
                        break;
                    case 6 :
                        System.out.println("Size = "+ list.size() +" \n");
                        break;
                    case 7 :
                        System.out.println("Sorted List cleared");
                        list.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display List  */
                System.out.println(list);
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Sorted List Operations

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

y

Sorted List Operations

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

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
6
[6, 24]

Do you want to continue (Type y or n)

y

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
1
Enter integer element to add
28
[6, 24, 28]

Do you want to continue (Type y or n)

y

Sorted List Operations

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
[6, 19, 24, 28]

Do you want to continue (Type y or n)

y

Sorted List Operations

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
[6, 19, 24, 28, 63]

Do you want to continue (Type y or n)

y

Sorted List Operations

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
[6, 19, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

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
[5, 6, 19, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

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
[5, 6, 19, 24, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

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
[5, 6, 19, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
6
Size = 7

[5, 6, 19, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
3
Enter integer element to search
63
Binary search result : 5
[5, 6, 19, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
4
Enter integer element
6
Contains result : true
[5, 6, 19, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
4
Enter integer element
7
Contains result : false
[5, 6, 19, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
2
Enter index
2
[5, 6, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
6
Size = 6

[5, 6, 24, 28, 63, 94]

Do you want to continue (Type y or n)

y

Sorted List Operations

1. insert
2. remove
3. binary search
4. contains
5. check empty
6. get size
7. clear
7
Sorted List cleared
[]

Do you want to continue (Type y or n)

y

Sorted List Operations

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
