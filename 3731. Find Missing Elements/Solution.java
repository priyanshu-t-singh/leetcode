class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        int k = 0;
        for (int i = nums[0]; i < nums[nums.length-1]; i++) {
            if (nums[k] == i) k++;
            else res.add(i);
        }

        return res;
    }
}
