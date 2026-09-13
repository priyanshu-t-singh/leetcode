// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        if (n == 1) return grid;

        for (int i = 0; i < n; i++) {
            int[] arr = grid[i].clone();
            int k = rowShift[i];
            for (int j = 0; j < n; j++) {
                grid[i][(j - k + n) % n] = arr[j];
            }
        }

        for (int i = 0; i < n; i++) {
            int[] arr = new int[n];
            int k = colShift[i];
            for (int l = 0; l < n; l++) arr[l] = grid[l][i];
            for (int j = 0; j < n; j++) {
                grid[(j - k + n) % n][i] = arr[j];
            }
        }

        return grid;
    }
}
