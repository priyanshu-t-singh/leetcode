// Time Complexity: O(n)
// Space Complexity: O(min(m, n)) - The size of the window set is at most the size of the character set (m) or the length of the string (n), whichever is smaller
class SolutionUsingSet {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int longest = 0;

        int n = s.length();
        int l = 0, r = 0;
        while (r < n) {
            char ch = s.charAt(r++);
            while (window.contains(ch)) {
                window.remove(s.charAt(l++));
            }
            window.add(ch);
            longest = Math.max(longest, window.size());
        }

        return longest;
    }
}
