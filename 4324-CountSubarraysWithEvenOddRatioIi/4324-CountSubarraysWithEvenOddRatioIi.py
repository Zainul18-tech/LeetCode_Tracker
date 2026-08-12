# Last updated: 12/08/2026, 11:31:56
class Solution:
    def countRatioSubarrays(self, nums: list[int], a: int, b: int) -> int:
        n = len(nums)
        prefix = [0] * (n + 1)

        for i , num in enumerate(nums):
            prefix[i + 1] = prefix[i] + (b if num % 2 == 0 else -a)

        sorted_vals = sorted(set(prefix))
        m = len(sorted_vals)
        tree = [0] * (m + 1)

        def update(i):
            while i <= m:
                tree[i] += 1
                i += i & (-i)

        def query(i):
            s = 0
            while i > 0:
                s += tree[i]
                i -= i & (-i)
            return s

        def rank(x):
            return bisect.bisect_left(sorted_vals, x) + 1

        ans = 0
        r0 = rank(prefix[0])
        update(r0)
        count = 1

        for j in range(1, n + 1):
            r = rank(prefix[j])
            ans += count - query(r - 1)
            update(r)
            count += 1

        return ans