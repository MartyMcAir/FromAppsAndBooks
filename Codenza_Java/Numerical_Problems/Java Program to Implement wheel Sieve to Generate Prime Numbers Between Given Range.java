/*
This is java program to implement Wheel Seive method to generate the prime numbers from 2 to the given limit. This algorithm reduces the time by checking only till n^2.
*/

//This is a sample program to print all the prime numbers between 2 and n
import java.util.LinkedList;
import java.util.Scanner;

public class Sieve_Method
{
    public static LinkedList<Integer> sieve(int n)
    {
        if(n < 2)
            return new LinkedList<Integer>();
        LinkedList<Integer> primes = new LinkedList<Integer>();
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 2; i <= n; i++)
            {
                //unoptimized
                nums.add(i);
            }
        while(nums.size() > 0)
            {
                int nextPrime = nums.remove();
                for(int i = nextPrime * nextPrime; i <= n; i += nextPrime)
                    {
                        nums.removeFirstOccurrence(i);
                    }
                primes.add(nextPrime);
            }
        return primes;
    }
    public static void main(String args[])
    {
        System.out.println("Enter the upper bound : ");
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();
        System.out.println(sieve(end));
        sc.close();
    }
}

/*
Enter the upper bound :
70
[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67]
