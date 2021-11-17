package 树;

public class lowestCommonAncestor {
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return lca;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (left && right || (root.val == p.val || root.val == q.val) && (left||right)) {
            lca = root;
        }
        return root.val == p.val || root.val == q.val || left || right;
    }
}
