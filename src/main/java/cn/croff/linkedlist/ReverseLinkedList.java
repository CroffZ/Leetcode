package cn.croff.linkedlist;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    /**
     * 递归实现
     *
     * @param head 链表头
     * @return 新链表头
     */
    public ListNode reverseListRecursively(ListNode head) {
        // 递归终止条件：当前节点为最后一个节点
        if (head == null || head.next == null) return head;
        // 递归处理当前节点的下一个节点
        ListNode newHead = reverseListRecursively(head.next);
        // 修改指针
        head.next.next = head;
        head.next = null;
        // 返回新链表头
        return newHead;
    }

    /**
     * 迭代实现
     *
     * @param head 链表头
     * @return 新链表头
     */
    public ListNode reverseListIteratively(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode previous = head, current = head.next;
        // 把头节点的next置为null，避免出现循环链表
        head.next = null;
        while (current != null) {
            // 修改指针，直到current为null，则previous为最后一个节点
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        // 返回新链表头：previous
        return previous;
    }
}
