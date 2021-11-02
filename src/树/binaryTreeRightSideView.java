package 树;

import java.util.*;

public class binaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> traverse = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        traverse.add(root);
        traverse.add(dummy);
        while (!traverse.isEmpty()) {
            TreeNode top = traverse.poll();
            if (top.equals(dummy)) {
                if (!traverse.isEmpty()) {
                    traverse.add(dummy);
                    continue;
                } else {
                    break;
                }
            }
            if (traverse.peek().equals(dummy)) {
                result.add(top.val);
            }
            if (top.left!= null) {
                traverse.add(top.left);
            }
            if (top.right!= null) {
                traverse.add(top.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        binaryTreeRightSideView a =new binaryTreeRightSideView();
        TreeNode root = new TreeNode(1,null, new TreeNode(3));
        System.out.print(a.rightSideView(root));
    }
}
