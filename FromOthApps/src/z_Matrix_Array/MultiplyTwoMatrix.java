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
public class MultiplyTwoMatrix {

    public static void main(String args[]) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base the matrices : ");
        n = input.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] c = new int[n][n];

        System.out.println("Enter the elements of 1st Matrix row wise \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter the elements of 2nd mrtix row wise \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = input.nextInt();
            }
        }

        System.out.println("Multiplying both sthe matrices...");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("The product of the matrices is : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}
