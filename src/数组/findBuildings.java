package 数组;

import java.util.LinkedList;
import java.util.List;

public class findBuildings {
    public int[] findBuildings(int[] heights) {
        int max = heights[heights.length - 1];
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = heights.length - 2; i >= 0; i++) {
            if (heights[i] > max) {
                res.addFirst(i);
                max = heights[i];
            }
        }
        int[] result = new int[res.size() + 1];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.pollFirst();
        }
        result[result.length - 1] = heights.length - 1;
        return result;
    }
}
