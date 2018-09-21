package cn.croff.linkedlist;

/**
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 判断剩下的链表长度是否足够
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) {
            count++;
            if (count == k) break;
        }
        // 如果不够就不反转了，直接返回
        if (count < k) return head;
        // 迭代法反转链表的前k个结点
        ListNode pre = head, cur = head.next;
        for (int i = 1; i < k && cur != null; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 递归处理剩下的链表
        head.next = reverseKGroup(cur, k);
        // 返回反转后的链表头
        return pre;
    }
}
