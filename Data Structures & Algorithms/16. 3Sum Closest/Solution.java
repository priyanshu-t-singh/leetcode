// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = 0;
        int diffSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i+1, r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(sum - target);

                if (diff == 0) {
                    return target;
                }

                if (diff < diffSum) {
                    diffSum = diff;
                    closestSum = sum;
                }

                if (sum > target) r--;
                else l++;
            }
        }

        return closestSum;
    }
}
