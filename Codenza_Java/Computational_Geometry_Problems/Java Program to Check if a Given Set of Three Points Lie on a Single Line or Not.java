/*This is a Java Program to check whether three points are collinear or not. We do this by taking two points make an equation of the line passing through those two points and check whether third points lies on it. In geometry, collinearity is a property of a set of points, specifically, the property of lying on a single line.*/

//This is a java program to check whether three points are collinear or not
import java.util.Scanner;

public class Collinear_Points
{
    public static void main(String args[])
    {
        System.out.println("Enter the points : <x>,<y>");
        Scanner scan = new Scanner(System.in);
        int x, y, x1, x2, y1, y2;
        x = scan.nextInt();
        y = scan.nextInt();
        x1 = scan.nextInt();
        x2 = scan.nextInt();
        y1 = scan.nextInt();
        y2 = scan.nextInt();
        /*
         * System.out.println("The Equation of the line is : (" + (y2 - y1) +
         * ")x+(" + (x1 - x2) + ")y+(" + (x2 * y1 - x1 * y2) + ") = 0");
         */
        int s = (y2 - y1) * x + (x1 - x2) * y + (x2 * y1 - x1 * y2);
        if (s < 0)
            System.out.println("The points are NOT collinear");
        else if (s > 0)
            System.out.println("The points are NOT collinear");
        else
            System.out.println("The points are collinear");
        scan.close();
    }
}

/*
Enter the points : <x>,<y>
3 2
1 3
1 5
The points are NOT collinear

Enter the points : <x>,<y>
1 1
1 5
1 9
The points are collinear
