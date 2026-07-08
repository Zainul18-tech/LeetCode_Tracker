# Last updated: 08/07/2026, 20:57:33
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        current = maximum = nums[0]

        for num in nums[1:]:
            current = max(num, current + num)
            maximum = max(maximum, current)

        return maximum