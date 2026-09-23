// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int jump(int[] nums) {
        int end = nums.length - 1;
        int l = 0, r = 0;
        int res = 0;

        while (r < end) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }

        return res;
    }
}
