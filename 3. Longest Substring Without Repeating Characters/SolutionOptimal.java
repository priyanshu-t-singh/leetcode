// Time Complexity: O(n)
// Space Complexity: O(1) - The size of the window array is constant (128 for ASCII characters)
class SolutionOptimal {
    public int lengthOfLongestSubstring(String s) {
        boolean[] window = new boolean[128];
        int longest = 0;

        int n = s.length();
        int l = 0, r = 0;
        while (r < n) {
            char ch = s.charAt(r++);
            while (window[ch]) {
                window[s.charAt(l++)] = false;
            }
            window[ch] = true;
            longest = Math.max(longest, r - l);
        }

        return longest;
    }
}
