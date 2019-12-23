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
public class CheackWeaterMatrix {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the matrix : ");

        int m = sc.nextInt();
        int A[][] = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Enter the elements : ");
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("*************************");
        System.out.println("The Matrix is : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("*************************");

        int p = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (A[i][j] != 0) {
                    p = 1;
                    break;
                }
            }
        }

        if (p == 0) {
            System.out.println("The matrix is Lower Triangular");
        } else {
            System.out.println("The matrix is not Lower Triangular");
        }
    }
}
