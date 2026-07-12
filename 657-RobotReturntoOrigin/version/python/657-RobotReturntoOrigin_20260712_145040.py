# Last updated: 12/07/2026, 14:50:40
1class Solution:
2    def restoreString(self, s: str, indices: List[int]) -> str:
3        ans = [''] * len(s)
4
5        for i, idx in enumerate(indices):
6            ans[idx] = s[i]
7
8        return "".join(ans)