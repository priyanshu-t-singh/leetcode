// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            String b = Integer.toBinaryString(ch);
            String b8bit = String.format("%8s", b).replace(" ", "0");
            sb.append(b8bit);
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
