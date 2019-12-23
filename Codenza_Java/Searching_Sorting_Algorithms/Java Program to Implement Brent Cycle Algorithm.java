/*This is a Java Program to Implement Brent Cycle Algorithm. Cycle detection is the algorithmic problem of finding a cycle in a sequence of iterated function values. Brent Cycle Algorithm is an alternative cycle detection algorithm that, like the tortoise and hare algorithm, requires only two pointers into the sequence.*/

/**
 ** Java Program to Implement Brent Cycle Algorithm
 **/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/** Class BrentCycle **/
public class BrentCycle
{
    private List<Integer> func;
    private int lam, mu;
    /** Constructor **/
    public BrentCycle(List<Integer> list, int x0)
    {
        func = list;
        /** print sequence **/
        printSequence(x0);
        /** find cycle **/
        findCycle(x0);
        /** display results **/
        display();
    }
    /** function to find cycle **/
    private void findCycle(int x0)
    {
        int power, lam;
        power = lam = 1;
        int tortoise = x0;
        int hare = f(x0);
        while (tortoise != hare)
            {
                if (power == lam)
                    {
                        tortoise = hare;
                        power *= 2;
                        lam = 0;
                    }
                hare = f(hare);
                lam += 1;
            }
        mu = 0;
        tortoise = hare = x0;
        for (int i = 0; i < lam; i++)
            {
                hare = f(hare);
            }
        while (tortoise != hare)
            {
                tortoise = f(tortoise);
                hare = f(hare);
                mu += 1;
            }
        this.lam = lam;
        this.mu = mu;
    }
    /** function to return value of function f(x) **/
    private int f(int p)
    {
        return func.get(p);
    }
    /** function to print first n sequence **/
    public void printSequence(int x0)
    {
        int n = func.size();
        int tempx = x0;
        System.out.print("\nFirst "+ n +" elements in sequence : \n"+ tempx);
        for (int i = 0; i < n; i++)
            {
                tempx = f(tempx);
                System.out.print(" "+ tempx);
            }
        System.out.println();
    }
    /** function to display results **/
    public void display()
    {
        System.out.println("\nLength of cycle : "+ lam);
        System.out.println("Position : "+ (mu + 1));
    }
    /** Main function **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Brent Cycle Algorithm Test\n");
        System.out.println("Enter size of list");
        int n = scan.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        System.out.println("\nEnter f(x)");
        for (int i = 0; i < n; i++)
            list.add(scan.nextInt());
        System.out.println("\nEnter x0");
        int x0 = scan.nextInt();
        BrentCycle bc = new BrentCycle(list, x0);
    }
}

/*
Enter size of list
9

Enter f(x)
6 6 0 1 4 3 3 4 2

Enter x0
8

First 9 elements in sequence :
8 2 0 6 3 1 6 3 1 6

Length of cycle : 3
Position : 4
