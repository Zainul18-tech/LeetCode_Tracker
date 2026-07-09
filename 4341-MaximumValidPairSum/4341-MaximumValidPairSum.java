// Last updated: 09/07/2026, 10:35:33
class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int max = nums[0], ans = Integer.MIN_VALUE;
       
            for(int j=k;j<nums.length;j++){
                max = Math.max(max,nums[j-k]);
                ans = Math.max(ans,max+nums[j]);
    }
        return ans;
    }
}