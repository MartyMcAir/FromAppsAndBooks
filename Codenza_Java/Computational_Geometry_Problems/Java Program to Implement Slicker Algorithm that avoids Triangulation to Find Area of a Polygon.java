/*This is a Java Program to find the area of a polygon using slicker method. The algorithm assumes the usual mathematical convention that positive y points upwards. In computer systems where positive y is downwards (most of them) the easiest thing to do is list the vertices counter-clockwise using the “positive y down” coordinates. The two effects then cancel out to produce a positive area.*/

//This is a java program to find the area of polygon using Slicker algorithm
import java.util.*;

class Area_polygon_Slicker
{
    static final int MAXPOLY = 200;
    static final double EPSILON = 0.000001;

    static class Point
    {
        double x, y;
    }

    static class Polygon
    {
        Point p[] = new Point[MAXPOLY];
        int n;

        Polygon()
        {
            for (int i = 0; i < MAXPOLY; i++)
                p[i] = new Point();
        }
    }

    static double area(Polygon p)
    {
        double total = 0;
        for (int i = 0; i < p.n; i++)
            {
                int j = (i + 1) % p.n;
                total += (p.p[i].x * p.p[j].y) - (p.p[j].x * p.p[i].y);
            }
        return total / 2;
    }

    static public void main(String[] args)
    {
        Polygon p = new Polygon();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of points in Polygon: ");
        p.n = sc.nextInt();
        System.out.println("Enter the coordinates of each point: <x> <y>");
        for (int i = 0; i < p.n; i++)
            {
                p.p[i].x = sc.nextDouble();
                p.p[i].y = sc.nextDouble();
            }
        double area = area(p);
        if (area > 0)
            System.out.print("The Area of Polygon with " + p.n
                             + " points using Slicker Algorithm is : " + area);
        else
            System.out.print("The Area of Polygon with " + p.n
                             + " points using Slicker Algorithm is : " + (area * -1));
        sc.close();
    }
}

/*
Enter the number of points in Polygon:
4
Enter the coordinates of each point: <x> <y>
1 1
1 6
6 6
6 1
The Area of Polygon with 4 points using Slicker Algorithm is : 25.0

Enter the number of points in Polygon:
5
Enter the coordinates of each point: <x> <y>
1 2
4 5
9 8
3 2
1 5
The Area of Polygon with 5points using Slicker Algorithm is : 6.0
