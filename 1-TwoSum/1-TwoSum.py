# Last updated: 08/07/2026, 20:57:49
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_set = {}
        for i,n in enumerate(nums):
            diff = target - n
            if diff in hash_set:
                return [hash_set[diff],i]
            hash_set[n] = i    