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
public class PopulationNextNode2 {

    public void connect(TreeLinkNode root) {
        TreeLinkNode pre = root;
        TreeLinkNode dummy = new TreeLinkNode(0); // Dummy head. dummy.next is the leftmost node of current level.
        while (pre != null) {
            TreeLinkNode cur = dummy; // Pointer of the next level, start from dummy.
            // At current level, connect next level.
            while (pre != null) {
                if (pre.left != null) { // Connect if root''s left child not null.
                    cur.next = pre.left;
                    cur = cur.next;
                }
                if (pre.right != null) { // Connect if root''s right child not null.
                    cur.next = pre.right;
                    cur = cur.next;
                }
                pre = pre.next; // Move previous level.
            }
            pre = dummy.next; // Move pre to next level''s head.
            dummy.next = null; // IMPORTANT! dummy.next is updated when cur.next is first set.
            // Set dummy.next to null to avoid infinite loop.
        }
    }
}
