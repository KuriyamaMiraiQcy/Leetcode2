package 字符串;

public class addStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(l1, l2); i++) {
            int position1 = 0;
            int position2 = 0;
            if (l1 - 1 - i >= 0) {
                position1 = num1.charAt(l1 -1 -i) - '0';
            }
            if (l2 - 1 - i >= 0) {
                position2 = num2.charAt(l2 -1 -i) - '0';
            }
            sb.append((position1 + position2 + carry)%10);
            carry =(position1 + position2 + carry)/10;
        }
        if (carry >0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
