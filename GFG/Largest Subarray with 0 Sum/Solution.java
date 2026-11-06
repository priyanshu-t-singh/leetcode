// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    int maxLength(int arr[]) {
        int n = arr.length;
        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }
        
        Map<Integer, Integer> firstOccurence = new HashMap<>();
        firstOccurence.put(0, 0);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (firstOccurence.containsKey(prefixSum[i])) {
                result = Math.max(result, i - firstOccurence.get(prefixSum[i]));
            }
            firstOccurence.putIfAbsent(prefixSum[i], i);
        }
        
        return result;
    }
}
