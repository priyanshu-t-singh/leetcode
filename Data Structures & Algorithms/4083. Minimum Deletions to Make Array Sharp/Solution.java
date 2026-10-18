// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int minDeletions(int[] nums) {
        int minDeletions = 0;

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] ^ nums[i-1]) == 0) {
                minDeletions++;
            }
        }

        return minDeletions;
    }
}
