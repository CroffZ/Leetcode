package cn.croff.linkedlist;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null, current = null;
        while (l1 != null || l2 != null) {
            int num;
            if (l1 == null) {
                num = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                num = l1.val;
                l1 = l1.next;
            } else {
                if (l1.val >= l2.val) {
                    num = l2.val;
                    l2 = l2.next;
                } else {
                    num = l1.val;
                    l1 = l1.next;
                }
            }
            if (current == null) {
                result = new ListNode(num);
                current = result;
            } else {
                current.next = new ListNode(num);
                current = current.next;
            }
        }
        return result;
    }
}
