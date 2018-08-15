package cn.croff.linkedlist;

/**
 * 148. Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {

    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public ListNode sortList(ListNode head) {
        quickSortLinkedList(head, null);
        return head;
    }

    private void quickSortLinkedList(ListNode head, ListNode tail) {
        if (head == null || head == tail) return;
        ListNode split = head, cur = head.next;
        while (cur != tail) {
            if (cur.val < head.val) {
                split = split.next;
                swapValue(cur, split);
            }
            cur = cur.next;
        }
        swapValue(head, split);
        quickSortLinkedList(head, split);
        quickSortLinkedList(split.next, tail);
    }

    private void swapValue(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head = new SortList().sortList(head);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
