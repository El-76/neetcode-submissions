class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l = len(heights)

        if l == 0:
            return 0

        left = [ 0 ]
        right = [ l - 1 ]

        maxHeight = heights[0]
        for i in range(1, l):
            if heights[i] > maxHeight:
                left += [ i ]

                maxHeight = heights[i]

        maxHeight = heights[l - 1]
        for i in range(l - 1, -1, -1):
            if heights[i] > maxHeight:
                left += [ i ]

                maxHeight = heights[i]

        i = 0
        j = l - 1
        if heights[i] > heights[j]:
            maxSquare = (j - i) * heights[j]
        else:
            maxSquare = (j - i) * heights[i]

        while i < j:
            if heights[i] > heights[j]:
                j -= 1
            else:
                i += 1

            if heights[i] > heights[j]:
                newSquare = (j - i) * heights[j]
            else:
                newSquare = (j - i) * heights[i]

            if maxSquare < newSquare:
                maxSquare = newSquare    

        return maxSquare