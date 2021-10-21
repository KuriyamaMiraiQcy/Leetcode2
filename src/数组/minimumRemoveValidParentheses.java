package 数组;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class minimumRemoveValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(c);
                //正括号数 + 1
                count++;
            }
            else if (c == ')') {
                if (count > 0 ){
                    //有正括号， 所以合法，把 ")"加到 sb里
                    sb.append(c);
                    //抵消了一个正括号，正括号 - 1
                    count--;
                }
                //如果没有正括号，说明 ")" 不合法， 什么也不做
            }else sb.append(c); //字母正常输出

        }
        //如果没有多余的正括号，返回结果
        if (count == 0) return sb.toString();

        //如果有多余的正括号， 那就反向遍历删除多余的正括号。因为是反向便利，删除多的任意count个正括号仍然合法。
        //这也是为啥Example 1 有多个解
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (count == 0) break;
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        minimumRemoveValidParentheses a = new minimumRemoveValidParentheses();
        System.out.print(a.minRemoveToMakeValid("a)b(c)d"));
    }
}
