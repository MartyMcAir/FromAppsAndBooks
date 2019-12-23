/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Matrix_Array;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.spyboy.javaprogramming
// Java Programming
public class SubstractionTwoMatrix {

    public static void main(String args[]) {
        int m1[][] = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int m2[][] = {{4, 4, 4}, {5, 5, 5}, {6, 6, 6}};

        int m3[][] = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m3[i][j] = m1[i][j] - m2[i][j];
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
