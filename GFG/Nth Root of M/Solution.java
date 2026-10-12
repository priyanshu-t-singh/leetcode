// Time Complexity: O(log(m) * n), where m is the number for which we want to find the nth root and n is the root we are trying to find. The binary search takes O(log(m)) time and for each mid value, we calculate mid^n which takes O(n) time.
// Space Complexity: O(1)
class Solution {
    public int nthRoot(int n, int m) {
        if (m == 0) return 0;
        if (n == 1) return m;
        
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = pow(mid, n, m);
            
            if (val == m) {
                return mid;
            } else if (val < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
    
    private int pow(int base, int exponent, int limit) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
            
            if (result > limit) {
                return result;
            }
        }
        return result;
    }
}
