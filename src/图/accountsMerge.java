package 图;

import java.util.*;

public class accountsMerge {
    HashMap<String, Integer> emailToIndex = new HashMap<>();
    HashMap<Integer, String> indexToName = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            indexToName.put(i, account.get(0));
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToIndex.containsKey(email)) {
                    union(parent, i, emailToIndex.get(email));
                } else {
                    emailToIndex.put(email, i);
                }
            }
        }

        HashMap<Integer, Set<String>> result = new HashMap<>();
        Set<Integer> roots = new TreeSet<>();
        for (int i = 0; i < parent.length; i++) {
            int root = find(parent, i);
            roots.add(root);
            Set<String> mergedAccount = result.getOrDefault(root, new TreeSet<>());
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                mergedAccount.add(account.get(j));
            }
            result.put(root, mergedAccount);
        }

        List<List<String>> res = new ArrayList<>();
        for (int root:roots) {
            List<String> account = new ArrayList<>();
            account.add(indexToName.get(root));
            account.addAll(result.get(root));
            res.add(account);
        }
        return res;
    }

    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        parent[rootI]  =rootJ;
    }

    private int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return index;
    }
}
