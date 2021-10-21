package 数组;

public class productArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArray = new int[nums.length];
        prefixArray[0] = 1;
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prefixArray[i] *= right;
            right *= nums[i];
        }
        return prefixArray;
    }
}
