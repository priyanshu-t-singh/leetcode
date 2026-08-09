class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int[] depth = new int[parent.length];
        int height = 1;
        for (int i = 0; i < parent.length; i++) {
            height = Math.max(height, getDepth(i, parent, depth));
        }

        long sum = 0;
        for (int i = 0; i < parent.length; i++) {
            sum += (long) nums[i] * (height - depth[i] + 1);
        }
        return sum;
    }

    private int getDepth(int i, int[] parent, int[] depth) {
        if (depth[i] != 0) {
            return depth[i];
        }

        if (parent[i] == -1) {
            depth[i] = 1;
        } else {
            depth[i] = getDepth(parent[i], parent, depth) + 1;
        }

        return depth[i];
    }
}
