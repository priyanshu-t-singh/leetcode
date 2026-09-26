// Time complexity: O(n + m)
// Space complexity: O(m)
//   where n is the length of the string s and m is the total number of characters in the knowledge list.
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<>();
        for (List<String> pair : knowledge) {
            knowledgeMap.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean isBracketOpen = false;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                isBracketOpen = true;
            } else if (ch == ')') {
                isBracketOpen = false;
                if (knowledgeMap.containsKey(key.toString())) {
                    sb.append(knowledgeMap.get(key.toString()));
                } else {
                    sb.append("?");
                }
                key.setLength(0);
            } else if (isBracketOpen) {
                key.append(ch);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
