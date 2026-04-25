class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    // Search word (with '.' support)
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if(node == null) return false;

        if(i == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(i);

        if(c == '.') {
            for(int j = 0; j < 26; j++) {
                if(node.children[j] != null && dfs(word, i + 1, node.children[j])) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, i + 1, node.children[c - 'a']);
        }
    }
}