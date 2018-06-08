package cn.croff.linkedlist;

/**
 * 61. Rotate List
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }

        ListNode p1pre = head, p1 = head, p2pre = null, p2 = head;
        for (int i = 0; i < k; i++) {
            p2pre = p2;
            p2 = p2.next;
        }

        while (p2 != null) {
            p1pre = p1;
            p1 = p1.next;
            p2pre = p2;
            p2 = p2.next;
        }

        p1pre.next = null;
        p2pre.next = head;
        return p1;
    }
}
