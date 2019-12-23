/*This is a Java Program to Implement Floyd Cycle Algorithm. Cycle detection is the algorithmic problem of finding a cycle in a sequence of iterated function values. Floyd’s cycle-finding algorithm, also called the “tortoise and the hare” algorithm, is a pointer algorithm that uses only two pointers, which move through the sequence at different speeds.*/

/**
 ** Java Program to Implement Floyd Cycle Algorithm
 **/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/** Class FloydCycle **/
public class FloydCycle
{
    private List<Integer> func;
    private int lam, mu;
    /** Constructor **/
    public FloydCycle(List<Integer> list, int x0)
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
        int tortoise = f(x0);
        int hare = f(f(x0));
        while (tortoise != hare)
            {
                tortoise = f(tortoise);
                hare = f(f(hare));
            }
        int mu = 0;
        tortoise = x0;
        while (tortoise != hare)
            {
                tortoise = f(tortoise);
                hare = f(hare);
                mu += 1;
            }
        int lam = 1;
        hare = f(tortoise);
        while (tortoise != hare)
            {
                hare = f(hare);
                lam += 1;
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
        System.out.println("Floyd Cycle Algorithm Test\n");
        System.out.println("Enter size of list");
        int n = scan.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        System.out.println("\nEnter f(x)");
        for (int i = 0; i < n; i++)
            list.add(scan.nextInt());
        System.out.println("\nEnter x0");
        int x0 = scan.nextInt();
        FloydCycle fc = new FloydCycle(list, x0);
    }
}

/*
Enter size of list
9

Enter f(x)
6 6 0 1 4 3 3 4 0

Enter x0
2

First 9 elements in sequence :
2 0 6 3 1 6 3 1 6 3

Length of cycle : 3
Position : 3
