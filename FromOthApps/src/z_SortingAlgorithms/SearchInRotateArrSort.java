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
public class SearchInRotateArrSort {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return true;
            }
            // Skip duplicates.
            if (nums[l] == nums[m] && nums[m] == nums[h]) { // [1, 3, 1, 1, 1] OR [1, 1, 1, 3, 1]
                l++;
                h--;
            } else if (nums[l] == nums[m]) {
                l = m + 1;
            } else if (nums[m] == nums[h]) {
                h = m - 1;
            } else if (nums[l] < nums[m]) { // [l, m] sorted.
                if (nums[l] <= target && target < nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[l] > nums[m]) { // [m, r] sorted.
                if (nums[m] < target && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return false;
    }
}
