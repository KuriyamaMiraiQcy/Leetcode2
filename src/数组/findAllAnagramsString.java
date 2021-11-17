package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findAllAnagramsString {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> result = new ArrayList<>();
        if (m < n) {
            return result;
        }
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int[] window = new int[26];
        for (int i = 0; i < m; i++) {
            window[s.charAt(i) - 'a']++;
            while (window[s.charAt(i)-'a']>count[s.charAt(i)-'a']) {
                window[s.charAt(left)-'a']--;
                left++;
            }
            if (i - left + 1 == n) {
                result.add(left);
            }
        }
        return result;
    }
}
