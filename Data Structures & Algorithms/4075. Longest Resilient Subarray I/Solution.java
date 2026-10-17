// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int result = 1;

        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (nums[i] % k == nums[j] % k) {
                    if (sum % k == nums[i] % k) {
                        result = Math.max(result, j - i + 1);
                    }
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
