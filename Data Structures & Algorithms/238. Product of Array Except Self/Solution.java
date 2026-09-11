// Time Complexity: O(n)
// Space Complexity: O(1) (not counting the output array)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            res[i] *= right * nums[i+1];
            right *= nums[i+1];
        }

        return res;
    }
}
