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
// https://play.google.com/store/apps/details?id=com.prodevs.apps.javaprogrammingguide
// Java Programs, Tutorials and Questions
public class TransposeMatrix {

    static int m, n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the no."
                + "of rows and coloumns:");
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        int a[][] = new int[3][3];
        int trans[][] = new int[3][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter element"
                        + i + "," + j + ":");
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                trans[i][j] = a[j][i];
            }
        }
        System.out.println("The original matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("The transpose matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(trans[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
