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
public class WiggleSort2 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = quickSelect((n + 1) / 2, nums);
        int left = 0;
        int i = 0;
        int right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left, n), newIndex(i, n));
                left++;
                i++;
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right, n), newIndex(i, n));
                right--;
            } else {
                i++;
            }
        }
    }

    private int newIndex(int i, int n) {
        return (2 * i + 1) % (n | 1);
    }

    private int quickSelect(int k, int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int pos = l + (r - l) / 2;
            pos = partition(nums, l, r, pos);
            if (pos == k) {
                return nums[pos];
            } else if (pos < k) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        return nums[l];
    }

    private int partition(int[] nums, int l, int r, int pivot) {
        int val = nums[pivot];
        swap(nums, pivot, r); // Move pivot to the end
        int storeIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < val) { // Move numbers smaller than pivot to the front
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, r);
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
