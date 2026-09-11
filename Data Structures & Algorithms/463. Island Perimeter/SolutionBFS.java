// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. In the worst case, we may visit every cell in the grid once.
// Space Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. We use a visited array to keep track of the cells we have visited.
class SolutionBFS {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                    break;
                }
            }
            if (q.size() > 0) break;
        }

        int perimeter = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for (int[] d : directions) {
                int dx = d[0] + x;
                int dy = d[1] + y;

                if (dx < 0 || dy < 0 || dx >= rows || dy >= cols || grid[dx][dy] == 0) {
                    perimeter++;
                } else if (!visited[dx][dy]) {
                    q.offer(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }

        return perimeter;
    }
}
