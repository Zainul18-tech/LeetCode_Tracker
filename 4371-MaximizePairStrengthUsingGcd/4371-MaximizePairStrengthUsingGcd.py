# Last updated: 12/08/2026, 11:30:59
class Solution:
    def maxPairStrength(self, nums: list[int]) -> int:
        ans = 0
        n = len(nums)

        for i in range(n):
            for j in range(i+1, n):
                g = gcd(nums[i], nums[j])
                ans = max(ans, (nums[i] * nums[j]) // (g * g))
        return ans