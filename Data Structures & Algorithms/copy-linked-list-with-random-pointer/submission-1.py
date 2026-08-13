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
            c = old2New.get(p, None)
            if c == None:
                c = Node(p.val)

                old2New[p] = c

            if p.random != None:
                c.random = old2New.get(p.random, None)

                if c.random == None:
                    c.random = Node(p.random.val)

                    old2New[p.random] = c.random

            if copy == None:
                copy = c

            if prev != None:
                prev.next = c

            prev = c

            p = p.next

        return copy