package cn.croff.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    private static int[][] array;

    private static int[][] answers = new int[][]{
            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            new int[]{1, 5, 12, 33, 36, 46, 68, 77, 89, 90},
            new int[]{4, 21, 23, 32, 43, 45, 54, 66, 86, 98}
    };

    @Before
    public void setUp() {
        array = new int[][]{
                new int[]{1, 8, 9, 5, 2, 6, 10, 7, 3, 4},
                new int[]{90, 33, 68, 12, 77, 36, 89, 5, 46, 1},
                new int[]{21, 32, 43, 98, 54, 45, 23, 4, 66, 86}
        };
    }

    @Test
    public void testBubbleSort() {
        for (int i = 0; i < array.length; i++) {
            BubbleSort.bubbleSort(array[i]);
            assertArrayEquals(array[i], answers[i]);
        }
    }

    @Test
    public void testSelectSort() {
        for (int i = 0; i < array.length; i++) {
            SelectSort.selectSort(array[i]);
            assertArrayEquals(array[i], answers[i]);
        }
    }

    @Test
    public void testInsertSort() {
        for (int i = 0; i < array.length; i++) {
            InsertSort.insertSort(array[i]);
            assertArrayEquals(array[i], answers[i]);
        }
    }

    @Test
    public void testMergeSort() {
        for (int i = 0; i < array.length; i++) {
            MergeSort.mergeSort(array[i]);
            assertArrayEquals(array[i], answers[i]);
        }
    }

    @Test
    public void testQuickSort() {
        for (int i = 0; i < array.length; i++) {
            QuickSort.quickSort(array[i]);
            assertArrayEquals(array[i], answers[i]);
        }
    }

    @Test
    public void testHeapSort() {
        for (int i = 0; i < array.length; i++) {
            HeapSort.heapSort(array[i]);
            assertArrayEquals(array[i], answers[i]);
        }
    }
}
