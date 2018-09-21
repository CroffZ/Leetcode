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

    public ListNode sortList(ListNode head) {
        quickSortLinkedList(head, null);
        return head;
    }

    private void quickSortLinkedList(ListNode head, ListNode tail) {
        // 递归终止条件
        if (head == null || head == tail) return;
        // 选取头结点为基准数，再设置一个分界结点
        ListNode split = head, cur = head.next;
        while (cur != tail) {
            // 遍历到尾结点
            if (cur.val < head.val) {
                // 如果当前结点小于基准数，就与分界结点交换，分界结点右移
                split = split.next;
                swapValue(cur, split);
            }
            cur = cur.next;
        }
        // 最后要把头结点和分界结点交换，就是把基准数放到正确的位置上
        swapValue(head, split);
        // 递归处理分界结点左右两边的链表
        quickSortLinkedList(head, split);
        quickSortLinkedList(split.next, tail);
    }

    private void swapValue(ListNode node1, ListNode node2) {
        // 为了方便，这里直接交换结点的值
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
