// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var next = head.next;
        head.next = head.next.next;
        next.next = head;
        head.next = swapPairs(head.next);

        return next;
    }
}
