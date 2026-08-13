"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        copy = None

        old2New = {}

        p = head
        prev = None
        while p != None:
            c = Node(p.val)

            old2New[p] = c

            if copy == None:
                copy = c

            if prev != None:
                prev.next = c

            prev = c

            p = p.next

        p = head
        c = copy
        while p != None:
            if p.random != None:
                c.random = old2New[p.random]

            p = p.next
            c = c.next

        return copy