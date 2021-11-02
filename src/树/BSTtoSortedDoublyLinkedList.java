package 树;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BSTtoSortedDoublyLinkedList {
    Map<Integer, Node> map = new TreeMap<>();
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        preOrderTraverse(root);
        Integer[] valueArray = map.keySet().toArray(new Integer[1]);

        for (int i = 1; i < valueArray.length - 1; i++) {
            map.get(valueArray[i]).left = map.get(valueArray[i - 1]);
            map.get(valueArray[i]).right = map.get(valueArray[i + 1]);
        }
        map.get(valueArray[0]).left = map.get(valueArray[valueArray.length - 1]);
        map.get(valueArray[0]).right = map.get(valueArray[valueArray.length > 1?1:0]);
        map.get(valueArray[valueArray.length - 1]).left = map.get(valueArray[valueArray.length > 1?valueArray.length - 2:0]);
        map.get(valueArray[valueArray.length - 1]).right = map.get(valueArray[0]);
        return map.get(valueArray[0]);
    }

    private void preOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        preOrderTraverse(root.left);
        map.put(root.val, root);
        preOrderTraverse(root.right);
    }

    Node first = null;
    Node last = null;

    public void helper(Node node) {
        if (node != null) {
            // left
            helper(node.left);
            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            }
            else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            last = node;
            // right
            helper(node.right);
        }
    }

    public Node TreeToDoublyList(Node root) {
        if (root == null) return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }
}
