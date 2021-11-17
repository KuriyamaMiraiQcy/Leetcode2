package 树;

public class isValidBST {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isValid = true;
        if (root.left != null) {
            isValid = isValid && root.val > root.left.val && isValidBST(root.left);
        }
        if (prev == null) {
            prev = root;
        } else {
            isValid = isValid && prev.val < root.val;
            prev = root;
        }
        if (root.right != null) {
            isValid = isValid && root.val < root.right.val && isValidBST(root.right);
        }

        return isValid;
    }
}
