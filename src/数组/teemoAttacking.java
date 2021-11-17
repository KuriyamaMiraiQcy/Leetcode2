package 数组;

public class teemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = duration;
        int previous = timeSeries[0] + duration;

        for (int i = 1; i < timeSeries.length; i++) {
            int next = timeSeries[i] + duration;
            if (timeSeries[i] >= previous) {
                count += duration;
            } else {
                count += next - previous;
            }
            previous = next;
        }
        return count;
    }
}
