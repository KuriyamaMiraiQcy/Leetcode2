package 字符串;

import java.util.Stack;

public class simplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        stack.push("/");
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].length() == 0 || paths[i].equals(".") || paths[i].equals("...")) {
                continue;
            }
            if (paths[i].equals("..")) {
                if (stack.size()> 1) {
                    stack.pop();
                }
            } else {
                stack.push(paths[i]);
            }
        }
        String result  = "";
        while (stack.size() > 1) {
            result = "/" + stack.pop() + result;
        }
        return result.length() ==0?"/":result;
    }
}
