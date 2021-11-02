package 动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>();
        boolean[] dp = new boolean[s.length() + 1];
        for (String word:wordDict) {
            dictionary.add(word);
        }
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dictionary.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
