/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Matrix_Array;

import java.util.Scanner;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming

//Input number of rows: 2
//Input number of rows: 3
//Enter elements of matrix a:
//Element [1,1] ? 1
//Element [1,2] ? 2
//Element [1,3] ? 3
//Element [2,1] ? 4
//Element [2,2] ? 5
//Element [2,3] ? 6
//Matrix a:
//1	2	3	
//4	5	6	
//::: Transpose Matrix ::: 
//1	4	
//2	5	
//3	6
public class TransposingMatrix {

    public static void main(String args[]) {
        int row, col;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        row = sc.nextInt();
        System.out.print("Input number of rows: ");
        col = sc.nextInt();

        int a[][] = new int[row][col];

        System.out.println("Enter elements of matrix a:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Element [" + (i + 1) + "," + (j + 1) + "] ? ");
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix a:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.print("\n");
        }

        System.out.println("::: Transpose Matrix ::: ");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(a[j][i] + "\t");
            }
            System.out.print("\n");
        }
    }
}
