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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        if (p == null) {
            return head.next;
        }

        ListNode h = head;
        for (;;) {
            if (p.next == null) {
                break;
            }

            p = p.next;
            h = h.next;
        }

        if (h.next != null) {
            h.next = h.next.next;
        }

        return head;
    }
}
