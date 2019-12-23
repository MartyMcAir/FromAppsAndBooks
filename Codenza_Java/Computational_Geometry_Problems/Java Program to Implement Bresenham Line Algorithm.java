/*This is a Java Program to Implement Bresenham Line Algorithm. The Bresenham line algorithm is an algorithm which determines which order to form a close approximation to a straight line between two given points. It is commonly used to draw lines on a computer screen, as it uses only integer addition, subtraction and bit shifting, all of which are very cheap operations in standard computer architectures. It is one of the earliest algorithms developed in the field of computer graphics. A minor extension to the original algorithm also deals with drawing circles.*/

/**
 ** Java Program to Implement Bresenham Line Algorithm
 **/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

/** Class Bresenham **/
public class Bresenham
{
    /** function findLine() - to find that belong to line connecting the two points **/
    public List<Point> findLine(Point[][] grid, int x0, int y0, int x1, int y1)
    {
        List<Point> line = new ArrayList<Point>();
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx-dy;
        int e2;
        while (true)
            {
                line.add(grid[x0][y0]);
                if (x0 == x1 && y0 == y1)
                    break;
                e2 = 2 * err;
                if (e2 > -dy)
                    {
                        err = err - dy;
                        x0 = x0 + sx;
                    }
                if (e2 < dx)
                    {
                        err = err + dx;
                        y0 = y0 + sy;
                    }
            }
        return line;
    }

    /** function plot() - to visualize grid **/
    public void plot(Point[][] grid, List<Point> line)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        System.out.println("\nPlot : \n");
        for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                    {
                        if (line.contains(grid[i][j]))
                            System.out.print("*");
                        else
                            System.out.print("X");
                    }
                System.out.println();
            }
    }

    /** Function main() **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bresenham Line Algorithm");
        System.out.println("\nEnter dimensions of grid");
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        Point[][] grid = new Point[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = new Point(i, j);
        System.out.println("\nEnter coordinates of point 1 and point 2");
        int sr = scan.nextInt();
        int sc = scan.nextInt();
        int fr = scan.nextInt();
        int fc = scan.nextInt();
        Bresenham b = new Bresenham();
        List<Point> line = b.findLine(grid, sr, sc, fr, fc);
        b.plot(grid, line);
    }
}

/*
Enter dimensions of grid
40 40

Enter coordinates of point 1 and point 2
2 3
37 31

Plot :

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*XXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
