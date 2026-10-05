// Time Complexity: O(n)
// Space Complexity: O(min(n, k))
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> firstOccurence = new HashMap<>();
        firstOccurence.put(0, -1);

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % k;

            if (firstOccurence.containsKey(prefixSum)) {
                if (i - firstOccurence.get(prefixSum) >= 2) {
                    return true;
                }
            } else {
                firstOccurence.put(prefixSum, i);
            }
        }

        return false;
    }
}
