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
public class RemoveDuplicateSortListNode2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0); // dummy head
        dummyHead.next = head;
        ListNode pre = dummyHead; // two pointers
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next; // skip
            }
            if (pre.next == cur) {
                pre = pre.next; // no dups
            } else {
                pre.next = cur.next; // cur moved
            }
            cur = cur.next; // update current
        }
        return dummyHead.next;
    }
}
