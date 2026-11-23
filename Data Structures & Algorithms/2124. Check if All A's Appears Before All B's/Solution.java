// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int lastA = -1;
        int firstB = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                lastA = i;
            } else if (firstB == -1) { // b
                firstB = i;
            }
        }

        if (lastA == -1 || firstB == -1) {
            return true;
        }

        return lastA < firstB;
    }
}
