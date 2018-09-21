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

    public ListNode swapPairs(ListNode head) {
        // 如果剩下的链表长度小于等于1就直接返回
        if (head == null || head.next == null) return head;
        // 把接下来的两个结点交换位置
        ListNode newHead = head.next, next = head.next.next;
        newHead.next = head;
        // 递归处理剩下的结点
        head.next = swapPairs(next);
        // 返回处理后的新链表头
        return newHead;
    }
}
