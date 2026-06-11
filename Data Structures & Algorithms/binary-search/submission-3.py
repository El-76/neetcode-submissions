class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1

        while True:
            m = l + int((r - l) / 2)

            num = nums[m]

            if num == target:
                return m

            if l == r:
                break

            if num < target:
                l = m + 1
            else:
                r = m

        return -1


        