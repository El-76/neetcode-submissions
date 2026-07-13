from sortedcontainers import SortedList

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        w = SortedList(nums[0:k])

        print(w)

        res = [ w[k - 1] ]

        for l in range(k, len(nums)):
            w.discard(nums[l - k])

            w.add(nums[l])

            res += [ w[k - 1] ]

        return res