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
    private ListNode seekEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode tail = null;
        int i = 0;
        for (;;) {
            if (p == null) {
                return null;
            }

            tail = p;
            p = p.next;

            i++;

            if (i == k) {
                return tail;
            }
        }
    }

    private ListNode[] reverse(ListNode head) {
        ListNode p = head;

        if (p.next == null) {
            return new ListNode[]{p, p};
        }

        ListNode prev = p;
        p = p.next;

        if (p.next == null) {
            prev.next = null;
            p.next = prev;

            return new ListNode[]{p, prev};
        }

        ListNode curHead = head;
        ListNode prevprev = prev;
        prev = p;
        p = p.next;

        for (;;) {
            if (prevprev != null) {
                prev.next = curHead;
                curHead = prev;
                prevprev.next = p;
            }

            if (prev != null && p == null) {
                return new ListNode[]{prev, prevprev};
            }

            if (prevprev == null) {
                prevprev = prev;
            }

            prev = p;
            p = p.next;
        }
    }

    private void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print(" -> ");
            }

            p = p.next;
        }

        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = head;
        ListNode curHead = head;
        ListNode prevTail = null;
        for (;;) {
            ListNode tail = seekEnd(curHead, k);

            if (tail != null) {
                ListNode nextPartHead = tail.next;

                tail.next = null;

                ListNode[] res = reverse(curHead);

                //printList(res[0]);

                if (curHead == head) {
                    newHead = res[0];
                }

                if (prevTail != null) {
                    prevTail.next = res[0];
                }

                //System.out.println(tail.val + ", " + res[0].val + ", " + res[1].val);

                curHead = nextPartHead;

                res[1].next = nextPartHead;
                prevTail = res[1];
            } else {
                break;
            }
        }

        return newHead;
    }
}
