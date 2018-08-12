package cn.croff.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertNum = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (insertNum < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = insertNum;
                    break;
                }
                if (j == 0) {
                    array[0] = insertNum;
                }
            }
        }
    }
}
