# Last updated: 12/08/2026, 11:31:15
class Solution:
    def minInitialStrength(self, monsters: list[int], boosts: list[list[int]]) -> int:
        n = len(monsters)

        diff = [0] * (n + 1)

        for l, r, v in boosts:
            diff[l] += v
            if r + 1 < n:
                diff[r + 1] -= v

        bonus = [0] * n
        cur = 0
        for i in range(n):
            cur += diff[i]
            bonus[i] = cur

        def can(start):
            strength = start
            for i in range(n):
                if strength + bonus[i] < monsters[i]:
                    return False
                strength = max(0, strength - monsters[i])
            return True

        lo, hi = 0, sum(monsters)
        while lo < hi:
            mid = (lo + hi) // 2
            if can(mid):
                hi = mid
            else:
                lo = mid + 1

        return lo
        
            