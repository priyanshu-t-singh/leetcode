// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long count = 0;
        
        int l = 0, r = 0;
        while (r < n) {
            if (r >= 2 && s.charAt(r) == 'c' && s.charAt(r-1) == 'b' && s.charAt(r-2) == 'a') {
                // If we find a valid substring "abc", move the left pointer to the position of 'b'
                l = r - 1;
            }
            count += r - l + 1;
            r++;
        }

        return count;
    }
}
