// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int noOfDistinct = 0;
        long maxSum = 0, sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) == 1) {
                noOfDistinct++;
            } else if (freq.get(nums[i]) == 2) {
                noOfDistinct--;
            }
        }

        if (noOfDistinct == k) {
            maxSum = sum;
        }

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i-k];
            freq.put(nums[i-k], freq.get(nums[i-k]) - 1);
            if (freq.get(nums[i-k]) == 1) {
                noOfDistinct++;
            } else if (freq.get(nums[i-k]) == 0) {
                noOfDistinct--;
                freq.remove(nums[i-k]);
            }

            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) == 1) {
                noOfDistinct++;
            } else if (freq.get(nums[i]) == 2) {
                noOfDistinct--;
            }

            if (noOfDistinct == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
