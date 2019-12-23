/*This is a java program to search a number using Fibonacci Sequence.
The Fibonacci search technique is a method of searching a sorted array using a divide and conquer algorithm that narrows down possible locations with the aid of Fibonacci numbers.
 Compared to binary search, Fibonacci search examines locations whose addresses have lower dispersion. Therefore, when the elements being searched have non-uniform access memory storage
 (i.e., the time needed to access a storage location varies depending on the location previously accessed), the Fibonacci search has an advantage over binary search in slightly reducing
 the average time needed to access a storage location. The typical example of non-uniform access storage is that of a magnetic tape, where the time to access a particular element is
 proportional to its distance from the element currently under the tape’s head. Note, however, that large arrays not fitting in cache or even in RAM can also be considered as non-uniform access examples.
  Fibonacci search has a complexity of O(log(x)).*/

//This is a java program to search an element using Fibonacci search
import java.util.Scanner;

public class Fibonacci_Search
{
    static int kk = -1, nn = -1;
    static int fib[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233,
                         377, 610, 98, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368,
                         75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309,
                         3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986,
                         102334155, 165580141
                       };

    static int fibsearch(int a[], int n, long x)
    {
        int inf = 0, pos, k;
        if (nn != n)
            {
                k = 0;
                while (fib[k] < n)
                    k++;
                kk = k;
                nn = n;
            }
        else
            k = kk;
        while (k > 0)
            {
                pos = inf + fib[--k];
                if ((pos >= n) || (x < a[pos]))
                    ;
                else if (x > a[pos])
                    {
                        inf = pos + 1;
                        k--;
                    }
                else
                    return pos;
            }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = { 2, 3, 45, 56, 67, 78, 89, 99, 100, 101 };
        int num, pos;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an element to search: ");
        num = scan.nextInt();
        pos = fibsearch(arr, 10, num);
        if (pos >= 0)
            System.out.println("\nElement is at index : "
                               + fibsearch(arr, 10, num));
        else
            System.out.println("\nElement NOT found!! ");
        scan.close();
    }
}

/*
Enter an element to search:
78

Element is at index : 5
