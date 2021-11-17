package 数组;

import java.util.List;
import java.util.Stack;

public class exclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int count = 0;
        for (String log:logs) {
            String[] record = log.split(":");
            int index = Integer.parseInt(record[0]);
            int time = Integer.parseInt(record[2]);
            if (record[1].equals("start")) {
                stack.push(time);
            }
            if (record[1].equals("end")) {
                int start = stack.pop();
                int selfTime = time + 1 -start - count > 0?time + 1 -start - count:time + 1 -start;
                result[index] += selfTime;
                count += selfTime;
            }
        }
        return result;
    }
}
