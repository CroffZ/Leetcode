package cn.croff.twopointers;

/**
 * 27. Remove Element
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2) {
            if (nums[p1] == val) {
                if (nums[p2] == val) {
                    p2--;
                } else {
                    int temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                }
            } else {
                p1++;
            }
        }
        if (nums[p1] == val) {
            return p1;
        } else {
            return p1 + 1;
        }
    }
}
