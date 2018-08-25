package cn.croff.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    public ListNode mergeKListsUsingPriorityQueue(ListNode[] lists) {
        // 使用PriorityQueue来实现，效率低
        if (lists == null || lists.length == 0) return null;
        // 建立最小堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) heap.offer(list);
        }
        // 循环把堆顶元素取出
        ListNode head = null, current = null;
        while (heap.peek() != null) {
            ListNode node = heap.poll();
            if (head == null) {
                head = current = node;
            } else {
                current.next = node;
                current = current.next;
            }
            node = node.next;
            if (node != null) heap.offer(node);
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 不用PriorityQueue来实现，效率高
        if (lists == null || lists.length == 0) return null;
        // 建立最小堆
        ListNode[] heap = new ListNode[lists.length];
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap[index] = lists[i];
                up(heap, index);
                index++;
            }
        }
        ListNode head = null, current = null;
        // 循环把堆顶元素取出
        while (heap[0] != null) {
            if (head == null) {
                head = current = heap[0];
            } else {
                current.next = heap[0];
                current = current.next;
            }
            heap[0] = heap[0].next;
            down(heap);
        }
        return head;
    }

    private void up(ListNode[] lists, int index) {
        // 上浮操作
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (lists[parent] == null || lists[index].val < lists[parent].val) {
                swap(lists, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void down(ListNode[] lists) {
        // 下沉操作
        int index = 0;
        while (index < lists.length) {
            int left = 2 * index + 1, right = 2 * index + 2;
            if (left < lists.length && right < lists.length) {
                if (lists[left] == null && lists[right] == null) {
                    break;
                } else if (lists[left] == null) {
                    if (lists[index] == null || lists[right].val < lists[index].val) {
                        swap(lists, index, right);
                        index = right;
                    } else {
                        break;
                    }
                } else if (lists[right] == null) {
                    if (lists[index] == null || lists[left].val < lists[index].val) {
                        swap(lists, index, left);
                        index = left;
                    } else {
                        break;
                    }
                } else {
                    if (lists[left].val <= lists[right].val && (lists[index] == null || lists[left].val < lists[index].val)) {
                        swap(lists, index, left);
                        index = left;
                    } else if (lists[right].val < lists[left].val && (lists[index] == null || lists[right].val < lists[index].val)) {
                        swap(lists, index, right);
                        index = right;
                    } else {
                        break;
                    }
                }
            } else if (left < lists.length && lists[left] != null && (lists[index] == null || lists[left].val < lists[index].val)) {
                swap(lists, index, left);
                index = left;
            } else if (right < lists.length && lists[right] != null && (lists[index] == null || lists[right].val < lists[index].val)) {
                swap(lists, index, right);
                index = right;
            } else {
                break;
            }
        }
    }

    private void swap(ListNode[] lists, int i, int j) {
        // 交换元素
        ListNode temp = lists[i];
        lists[i] = lists[j];
        lists[j] = temp;
    }
}
