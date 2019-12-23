/*This is a Java Program to Implement Flood Fill Algorithm. Flood fill, also called seed fill, is an algorithm that determines the area connected to a given node in a multi-dimensional array. It is used in the “bucket” fill tool of paint programs to fill connected, similarly-colored areas with a different color, and in games such as Go and Minesweeper for determining which pieces are cleared. When applied on an image to fill a particular bounded area with color, it is also known as boundary fill. Here ‘P’ is for passage, ‘O’ for obstacle and ‘W’ for water flow.*/

/**
 * Java Program to Implement Flood Fill Algorithm
 **/

import java.util.Scanner;
import java.util.Arrays;

/** Class FloodFill **/
public class FloodFill
{
    /** Function to fill grid **/
    private void fillGrid(char[][] arr, int r, int c)
    {
        if (arr[r][c] == 'P')
            {
                arr[r][c] = 'W';
                display(arr);
                fillGrid(arr, r + 1, c);
                fillGrid(arr, r - 1, c);
                fillGrid(arr, r, c + 1);
                fillGrid(arr, r, c - 1);
            }
    }
    /** Function to display grid **/
    private void display(char[][] arr)
    {
        System.out.println("\nGrid : ");
        for (int i = 1; i < arr.length - 1; i++)
            {
                for (int j = 1; j < arr[i].length - 1; j++)
                    System.out.print(arr[i][j] +" ");
                System.out.println();
            }
    }

    /** Main method **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Flood Fill Test\n");
        /** Accept dimensions **/
        System.out.println("Enter dimensions of grid");
        int M = scan.nextInt();
        int N = scan.nextInt();
        /** make grid with border as obstacle to avoid boundary conditions **/
        char[][] arr = new char[M + 2][N + 2];
        for (int i = 0; i < M + 2; i++)
            Arrays.fill(arr[i], 'O');
        /** Accept grid **/
        System.out.println("Enter grid with 'P' for passage and 'O' for obstacle");
        for (int i = 1; i < M + 1; i++)
            for (int j = 1; j < N + 1; j++)
                arr[i][j] = scan.next().charAt(0);
        System.out.println("Enter coordinates to start ");
        int sr = scan.nextInt();
        int sc = scan.nextInt();
        if (arr[sr][sc] != 'P')
            {
                System.out.println("Invalid coordinates");
                System.exit(0);
            }
        FloodFill ff = new FloodFill();
        ff.fillGrid(arr, sr, sc);
    }
}

/*
Enter dimensions of grid
5 5
Enter grid with 'P' for passage and 'O' for obstacle
P P P P P
O P O P O
O O P P O
P P P O O
P O O O O
Enter coordinates to start
3 3

Grid :
P P P P P
O P O P O
O O W P O
P P P O O
P O O O O

Grid :
P P P P P
O P O P O
O O W P O
P P W O O
P O O O O

Grid :
P P P P P
O P O P O
O O W P O
P W W O O
P O O O O

Grid :
P P P P P
O P O P O
O O W P O
W W W O O
P O O O O

Grid :
P P P P P
O P O P O
O O W P O
W W W O O
W O O O O

Grid :
P P P P P
O P O P O
O O W W O
W W W O O
W O O O O

Grid :
P P P P P
O P O W O
O O W W O
W W W O O
W O O O O

Grid :
P P P W P
O P O W O
O O W W O
W W W O O
W O O O O

Grid :
P P P W W
O P O W O
O O W W O
W W W O O
W O O O O

Grid :
P P W W W
O P O W O
O O W W O
W W W O O
W O O O O

Grid :
P W W W W
O P O W O
O O W W O
W W W O O
W O O O O

Grid :
P W W W W
O W O W O
O O W W O
W W W O O
W O O O O

Grid :
W W W W W
O W O W O
O O W W O
W W W O O
W O O O O
