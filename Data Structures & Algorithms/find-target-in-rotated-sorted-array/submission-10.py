class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        
        l = 0
        r = n - 1
        k = 0

        while True:
            m = l + int((r - l) / 2)

            if l == r:
                k = l

                break

            if nums[m] > nums[r]:
                l = m + 1
            else:
                r = m

        l = 0
        r = n - 1
        while True:
            m = l + int((r - l) / 2)

            i = (m + k) % n

            if nums[i] == target:
                return i

            if l == r:
                return -1

            if nums[i] > target:
                r = m
            else:
                l = m + 1
            
        