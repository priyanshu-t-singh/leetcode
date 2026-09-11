// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. In the worst case, we may visit every cell in the grid once.
// Space Complexity: O(1), we are using a constant amount of space.
class SolutionIteration {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += (i + 1 >= rows || grid[i+1][j] == 0) ? 1 : 0;
                    perimeter += (j + 1 >= cols || grid[i][j+1] == 0) ? 1 : 0;
                    perimeter += (i - 1 < 0 || grid[i-1][j] == 0) ? 1 : 0;
                    perimeter += (j - 1 < 0 || grid[i][j-1] == 0) ? 1 : 0;
                }
            }
        }

        return perimeter;
    }
}
