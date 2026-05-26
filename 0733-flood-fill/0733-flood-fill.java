class Solution {

    int rows, cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        rows = image.length;
        cols = image[0].length;

        int original = image[sr][sc];

        // Edge case
        if (original == color) {
            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c,
                     int original, int color) {

        // Out of bounds
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        // Different color
        if (image[r][c] != original) {
            return;
        }

        // Paint new color
        image[r][c] = color;

        // 4 directions
        dfs(image, r + 1, c, original, color);
        dfs(image, r - 1, c, original, color);
        dfs(image, r, c + 1, original, color);
        dfs(image, r, c - 1, original, color);
    }
}