/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_SortingAlgorithms;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Leetcode Algorithm Coding, Java Interview Offline
public class SortColors {

    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public void sortColors(int[] nums) {
        int redEnd = -1; // Ending index of red
        int whiteEnd = -1; // Ending index of white

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            nums[i] = BLUE;
            if (v == RED) {
                nums[++whiteEnd] = WHITE; // Update white first
                nums[++redEnd] = RED; // If there is no white yet, will overwrite white.
            } else if (v == WHITE) {
                nums[++whiteEnd] = WHITE;
            }
        }
    }
}
