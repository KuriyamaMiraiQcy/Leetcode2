package 树;

public class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie dummy = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (dummy.children[ch - 'a'] == null) {
                dummy.children[ch - 'a'] = new Trie();
            }
            dummy = dummy.children[ch - 'a'];
        }
        dummy.isLeaf = true;
    }

    public boolean search(String word) {
        Trie dummy = root;
        return searchHelper(word, dummy, 0);
    }

    class Trie{
        boolean isLeaf;
        Trie[] children = new Trie[26];
    }

    private boolean searchHelper(String word, Trie root, int index) {
        if (index == word.length()) {
            return root.isLeaf;
        }

        char ch = word.charAt(index);
        if (ch != '.') {
            if (root.children[ch - 'a'] == null) {
                return false;
            }
            return searchHelper(word, root.children[ch - 'a'], index + 1);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                if (searchHelper(word, root.children[i], index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary a =new WordDictionary();
        a.addWord("bad");
        a.addWord("mad");
        a.addWord("dad");
        System.out.print(a.search("pad"));
        System.out.print(a.search(".ad"));
        System.out.print(a.search("b.."));
    }
}




