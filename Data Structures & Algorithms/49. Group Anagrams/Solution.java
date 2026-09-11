// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);
            if (!mp.containsKey(key)) {
                mp.put(key, new ArrayList<>());
            }

            mp.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (var key : mp.keySet()) {
            res.add(mp.get(key));
        }
        return res;
    }
}
