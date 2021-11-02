package 树;

import java.util.*;

public class binaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, Integer> columns = new HashMap<>();
        Map<Integer, List<Integer>> result = new TreeMap<>();
        queue.add(root);
        columns.put(root,  100);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            int column = columns.get(top);
            List<Integer> columnList = result.getOrDefault(column, new ArrayList<>());
            columnList.add(top.val);
            result.put(column, columnList);
            if (top.left != null) {
                queue.add(top.left);
                columns.put(top.left, column - 1);
            }
            if (top.right != null) {
                queue.add(top.right);
                columns.put(top.right, column + 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int key:result.keySet()) {
            res.add(result.get(key));
        }
        return res;
    }
}
