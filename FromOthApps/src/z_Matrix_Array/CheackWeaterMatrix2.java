/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Matrix_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming
public class CheackWeaterMatrix2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of elements : ");
        int m = Integer.parseInt(br.readLine());
        int A[][] = new int[m][m];

        if (m > 2 && m < 10) {
            System.out.println("\nInputting the elements of the Matrix : n");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print("Enter the elements : ");
                    A[i][j] = Integer.parseInt(br.readLine());
                }
            }

            System.out.println("\nThe Original Matrix is : ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(A[i][j] + "\t");
                }
                System.out.println();
            }

            int flag = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (A[i][j] != A[j][i]) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) {
                System.out.println("\nThe given Matrix is Not Symmetric");
            } else {
                System.out.println("\nThe given Matrix is Symmetric");
            }

            int ld = 0, rd = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == j) {
                        ld = ld + A[i][j];
                    }
                    if ((i + j) == (m - 1)) {
                        rd = rd + A[i][j];
                    }
                }
            }

            System.out.println("The sum of the left diagonal = " + ld);
            System.out.println("The sum of the right diagonal = " + rd);
        } else {
            System.out.println("The Matrix Size is Out Of Range....");
        }
    }
}
