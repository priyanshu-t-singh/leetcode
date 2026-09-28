// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else { // ')'
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            int leftIdx = leftStack.pop();
            int starIdx = starStack.pop();

            if (leftIdx > starIdx) {
                return false;
            }
        }

        if (!leftStack.isEmpty()) {
            return false;
        }

        return true;
    }
}
