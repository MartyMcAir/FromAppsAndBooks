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
public class CheackSparseMatrix {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the dimensions of the matrix : ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        double[][] mat = new double[m][n];

        int zeros = 0;

        System.out.println("Enter the elements of the matrix : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextDouble();
                if (mat[i][j] == 0) {
                    zeros++;
                }
            }
        }

        if (zeros > (m * n) / 2) {
            System.out.println("The matrix is a sparse matrix");
        } else {
            System.out.println("The matrix is not a sparse matrix");
        }
        sc.close();
    }
}
