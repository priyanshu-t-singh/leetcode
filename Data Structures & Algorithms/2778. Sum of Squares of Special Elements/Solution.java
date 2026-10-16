// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int sumOfSquares(int[] nums) {
        int sumOfSquares = 0;

        for (int i = 1; i <= nums.length; i++) {
            if (nums.length % i == 0) {
                sumOfSquares += nums[i - 1] * nums[i - 1];
            }
        }

        return sumOfSquares;
    }
}
