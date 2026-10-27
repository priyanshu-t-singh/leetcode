// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length();
        int count = 0;

        for (int j = 1; j < n; j++) {
            Set<Character> s1 = new HashSet<>();
            Set<Character> s2 = new HashSet<>();
            Map<Integer, Integer> prefix = new HashMap<>();
            Map<Integer, Integer> suffix = new HashMap<>();

            for (int i = j - 1; i >= 0; i--) {
                s1.add(s.charAt(i));
                prefix.put(s1.size(), prefix.getOrDefault(s1.size(), 0) + 1);
            }

            for (int i = j; i < n; i++) {
                s2.add(s.charAt(i));
                suffix.put(s2.size(), suffix.getOrDefault(s2.size(), 0) + 1);
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
