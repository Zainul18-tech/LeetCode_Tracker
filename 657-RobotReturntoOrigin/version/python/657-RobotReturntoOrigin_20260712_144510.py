# Last updated: 12/07/2026, 14:45:10
1class Solution:
2    def repeatedSubstringPattern(self, s: str) -> bool:
3        return s in (s + s)[1:-1]