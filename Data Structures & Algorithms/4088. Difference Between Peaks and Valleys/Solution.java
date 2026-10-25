// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int peakValleyDifference(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                result += nums[i];
            } else if (nums[i] < nums[i-1] && nums[i] < nums[i+1]) {
                result -= nums[i];
            }
        }
        return result;
    }
}
