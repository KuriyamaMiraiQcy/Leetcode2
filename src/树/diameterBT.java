package 树;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class diameterBT {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode t) {
        if (t.left == null && t.right == null) {
            return 0;
        }
        int left = 0;
        if (t.left != null) {
            left = depth(t.left);
        }
        int right = 0;
        if (t.right != null) {
            right = depth(t.right);
        }
        int maxDepth = Math.max(left, right) + 1;
        int leftConn = t.left == null?0:1;
        int rightConn = t.right == null?0:1;

        max = Math.max(max, left + right + leftConn + rightConn);
        return maxDepth;
    }
}
