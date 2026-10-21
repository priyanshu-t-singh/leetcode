// Time Complexity: O(n)
// Space Complexity: O(n)
// Asked in FreightFox interview
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            ch = Character.toLowerCase(ch);
            if ('a' <= ch && ch <= 'z' || '0' <= ch && ch <= '9') {
                sb.append(ch);
            }
        }

        String t = sb.toString();
        int n = t.length();
        for (int i = 0; i < n / 2; i++) {
            int end = n - i - 1;
            if (t.charAt(i) != t.charAt(end)) {
                return false;
            }
        }

        return true;
    }
}
