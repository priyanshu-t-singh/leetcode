// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int r1 = nums[i] + k;
            int r2 = nums[i] - k;

            if (mp.containsKey(r1)) {
                count += mp.get(r1);
            }
            if (mp.containsKey(r2)) {
                count += mp.get(r2);
            }

            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        return count;
    }
}
