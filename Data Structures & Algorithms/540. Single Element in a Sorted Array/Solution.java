// Time Complexity : O(log n)
// Space Complexity : O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid > 0 && nums[mid] == nums[mid-1]) {
                if ((mid-1) % 2 == 0) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else if (mid+1 < nums.length && nums[mid] == nums[mid+1]) {
                if (mid % 2 == 0) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                return nums[mid];
            }
        }

        return -1;
    }
}
