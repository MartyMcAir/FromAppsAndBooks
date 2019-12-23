/*This is a Java Program to check whether a point lies below, above or on the line. For any point t (xt, yt) on the plane, its position with respect to the line L connecting p and q is found by calculating the scalar s:
s = A xt + B yt + C
If s < 0, t lies in the clockwise halfplane of L; if s > 0, t lies on the counter-clockwise halfplane; if s = 0, t lies on L.
For example, the equation of the line connecting points (2, 2) and (4, 5) is -3x + 2y + 2 = 0. The point (6, 3) lies in the clockwise halfplane of this line, because (-3)(6) + (2)(3) + 2 = -10. Conversely, the point (0, 5) lies in the other halfplane as (-3)(0) +(2)(5) +2 = 12.*/

//This is a java program to check whether a point lies on, above or below the gievn line
import java.util.Random;
import java.util.Scanner;

public class Position_Point_WRT_Line
{
    public static void main(String args[])
    {
        Random random = new Random();
        int x1, x2, y1, y2;
        x1 = random.nextInt(10);
        x2 = random.nextInt(10);
        y1 = random.nextInt(10);
        y2 = random.nextInt(10);
        System.out.println("The Equation of the line is : (" + (y2 - y1)
                           + ")x+(" + (x1 - x2) + ")y+(" + (x2 * y1 - x1 * y2) + ") = 0");
        System.out.println("Enter the point : <x>,<y>");
        Scanner scan = new Scanner(System.in);
        int x, y;
        x = scan.nextInt();
        y = scan.nextInt();
        int s = (y2 - y1) * x + (x1 - x2) * y + (x2 * y1 - x1 * y2);
        if (s < 0)
            System.out
            .println("The point lies below the line or left side of the line");
        else if (s > 0)
            System.out
            .println("The point lies above the line or right side of the line");
        else
            System.out.println("The point lies on the line");
        scan.close();
    }
}

/*
The Equation of the line is : (-2)x+(-9)y+(81) = 0
Enter the point : <x>,<y>
2
3
The point lies above the line or right side of the line
