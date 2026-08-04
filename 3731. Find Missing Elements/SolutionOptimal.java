class SolutionOptimal {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        boolean[] visited = new boolean[max + 1];
        for (int num : nums) {
            visited[num] = true;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = min; i < max; i++) {
            if (!visited[i]) res.add(i);
        }

        return res;
    }
}
