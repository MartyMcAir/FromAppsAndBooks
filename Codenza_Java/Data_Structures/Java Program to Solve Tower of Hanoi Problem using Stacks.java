/*This is a Java Program to solve Tower of Hanoi Problem using stacks. Stack is an area of memory that holds all local variables and parameters used by any function and remembers the order in which functions are called so that function returns occur correctly. ‘push’ operation is used to add an element to stack and ‘pop’ operation is used to remove an element from stack. ‘peek’ operation is also implemented returning the value of the top element without removing it. The relation between the push and pop operations is such that the stack is a Last-In-First-Out (LIFO) data structure.
The Tower of Hanoi is a mathematical game or puzzle. It consists of three rods, and a number of disks of different sizes which can slide onto any rod. The puzzle starts with the disks in a neat stack in ascending order of size on one rod, the smallest at the top, thus making a conical shape.
The objective of the puzzle is to move the entire stack to another rod, obeying the following rules:
i) Only one disk may be moved at a time.
ii) Each move consists of taking the upper disk from one of the rods and sliding it onto another rod, on top of the other disks that may already be present on that rod.
iii) No disk may be placed on top of a smaller disk.*/

/*
 * Java Program to Solve Tower of Hanoi Problem using Stacks
 */

import java.util.*;

/* Class TowerOfHanoiUsingStacks */
public class TowerOfHanoiUsingStacks
{
    public static int N;
    /* Creating Stack array  */
    public static Stack<Integer>[] tower = new Stack[4];

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();
        /* Accepting number of disks */
        System.out.println("Enter number of disks");
        int num = scan.nextInt();
        N = num;
        toh(num);
    }
    /* Function to push disks into stack */
    public static void toh(int n)
    {
        for (int d = n; d > 0; d--)
            tower[1].push(d);
        display();
        move(n, 1, 2, 3);
    }
    /* Recursive Function to move disks */
    public static void move(int n, int a, int b, int c)
    {
        if (n > 0)
            {
                move(n-1, a, c, b);
                int d = tower[a].pop();
                tower[c].push(d);
                display();
                move(n-1, b, a, c);
            }
    }
    /*  Function to display */
    public static void display()
    {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for(int i = N - 1; i >= 0; i--)
            {
                String d1 = " ", d2 = " ", d3 = " ";
                try
                    {
                        d1 = String.valueOf(tower[1].get(i));
                    }
                catch (Exception e)
                    {
                    }
                try
                    {
                        d2 = String.valueOf(tower[2].get(i));
                    }
                catch(Exception e)
                    {
                    }
                try
                    {
                        d3 = String.valueOf(tower[3].get(i));
                    }
                catch (Exception e)
                    {
                    }
                System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
            }
        System.out.println("\n");
    }
}

/*

Enter number of disks
5
 A  |  B  |  C
---------------
 1  |     |
 2  |     |
 3  |     |
 4  |     |
 5  |     |


 A  |  B  |  C
---------------
    |     |
 2  |     |
 3  |     |
 4  |     |
 5  |     |  1


 A  |  B  |  C
---------------
    |     |
    |     |
 3  |     |
 4  |     |
 5  |  2  |  1


 A  |  B  |  C
---------------
    |     |
    |     |
 3  |     |
 4  |  1  |
 5  |  2  |


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |
 4  |  1  |
 5  |  2  |  3


 A  |  B  |  C
---------------
    |     |
    |     |
 1  |     |
 4  |     |
 5  |  2  |  3


 A  |  B  |  C
---------------
    |     |
    |     |
 1  |     |
 4  |     |  2
 5  |     |  3


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |  1
 4  |     |  2
 5  |     |  3


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |  1
    |     |  2
 5  |  4  |  3


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |
    |  1  |  2
 5  |  4  |  3


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |
 2  |  1  |
 5  |  4  |  3


 A  |  B  |  C
---------------
    |     |
    |     |
 1  |     |
 2  |     |
 5  |  4  |  3


 A  |  B  |  C
---------------
    |     |
    |     |
 1  |     |
 2  |  3  |
 5  |  4  |


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |
 2  |  3  |
 5  |  4  |  1


 A  |  B  |  C
---------------
    |     |
    |     |
    |  2  |
    |  3  |
 5  |  4  |  1


 A  |  B  |  C
---------------
    |     |
    |  1  |
    |  2  |
    |  3  |
 5  |  4  |


 A  |  B  |  C
---------------
    |     |
    |  1  |
    |  2  |
    |  3  |
    |  4  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |  2  |
    |  3  |
 1  |  4  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |
    |  3  |  2
 1  |  4  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |  1
    |  3  |  2
    |  4  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |  1
    |     |  2
 3  |  4  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |
    |  1  |  2
 3  |  4  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |
 2  |  1  |
 3  |  4  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
 1  |     |
 2  |     |
 3  |  4  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
 1  |     |
 2  |     |  4
 3  |     |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |  1
 2  |     |  4
 3  |     |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |  1
    |     |  4
 3  |  2  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |
    |  1  |  4
 3  |  2  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |  3
    |  1  |  4
    |  2  |  5


 A  |  B  |  C
---------------
    |     |
    |     |
    |     |  3
    |     |  4
 1  |  2  |  5


 A  |  B  |  C
---------------
    |     |
    |     |  2
    |     |  3
    |     |  4
 1  |     |  5


 A  |  B  |  C
---------------
    |     |  1
    |     |  2
    |     |  3
    |     |  4
    |     |  5
