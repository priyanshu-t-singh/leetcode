// Time complexity: O(nlogn) where n is the number of elements in the input array.
// Space complexity: O(1) excluding the space used for the output list.
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums); // O(nlogn)

        List<Integer> res = new ArrayList<>();
        int k = 0;
        for (int i = nums[0]; i < nums[nums.length-1]; i++) { // O(n)
            if (nums[k] == i) k++;
            else res.add(i);
        }

        return res;
    }
}
