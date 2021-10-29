package 数组;

import java.util.Arrays;
import java.util.Comparator;

public class meetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i]  =intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int endTime = 0;

        for (int startTime = 0; startTime < start.length; startTime++) {
            if (start[startTime] >= end[endTime]) {
                endTime++;
                count--;
            }
            count++;
        }
        return count;
    }
}
