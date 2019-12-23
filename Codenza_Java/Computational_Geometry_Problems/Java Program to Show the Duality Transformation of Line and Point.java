/*This is a java program to show the duality transformation of line and point. The transformation corresponds from line to point and point to line.*/
import java.util.Scanner;

public class DualityTransformationofPointandLine
{
    public static void performLineTransformation(double a, double b)
    {
        System.out.println("X: " + (b / a) + ", Y: " + (b * -1));
    }

    public static void performPointTransformation(double x, double y)
    {
        System.out.println("y=" + (-1 * y / x) + "x +" + (-1 * y));
    }

    public static void main(String[] args)
    {
        System.out
        .println("Perform what transformation.\n1. Line Transformation\n2. Point Transformation");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option)
            {
            case 1:
                System.out.println("Enter the coefficients of line <y=ax-b>");
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                performLineTransformation(a, b);
                break;
            case 2:
                System.out.println("Enter the coordinate of point <x, y>");
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                performPointTransformation(x, y);
                break;
            default:
                break;
            }
        sc.close();
    }
}

/*
Perform what transformation.
1. Line Transformation
2. Point Transformation
1
Enter the coefficients of line <y=ax-b>
1 2
X: 2.0, Y: -2.0

Perform what transformation.
1. Line Transformation
2. Point Transformation
2
Enter the coordinate of point <x, y>
2 -2
y=1.0x +2.0
