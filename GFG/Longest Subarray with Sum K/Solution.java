// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int prefixSum = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        int result = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            int target = prefixSum - k;
            if (target == 0) {
                result = i + 1;
            } else if (mp.containsKey(target)) {
                result = Math.max(result, i - mp.get(target));
            }
            
            mp.putIfAbsent(prefixSum, i);
        }
        
        return result;
    }
}
