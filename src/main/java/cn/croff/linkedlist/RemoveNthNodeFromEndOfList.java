package cn.croff.linkedlist;

/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * Given n will always be valid.
 * <p>
 * Follow up:
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        // 用一个dummy放在头节点之前，便于删除头节点，快慢指针都从dummy开始
        ListNode dummy = new ListNode(0), fast, slow;
        dummy.next = head;
        fast = slow = dummy;
        // 快指针先走n步
        for (int i = 0; i < n; i++) fast = fast.next;
        // 然后快慢指针一起走，直到快指针指向最后一个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除慢指针的下一个节点，返回dummy的下一个节点，也就是新的头节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
