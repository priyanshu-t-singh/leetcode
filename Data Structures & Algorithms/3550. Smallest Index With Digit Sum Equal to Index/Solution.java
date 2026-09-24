// Time Complexity: O(n * d), where n is the length of the input array nums and d is the maximum number of digits in any number in nums. The outer loop iterates through each element of the array, and the inner loop calculates the sum of digits for each number, which takes O(d) time.
// Space Complexity: O(1)
class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == sumOfDigits(nums[i])) {
                return i;
            }
        }
        return -1;
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }
}
