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
// https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Leetcode Algorithm Coding, Java Interview Offline
public class PopulationNextNode {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while (pre.left != null) { // Stop when next level doesn''t exist.
            cur = pre; // Current pointer of this level.
            while (cur != null) {
                cur.left.next = cur.right; // Set left child''s next to right child.
                if (cur.next != null) { // Set right child''s next to next node''s left child.
                    cur.right.next = cur.next.left;
                }
                cur = cur.next; // Move to the next node.
            }
            pre = pre.left; // Move to the next level.
        }
    }
}
