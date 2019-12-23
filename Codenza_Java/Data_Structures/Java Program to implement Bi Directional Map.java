/*This is a Java Program to implement Bi Directional Map. A bi-directional map is an associative data structure in which the (key, value) pairs form a one-to-one correspondence. Thus the binary relation is functional in each direction: value can also act as a key to key. A pair (a, b) thus provides a unique coupling between a and b so that b can be found when a is used as a key and a can be found when b is used as a key.*/

/**
 ** Java Program to implement Bi Directional Map
 **/

import java.util.Scanner;
import java.util.HashMap;

/** class BiDrirectionalMap */
class BiDirectionalMap
{
    private HashMap<String, String> keyVal;
    private HashMap<String, String> valKey;

    /** constructor **/
    public BiDirectionalMap()
    {
        keyVal = new HashMap<String, String>();
        valKey = new HashMap<String, String>();
    }
    /** function to clear maps **/
    public void clear()
    {
        keyVal.clear();
        valKey.clear();
    }
    /** function to get size of maps **/
    public int size()
    {
        return keyVal.size();
    }
    /** function to insert element **/
    public void put(String key, String val)
    {
        keyVal.put(key, val);
        valKey.put(val, key);
    }
    /** function to get element **/
    public String get(String ele)
    {
        String str = keyVal.get(ele);
        if (str == null)
            str = valKey.get(ele);
        return str;
    }
    /** function to remove element **/
    public void remove(String key)
    {
        String val = keyVal.get(key);
        if (val != null)
            {
                keyVal.remove(key);
                valKey.remove(val);
            }
        else
            {
                val = valKey.get(key);
                if (val != null)
                    {
                        keyVal.remove(val);
                        valKey.remove(key);
                    }
                else
                    System.out.println("\nError : Not found\n");
            }
    }
}

/** Class BiDirectionalMapTest **/
public class BiDirectionalMapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bi Directional Map Test\n");
        BiDirectionalMap bdm = new BiDirectionalMap();
        char ch;
        /** Perform Bi Directional Map operations **/
        do
            {
                System.out.println("\nBi Directional Map <String, String> Operations\n");
                System.out.println("1. put ");
                System.out.println("2. get");
                System.out.println("3. remove");
                System.out.println("4. clear");
                System.out.println("5. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter key and value");
                        bdm.put(scan.next(), scan.next() );
                        break;
                    case 2 :
                        System.out.println("Enter element");
                        String ele = scan.next();
                        String str = bdm.get(ele);
                        if (str != null)
                            System.out.println("Result : "+ str);
                        else
                            System.out.println("\nError : Not found\n");
                        break;
                    case 3 :
                        System.out.println("\nEnter element to be removed");
                        bdm.remove(scan.next() );
                        break;
                    case 4 :
                        System.out.println("\nBi Directional Map Cleared");
                        bdm.clear();
                        break;
                    case 5 :
                        System.out.println("\nSize = "+ bdm.size() );
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
Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
1
Enter key and value
green mango

Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
1
Enter key and value
banana yellow

Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
1
Enter key and value
red apple

Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
2
Enter element
red
Result : apple

Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
2
Enter element
mango
Result : green

Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
2
Enter element
apple
Result : red

Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
5

Size = 3

Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
3

Enter element to be removed
red

Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
2
Enter element
apple

Error : Not found


Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
2
Enter element
red

Error : Not found


Do you want to continue (Type y or n)

y

Bi Directional Map <String, String> Operations

1. put
2. get
3. remove
4. clear
5. size
4

Bi Directional Map Cleared

Do you want to continue (Type y or n)

n
