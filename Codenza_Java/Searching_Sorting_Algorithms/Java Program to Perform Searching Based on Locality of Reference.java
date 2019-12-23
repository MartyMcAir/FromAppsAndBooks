
/*
 * Follows recently accessed elements should be referred more so kept on top of
 * the list
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LocalityBasedSearching
{
    public static void main(String[] args)
    {
        List<Integer> items = new LinkedList<Integer>();
        Integer n = 10;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        while (n > 0)
            {
                items.add(rand.nextInt(100));
                n--;
            }
        System.out.println(items.toString());
        boolean flag = true;
        boolean found = false;
        Integer numberofInstance;
        while (flag == true)
            {
                numberofInstance = 0;
                System.out.println("Enter the element to find: ");
                Integer search = sc.nextInt();
                for (int i = 0; i < items.size(); i++)
                    {
                        if (items.get(i).equals(search))
                            {
                                found = true;
                                System.out.println("Element found at index " + i
                                                   + "\nReordering list...");
                                // Integer temp = items.get(numberofInstance);
                                // items.set(numberofInstance, search);
                                items.add(numberofInstance, search);
                                items.remove(i + 1);
                                // items.set(i, temp);
                                System.out.println("Reordered list: " + items.toString());
                                numberofInstance++;
                                // break;
                            }
                    }
                if (found == false)
                    {
                        System.out.println("No such element found.");
                    }
                System.out.println("Do you want to continue? <true>/<false>");
                flag = sc.nextBoolean();
            }
        sc.close();
    }
}

/*

[52, 94, 58, 8, 78, 0, 30, 81, 16, 58]
Enter the element to find:
8
Element found at index 3
Reordering list...
Reordered list: [8, 52, 94, 58, 78, 0, 30, 81, 16, 58]
Do you want to continue? <true>/<false>
true
Enter the element to find:
58
Element found at index 3
Reordering list...
Reordered list: [58, 8, 52, 94, 78, 0, 30, 81, 16, 58]
Element found at index 9
Reordering list...
Reordered list: [58, 58, 8, 52, 94, 78, 0, 30, 81, 16]
Do you want to continue? <true>/<false>
true
Enter the element to find:
94
Element found at index 4
Reordering list...
Reordered list: [94, 58, 58, 8, 52, 78, 0, 30, 81, 16]
Do you want to continue? <true>/<false>
false
