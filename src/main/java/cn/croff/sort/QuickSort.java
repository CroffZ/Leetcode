package cn.croff.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        if (array.length > 0) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        boolean fromStartToEnd = false;
        int left = start, right = end;
        int pivot = array[left];
        while (left < right) {
            if (fromStartToEnd) {
                if (array[left] > pivot) {
                    array[right] = array[left];
                    array[left] = pivot;
                    fromStartToEnd = false;
                    right--;
                } else {
                    left++;
                }
            } else {
                if (array[right] < pivot) {
                    array[left] = array[right];
                    array[right] = pivot;
                    fromStartToEnd = true;
                    left++;
                } else {
                    right--;
                }
            }
        }
        if (left > start) {
            quickSort(array, start, left - 1);
        }
        if (left < end) {
            quickSort(array, left + 1, end);
        }
    }
}
