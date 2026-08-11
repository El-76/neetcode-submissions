/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reorderList(head *ListNode) {
	if head == nil {
		return
	}

	var prev *ListNode

	p := head
	p2 := head
    for {
		prev = p2
		p2 = p2.Next
		p = p.Next
		if (p == nil) {
			break
		}
		p = p.Next
		if (p == nil) {
			break
		}
	}

	prev.Next = nil

    p2 = reverseList(p2)

	p = head

	var t, t2 *ListNode
	for ;; {
		if p2 == nil {
			break
		}

		t = p.Next
		t2 = p2.Next
		p.Next = p2
		p2.Next = t
		p = t
		p2 = t2
	}
}

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
