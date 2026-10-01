// Time Complexity: O(n)
// Space Complexity: O(n)
class SolutionTopDown {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0, cache);
    }

    private int dfs(int n, int curr, int[] cache) {
        if (curr > n) return 0;
        if (curr == n) return 1;
        if (cache[curr] != -1) {
            return cache[curr];
        }

        cache[curr] = dfs(n, curr + 1, cache) + dfs(n, curr + 2, cache);
        return cache[curr];
    }
}
