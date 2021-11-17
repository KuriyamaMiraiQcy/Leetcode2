package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intervalIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][];
        }
        int first = 0, second = 0;
        List<int[]> result = new ArrayList<>();
        while (first < firstList.length && second < secondList.length) {
            if (firstList[first][0] > secondList[second][1]) {
                second++;
                continue;
            }
            if (firstList[first][1] < secondList[second][0]) {
                first++;
                continue;
            }
            result.add(new int[]{Math.max(firstList[first][0], secondList[second][0]), Math.min(firstList[first][1], secondList[second][1])});
            if (firstList[first][1] == secondList[second][1]) {
                first++;
                second++;
            } else if (firstList[first][1] < secondList[second][1]) {
                first++;
            }else {
                second++;
            }
        }
        return result.toArray(new int[][]{{0,1}});
    }
}
