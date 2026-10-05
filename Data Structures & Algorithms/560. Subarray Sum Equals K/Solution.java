// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // if prefixSum == k, we can count it as a valid subarray

        int prefixSum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Formula: prefixSum[i] - prefixSum[j] = k
            //                      => prefixSum[j] = prefixSum[i] - k
            if (prefixSumFreq.containsKey(prefixSum - k)) {
                count += prefixSumFreq.get(prefixSum - k);
            }

            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
