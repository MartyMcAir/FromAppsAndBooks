import java.util.Random;
import java.util.Scanner;

public class BinarySearchSequence
{
    public static void searchSequence(int[] array, int[] search)
    {
        int first, last, middle;
        first = 0;
        last = array.length - 1;
        boolean flag = true;
        for (int i = 0; i < search.length; i++)
            {
                middle = (first + last) / 2;
                while (first <= last && flag == true)
                    {
                        if (array[middle] < search[i])
                            {
                                first = middle + 1;
                            }
                        else if (array[middle] == search[i])
                            {
                                System.out.println(search[i] + " found at location "
                                                   + (middle + 1) + ".");
                                first = 0;
                                last = array.length - 1;
                                break;
                            }
                        else
                            {
                                last = middle - 1;
                            }
                        middle = (first + last) / 2;
                    }
                if (first > last)
                    {
                        System.out
                        .println(search[i] + " is not present in the list.");
                        flag = false;
                    }
            }
    }

    public static void main(String args[])
    {
        int c, n, search[], array[];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        n = in.nextInt();
        array = new int[n];
        Random rand = new Random();
        for (c = 0; c < n; c++)
            {
                array[c] = rand.nextInt(100);
            }
        System.out.println("Elements: ");
        for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + " ");
            }
        System.out.println("\nEnter length of sequence to find: ");
        int m = in.nextInt();
        search = new int[m];
        System.out.println("Enter the sequence to find: ");
        for (int i = 0; i < m; i++)
            {
                search[i] = in.nextInt();
            }
        searchSequence(array, search);
        in.close();
    }
}

/*

Enter number of elements:
10
Elements:
68 45 85 63 7 48 44 93 10 20
Enter length of sequence to find:
2
Enter the sequence to find:
7 48
7 found at location 5.
48 found at location 6.


Enter number of elements:
10
Elements:
60 52 44 55 55 25 34 97 24 18
Enter length of sequence to find:
3
Enter the sequence to find:
2 3 4
2 is not present in the list.
3 is not present in the list.
4 is not present in the list.
