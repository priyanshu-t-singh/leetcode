// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
//    where n is the length of the nums array and m is the average length of the strings in nums. We iterate through each string in nums and perform substring operations, which take O(m) time.
class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> freq = new HashMap<>(); // O(n * m) space complexity for storing the frequency of each string in nums
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target.startsWith(nums[i])) {
                String search = target.substring(nums[i].length());
                if (freq.containsKey(search)) {
                    count += freq.get(search);
                    if (nums[i].equals(search)) {
                        count--;
                    }
                }
            }
        }

        return count;
    }
}
