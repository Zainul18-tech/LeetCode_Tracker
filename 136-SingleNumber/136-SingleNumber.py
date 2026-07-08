# Last updated: 08/07/2026, 20:57:14
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        target=0
        for num in nums:
            target^=num
        return target
        