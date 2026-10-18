// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int[] result = new int[2];
        int r = 0, c = 0;
        while (r >= 0 && c >= 0 && r < m && c < n) {
            if (visited[r][c]) {
                return result;
            }

            visited[r][c] = true;
            result[0] = r;
            result[1] = c;

            switch (grid[r][c]) {
                case 'U': r--; break;
                case 'D': r++; break;
                case 'L': c--; break;
                case 'R': c++; break;
            }
        }

        return result;
    }
}
