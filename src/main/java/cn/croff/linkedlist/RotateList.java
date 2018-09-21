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

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        // 先计算链表长度，用于处理k大于等于链表长度的情况
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        k = k % length;
        if (k == 0) return head;
        // 用快慢指针找出倒数第k个结点
        ListNode slowPre = head, slow = head, fastPre = head, fast = head;
        // 快指针先走k步
        for (int i = 0; i < k; i++) {
            fastPre = fast;
            fast = fast.next;
        }
        // 快慢指针一起走，直到快指针走到尾
        while (fast != null) {
            slowPre = slow;
            slow = slow.next;
            fastPre = fast;
            fast = fast.next;
        }
        // 把慢指针开始的结点移到链表头
        slowPre.next = null;
        fastPre.next = head;
        // 慢指针就是新的链表头
        return slow;
    }
}
