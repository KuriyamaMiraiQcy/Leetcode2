package 数组;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SparseVector {
    Map<Integer, Integer> vec;
    SparseVector(int[] nums) {
        vec = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                vec.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for (int index:this.vec.keySet()) {
            if (vec.vec.containsKey(index)) {
                sum += this.vec.get(index) * vec.vec.get(index);
            }
        }
        return sum;
    }
}
