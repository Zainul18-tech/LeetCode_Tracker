# Last updated: 15/08/2026, 09:39:28
1class Solution:
2    def hasAlternatingBits(self, n: int) -> bool:
3        prev = n & 1
4        n >>= 1
5
6        while n:
7            curr = n & 1
8
9            if curr == prev:
10                return False
11
12            prev = curr
13            n >>= 1
14
15        return True