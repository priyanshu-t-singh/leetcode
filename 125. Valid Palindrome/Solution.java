// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;

        while (l < r) {
            char ch1 = s.charAt(l);
            while (!Character.isLetterOrDigit(ch1) && l < r) {
                l++;
                ch1 = s.charAt(l);
            }

            char ch2 = s.charAt(r);
            while (!Character.isLetterOrDigit(ch2) && l < r) {
                r--;
                ch2 = s.charAt(r);
            }

            if (l < r && Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
