package cn.croff.linkedlist;

/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {

    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p0, p1 = head, p2 = p1.next, p3 = p2.next;
        head = p2;
        head.next = p1;
        p1.next = p3;
        while (true) {
            p0 = p1;
            p1 = p3;
            if (p1 != null) {
                p2 = p1.next;
            } else {
                break;
            }
            if (p2 != null) {
                p3 = p2.next;
            } else {
                break;
            }
            p0.next = p2;
            p2.next = p1;
            p1.next = p3;
        }
        return head;
    }
}
