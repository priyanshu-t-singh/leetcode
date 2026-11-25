// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(A[i]);
            set2.add(B[i]);

            Set<Integer> intersection = new HashSet<>(set1);
            intersection.retainAll(set2);

            result[i] = intersection.size();
        }

        return result;
    }
}
