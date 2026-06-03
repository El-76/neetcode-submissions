class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        l = len(nums)

        head = l * [ 1 ]
        tail = l * [ 1 ]
        output = l * [ 0 ]
        
        for i in range(1, l):
            head[i] = head[i - 1] * nums[i - 1]
            tail[l - i - 1] = tail[l - i] * nums[l - i]

        for i in range(l):
            output[i] = head[i] * tail[i]

        return output
