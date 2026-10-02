// Time Complexity: O(4^n / sqrt(n)) - Catalan number
// Space Complexity: O(n) - recursion stack, string builder
class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return result;
    }

    public void dfs(int n, int opening, int closing, StringBuilder sb) {
        if (opening > n || closing > n || opening < closing) {
            return;
        }

        if (opening == closing && opening == n) {
            result.add(sb.toString());
        }

        sb.append('(');
        dfs(n, opening + 1, closing, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        dfs(n, opening, closing + 1, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
