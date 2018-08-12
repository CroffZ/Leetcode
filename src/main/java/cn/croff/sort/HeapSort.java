package cn.croff.sort;

/**
 * 堆排序
 */
public class HeapSort {

    public static void heapSort(int[] array) {
        // 构建最大堆
        for (int i = 1; i < array.length; i++) {
            int index = i;
            do {
                int parentIndex = (index - 1) / 2;
                if (array[parentIndex] < array[index]) {
                    int temp = array[index];
                    array[index] = array[parentIndex];
                    array[parentIndex] = temp;
                }
                index = parentIndex;
            }
            while (index > 0);
        }

        // 交换结点和调整
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            int index = 0;
            while (true) {
                int leftIndex = 2 * index + 1, rightIndex = 2 * index + 2;
                int leftValue = Integer.MIN_VALUE, rightValue = Integer.MIN_VALUE;
                if (leftIndex < i) {
                    leftValue = array[leftIndex];
                }
                if (rightIndex < i) {
                    rightValue = array[rightIndex];
                }
                if (leftValue > rightValue && leftValue > array[index]) {
                    temp = array[leftIndex];
                    array[leftIndex] = array[index];
                    array[index] = temp;
                    index = leftIndex;
                } else if (rightValue > leftIndex && rightValue > array[index]) {
                    temp = array[rightIndex];
                    array[rightIndex] = array[index];
                    array[index] = temp;
                    index = rightIndex;
                } else {
                    break;
                }
            }
        }
    }
}
