// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] filtered = new boolean[triplets.length];
        for (int i = 0; i < triplets.length; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (triplets[i][j] > target[j]) {
                    filtered[i] = true;
                    break;
                }

                if (triplets[i][j] == target[j]) {
                    count++;
                }
            }

            if (count == 0) {
                filtered[i] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            boolean isTargetFound = false;
            for (int j = 0; j < triplets.length; j++) {
                if (!filtered[j] && triplets[j][i] == target[i]) {
                    isTargetFound = true;
                    break;
                }
            }

            if (isTargetFound) count++;
        }

        return count == 3;
    }
}
