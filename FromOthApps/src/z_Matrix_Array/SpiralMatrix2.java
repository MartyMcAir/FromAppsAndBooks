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
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int[][] ans = new int[n][n];
        int num = 1;
        int lv = 0;
        while (2 * lv < n) {
            for (int i = lv; i < n - lv; i++) {
                ans[lv][i] = num++;
            }
            for (int i = lv + 1; i < n - lv; i++) {
                ans[i][n - lv - 1] = num++;
            }
            for (int i = n - lv - 2; i >= lv; i--) {
                ans[n - lv - 1][i] = num++;
            }
            for (int i = n - lv - 2; i >= lv + 1; i--) {
                ans[i][lv] = num++;
            }
            lv++;
        }
        return ans;
    }
}
