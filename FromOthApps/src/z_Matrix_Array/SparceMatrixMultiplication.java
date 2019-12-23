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
// https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Leetcode Algorithm Coding, Java Interview Offline
public class SparceMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int rA = A.length, cA = A[0].length;
        int cB = B[0].length;
        int[][] res = new int[rA][cB];

        for (int i = 0; i < rA; i++) {
            for (int j = 0; j < cA; j++) {
                if (A[i][j] == 0) {
                    continue; // Skip zeros in A.
                }
                for (int k = 0; k < cB; k++) { // Multiply
                    if (B[j][k] == 0) {
                        continue; // Skip zeros in B.
                    }
                    res[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return res;
    }
}
