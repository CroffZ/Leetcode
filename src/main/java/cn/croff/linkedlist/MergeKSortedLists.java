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
        // 循环把堆顶元素取出，再把其next放回堆中
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
        // 建立最小堆，依次在末尾添加节点后上浮
        ListNode[] heap = new ListNode[lists.length];
        int index = 0;
        for (ListNode list : lists) {
            if (list != null) {
                heap[index] = list;
                up(heap, index);
                index++;
            }
        }
        ListNode result = null, current = null;
        // 循环把堆顶元素取出后放入结果链表，然后把堆顶元素指向其next后下沉
        while (heap[0] != null) {
            if (result == null) {
                result = current = heap[0];
            } else {
                current.next = heap[0];
                current = current.next;
            }
            heap[0] = heap[0].next;
            down(heap);
        }
        return result;
    }

    /**
     * 上浮操作
     *
     * @param heap  最小堆
     * @param index 从指定index开始上浮
     */
    private void up(ListNode[] heap, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] == null || heap[index].val < heap[parent].val) {
                // 如果父节点为null或父节点的值大于当前节点的值，就把当前节点与父节点交换，然后把当前节点设为父节点
                swap(heap, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    /**
     * 下沉操作
     *
     * @param heap 最小堆
     */
    private void down(ListNode[] heap) {
        // 从堆顶开始下沉
        int index = 0;
        while (index < heap.length) {
            // 计算左右两个子节点的下标
            int left = 2 * index + 1, right = 2 * index + 2;
            if (left < heap.length && right < heap.length) {
                // 左右子节点都在数组范围内
                if (heap[left] == null && heap[right] == null) {
                    // 左右子节点都为null
                    break;
                } else if (heap[left] == null) {
                    // 左子节点为null时，如果当前节点为null或当前节点的值小于右子节点的值，就交换当前节点和右子节点
                    if (heap[index] == null || heap[right].val < heap[index].val) {
                        swap(heap, index, right);
                        index = right;
                    } else {
                        break;
                    }
                } else if (heap[right] == null) {
                    // 右子节点为null时，如果当前节点为null或当前节点的值小于左子节点的值，就交换当前节点和左子节点
                    if (heap[index] == null || heap[left].val < heap[index].val) {
                        swap(heap, index, left);
                        index = left;
                    } else {
                        break;
                    }
                } else {
                    // 左右子节点都不为null，需要找出左右节点中值较小的，并且也小于当前节点的，或当前节点为null，要与当前节点交换
                    if (heap[left].val <= heap[right].val && (heap[index] == null || heap[left].val < heap[index].val)) {
                        swap(heap, index, left);
                        index = left;
                    } else if (heap[right].val < heap[left].val && (heap[index] == null || heap[right].val < heap[index].val)) {
                        swap(heap, index, right);
                        index = right;
                    } else {
                        break;
                    }
                }
            } else if (left < heap.length && heap[left] != null && (heap[index] == null || heap[left].val < heap[index].val)) {
                // 左子节点在数组范围内，并且不为null，如果当前节点为null或当前节点的值小于左子节点的值，就交换当前节点和左子节点
                swap(heap, index, left);
                index = left;
            } else if (right < heap.length && heap[right] != null && (heap[index] == null || heap[right].val < heap[index].val)) {
                // 右子节点在数组范围内，并且不为null，如果当前节点为null或当前节点的值小于右子节点的值，就交换当前节点和右子节点
                swap(heap, index, right);
                index = right;
            } else {
                break;
            }
        }
    }

    private void swap(ListNode[] lists, int i, int j) {
        ListNode temp = lists[i];
        lists[i] = lists[j];
        lists[j] = temp;
    }
}
