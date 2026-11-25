// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int[] result = new int[n];
        int[] freq = new int[n+1];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (++freq[a[i]] == 2) count++;
            if (++freq[b[i]] == 2) count++;
            result[i] = count;
        }

        return result;
    }
}
