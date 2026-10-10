// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            findFirstOccurence(nums, target),
            findLastOccurence(nums, target)
        };
    }

    private int findFirstOccurence(int[] nums, int target) {
        int result = -1;
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (result == -1) result = mid;
                else result = Math.min(result, mid);
                high = mid - 1;
            } 
        }

        return result;
    }

    private int findLastOccurence(int[] nums, int target) {
        int result = -1;
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                result = Math.max(result, mid);
                low = mid + 1;
            }
        }

        return result;
    }

}
