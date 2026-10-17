// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int result = 1;

        int l = 0, r = 0;
        while (r < n) {
            int sum = 0;
            while (r < n && nums[l] % k == nums[r] % k) {
                sum += nums[r];
                if (sum % k == nums[l] % k) {
                    result = Math.max(result, r - l + 1);
                }
                r++;
            }
            l = r;
        }

        return result;
    }
}
