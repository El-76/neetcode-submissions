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
    public ListNode reverseList(ListNode head) {
        ListNode h = head;

        if (h == null) {
            return h;
        }

        ListNode m = h.next;

        if (m == null) {
            return h;
        }

        h = null;
        m = head;

        ListNode t = m.next;

        for (;;) {
            m.next = h;

            h = m;
            m = t;

            if (t == null) {
                break;
            }

            t = t.next;
        }

        return h;
    }
}
