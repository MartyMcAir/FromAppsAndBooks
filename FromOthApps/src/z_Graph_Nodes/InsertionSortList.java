/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Graph_Nodes;

import z_SortingAlgorithms.*;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Leetcode Algorithm Coding, Java Interview Offline
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;

        for (ListNode p = head.next, prev = head; p != null; prev = p, p = p.next) {
            for (ListNode c = pre; c.next != p; c = c.next) {
                if (c.next.val > p.val) {
                    prev.next = p.next; // skip p
                    p.next = c.next; // insert between cur and cur.next
                    c.next = p;
                    p = prev; // p is inserted to somewhere in the front, reset
                    break;
                }
            }
        }
        return pre.next;
    }
}
