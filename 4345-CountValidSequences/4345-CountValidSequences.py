# Last updated: 12/08/2026, 11:31:20
class Solution:
    def countValidSequences(self, n: int, k: int) -> int:
        MOD = 10**9 + 7

        if n < k:
            return 0

        def nCr(n,r):
            if r < 0 or r > n:
                return 0
            r = min(r, n - r)
            ans = 1
            for i in range(r):
                ans = ans * (n - i) % MOD 
                ans = ans * pow(i + 1, MOD - 2, MOD) % MOD

            return ans

        total = nCr(n - 1, k - 1)

        odd = 0
        if (n - k) % 2 == 0:
            odd = nCr((n + k - 2) // 2, k - 1)

        return (total - odd) % MOD