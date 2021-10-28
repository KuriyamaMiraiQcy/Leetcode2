package 字符串;

public class validPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            if (isAlphabet(s.charAt(start)) && isAlphabet(s.charAt(end))) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            if (!isAlphabet(s.charAt(start))) {
                start++;
            }
            if (!isAlphabet(s.charAt(end))) {
                end--;
            }
        }
        return true;
    }

    private boolean isAlphabet(char ch) {
        return ch>='a' && ch <= 'z' || ch >= '0' && ch <= '9';
    }
}
