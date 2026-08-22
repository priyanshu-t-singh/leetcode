// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length+1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (int key : count.keySet()) {
            bucket[count.get(key)].add(key);
        }

        int idx = 0;
        int[] res = new int[k];
        for (int i = bucket.length-1; i >= 0; i--) {
            for (int n : bucket[i]) {
                res[idx++] = n;
                if (idx == k) return res;
            }
        }

        return res;
    }
}

