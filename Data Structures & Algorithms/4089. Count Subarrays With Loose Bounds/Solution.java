// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0L;
        int l = 0, r = 0;

        while (r < nums.length) {
            if (minK <= nums[r] && nums[r] <= maxK) {
                result += (r - l + 1);
            } else {
                l = r+1;
            }
            r++;
        }

        return result;
    }
}
