// Time Complexity: O(n)
// Space Complexity: O(k)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>(); // int[k] can be used too
        prefixSumFreq.put(0, 1);

        int prefixSum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (((prefixSum + nums[i]) % k) + k) % k; // convert negative to positive

            // the above line is equivalent to (if language doesn't supports negative modulo):
            // sum = prefixSum + nums[i];
            // if (sum < 0) {
            //     prefixSum = k - Math.abs(sum) % k;
            // } else {
            //     prefixSum = sum % k;
            // }

            if (prefixSumFreq.containsKey(prefixSum)) {
                count += prefixSumFreq.get(prefixSum);
            }

            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
