package cn.croff.array;

/**
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 把两个数组合并成一个排好序的新数组
        int length = nums1.length + nums2.length;
        int[] nums3 = new int[length];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < length; i++) {
            if (index1 >= nums1.length) {
                // nums1的数已经取完，直接取nums2的数
                nums3[i] = nums2[index2];
                index2++;
            } else if (index2 >= nums2.length) {
                // nums2的数已经取完，直接取nums1的数
                nums3[i] = nums1[index1];
                index1++;
            } else {
                // nums1和nums2的数都没取完，要比较大小
                if (nums1[index1] >= nums2[index2]) {
                    nums3[i] = nums2[index2];
                    index2++;
                } else {
                    nums3[i] = nums1[index1];
                    index1++;
                }
            }
        }
        // 计算新数组的中位数
        if (length % 2 == 0) {
            return ((double) (nums3[length / 2] + nums3[length / 2 - 1])) / 2;
        } else {
            return nums3[length / 2];
        }
    }
}
