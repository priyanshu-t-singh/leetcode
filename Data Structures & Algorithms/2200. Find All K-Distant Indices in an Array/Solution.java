// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                arr.add(j);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j : arr) {
                int diff = Math.abs(i - j);
                if (diff <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
