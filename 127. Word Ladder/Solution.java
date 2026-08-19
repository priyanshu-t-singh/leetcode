// Time Complexity: O(m^2 * n)
// Space Complexity: O(m^2 * n)
//      where n is the number of words in the wordList and m is the length of each word.
// 127. Word Ladder is similar to 752. Open the Lock.
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) wordSet.add(word);

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        wordSet.add(beginWord);
        visited.add(beginWord);
        q.offer(beginWord);

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int k = 0; k < size; k++) {
                String word = q.poll();
                for (int i = 0; i < word.length(); i++) {
                    char[] letters = word.toCharArray();
                    char curr = letters[i];
                    for (int j = 0; j < 26; j++) {
                        letters[i] = (char) (j + 'a');
                        String s = new String(letters);
                        if (wordSet.contains(s) && !visited.contains(s)) {
                            if (endWord.equals(s)) {
                                return count + 1;
                            }
                            visited.add(s);
                            q.offer(s);
                        }
                    }
                    letters[i] = curr;
                }
            }
        }

        return 0;
    }
}
