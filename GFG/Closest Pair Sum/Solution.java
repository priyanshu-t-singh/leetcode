// Time Complexity: O(nlogn) + O(n) = O(nlogn)
// Space Complexity: O(1)
class Solution {
    public ArrayList<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr); // TC: O(nlogn)
        ArrayList<Integer> result = new ArrayList<>(List.of(-1, -1));
        
        int diff = Integer.MAX_VALUE;
        int l = 0, r = arr.length-1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                return new ArrayList<>(List.of(arr[l], arr[r]));
            }
            
            int currDiff = Math.abs(sum - target);
            if (currDiff < diff) {
                diff = currDiff;
                result.set(0, arr[l]);
                result.set(1, arr[r]);
            }
            
            if (sum > target) r--;
            else l++;
        }
        
        return diff == Integer.MAX_VALUE ? new ArrayList<>() : result;
    }
}
