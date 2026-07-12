# Last updated: 12/07/2026, 14:42:37
1class Solution:
2    def reverseVowels(self, s: str) -> str:
3        vowels = set("aeiouAEIOU")
4        s = list(s)
5
6        left, right = 0, len(s) - 1
7
8        while left < right:
9            while left < right and s[left] not in vowels:
10                left += 1
11            while left < right and s[right] not in vowels:
12                right -= 1
13
14            s[left], s[right] = s[right], s[left]
15            left += 1
16            right -= 1
17
18        return "".join(s)