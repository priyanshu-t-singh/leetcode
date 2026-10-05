// Time Complexity: O(n) for constructor, O(1) for sumRange
// Space Complexity: O(n) for prefixSum array
class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) { // TC: O(n)
        this.prefixSum = new int[nums.length];
        this.prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }

    // it can be calculated in two ways:
    // 1. sumRange(left, right) = prefixSum[right] - prefixSum[left-1] if left > 0
    // 2. sumRange(left, right) = prefixSum[right+1] - prefixSum[left] if prefixSum.length == nums.length + 1
    public int sumRange(int left, int right) { // TC; O(1)
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left-1];
    }
}
