// Time Complexity: O(n * m), where n is the number of words and m is the average length of the words.
//      We need to compare each pair of adjacent words, and in the worst case, we may need
//      to compare all characters of both words.
// Space Complexity: O(1), since we are using a fixed-size array of length 26 to store the order of
//      characters in the alien dictionary.
class Solution {
    private int[] alienDictOrder = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < 26; i++) {
            alienDictOrder[order.charAt(i)-'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compareWordsInAlienDict(words[i-1], words[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    private int compareWordsInAlienDict(String s1, String s2) {
        int l = Math.min(s1.length(), s2.length());
        for (int i = 0; i < l; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 != ch2) {
                return alienDictOrder[ch1-'a'] - alienDictOrder[ch2-'a'];
            }
        }

        return s1.length() - s2.length();
    }
}
