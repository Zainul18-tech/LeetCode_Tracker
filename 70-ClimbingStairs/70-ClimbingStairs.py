# Last updated: 08/07/2026, 20:57:29
class Solution:
    def climbStairs(self, n: int) -> int:
        if n==0 and n==1:
            return 1

        dp = [0] * (n+1)    
        dp[0] = dp[1] = 1
        
        for i in range(2,n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]        