// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;

        int res = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                res = Math.min(res, nums[low]);
                low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                res = Math.min(res, nums[mid]);
                high = mid - 1;
            }
        }

        return res;
    }
}
