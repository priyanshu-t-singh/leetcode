// Time Complexity: O(log n) in average case, O(n) in worst case (when all elements are duplicates)
// Space Complexity: O(1)
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int result = nums[0];

        while (low <= high) {
            int mid = (low + high) / 2;

            // Remove duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                result = Math.min(result, nums[low]);
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                result = Math.min(result, nums[low]);
                low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                result = Math.min(result, nums[mid]);
                high = mid - 1;
            }
        }

        return result;
    }
}
