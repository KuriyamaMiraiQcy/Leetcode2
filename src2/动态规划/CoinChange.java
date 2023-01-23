package 动态规划;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.sort(coins);

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0) {
                for (int j = 0; j < coins.length; j++) {
                    if (i + coins[j] < 0 || i + coins[j] > amount) {
                        break;
                    }
                    if (dp[i + coins[j]] == 0) {
                        dp[i + coins[j]] = dp[i] + 1;
                    } else {
                        dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                    }
                }
            }
        }
        return dp[amount] > 0 ? dp[amount] : -1;
    }
}
