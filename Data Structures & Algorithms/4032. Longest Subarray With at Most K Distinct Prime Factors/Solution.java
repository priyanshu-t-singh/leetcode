// Time Complexity: O(m log m + n log m), m = max(nums)
// Space Complexity: O(m + n)

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxVal; j+=i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        List<Integer>[] primeFactors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            primeFactors[i] = getDistinctPrimeFactors(nums[i], spf);
        }
        
        Map<Integer, Integer> primeFreq = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            for (int p : primeFactors[right]) {
                primeFreq.put(p, primeFreq.getOrDefault(p, 0) + 1);
            }

            while (primeFreq.size() > k) {
                for (int p : primeFactors[left]) {
                    int count = primeFreq.get(p);
                    if (count == 1) {
                        primeFreq.remove(p);
                    } else {
                        primeFreq.put(p, count - 1);
                    }
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    private List<Integer> getDistinctPrimeFactors(int num, int[] spf) {
        List<Integer> factors = new ArrayList<>();
        while (num > 1) {
            int factor = spf[num];
            factors.add(factor);
            while (num > 1 && spf[num] == factor) {
                num /= factor;
            }
        }
        return factors;
    }
}
