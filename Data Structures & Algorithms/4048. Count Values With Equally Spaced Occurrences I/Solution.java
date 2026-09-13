// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], new ArrayList<>());
            }

            mp.get(nums[i]).add(i);
        }

        int count = 0;
        for (int key : mp.keySet()) {
            List<Integer> arr = mp.get(key);
            if (arr.size() == 3 && arr.get(1) - arr.get(0) == arr.get(2) - arr.get(1)) {
                count++;
            }
        }

        return count;
    }
}
