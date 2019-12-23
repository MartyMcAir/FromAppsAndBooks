/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Graph_Nodes;

/**
 *
 * @author MartyMcAir
 */
// sorted arr to beenary search tree
// https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Leetcode Algorithm Coding, Java Interview Offline
public class SortedArrToBeenaryTree {

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return helper(num, 0, num.length - 1);
    }

    /**
     * Recursive, DFS Divide into left subtree and right subtree with indices
     * range Choose mid point as the root of subtree
     */
    public static TreeNode helper(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, left, mid - 1); // left and mid -1
        root.right = helper(num, mid + 1, right); // mid + 1 and right
        return root;
    }
}
