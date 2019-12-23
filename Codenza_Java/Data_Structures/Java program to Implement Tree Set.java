/*This is a Java program to Implement Tree Set. A set is an abstract data structure that can store certain values, without any particular order, and no repeated values. Here Tree set maintains sorted order.*/

/**
 * Java program to implement Tree Set
 */

import java.util.Scanner;

/** class TreeSetNode **/
class TreeSetNode
{
    String data;
    TreeSetNode left, right;

    /** constructor **/
    public TreeSetNode(String data, TreeSetNode left, TreeSetNode right)
    {
        this.data  = data;
        this.left  = left;
        this.right = right;
    }
}

/** class TreeSet **/
class TreeSet
{
    private TreeSetNode root;
    private int size;

    /** constructor **/
    public TreeSet()
    {
        root = null;
        size = 0;
    }

    /** function to check if empty **/
    public boolean isEmpty()
    {
        return root == null;
    }

    /** function to clear **/
    public void clear()
    {
        root = null;
        size = 0;
    }

    /** function to insert an element **/
    public void add(String ele)
    {
        root = insert(root, ele);
    }

    /** function to insert an element **/
    private TreeSetNode insert(TreeSetNode r, String ele)
    {
        if (r == null)
            r = new TreeSetNode(ele, null, null);
        else
            {
                if (ele.compareTo(r.data) < 0)
                    r.left = insert(r.left, ele);
                else if (ele.compareTo(r.data) > 0)
                    r.right = insert(r.right, ele);
            }
        return r;
    }

    /** Functions to count number of nodes **/
    public int countNodes()
    {
        return countNodes(root);
    }
    /** Function to count number of nodes recursively **/
    private int countNodes(TreeSetNode r)
    {
        if (r == null)
            return 0;
        else
            {
                int l = 1;
                l += countNodes(r.left);
                l += countNodes(r.right);
                return l;
            }
    }

    /** Functions to search for an element **/
    public boolean contains(String ele)
    {
        return contains(root, ele);
    }
    /** Function to search for an element recursively **/
    private boolean contains(TreeSetNode r, String ele)
    {
        boolean found = false;
        while ((r != null) && !found)
            {
                if (ele.compareTo(r.data) < 0)
                    r = r.left;
                else if (ele.compareTo(r.data) > 0)
                    r = r.right;
                else
                    {
                        found = true;
                        break;
                    }
                found = contains(r, ele);
            }
        return found;
    }

    /** Function to delete data **/
    public void delete(String ele)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (contains(ele) == false)
            System.out.println("Error : "+ ele +" is not present");
        else
            {
                root = delete(root, ele);
                System.out.println(ele +" deleted from the tree set");
            }
    }
    /** Function to delete element **/
    private TreeSetNode delete(TreeSetNode r, String ele)
    {
        TreeSetNode p, p2, n;
        if (r.data.equals(ele))
            {
                TreeSetNode lt, rt;
                lt = r.left;
                rt = r.right;
                if (lt == null && rt == null)
                    return null;
                else if (lt == null)
                    {
                        p = rt;
                        return p;
                    }
                else if (rt == null)
                    {
                        p = lt;
                        return p;
                    }
                else
                    {
                        p2 = rt;
                        p = rt;
                        while (p.left != null)
                            p = p.left;
                        p.left = lt;
                        return p2;
                    }
            }
        if (ele.compareTo(r.data) < 0)
            {
                n = delete(r.left, ele);
                r.left = n;
            }
        else
            {
                n = delete(r.right, ele);
                r.right = n;
            }
        return r;
    }

    /** function toString() **/
    public String toString()
    {
        return "[ "+ inorder(root, "") +"]";
    }
    private String inorder(TreeSetNode r, String str)
    {
        if (r != null)
            return str + inorder(r.left, str) + r.data +" "+ inorder(r.right, str);
        else
            return "";
    }
}

/** Class TreeSetTest **/
public class TreeSetTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /** Creating object of TreeSetTest **/
        TreeSet ts = new TreeSet();
        System.out.println("Tree Set Test\n");
        char ch;
        /**  Perform set operations  **/
        do
            {
                System.out.println("\nTree Set Operations\n");
                System.out.println("1. add ");
                System.out.println("2. delete");
                System.out.println("3. contains");
                System.out.println("4. count ");
                System.out.println("5. check empty");
                System.out.println("6. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter element to insert");
                        ts.add( scan.next() );
                        break;
                    case 2 :
                        System.out.println("Enter element to delete");
                        ts.delete( scan.next() );
                        break;
                    case 3 :
                        System.out.println("Enter integer element to search");
                        System.out.println("Search result : "+ ts.contains( scan.next() ));
                        System.out.println();
                        break;
                    case 4 :
                        System.out.println("Count = "+ ts.countNodes());
                        break;
                    case 5 :
                        System.out.println("Empty status = "+ ts.isEmpty());
                        break;
                    case 6 :
                        System.out.println("Tree set cleared");
                        ts.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /**  Display tree set  **/
                System.out.print("\nTree Set : "+ ts);
                System.out.println();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
5
Empty status = true

Tree Set : [ ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
1
Enter element to insert
mango

Tree Set : [ mango ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
1
Enter element to insert
strawberry

Tree Set : [ mango strawberry ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
1
Enter element to insert
apple

Tree Set : [ apple mango strawberry ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
1
Enter element to insert
pineapple

Tree Set : [ apple mango pineapple strawberry ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
1
Enter element to insert
orange

Tree Set : [ apple mango orange pineapple strawberry ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
1
Enter element to insert
jackfruit

Tree Set : [ apple jackfruit mango orange pineapple strawberry ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
4
Count = 6

Tree Set : [ apple jackfruit mango orange pineapple strawberry ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
2
Enter element to delete
jackfruit
jackfruit deleted from the tree set

Tree Set : [ apple mango orange pineapple strawberry ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
2
Enter element to delete
strawberry
strawberry deleted from the tree set

Tree Set : [ apple mango orange pineapple ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
3
Enter integer element to search
strawberry
Search result : false


Tree Set : [ apple mango orange pineapple ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
4
Count = 4

Tree Set : [ apple mango orange pineapple ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
5
Empty status = false

Tree Set : [ apple mango orange pineapple ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
6
Tree set cleared

Tree Set : [ ]

Do you want to continue (Type y or n)

y

Tree Set Operations

1. add
2. delete
3. contains
4. count
5. check empty
6. clear
5
Empty status = true

Tree Set : [ ]

Do you want to continue (Type y or n)

n
