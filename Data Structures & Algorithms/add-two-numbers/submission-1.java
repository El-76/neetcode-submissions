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
        ListNode res = null;
        ListNode prev = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        boolean carry = false;
        for (;;) {
            int r = (p1 == null ? 0 : p1.val)
                + (p2 == null ? 0 : p2.val);
            if (carry) {
                r++;
            }

            ListNode n = new ListNode(r % 10);

            carry = r >= 10;

            if (res == null) {
                res = n;
            }

            if (prev != null) {
                prev.next = n;
            }

            prev = n;

            if (p1 != null) {
                p1 = p1.next;
            }

            if (p2 != null) {
                p2 = p2.next;
            }

            if (p1 == null && p2 == null) {
                if (carry) {
                    n = new ListNode(1);

                    prev.next = n;
                }

                break;
            }
        }

        return res;
    }
}
