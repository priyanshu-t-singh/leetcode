// Time Complexity: O(m + n)
// Space Complexity: O(m + n)
//  where n is strs.length and m is strs[i].length
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length())
                .append("#")
                .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == '#') {
                int size = Integer.parseInt(sb.toString());
                sb.setLength(0);
                res.add(str.substring(i+1, i+size+1));
                i += size;
                continue;
            }

            sb.append(ch);
        }

        return res;
    }
}

