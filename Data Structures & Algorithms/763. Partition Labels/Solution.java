// Time complexity: O(n)
// Space complexity: O(1) or O(26) = O(1) since we are using a hashmap to store 
// the last index of each character, and there are at most 26 lowercase English letters.
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> lastCharIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lastCharIdx.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int idx = lastCharIdx.get(s.charAt(i));
            end = Math.max(end, idx);

            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}
