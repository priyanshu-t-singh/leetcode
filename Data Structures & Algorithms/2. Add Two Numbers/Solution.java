// Time complexity: O(max(n, m))
// Space complexity: O(max(n, m))
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;
        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;
            node1 = node1.next;
            node2 = node2.next;
            result = result.next;
        }

        while (node1 != null) {
            int sum = node1.val + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;
            node1 = node1.next;
            result = result.next;
        }
        
        while (node2 != null) {
            int sum = node2.val + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;
            node2 = node2.next;
            result = result.next;
        }

        if (carry > 0) {
          result.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
