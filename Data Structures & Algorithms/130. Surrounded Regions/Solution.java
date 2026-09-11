// Similar to 417. Pacific Atlantic Water Flow
// 
// Visit all the 'O's on the border and mark them as visited. Then, 
// traverse the entire board and mark all unvisited 'O's as 'X's. 
// The visited 'O's are not surrounded by 'X's, so we keep them as 'O's.
// 
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
class Solution {

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(board, visited, i, 0, board[i][0]);
            dfs(board, visited, i, cols-1, board[i][cols-1]);
        }

        for (int i = 0; i < cols; i++) {
            dfs(board, visited, 0, i, board[0][i]);
            dfs(board, visited, rows-1, i, board[rows-1][i]);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]) board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col, char prevChar) {
        if (
            prevChar == 'X' || 
            row < 0 || col < 0 || row >= board.length || col >= board[row].length || 
            board[row][col] == 'X' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        dfs(board, visited, row + 1, col, board[row][col]);
        dfs(board, visited, row - 1, col, board[row][col]);
        dfs(board, visited, row, col + 1, board[row][col]);
        dfs(board, visited, row, col - 1, board[row][col]);
    }

}
