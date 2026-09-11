// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
// Space Complexity: O(m * n) for the visited array, and O(m * n) for the recursion stack in the worst case.
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid, visited, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length ||
            grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        return 1 + dfs(grid, visited, row + 1, col) +
            dfs(grid, visited, row - 1, col) +
            dfs(grid, visited, row, col + 1) +
            dfs(grid, visited, row, col - 1);
    }
}
