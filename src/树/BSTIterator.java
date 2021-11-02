package 树;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {
    List<Integer> result = new LinkedList<>();
    Iterator<Integer> iterator;
    public BSTIterator(TreeNode root) {
        inOrderTraverse(root);
        iterator = result.iterator();
    }

    private void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        result.add(root.val);
        inOrderTraverse(root.right);
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
