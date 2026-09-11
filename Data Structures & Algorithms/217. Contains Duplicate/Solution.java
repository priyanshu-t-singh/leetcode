// Time Complexity: O(n log n)
// Space Complexity: O(1)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) return true;
        }
        return false;
    }
}
