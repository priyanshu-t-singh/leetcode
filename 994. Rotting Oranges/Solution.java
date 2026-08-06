// The key to solving this problem is to use a breadth-first search (BFS) approach.
// We can start by adding all the rotten oranges to a queue and then process them
// level by level, rotting adjacent fresh oranges in each iteration. We also keep track
// of the number of fresh oranges and the time taken for all oranges to rot. If there
// are still fresh oranges left after processing, we return -1.
// 
// Time complexity: O(m*n) where m is the number of rows and n is the number of columns in the grid.
// Space complexity: O(m*n) for the queue and visited array.

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int time = 0;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (fresh > 0 && !q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int x = q.peek()[0];
                int y = q.poll()[1];

                for (int[] d : directions) {
                    int dx = d[0] + x;
                    int dy = d[1] + y;

                    if (dx < 0 || dy < 0 || dx >= rows || dy >= cols
                        || grid[dx][dy] != 1) {
                        continue;
                    }

                    q.offer(new int[]{ dx, dy });
                    grid[dx][dy] = 2;
                    fresh--;
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
