// Time Complexity: O(n^2)
// Space Complexity: O(n)
//      where n is the length of the string s.
class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (scoreEquals(s, k)) {
                count++;
            }
            s = rotateLeft(s);
        }
        return count;
    }

    private boolean scoreEquals(String s, int k) {
        int maxScore = 0, score = 0, n = s.length();
        char prev = s.charAt(0);

        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == prev) score++;
            else {
                maxScore += score;
                score = 0;
            }
            prev = ch;
        }

        return maxScore + score == k;
    }

    private String rotateLeft(String s) {
        return s.substring(1, s.length()) + s.charAt(0);
    }
}
