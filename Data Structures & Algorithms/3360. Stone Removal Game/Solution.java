// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public boolean canAliceWin(int n) {
        int stonesToRemove = 10;
        boolean isAlice = true;

        while (n >= stonesToRemove) {
            n -= stonesToRemove--;
            isAlice = !isAlice;
        }

        return !isAlice;
    }
}
