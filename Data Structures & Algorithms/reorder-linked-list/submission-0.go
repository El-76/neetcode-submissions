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

	l := 0
	p := head
    for {
		if p == nil {
			break
		}

		l++

		p = p.Next
	}

	p = head
	n := l / 2
	if (l % 2) == 1 {
		n++
	}
	var prev *ListNode
	for range n {
		prev = p
		p = p.Next
	}

	prev.Next = nil

    p2 := reverseList(p)

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
