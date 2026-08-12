# Last updated: 12/08/2026, 11:31:09
class Solution:
    def largestInteger(self, n: int, s: int) -> int:
        if s > 9 * n:
            return -1

        if s == 0 :
            return 0

        ans = []

        for _ in range(n):
            digit = min(9, s)
            ans.append(str(digit))
            s -= digit 

        return int("".join(ans))