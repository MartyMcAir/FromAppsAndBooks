/*
This is the java program for emulating N dice roller. This can be achieved using random numbers. User can also select how many dice in a game.
*/

//This is a sample program to emulate n dice roller
import java.util.Random;
import java.util.Scanner;


public class Emulation_N_Dice
{
    public static void main(String args[])
    {
        System.out.println("Enter the number of dice: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random rand = new Random();
        do
            {
                System.out.println("The values on dice are: ");
                for(int i=0; i<n; i++)
                    System.out.println(rand.nextInt(6)+1);
                System.out.println("Continue: true/false");
            }
        while (sc.nextBoolean() == true);
        sc.close();
    }
}

/*

Enter the number of dice:
6
The values on dice are:
1 1 1 2 2 6
Continue: true/false
true
The values on dice are:
6 5 2 5 5 1
Continue: true/false
false
