// Time Complexity: O(n)
// Space Complexity: O(1)
class SolutionOptimal {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int longest = 0, n = s.length();
        int l = 0, r = 0, maxFreq = 0;

        while (r < n) {
            char ch = s.charAt(r++);
            count[ch - 'A']++;
            maxFreq = Math.max(maxFreq, count[ch - 'A']);

            while (r - l - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l);
        }

        return longest;
    }
}
