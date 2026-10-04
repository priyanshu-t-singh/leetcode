// Time Complexity: O(n)
// Space Complexity: O(n)
class SolutionTwoPass {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        boolean[] arr = new boolean[nums.length];

        // Two Pass Approach
        // Left to Right
        int active = 0;
        for (int i = 0; i < nums.length; i++) {
            if (active > 0) {
                active--;
                arr[i] = true;
            }

            if (nums[i] == key) {
                active = k;
                arr[i] = true;
            }
        }

        // Right to Left
        active = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if (active > 0) {
                active--;
                arr[i] = true;
            }

            if (nums[i] == key) {
                active = k;
                arr[i] = true;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] == true) {
                res.add(i);
            }
        }

        return res;
    }
}
