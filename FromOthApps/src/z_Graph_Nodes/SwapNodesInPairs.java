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
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        final ListNode dummy = new ListNode(0); // Create a dummy node to hold the head
        dummy.next = head;
        ListNode cur = dummy; // Start from dummy, the node before head

        while (cur != null && cur.next != null && cur.next.next != null) { // Has at least 2 nodes
            cur.next = swap(cur.next, cur.next.next); // Link current node to the new head
            cur = cur.next.next; // Move to the next node before head
        }

        return dummy.next;
    }

    private ListNode swap(ListNode first, ListNode second) {
        first.next = second.next; // Link first node to node after second
        second.next = first; // Link second node to first
        return second; // Return the new head
    }
}
