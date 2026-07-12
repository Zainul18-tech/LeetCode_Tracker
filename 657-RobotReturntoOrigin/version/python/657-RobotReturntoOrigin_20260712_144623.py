# Last updated: 12/07/2026, 14:46:23
1class Solution:
2    def detectCapitalUse(self, word: str) -> bool:
3        return (
4            word.isupper() or
5            word.islower() or
6            word.istitle()
7        )