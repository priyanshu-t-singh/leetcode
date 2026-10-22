// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public void sortInWave(int arr[]) {
        for (int i = 1; i < arr.length; i+=2) {
            int tmp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = tmp;
        }
    }
}
