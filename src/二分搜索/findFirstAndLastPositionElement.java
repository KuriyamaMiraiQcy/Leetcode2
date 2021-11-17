package 二分搜索;

public class findFirstAndLastPositionElement {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        int start = findFirstElementLarger(nums, target - 1);
        int end = findFirstElementLarger(nums, target);
        if (nums[start] == target) {
            result[0] = start;
            result[1] = nums[end] == target?end:end - 1;
            return result;
        }
        return result;
    }

    private int findFirstElementLarger(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
