// Time Complexity: O(n)
// Space Complexity: O(1)
//      where n is the length of the array nums.
class Solution {
    public int countGoodRotations(int[] nums) {
        long leftSum = 0;
        long rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                leftSum += nums[i];
            } else {
                rightSum += nums[i];
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum > rightSum) count++;

            // rotate left
            leftSum -= nums[i];
            rightSum += nums[i];
            int mid = ((nums.length / 2) + i) % nums.length;
            leftSum += nums[mid];
            rightSum -= nums[mid];
        }

        return count;
    }
}
