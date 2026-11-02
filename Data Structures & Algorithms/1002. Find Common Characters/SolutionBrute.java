// Time Complexity: O(n * m)
// Space Complexity: O(n * 26)
//    where n is the number of words and m is the average length of the words. We iterate through each word and count the frequency of each character, which takes O(m) time for each word. Then we find the minimum frequency for each character across all words, which takes O(n) time for each character (26 characters in total).
class Solution {
    public List<String> commonChars(String[] words) {
        int[][] common = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                common[i][ch-'a']++;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int minCount = common[0][i];
            for (int j = 1; j < words.length; j++) {
                minCount = Math.min(minCount, common[j][i]);
            }
            for (int j = 0; j < minCount; j++) {
                result.add("" + (char) ('a' + i));
            }
        }

        return result;
    }
}
