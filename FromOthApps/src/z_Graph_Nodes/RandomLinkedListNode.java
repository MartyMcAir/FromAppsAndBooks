/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Graph_Nodes;

import java.util.Random;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Leetcode Algorithm Coding, Java Interview Offline
public class RandomLinkedListNode {

    private final ListNode head;
    private final Random r;
    private ListNode current;

    /**
     * @param head The linked list''s head. Note that the head is guaranteed to
     * be not null, so it contains at least one node.
     */
    public RandomLinkedListNode(ListNode head) {
        this.head = head;
        this.current = head;
        r = new Random();
    }

    /**
     * Returns a random node''s value.
     */
    public int getRandom() {
        int res = head.val;
        ListNode n = head.next;
        int i = 2;
        while (n != null) {
            if (r.nextInt(i) == 0) { // For ith item, with probability 1/i, replace with new item.
                res = n.val;
            }
            n = n.next;
            i++;
        }
        return res;
    }
}
