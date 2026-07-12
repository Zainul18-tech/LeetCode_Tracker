# Last updated: 12/07/2026, 08:14:04
1class Solution:
2    def minimumCost(self, nums: list[int], k: int) -> int:
3        MOD = 10**9 + 7
4
5        resources = k
6        operations = 0
7
8        for x in nums:
9            if resources < x:
10                need = x - resources
11                add = (need + k - 1) // k
12
13                operations += add
14                resources += add * k
15
16            resources -= x
17
18        return (operations * (operations + 1) // 2) % MOD