package cn.croff.sort;

/**
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length > 0) {
            mergeSort(array, 0, array.length);
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        // Divide
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);

        // Merge
        int i = start, j = mid;
        while (i < j && j < end) {
            if (array[i] > array[j]) {
                int temp = array[j];
                System.arraycopy(array, i, array, i + 1, j - i);
                array[i] = temp;
                j++;
            }
            i++;
        }
    }
}
