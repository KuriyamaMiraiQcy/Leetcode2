package 数组;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int num:count.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new int[]{num, count.get(num)});
            } else {
                int[] top = minHeap.peek();
                if (count.get(num) > top[1]) {
                    minHeap.poll();
                    minHeap.add(new int[]{num, count.get(num)});
                }
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >=0 ; i--) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
