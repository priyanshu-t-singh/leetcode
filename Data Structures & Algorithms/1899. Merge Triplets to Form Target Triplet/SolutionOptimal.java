// Time Complexity: O(n)
// Space Complexity: O(1)
class SolutionOptimal {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false, y = false, z = false;
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
                continue;
            }

            x |= target[0] == triplets[i][0];
            y |= target[1] == triplets[i][1];
            z |= target[2] == triplets[i][2];

            if (x && y && z) {
                return true;
            }
        }

        return false;
    }
}
