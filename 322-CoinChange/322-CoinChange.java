// Last updated: 09/07/2026, 10:37:35
class Solution {
    public int coinChange(int[] coins, int amt) {
        int[] dp = new int[amt+1];
        for(int i=0;i<=amt;i++){
            dp[i]=amt+1;
        }
        dp[0]=0;
        for(int i=1;i<=amt;i++){
            for(int a : coins){
                if(i-a>=0){
                    dp[i]=Math.min(dp[i],dp[i-a]+1);
                }
            }
        }
        return dp[amt] > amt ? -1 : dp[amt];
    }
}