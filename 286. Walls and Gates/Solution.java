// Similar to Q994. Rotting Oranges

class Solution {

    private final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) q.offer(new int[]{ i, j });
            }
        }

        int distance = 1;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];

                for (int[] d : directions) {
                    int dx = d[0] + x;
                    int dy = d[1] + y;

                    if (dx < 0 || dy < 0 || dx >= rows || dy >= cols || grid[dx][dy] != INF)
                        continue;
                    
                    grid[dx][dy] = distance;
                    q.offer(new int[]{ dx, dy });
                }
            }
            distance++;
        }
    }
}
