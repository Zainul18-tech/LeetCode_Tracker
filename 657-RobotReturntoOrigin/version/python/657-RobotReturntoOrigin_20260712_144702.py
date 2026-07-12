# Last updated: 12/07/2026, 14:47:02
1class Solution:
2    def reverseWords(self, s: str) -> str:
3        return " ".join(word[::-1] for word in s.split())