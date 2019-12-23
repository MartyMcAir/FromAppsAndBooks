/**
 **  Java Program to implement Array Deque
 **/

import java.util.Scanner;

/** Class ArrayDeque **/
class ArrayDeque
{
    private int[] a;
    private int j, n;

    /** constructor **/
    public ArrayDeque()
    {
        j = 0;
        n = 0;
        resize();
    }

    /** function to check if empty **/
    public boolean isEmpty()
    {
        return n == 0;
    }

    /** function to clear array deque **/
    public void clear()
    {
        j = 0;
        n = 0;
        resize();
    }

    /** function to get number of elements **/
    public int getSize()
    {
        return n;
    }

    /** function to resize array deque **/
    private void resize()
    {
        int[] temp = new int[Math.max(2 * n, 1)];
        for (int k = 0; k < n; k++)
            temp[k] = a[(j + k) % a.length];
        a = temp;
        j = 0;
    }

    /** function to get an element array deque **/
    public int get(int i)
    {
        return a[(j + i) % a.length];
    }

    /** function to set an element **/
    public int set(int i, int x)
    {
        int y = a[(j + i) % a.length];
        a[(j + i) % a.length] = x;
        return y;
    }

    /** function to add an element **/
    void add(int i, int x)
    {
        if (n + 1 > a.length)
            resize();
        if (i < n/2)
            {
                /** shift left one position **/
                j = (j == 0) ? a.length - 1 : j - 1;
                for (int k = 0; k <= i - 1; k++)
                    a[(j + k) % a.length] = a[(j + k + 1)%a.length];
            }
        else
            {
                /** shift right one position **/
                for (int k = n; k > i; k--)
                    a[(j + k) % a.length] = a[(j + k - 1)%a.length];
            }
        a[(j + i) % a.length] = x;
        n++;
    }

    /** function to remove an element **/
    public int remove(int i)
    {
        int x = a[(j + i) % a.length];
        if (i < n/2)
            {
                /** shift a[0],..,[i-1] right one position **/
                for (int k = i; k > 0; k--)
                    a[(j + k) % a.length] = a[(j + k - 1) % a.length];
                j = (j + 1) % a.length;
            }
        else
            {
                /** shift a[i+1],..,a[n-1] left one position **/
                for (int k = i; k < n - 1; k++)
                    a[(j + k) % a.length] = a[(j + k + 1) % a.length];
            }
        n--;
        if (3 * n < a.length)
            resize();
        return x;
    }

    /** function display array deque **/
    public void display()
    {
        System.out.print("\nArray Deque : ");
        int p = j;
        for (int i = 0; i < n; i++)
            {
                System.out.print(a[p % a.length] +" ");
                p++;
            }
        System.out.println();
    }
}

/** Class ArrayDequeTest **/
public class ArrayDequeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Array Deque Test\n");
        ArrayDeque ad = new ArrayDeque();
        char ch;
        /*  Perform Array Deque operations */
        do
            {
                System.out.println("\nArray Deque Operations\n");
                System.out.println("1. add");
                System.out.println("2. get");
                System.out.println("3. set");
                System.out.println("4. remove");
                System.out.println("5. check empty");
                System.out.println("6. clear");
                System.out.println("7. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter index and element");
                        ad.add(scan.nextInt(), scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter index");
                        System.out.println("Result : "+ ad.get(scan.nextInt() ));
                        break;
                    case 3 :
                        System.out.println("Enter index and element");
                        ad.set(scan.nextInt(), scan.nextInt() );
                        break;
                    case 4 :
                        System.out.println("\nEnter index");
                        ad.remove(scan.nextInt() );
                        break;
                    case 5 :
                        System.out.println("\nEmpty Status : "+ ad.isEmpty());
                        break;
                    case 6 :
                        System.out.println("\nArray Deque Cleared");
                        ad.clear();
                        break;
                    case 7 :
                        System.out.println("\nSize = "+ ad.getSize() );
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** print array deque **/
                ad.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
5

Empty Status : true

Array Deque :

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
0 1

Array Deque : 1

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
1 2

Array Deque : 1 2

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
2 3

Array Deque : 1 2 3

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
3 4

Array Deque : 1 2 3 4

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
4 5

Array Deque : 1 2 3 4 5

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
5 6

Array Deque : 1 2 3 4 5 6

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
6 7

Array Deque : 1 2 3 4 5 6 7

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
7 8

Array Deque : 1 2 3 4 5 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
7

Size = 8

Array Deque : 1 2 3 4 5 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
4

Enter index
2

Array Deque : 1 2 4 5 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
4 24

Array Deque : 1 2 4 5 24 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
3 25

Array Deque : 1 2 4 25 5 24 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
1
Enter index and element
4 26

Array Deque : 1 2 4 25 26 5 24 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
7

Size = 10

Array Deque : 1 2 4 25 26 5 24 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
2
Enter index
6
Result : 24

Array Deque : 1 2 4 25 26 5 24 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
3
Enter index and element
3 28

Array Deque : 1 2 4 28 26 5 24 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
7

Size = 10

Array Deque : 1 2 4 28 26 5 24 6 7 8

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
6

Array Deque Cleared

Array Deque :

Do you want to continue (Type y or n)

y

Array Deque Operations

1. add
2. get
3. set
4. remove
5. check empty
6. clear
7. size
5

Empty Status : true

Array Deque :

Do you want to continue (Type y or n)

n
