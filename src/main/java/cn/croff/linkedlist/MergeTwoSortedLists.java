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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null, current = null;
        // 当l1和l2都不为null时进入比较
        while (l1 != null && l2 != null) {
            // 得出l1和l2中较小的那个值
            int num;
            if (l1.val >= l2.val) {
                num = l2.val;
                l2 = l2.next;
            } else {
                num = l1.val;
                l1 = l1.next;
            }
            // 把这个值添加进结果链表
            if (current == null) {
                result = new ListNode(num);
                current = result;
            } else {
                current.next = new ListNode(num);
                current = current.next;
            }
        }
        // 把剩下未处理的l1或l2接到结果链表的尾部
        if (l1 == null) {
            if (result == null) return l2;
            else current.next = l2;
        }
        if (l2 == null) {
            if (result == null) return l1;
            else current.next = l1;
        }
        return result;
    }
}
