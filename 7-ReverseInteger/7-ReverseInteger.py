# Last updated: 08/07/2026, 20:57:48
class Solution:
    def reverse(self, x: int) -> int:
        sign = -1 if x < 0 else 1
        x = abs(x)

        rev = 0
        while x:
            rev = rev * 10 + x % 10
            x //= 10

        rev *= sign

        if rev < -2**31 or rev > 2**31 - 1:
            return 0

        return rev