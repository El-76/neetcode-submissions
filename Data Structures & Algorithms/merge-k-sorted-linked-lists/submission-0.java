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
    private ListNode merge(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        ListNode head = null;
        ListNode tail = null;

        for (;;) {
            if (pA == null) {
                if (pB == null) {
                    return head;
                } else {
                    if (tail == null) {
                        head = pB;
                    } else {
                        tail.next = pB;
                    }

                    tail = pB;
                    pB = tail.next;
                }
            } else if (pB == null) {
                if (tail == null) {
                    head = pA;
                } else {
                    tail.next = pA;
                }

                tail = pA;
                pA = tail.next;
            } else if (pA.val < pB.val) {
                if (tail == null) {
                    head = pA;
                } else {
                    tail.next = pA;
                }

                tail = pA;
                pA = tail.next;
            } else {
                if (tail == null) {
                    head = pB;
                } else {
                    tail.next = pB;
                }

                tail = pB;
                pB = tail.next;
            }
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;

        if (size == 0) {
            return null;
        }

        while (size > 1) {
            int oldSize = size;

            for (int i = 1; i < size; i += 2) {
                lists[i / 2] = merge(lists[i - 1], lists[i]);
            }

            if (size % 2 == 0) {
                size = size / 2;
            } else {
                size = size / 2 + 1;

                lists[size - 1] = lists[oldSize - 1];
            }
        }

        return lists[0];
    }
}
