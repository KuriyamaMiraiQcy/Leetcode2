package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    Map<Integer, char[]> map = new HashMap<>();
    char[] two = {'a', 'b','c'};
    char[] three = {'d','e','f'};
    char[] four = {'g','h', 'i'};
    char[] five = {'j','k','l'};
    char[] six = {'m','n', 'o'};
    char[] seven = {'p','q','r','s'};
    char[] eight = {'t','u','v'};
    char[] nine = {'w','x','y','z'};
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put(2, two);
        map.put(3, three);
        map.put(4, four);
        map.put(5, five);
        map.put(6, six);
        map.put(7, seven);
        map.put(8, eight);
        map.put(9, nine);
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb);
        return result;
    }

    private void dfs(String digits, int location, StringBuilder current) {
        if (location >= digits.length()) {
            if (!current.toString().equals("")) {
                result.add(current.toString());
            }
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(location));
        for (char letter:map.get(digit)) {
            current.append(letter);
            dfs(digits, location + 1, current);
            current.deleteCharAt(location);
        }
    }
}
