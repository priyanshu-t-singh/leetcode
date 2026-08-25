// Time Complexity: O(1) - The board size is fixed (9x9), so the time complexity is constant.
// Space Complexity: O(1) - The space complexity is constant because the size of the visited array is fixed.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Horizontal
        for (int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (visited[ch-'1']) return false;
                    visited[ch-'1'] = true;
                }
            }
        }

        // Vertical
        for (int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];
                if (ch != '.') {
                    if (visited[ch-'1']) return false;
                    visited[ch-'1'] = true;
                }
            }
        }

        // Grid by Grid
        for (int i = 0; i < 9; i++) {
            int offsetRow = i / 3;
            int offsetCol = i % 3;
            boolean[] visited = new boolean[9];
            for (int j = 0; j < 9; j++) {
                int row = offsetRow * 3 + j / 3;
                int col = offsetCol * 3 + j % 3;
                char ch = board[row][col];
                if (ch != '.') {
                    if (visited[ch-'1']) return false;
                    visited[ch-'1'] = true;
                }
            }
        }

        return true;
    }
}
