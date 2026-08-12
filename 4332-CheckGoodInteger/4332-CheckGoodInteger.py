# Last updated: 12/08/2026, 11:31:43
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