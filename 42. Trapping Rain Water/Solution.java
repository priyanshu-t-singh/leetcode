// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1;
        int lmax = height[l], rmax = height[r];

        int result = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                result += Math.max(lmax - height[l], 0);
                lmax = Math.max(lmax, height[l++]);
            } else {
                result += Math.max(rmax - height[r], 0);
                rmax = Math.max(rmax, height[r--]);
            }
        }

        return result;
    }
}
