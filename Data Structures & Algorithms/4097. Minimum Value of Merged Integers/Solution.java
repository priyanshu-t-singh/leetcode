// Time Complexity: O(n * log m)
// Space Complexity: O(1)
class Solution {
    public int minMergedInteger(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i+=2) {
            int first = nums[i];
            int second = nums[i+1];
            int mergedInt = first * (int) Math.pow(10, findNoOfDigits(second)) + second;
            result = Math.min(result, mergedInt);

        }
        return result;
    }

    private int findNoOfDigits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }
}
