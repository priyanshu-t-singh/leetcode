// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]);
        }

        int longest = 0;
        for (int num : st) { // mistake: for (int num : nums)
            if (!st.contains(num-1)) {
                int count = 0;
                while (st.contains(num + count)) {
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
