package 数组;

import java.util.Stack;

public class addBinary {
    public String AddBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public String addBinary(String a, String b) {
        int startIndexA = a.length() - 1;
        int startIndexB = b.length() - 1;

        Stack<Character> res = new Stack<>();

        boolean isExtra = false;
        while (startIndexA >=0 || startIndexB >= 0) {
            char first = '0';
            char next = '0';
            if (startIndexA >= 0) {
                first = a.charAt(startIndexA);
            }
            if (startIndexB >= 0) {
                next = b.charAt(startIndexB);
            }
            startIndexA--;
            startIndexB--;
            if (first == '0' && next == '0') {
                if (isExtra) {
                    res.push('1');
                } else {
                    res.push('0');
                }
                isExtra = false;
                continue;
            }
            if (first == '1' && next == '1') {
                if (isExtra) {
                    res.push('1');
                } else {
                    res.push('0');
                    isExtra = true;
                }
                continue;
            }
            if ((first == '1' || next == '1') && isExtra) {
                res.push('0');
                continue;
            }
            res.push('1');
            isExtra = false;
        }

        String result = "";
        if (isExtra) {
            result += "1";
        }
        while (!res.isEmpty()) {
            result += res.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        addBinary a = new addBinary();
        System.out.print(a.addBinary("1010", "1011"));
    }
}
