/*This is a Java Program to whether two lines intersect or not. The above-below primitive can be used to test whether a line intersects a line segment. It does iff one endpoint of the segment is to the left of the line and the other is to the right. Segment intersection is similar but more complicated, and we refer you to implementations described below. The decision whether two segments intersect if they share an endpoint depends upon your application and is representative of the problems of degeneracy.*/

//This is a java program to find whether two lines intersect or not using above and below primitive
import java.util.Random;

public class Line_Intersection
{
    public static void main(String args[])
    {
        Random random = new Random();
        int x1, x2, y1, y2;
        x1 = random.nextInt(10);
        x2 = random.nextInt(10);
        y1 = random.nextInt(10);
        y2 = random.nextInt(10);
        System.out.println("The Equation of the 1st line is : (" + (y2 - y1)
                           + ")x+(" + (x1 - x2) + ")y+(" + (x2 * y1 - x1 * y2) + ") = 0");
        int p1, p2, q1, q2;
        p1 = random.nextInt(10);
        p2 = random.nextInt(10);
        q1 = random.nextInt(10);
        q2 = random.nextInt(10);
        System.out.println("The Equation of the 2nd line is : (" + (q2 - q1)
                           + ")x+(" + (p1 - p2) + ")y+(" + (p2 * q1 - p1 * q2) + ") = 0");
        int s1 = (y2 - y1) * p1 + (x1 - x2) * q1 + (x2 * y1 - x1 * y2);
        if (s1 < 0)
            {
                int s2 = (y2 - y1) * p2 + (x1 - x2) * q2 + (x2 * y1 - x1 * y2);
                if (s2 >= 0)
                    System.out.println("The lines intersect");
                else if (s2 < 0)
                    System.out.println("The lines doesn't intersect");
            }
        else if (s1 > 0)
            {
                int s2 = (y2 - y1) * p2 + (x1 - x2) * q2 + (x2 * y1 - x1 * y2);
                if (s2 <= 0)
                    System.out.println("The lines intersect");
                else if (s2 > 0)
                    System.out.println("The lines doesn't intersect");
            }
        else
            System.out.println("The point lies on the line");
    }
}

/*
The Equation of the line is : (2)x+(9)y+(-63) = 0
The Equation of the line is : (-4)x+(2)y+(-4) = 0
The lines doesn't intersect

The Equation of the line is : (-4)x+(-3)y+(43) = 0
The Equation of the line is : (-1)x+(-8)y+(73) = 0
The lines intersect
