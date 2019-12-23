/*This is a Java Program to implement Associate Array. An associative array, map, symbol table, or dictionary is an abstract data type composed of a collection of (key, value) pairs, such that each possible key appears at most once in the collection.*/

/**
 ** Java Program to implement Associate Array
 **/

import java.util.Scanner;
import java.util.HashMap;

/** class AssociateArray */
class AssociateArray
{
    private HashMap<String, String> keyVal;

    /** constructor **/
    public AssociateArray()
    {
        keyVal = new HashMap<String, String>();
    }
    /** function to clear **/
    public void clear()
    {
        keyVal.clear();
    }
    /** function to get size **/
    public int size()
    {
        return keyVal.size();
    }
    /** function to insert element **/
    public void insert(String key, String val)
    {
        keyVal.put(key, val);
    }
    /** function to get element **/
    public String get(String ele)
    {
        return keyVal.get(ele);
    }
    /** function to remove element **/
    public void remove(String key)
    {
        keyVal.remove(key);
    }
    /** function to modify **/
    public void modify(String key, String val)
    {
        keyVal.put(key, val);
    }
}

/** Class AssociateArrayTest **/
public class AssociateArrayTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Associate Array Test\n");
        AssociateArray aa = new AssociateArray();
        char ch;
        /*  Perform Associate Array operations */
        do
            {
                System.out.println("\nAssociate Array <String, String> Operations\n");
                System.out.println("1. put ");
                System.out.println("2. get");
                System.out.println("3. remove");
                System.out.println("4. modify");
                System.out.println("5. clear");
                System.out.println("6. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter key and value");
                        aa.insert(scan.next(), scan.next() );
                        break;
                    case 2 :
                        System.out.println("Enter element");
                        String ele = scan.next();
                        String str = aa.get(ele);
                        if (str != null)
                            System.out.println("Result : "+ str);
                        else
                            System.out.println("\nError : Not found\n");
                        break;
                    case 3 :
                        System.out.println("\nEnter key to be removed");
                        aa.remove(scan.next() );
                        break;
                    case 4 :
                        System.out.println("\nEnter key, value to be modified");
                        aa.modify(scan.next(), scan.next() );
                        break;
                    case 5 :
                        System.out.println("\nAssociate Array Cleared");
                        aa.clear();
                        break;
                    case 6 :
                        System.out.println("\nSize = "+ aa.size() );
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

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
1
Enter key and value
fruit mango

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
1
Enter key and value
vegetable tomato

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
1
Enter key and value
drink water

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
2
Enter element
drink
Result : water

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
2
Enter element
fruit
Result : mango

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
4

Enter key, value to be modified
fruit apple

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
2
Enter element
fruit
Result : apple

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
6

Size = 3

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
3

Enter key to be removed
fruit

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
2
Enter element
fruit

Error : Not found


Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
5

Associate Array Cleared

Do you want to continue (Type y or n)

y

Associate Array <String, String> Operations

1. put
2. get
3. remove
4. modify
5. clear
6. size
6

Size = 0

Do you want to continue (Type y or n)

n
