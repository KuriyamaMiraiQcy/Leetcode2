package 字符串;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class basicCalculator2 {
    int sum = 0;
    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();

        stack.push('+');
        for (int i = 0; i < s.length(); i++) {
            char expr = s.charAt(i);
            if (expr == ' ') {
                continue;
            }
            if (expr == '+' || expr == '-') {
                calculateStack(stack);
            }
            stack.push(expr);
        }
        calculateStack(stack);
        return sum;
    }

    private void calculateStack(Stack<Character> stack) {
        Stack<Character> mulstack = new Stack<>();
        int val = 1;
        while (stack.peek() != '+' && stack.peek() != '-') {
            mulstack.push(stack.pop());
        }
        boolean isMul = true;
        StringBuilder num = new StringBuilder();
        while (!mulstack.isEmpty()) {
            char top = mulstack.pop();
            if (top >= '0' && top <= '9') {
                num.append(top);
                continue;
            }
            val = isMul?val* Integer.parseInt(num.toString()):val/ Integer.parseInt(num.toString());
            isMul = top == '*';
            num = new StringBuilder();
        }
        val = isMul?val* Integer.parseInt(num.toString()):val/ Integer.parseInt(num.toString());
        char operator = stack.pop();
        if (operator == '+') {
            sum += val;
        } else {
            sum-= val;
        }
    }

    public int Calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
