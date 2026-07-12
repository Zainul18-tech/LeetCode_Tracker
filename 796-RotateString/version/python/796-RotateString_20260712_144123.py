# Last updated: 12/07/2026, 14:41:23
1class Solution:
2    def rotateString(self, s: str, goal: str) -> bool:
3        return len(s) == len(goal) and goal in (s + s)