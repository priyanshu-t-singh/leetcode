// Time Complexity: O(n)
// Space Complexity: O(n)
//    where n is the number of nodes in the linked list.
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
