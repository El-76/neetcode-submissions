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

        int l = 0;
        ListNode p = head;
        for (;;) {
            if (p == null) {
                break;
            }

            l++;

            p = p.next;
        }

        if (n == l) {
            return head.next;
        }

        p = head;
        for (int i = 0; i < l - n - 1; i++) {
            p = p.next;
        }

        if (p.next != null) {
            p.next = p.next.next;
        }
        
        return head;
    }
}
