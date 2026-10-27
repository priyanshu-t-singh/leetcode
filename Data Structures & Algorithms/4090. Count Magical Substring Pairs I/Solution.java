// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length();
        int count = 0;

        for (int j = 1; j < n; j++) {
            char[] s1 = new char[26];
            char[] s2 = new char[26];
            int cnt1 = 0, cnt2 = 0;
            Map<Integer, Integer> prefix = new HashMap<>();
            Map<Integer, Integer> suffix = new HashMap<>();

            for (int i = j - 1; i >= 0; i--) {
                if (++s1[s.charAt(i)-'a'] == 1) cnt1++;
                prefix.put(cnt1, prefix.getOrDefault(cnt1, 0) + 1);
            }

            for (int i = j; i < n; i++) {
                if (++s2[s.charAt(i)-'a'] == 1) cnt2++;
                suffix.put(cnt2, suffix.getOrDefault(cnt2, 0) + 1);
            }

            for (int distinctCount : prefix.keySet()) {
                if (suffix.containsKey(distinctCount)) {
                    count += prefix.get(distinctCount) * suffix.get(distinctCount);
                }
            }
        }

        return count;
    }
}
