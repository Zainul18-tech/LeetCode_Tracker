# Last updated: 12/07/2026, 08:09:08
1class Solution:
2    def secondsBetweenTimes(self, startTime: str, endTime: str) -> int:
3        def toseconds(t):
4            h, m, s = map(int, t.split(":"))
5            return h * 3600 + m * 60 + s
6
7        return toseconds(endTime) - toseconds(startTime)