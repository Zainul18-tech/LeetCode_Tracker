# Last updated: 08/07/2026, 20:56:34
class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        seen = set()
        duplicate = -1

        for num in nums:
            if num in seen:
                duplicate = num
            seen.add(num)

        for i in range(1, len(nums) + 1):
            if i not in seen:
                return [duplicate, i]  