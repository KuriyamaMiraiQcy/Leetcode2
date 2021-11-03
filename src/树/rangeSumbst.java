package 树;

public class rangeSumbst {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return traverse(root, low, high, 0);
    }

    private int traverse(TreeNode root, int low, int high, int sum) {
        if (root == null) {
            return sum;
        }
        int leftSum = traverse(root.left, low, high, sum);
        int rightSum = traverse(root.right, low, high, sum);
        if (root.val >= low && root.val <= high) {
            leftSum += root.val;
        }
        return leftSum + rightSum;
    }
}
