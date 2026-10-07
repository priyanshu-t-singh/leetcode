// Time Complexity: O(m + n)
// Space Complexity: O(1)
class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        ArrayList<Integer> result = new ArrayList<>(List.of(-1, -1));

        int l = 0, r = arr2.length-1;
        int diff = Integer.MAX_VALUE;
        while (l < arr1.length && r >= 0) {
            int sum = arr1[l] + arr2[r];
            int currDiff = Math.abs(sum - x);

            if (currDiff < diff) {
                diff = currDiff;
                result.set(0, arr1[l]);
                result.set(1, arr2[r]);
            }

            if (sum > x) r--;
            else l++;
        }

        return result;
    }
}
