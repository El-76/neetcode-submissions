class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l = len(heights)

        if l == 0:
            return 0

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