# Last updated: 08/07/2026, 20:56:06
class Solution:
    def checkGoodInteger(self, n: int) -> bool:

        digit_sum = 0
        square_sum = 0

        for digit in str(n):
            d = int(digit)

            digit_sum += d
            square_sum += d*d
            
        if(square_sum - digit_sum) >= 50:
            return True
        else:
            return False