// Time Complexity: O(n)
// Space Complexity: O(k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int l = 0, r = 0;

        int[] res = new int[nums.length - k + 1];
        while (r < nums.length) {
            while (!dq.isEmpty() && dq.peekLast() < nums[r]) {
                dq.pollLast();
            }

            dq.offerLast(nums[r]);

            if (r + 1 >= k) {
                res[l] = dq.peekFirst();
                if (dq.peekFirst() == nums[l]) {
                    dq.pollFirst();
                }
                l++;
            }
            r++;
        }

        return res;
    }
}
