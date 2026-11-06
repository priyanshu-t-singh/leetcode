// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    int maxLength(int arr[]) {
        int n = arr.length;

        Map<Integer, Integer> firstOccurence = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        firstOccurence.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (firstOccurence.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - firstOccurence.get(prefixSum));
            } else {
                firstOccurence.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
