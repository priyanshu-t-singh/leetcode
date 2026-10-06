// Time Complexity: O(n * sqrt(k))
// Space Complexity: O(n)
class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Long, Long> gcdCount = new HashMap<>();

        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            long gcd = gcd(k, nums[i]);

            for (var entrySet : gcdCount.entrySet()) {
                if (gcd * entrySet.getKey() % k == 0) {
                    count += entrySet.getValue();
                }
            }

            gcdCount.put(gcd, gcdCount.getOrDefault(gcd, 0L) + 1);
        }

        return count;
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
