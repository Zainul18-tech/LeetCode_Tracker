# Last updated: 12/08/2026, 11:32:27
class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        s = set(nums)
        mn = min(nums)
        mx = max(nums)

        answer = []
        for x in range(mn + 1, mx):
            if not x in s:
                answer.append(x)

        return answer