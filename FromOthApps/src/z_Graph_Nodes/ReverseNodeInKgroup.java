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
public class ReverseNodeInKgroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = head;
        int count = 0;
        while (nextHead != null && count != k) { // Find the head of the rest of the list
            nextHead = nextHead.next;
            count++;
        }
        if (count != k) {
            return head; // Return original head since not enough nodes
        }
        ListNode newHead = reverseKGroup(nextHead, k); // Reverse the rest of the list 
        // Head of reversed list, which is the tail of the current K group
        while (count-- > 0) { // Reverse node k times in the current group
            ListNode next = head.next; // Save next node
            head.next = newHead; // Link head with tail
            newHead = head; // Move tail to head
            head = next; // Move to next node in the group
        }
        return newHead;
    }
}
