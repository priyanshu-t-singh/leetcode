// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> countFreq = new HashMap<>();

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = k - nums[i];
            // Check if the complement exists in the map and has a positive count
            if (countFreq.containsKey(num) && countFreq.get(num) > 0) {
                countFreq.put(num, countFreq.get(num) - 1);
                count++;
            } else {
                // Count the frequency of the current number
                countFreq.put(nums[i], countFreq.getOrDefault(nums[i], 0) + 1);
            }
        }

        return count;
    }
}
