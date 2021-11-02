package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cloneGraph {
    Map<Node, Node> cloneMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        clone(node);
        for (Map.Entry<Node, Node> entry: cloneMap.entrySet()) {
            List<Node> neighbors = new ArrayList<>();
            for (Node neighbor:entry.getKey().neighbors) {
                neighbors.add(cloneMap.get(neighbor));
            }
            entry.getValue().neighbors = neighbors;
        }
        return cloneMap.get(node);
    }

    private void clone(Node node) {
        if (cloneMap.containsKey(node)) {
            return;
        }
        Node newNode = new Node(node.val);
        cloneMap.put(node, newNode);
        for (Node neighbor:node.neighbors) {
            clone(neighbor);
        }
    }
}
