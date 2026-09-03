// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int n = s.length();
        int l = 0, r = 0;
        int longest = 0;
        char largestCh = s.charAt(0);

        while (r < n) {
            char ch = s.charAt(r++);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            if (mp.get(largestCh) < mp.get(ch)) {
                largestCh = ch;
            }

            while (r - l - mp.get(largestCh) > k) {
                char removeCh = s.charAt(l);
                mp.put(removeCh, mp.get(removeCh) - 1);
                if (largestCh == removeCh) {
                    for (char key : mp.keySet()) {
                        if (mp.get(largestCh) < mp.get(key)) {
                            largestCh = key;
                        }
                    }
                }
                l++;
            }

            longest = Math.max(longest, r - l);
        }

        return longest;
    }
}
