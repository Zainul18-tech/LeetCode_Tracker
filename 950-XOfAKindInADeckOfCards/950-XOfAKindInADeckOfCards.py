# Last updated: 08/07/2026, 20:56:30
from collections import Counter
from math import gcd

class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        counts = Counter(deck).values()

        g = 0
        for count in counts:
            g = gcd(g, count)

        return g >= 2