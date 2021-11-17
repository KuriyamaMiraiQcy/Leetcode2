package 数组;

public class buySellStock {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int[] max = new int[prices.length];
        min[0] = prices[0];
        max[prices.length - 1] = prices[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i - 1], prices[i]);
            max[prices.length - i - 1] = Math.max(max[prices.length - i], prices[prices.length - i - 1]);
        }

        int outcome = 0;
        for (int i = 0; i < min.length; i++) {
            outcome = Math.max(outcome, max[i] - min[i]);
        }
        return outcome;
    }

    public int MaxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
