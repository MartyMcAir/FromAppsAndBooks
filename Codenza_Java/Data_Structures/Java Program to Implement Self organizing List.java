/*This is a Java Program to implement Self Organizing List. A self-organizing list is a list that reorders its elements based on some self-organizing heuristic to improve average access time. The aim of a self-organizing list is to improve efficiency of linear search by moving more frequently accessed items towards the head of the list. A self-organizing list achieves near constant time for element access in the best case. A self-organizing list uses a reorganizing algorithm to adapt to various query distributions at runtime. The following program uses Count Method to reorder the list. In this technique, the number of times each node was searched for is counted i.e. every node keeps a separate counter variable which is incremented every time it is called. The nodes are then rearranged according to decreasing count. Thus, the nodes of highest count i.e. most frequently accessed are kept at the head of the list. The primary advantage of this technique is that it generally is more realistic in representing the actual access pattern.*/

/*
 *    Java Program to Implement Self organizing List
 */

import java.util.Scanner;

/* Class SelfOrganizingList */
class SelfOrganizingList
{
    private int[] list;
    private int[] count;
    private int size;

    /* Constructor */
    public SelfOrganizingList(int listSize)
    {
        list = new int[listSize];
        count = new int[listSize];
        size = 0;
    }
    /* Function to check is empty */
    public boolean isEmpty()
    {
        return size == 0;
    }
    /* Function to check if full */
    public boolean isFull()
    {
        return size == list.length;
    }
    /* Function to make list empty */
    public void makeEmpty()
    {
        int l = list.length;
        list = new int[l];
        count = new int[l];
        size = 0;
    }
    /* Function to get size of list */
    public int getSize()
    {
        return size;
    }
    /* Function to insert element */
    public void insert(int val)
    {
        if (isFull() )
            {
                System.out.println("Error : List full!");
                return;
            }
        list[size] = val;
        count[size] = 0;
        size++;
    }
    /* Function to remove element */
    public void remove(int pos)
    {
        pos-- ;
        if (pos < 0 || pos >= size )
            {
                System.out.println("Invalid position ");
                return;
            }
        for (int i = pos; i < size - 1; i++)
            {
                list[i] = list[i + 1];
                count[i] = count[i + 1];
            }
        size--;
    }
    /* Function to search for an element */
    public boolean search(int x)
    {
        boolean searchResult = false;
        int pos = -1;
        for (int i = 0; i < size; i++)
            {
                if (list[i] == x)
                    {
                        searchResult = true;
                        pos = i;
                        break;
                    }
            }
        if (searchResult)
            {
                count[pos]++;
                int c = count[pos];
                for (int i = 0; i < pos; i++)
                    {
                        if (count[pos] > count[i])
                            {
                                for (int j = pos; j > i; j--)
                                    {
                                        list[j] = list[j - 1];
                                        count[j] = count[j - 1];
                                    }
                                list[i] = x;
                                count[i] = c;
                                break;
                            }
                    }
            }
        return searchResult;
    }
    /* Function to print list */
    public void printList()
    {
        System.out.print("\nList = ");
        for (int i = 0; i < size; i++)
            System.out.print(list[i] +" ");
        System.out.print("\nCount = ");
        for (int i = 0; i < size; i++)
            System.out.print(count[i] +" ");
    }
}

/*  Class SelfOrganizingListTest  */
public class SelfOrganizingListTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("SelfOrganizingList Test\n");
        /* Creating object of class SelfOrganizingList */
        System.out.println("Enter size of list ");
        SelfOrganizingList list = new SelfOrganizingList(scan.nextInt() );
        char ch;
        /*  Perform list operations  */
        do
            {
                System.out.println("\nSelfOrganizingList Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. delete at position");
                System.out.println("3. search");
                System.out.println("4. check empty");
                System.out.println("5. check full");
                System.out.println("6. get size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        list.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter position to delete");
                        list.remove(scan.nextInt() );
                        break;
                    case 3 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Search Result : "+ list.search(scan.nextInt() ));
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ list.isEmpty());
                        break;
                    case 5 :
                        System.out.println("Full status = "+ list.isFull());
                        break;
                    case 6 :
                        System.out.println("Size = "+ list.getSize() +" \n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display List  */
                list.printList();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}


/*

Enter size of list
5

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
1
Enter integer element to insert
7

List  = 7
Count = 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
1
Enter integer element to insert
3

List  = 7 3
Count = 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
1
Enter integer element to insert
1

List  = 7 3 1
Count = 0 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
1
Enter integer element to insert
9

List  = 7 3 1 9
Count = 0 0 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
1
Enter integer element to insert
6

List  = 7 3 1 9 6
Count = 0 0 0 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
3
Enter integer element to search
6
Search Result : true

List  = 6 7 3 1 9
Count = 1 0 0 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
3
Enter integer element to search
9
Search Result : true

List  = 6 9 7 3 1
Count = 1 1 0 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
3
Enter integer element to search
1
Search Result : true

List  = 6 9 1 7 3
Count = 1 1 1 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
3
Enter integer element to search
1
Search Result : true

List  = 1 6 9 7 3
Count = 2 1 1 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
3
Enter integer element to search
9
Search Result : true

List  = 1 9 6 7 3
Count = 2 2 1 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
3
Enter integer element to search
6
Search Result : true

List  = 1 9 6 7 3
Count = 2 2 2 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
3
Enter integer element to search
6
Search Result : true

List  = 6 1 9 7 3
Count = 3 2 2 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
2
Enter position to delete
3

List  = 6 1 7 3
Count = 3 2 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
4
Empty status = false

List  = 6 1 7 3
Count = 3 2 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
1
Enter integer element to insert
7

List  = 6 1 7 3 7
Count = 3 2 0 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
5
Full status = true

List  = 6 1 7 3 7
Count = 3 2 0 0 0
Do you want to continue (Type y or n)

y

SelfOrganizingList Operations

1. insert
2. delete at position
3. search
4. check empty
5. check full
6. get size
6
Size = 5


List  = 6 1 7 3 7
Count = 3 2 0 0 0
Do you want to continue (Type y or n)

n
