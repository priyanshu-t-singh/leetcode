// Time complexity: O(n) where n is the number of elements in the input array.
// Space complexity: O(max - min) => O(n) in worst case

class SolutionOptimal {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) { // O(n)
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        boolean[] visited = new boolean[max - min + 1];
        for (int num : nums) { // O(n)
            visited[num - min] = true;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = min; i < max; i++) { // O(max - min) => O(n) in worst case
            if (!visited[i - min]) res.add(i);
        }

        return res;
    }
}
