// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                
                if (st.isEmpty())
                    st.push(i);
                else
                    res = Math.max(res, i - st.peek());
            }
        }

        return res;
    }
}
