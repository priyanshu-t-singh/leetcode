// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int opening = 0, closing = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (opening != closing) {
                    sb.append(ch);
                }
                opening++;
            } else {
                closing++;
                if (opening != closing) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
