package 二分搜索;

import java.util.Random;

public class randomPickWithWeight {
    int[] sum;
    public void Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1]+w[i];
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int num = random.nextInt(sum[sum.length - 1]);
        int start = 0;
        int end = sum.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sum[mid] <= num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
