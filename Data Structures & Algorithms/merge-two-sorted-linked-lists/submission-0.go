/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    var h, l *ListNode
    l1 := list1
    l2 := list2 
    for {
        if l1 == nil {
            if l2 == nil {
                break;
            } else {
                if l == nil {
                    l = l2
                    h = l
                } else {
                    l.Next = l2
                }
                l = l2
                l2 = l2.Next
            }
        } else if l2 == nil {
            if l == nil {
                l = l1
                h = l
            } else {
                l.Next = l1
            }
            l = l1
            l1 = l1.Next
        } else if l1.Val < l2.Val {
            if l == nil {
                l = l1
                h = l
            } else {
                l.Next = l1
            }
            l = l1
            l1 = l1.Next
        } else {
            if l == nil {
                l = l2
                h = l
            } else {
                l.Next = l2
            }
            l = l2
            l2 = l2.Next
        }
    }

    return h
}
