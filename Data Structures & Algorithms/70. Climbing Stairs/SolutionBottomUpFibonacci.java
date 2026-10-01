// Time Complexity: O(n)
// Space Complexity: O(1)
// It is a DP solution, and the pattern is similar to fibonacci series.
class SolutionBottomUpFibonacci {
    public int climbStairs(int n) {
        int first = 1, second = 1;

        for (int i = 2; i <= n; i++) {
            int third = first + second;
            second = first;
            first = third;
        }

        return first;
    }
}
