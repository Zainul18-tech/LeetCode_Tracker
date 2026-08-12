# Last updated: 12/08/2026, 11:31:01
class Solution:
    def countValidPrefixes(self, s: str) -> int:
        zeroes = 0
        ones = 0
        ans = 0

        for ch in s:
            if ch =='0':
                zeroes += 1
            else:
                ones += 1

            if abs(zeroes-ones) <= 1:
                ans += 1

        return ans