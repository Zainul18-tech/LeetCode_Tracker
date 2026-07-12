# Last updated: 12/07/2026, 14:49:48
1class Solution:
2    def reverseOnlyLetters(self, s: str) -> str:
3        s = list(s)
4        left, right = 0, len(s) - 1
5
6        while left < right:
7            if not s[left].isalpha():
8                left += 1
9            elif not s[right].isalpha():
10                right -= 1
11            else:
12                s[left], s[right] = s[right], s[left]
13                left += 1
14                right -= 1
15
16        return "".join(s)