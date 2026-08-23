// Time Complexity: O(n logn)
// Space Complexity: O(n logn) due to sorting

class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        int start = lower;
        for (int i = 0; i < nums.length; i++) {
            if (lower <= nums[i] && nums[i] <= upper) {
                if (start < nums[i]) {
                    res.add(List.of(start, nums[i]-1));
                }
                start = nums[i] + 1;
            }
        }

        if (start <= upper) {
            res.add(List.of(start, upper));
        }

        return res;
    }
}
