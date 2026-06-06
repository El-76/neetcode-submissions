class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l = len(heights)

        if l == 0:
            return 0

        i = 0
        j = l - 1
        maxSquare = 0

        while i < j:
            if heights[i] > heights[j]:
                newSquare = (j - i) * heights[j]

                j -= 1
            else:
                newSquare = (j - i) * heights[i]

                i += 1

            if maxSquare < newSquare:
                maxSquare = newSquare    

        return maxSquare