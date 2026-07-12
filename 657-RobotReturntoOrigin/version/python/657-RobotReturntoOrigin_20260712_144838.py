# Last updated: 12/07/2026, 14:48:38
1class Solution:
2    def shortestToChar(self, s: str, c: str) -> List[int]:
3        n = len(s)
4        ans = [0] * n
5
6        prev = -n
7        for i in range(n):
8            if s[i] == c:
9                prev = i
10            ans[i] = i - prev
11
12        prev = 2 * n
13        for i in range(n - 1, -1, -1):
14            if s[i] == c:
15                prev = i
16            ans[i] = min(ans[i], prev - i)
17
18        return ans