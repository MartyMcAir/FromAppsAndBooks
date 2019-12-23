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
public class PrintMatrix {

    public static void main(String args[]) throws IOException {
        int m, n;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.print("Enter the no. of rows and coloumns:");
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++)//Accept the matrix 
        {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter element(" + i
                        + "," + j + "):");
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
        for (int i = 0; i < m; i++)//Print the matrix 
        {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
