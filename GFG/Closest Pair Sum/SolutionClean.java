// Time Complexity: O(nlogn) + O(n) = O(nlogn)
// Space Complexity: O(1)
class SolutionClean {
    public ArrayList<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr); // TC: O(nlogn)
        ArrayList<Integer> result = new ArrayList<>();
        
        int diff = Integer.MAX_VALUE;
        int l = 0, r = arr.length-1;
        while (l < r) {
            int sum = arr[l] + arr[r];

            int currDiff = Math.abs(sum - target);
            if (currDiff < diff) {
                diff = currDiff;
                result.clear();
                result.add(arr[l]);
                result.add(arr[r]);
            }
            
            if (sum > target) r--;
            else if (sum < target) l++;
            else return result;
        }
        
        return result;
    }
}
