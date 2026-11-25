// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int[] result = new int[n];
        int[] freq = new int[n+1];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                count++;
            } else {
                if (freq[a[i]] > 0) count++;
                if (freq[b[i]] > 0) count++;
            }

            result[i] = count;

            freq[a[i]]++;
            freq[b[i]]++;
        }

        return result;
    }
}
