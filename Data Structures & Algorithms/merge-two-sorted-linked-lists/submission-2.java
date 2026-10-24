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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode head1 = list1;
        ListNode head2 = list2;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                curr.next = head2;
                head2 = null;
            } else if (head2 == null) {
                curr.next = head1;
                head1 = null;
            } else if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}