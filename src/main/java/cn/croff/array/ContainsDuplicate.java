package cn.croff.array;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 2, 8};
        System.out.println(new ContainsDuplicate().containsDuplicate(array));
    }
}
