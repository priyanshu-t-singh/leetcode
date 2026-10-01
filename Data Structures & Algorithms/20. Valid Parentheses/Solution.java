// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    Map<Character, Character> brackets = Map.of(')', '(', ']', '[', '}', '{');

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isOpeningBracket(ch)) {
                st.push(ch);
            } else if (isClosingBracket(ch)) {
                if (!st.isEmpty() && st.peek() == brackets.get(ch)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    private boolean isClosingBracket(char ch) {
        return brackets.containsKey(ch);
    }

    private boolean isOpeningBracket(char ch) {
        // only opening and closing brackets are there in the string so,
        return !brackets.containsKey(ch);
    }
}
