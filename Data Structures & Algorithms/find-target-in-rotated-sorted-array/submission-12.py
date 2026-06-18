class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        
        l = 0
        r = n - 1

        while True:
            m = l + int((r - l) / 2)

            if nums[m] == target:
                return m

            if l == r:
                return -1

            if nums[l] < nums[m]:
                if nums[l] <= target and target <= nums[m]:
                    r = m
                else:
                    l = m + 1
            else:
                if nums[r] >= target and target >= nums[m + 1]:
                    l = m + 1
                else:
                    r = m
            
        