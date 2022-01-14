package 字符串;

public class zigzagConversion {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            Boolean isSameRound = true;
            int j = i;
            int next=1;
            while (j < s.length()) {
                if (next != 0) {
                    result.append(s.charAt(j));
                }
                next = isSameRound? (numRows - 1 - i) * 2:i * 2;
                isSameRound = !isSameRound;
                j += next;
            }
        }
        return result.toString();
    }
}
