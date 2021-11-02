package 数组;

import java.util.*;

public class threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) {
            return res;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> set = count.keySet();
        for (int i:set) {
            if (i > 0) {
                break;
            }
            count.put(i, count.get(i) - 1);
            for (int j:set) {
                if (i <=j && count.get(j) > 0) {
                    count.put(j, count.get(j) - 1);
                    if(count.getOrDefault(-i-j, 0) > 0 && j <= -i-j) {
                        List<Integer> result = new LinkedList<>();
                        result.add(i);
                        result.add(j);
                        result.add(-i - j);
                        res.add(result);
                    }
                    count.put(j, count.get(j) + 1);
                }
            }
            count.put(i, count.get(i) + 1);
        }
        return res;
    }

    public static List<List<Integer>> ThreeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
}
