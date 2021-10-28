package 字符串;

public class validPalindrome2 {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, 0);
    }

    private boolean validPalindrome(String s, int begin, int end, int deleteCount) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                if (deleteCount == 1) {
                    return false;
                }
                return validPalindrome(s, begin + 1, end, deleteCount + 1) || validPalindrome(s, begin, end - 1, deleteCount + 1);
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        validPalindrome2 a = new validPalindrome2();
        System.out.print(a.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
