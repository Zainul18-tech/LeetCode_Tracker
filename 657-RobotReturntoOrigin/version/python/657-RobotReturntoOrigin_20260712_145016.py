# Last updated: 12/07/2026, 14:50:16
1class Solution:
2    def maxPower(self, s: str) -> int:
3        ans = cur = 1
4
5        for i in range(1, len(s)):
6            if s[i] == s[i - 1]:
7                cur += 1
8            else:
9                cur = 1
10            ans = max(ans, cur)
11
12        return ans
13        