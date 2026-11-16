// Time Complexity: O(n * log(n))
// Space Complexity: O(n)
//   where n is the length of the string s. In each iteration,
//   we are reducing the length of the string by a factor of k,
//   and we are calculating the sum of digits for each substring,
//   which takes O(n) time. Therefore, the overall time complexity is O(n * log(n)).
class Solution {
    public String digitSum(String s, int k) {
        String currStr = s;
        while (currStr.length() > k) {
            int n = currStr.length();
            int l = (int) Math.ceil(n / (float) k);
            StringBuilder nextStr = new StringBuilder();
            for (int i = 0; i < l; i++) {
                String substr = currStr.substring(i*k, Math.min(i*k+k, n));
                nextStr.append(sumOfDigit(substr));
            }
            currStr = nextStr.toString();
        }
        return currStr;
    }

    private String sumOfDigit(String s) {
        int sum = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            sum += (int) (s.charAt(i) - '0');
        }
        return String.valueOf(sum);
    }
}
