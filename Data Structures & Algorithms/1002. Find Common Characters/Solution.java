// Time Complexity: O(n * m), where n is the number of words and m is the average length of the words.
// Space Complexity: O(26) or O(1)
class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[] commonCharacters = new int[26];
        int[] currentCharacters = new int[26];

        for (char ch : words[0].toCharArray()) {
            commonCharacters[ch-'a']++;
        }

        for (int i = 1; i < n; i++) {
            Arrays.fill(currentCharacters, 0);

            for (char ch : words[i].toCharArray()) {
                currentCharacters[ch-'a']++;
            }

            for (int j = 0; j < 26; j++) {
                commonCharacters[j] = Math.min(commonCharacters[j], currentCharacters[j]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < commonCharacters[i]; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }
}
