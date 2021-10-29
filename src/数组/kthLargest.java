package 数组;

import java.util.Random;

public class kthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        int pivot = partition(nums, left, right);
        if (pivot == nums.length - k) {
            return nums[pivot];
        }
        return pivot < nums.length - k ? quickSort(nums, pivot + 1, right, k): quickSort(nums, left, pivot - 1, k);
    }

    private int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int pivot = random.nextInt(right - left + 1) + left;
        swap(nums, pivot, right);
        return findPlace(nums, left, right);
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int findPlace(int[] nums, int left, int right) {
        int start = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, start, i);
                start++;
            }
        }
        swap(nums, start, right);
        return start;
    }

    public static void main(String[] args) {
        kthLargest a = new kthLargest();
        System.out.print(a.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
