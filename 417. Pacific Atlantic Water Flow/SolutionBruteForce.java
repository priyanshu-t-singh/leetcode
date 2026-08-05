// Backtracking solution
class SolutionBruteForce {

    private boolean isPacafic = false;
    private boolean isAtlantic = false;

    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                isAtlantic = isPacafic = false;
                dfs(heights, i, j, Integer.MAX_VALUE);
                if (isPacafic && isAtlantic) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int row, int col, int prevHeight) {
        if (row < 0 || col < 0) {
            isPacafic = true;
            return;
        }
        if (row >= heights.length || col >= heights[row].length) {
            isAtlantic = true;
            return;
        }
        if (heights[row][col] > prevHeight) {
            return;
        }

        int tmp = heights[row][col];
        heights[row][col] = Integer.MAX_VALUE;
        for (int[] dir : directions) {
            dfs(heights, row + dir[0], col + dir[1], tmp);
            if (isPacafic && isAtlantic) break;
        }
        heights[row][col] = tmp;
    }
}
