// Time Complexity: O(n log n)
// Space Complexity: O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
