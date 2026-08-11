/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseList(head *ListNode) *ListNode {
    h := head;

    if h == nil {
        return h
    }

    m := h.Next

    if m == nil {
        return h
    }

    h = nil
    m = head

    t := m.Next

    for {
        m.Next = h

        h = m
        m = t

        if t == nil {
            break
        }

        t = t.Next
    }

    return h
}
