class MinStack:
    stack: List[(int, int)]

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        l = len(self.stack)

        if l == 0: 
            self.stack += [ (val, val) ]
        else:
            self.stack += [ (val, min(val, self.stack[l - 1][1])) ]

    def pop(self) -> None:
        l = len(self.stack)

        val = self.stack[l - 1][0]

        self.stack = self.stack[:l - 1]

        return val

    def top(self) -> int:
        l = len(self.stack)

        return self.stack[l - 1][0]

    def getMin(self) -> int:
        l = len(self.stack)

        return self.stack[l - 1][1]
        
