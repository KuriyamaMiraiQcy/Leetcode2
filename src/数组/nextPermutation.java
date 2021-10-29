package 数组;

import java.util.Arrays;

public class nextPermutation {
    public void nextPermutation(int[] nums) {
        int end = nums.length - 2;
        while (end >= 0) {
            if (nums[end] < nums[end + 1]) {
                break;
            }
            end--;
        }
        if (end < 0) {
            Arrays.sort(nums);
            return;
        }
        int index;
        for (index = nums.length - 1; index >= 0; index--) {
            if (nums[index] > nums[end]) {
                break;
            }
        }
        int temp = nums[end];
        nums[end] = nums[index];
        nums[index] = temp;
        Arrays.sort(nums, end + 1, nums.length);
    }
}
