# Last updated: 08/07/2026, 20:56:08
class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq = {}

        for num in nums:
            freq[num] = freq.get(num, 0) + 1

        max_freq = max(freq.values())

        ans = 0
        for value in freq.values():
            if value == max_freq:
                ans += value

        return ans