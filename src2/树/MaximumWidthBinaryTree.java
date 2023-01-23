package 树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MaximumWidthBinaryTree {
    Map<Integer, Integer> level = new HashMap<>();
    int result = 0;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        return result;
    }

    private void dfs(TreeNode node, int dep, int num) {
        if (node == null) {
            return;
        }
        if (!level.containsKey(dep)) {
            level.put(dep, num);
        }
        result = Math.max(result, num - level.get(dep));
        dfs(node.left, dep + 1, num * 2);
        dfs(node.right, dep + 1, num * 2 + 1);
    }
}
