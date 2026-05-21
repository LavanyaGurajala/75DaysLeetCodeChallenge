class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    // Insert word into Trie
    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int i, int j,
                    TrieNode node, List<String> result) {

        // Boundary check
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length) {
            return;
        }

        char c = board[i][j];

        // Visited cell or character not in Trie
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];

        // Word found
        if (node.word != null) {
            result.add(node.word);

            // Avoid duplicates
            node.word = null;
        }

        // Mark visited
        board[i][j] = '#';

        // Explore 4 directions
        dfs(board, i + 1, j, node, result);
        dfs(board, i - 1, j, node, result);
        dfs(board, i, j + 1, node, result);
        dfs(board, i, j - 1, node, result);

        // Backtrack
        board[i][j] = c;
    }
}