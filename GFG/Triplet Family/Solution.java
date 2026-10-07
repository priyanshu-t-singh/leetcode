// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public boolean findTriplet(int[] arr) {
        Arrays.sort(arr);
        
        for (int i = 2; i < arr.length; i++) {
            int l = 0, r = i-1;
            
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum == arr[i]) {
                    return true;
                }
                
                if (sum > arr[i]) r--;
                else l++;
            }
        }
        
        return false;
    }
}
