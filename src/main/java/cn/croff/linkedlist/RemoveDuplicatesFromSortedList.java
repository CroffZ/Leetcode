package cn.croff.linkedlist;

/**
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            // current与current.next值相同时删除current.next，否则继续遍历下一个节点
            if (current.val == current.next.val) current.next = current.next.next;
            else current = current.next;
        }
        return head;
    }
}
