// This solution does the opposite of the Brute Force solution (backtracking).
// The iteration starts from the ocean and goes to the land, instead of
// starting from the land and going to the ocean.
//
// The time complexity is O(m*n) where m is the number of rows and n is the number of columns in the heights matrix.
class SolutionDFS {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < cols; i++) {
            dfs(heights, pacific, 0, i, heights[0][i]);
            dfs(heights, atlantic, rows-1, i, heights[rows-1][i]);
        }

        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, cols-1, heights[i][cols-1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col, int prevHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[row].length ||
            visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;
        dfs(heights, visited, row + 1, col, heights[row][col]);
        dfs(heights, visited, row - 1, col, heights[row][col]);
        dfs(heights, visited, row, col + 1, heights[row][col]);
        dfs(heights, visited, row, col - 1, heights[row][col]);
    }
}
