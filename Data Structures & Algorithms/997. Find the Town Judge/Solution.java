// Time Complexity: O(n + M), where n is the number of people and M is the length of the trust array.
// Space Complexity: O(n), to keep track of the number of people each person trusts and the number of people who trust each person.
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n+1];
        int[] trustedBy = new int[n+1];

        for (int[] t : trust) {
            trusts[t[0]]++;
            trustedBy[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0 && trustedBy[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
