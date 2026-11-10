// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public long subarrayXor(int arr[], int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        
        int count = 0;
        int currXor = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currXor ^= arr[i];
            
            if (freq.containsKey(currXor ^ k)) {
                count += freq.get(currXor ^ k);
            }
            
            freq.put(currXor, freq.getOrDefault(currXor, 0) + 1);
        }
        
        return count;
    }
}
