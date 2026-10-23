// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
class Solution {
    public boolean fourSum(int[] arr, int x) {
        int n = arr.length;

        Set<Integer> pairSum = new HashSet<>();
        for (int j = 1; j < n; j++) {
            for (int k = j+1; k < n; k++) {
                int required = x - arr[j] - arr[k];

                if (pairSum.contains(required)) {
                    return true;
                }
            }

            for (int i = 0; i < j; i++) {
                pairSum.add(arr[i] + arr[j]);
            }
        }

        return false;
    }
}
