package 字符串;

import java.util.LinkedList;
import java.util.List;

public class multiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num1.length(); i++) {
            sb.append(0);
        }
        for (int i = 0; i < num2.length(); i++) {
            if (num2.charAt(num2.length() - 1 -i) == '0') {
                continue;
            }
            StringBuilder partRes = mul(num1, num2.charAt(num2.length() - 1 -i));
            int carry = 0;
            for (int j = 0; j < partRes.length(); j++) {
                int sum = 0;
                if (i + j >= sb.length()) {
                    sum = Character.getNumericValue(partRes.charAt(j)) + carry;
                    sb.append(sum % 10);
                } else {
                    sum = Character.getNumericValue(partRes.charAt(j)) + Character.getNumericValue(sb.charAt(i + j)) + carry;
                    sb.setCharAt(i + j, (char) (sum % 10 + '0'));
                }
                carry =  sum / 10;
            }
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString().replaceFirst ("^0*", "");
    }

    private StringBuilder mul(String num, char ch) {
        StringBuilder sb = new StringBuilder();
        int multiply = Character.getNumericValue(ch);
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int sum = Character.getNumericValue(num.charAt(i)) * multiply  +carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        sb.append(carry);
        return sb;
    }

    public String Multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m+n];
        for(int i=m-1;i>=0;i--){
            int x = num1.charAt(i) - '0';
            for(int j=n-1;j>=0;j--){
                int y = num2.charAt(j) - '0';
                arr[i+j+1] += x*y;
            }
        }
        for(int i=n+m-1;i>0;i--){
            arr[i-1] = arr[i-1] + arr[i]/10;
            arr[i] = arr[i]%10;
        }
        int start=arr[0]==0?1:0;
        StringBuilder res = new StringBuilder();
        while(start<n+m){
            res.append(arr[start]);
            start++;
        }
        return res.toString();
    }
}
