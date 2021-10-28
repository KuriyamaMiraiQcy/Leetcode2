package 动态规划;

public class decodeways {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int first = 1;
        int next = 1;
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            int tmp = 0;
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (current != '0') {
                tmp = next;
            }
            if (s.charAt(i - 1) != '0' && num <= 26) {
                tmp += first;
            }
            if (tmp == 0) {
                return 0;
            }
            first = next;
            next = tmp;
        }
        return next;
    }
    public static void main(String[] args) {
        decodeways a = new decodeways();
        System.out.print(a.numDecodings("221012"));
    }
}
