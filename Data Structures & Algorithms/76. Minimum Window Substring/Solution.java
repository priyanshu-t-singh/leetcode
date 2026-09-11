// Time Complexity: O(n + m)
// Space Complexity: O(n + m)
//      where n is the length of s and m is the length of t
class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int[] res = new int[2];
        int have = 0, need = freq.size();
        int minWindow = Integer.MAX_VALUE;
        int l = 0, r = 0, n = s.length();

        while (r < n) {
            char ch = s.charAt(r++);
            count.put(ch, count.getOrDefault(ch, 0) + 1);


            // use .equals() to compare Integer values, not ==,
            // In Java, the == operator on objects compares their memory references, not their values.
            // While Java caches Integer objects for values between -128 and 127 (which is why your
            // code might pass some smaller test cases), it will fail for any character frequency of
            // 128 or higher.
            if (freq.containsKey(ch) && count.get(ch).equals(freq.get(ch))) {
                have++;
            }

            while (have == need) {
                if (minWindow > r - l) {
                    res[0] = l; res[1] = r;
                    minWindow = r - l;
                }

                char rm = s.charAt(l++);
                count.put(rm, count.get(rm) - 1);

                if (freq.containsKey(rm) && count.get(rm) < freq.get(rm)) {
                    have--;
                }
            }
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]);
    }
}
