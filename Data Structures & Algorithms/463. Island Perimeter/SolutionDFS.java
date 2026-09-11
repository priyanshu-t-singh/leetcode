// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. In the worst case, we may visit every cell in the grid once.
// Space Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. We use a visited array to keep track of the cells we
class SolutionDFS {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return dfs(grid, visited, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length ||
            grid[row][col] == 0) {
            return 1;
        }
        if (visited[row][col]) return 0;

        visited[row][col] = true;
        return dfs(grid, visited, row + 1, col) +
            dfs(grid, visited, row - 1, col) +
            dfs(grid, visited, row, col + 1) +
            dfs(grid, visited, row, col - 1);
    }
}
