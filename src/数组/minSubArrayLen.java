package 数组;

public class minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = nums[0];
        int start = 0, end = 1;
        int minLength = Integer.MAX_VALUE;
        while (end < nums.length) {
            if (currentSum >= target) {
                minLength = Math.min(minLength, end - start);
                currentSum -= nums[start];
                start++;
            } else {
                currentSum += nums[end];
                end++;
            }
        }
        while (currentSum >= target) {
            minLength = Math.min(minLength, end - start);
            currentSum -= nums[start];
            start++;
        }
        return minLength<= nums.length?minLength:0;
    }
}
