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
public class RemoveDuplicateSortArr {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int length = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[length - 2]) { // Compare with the second last element of the new array.
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }
}
