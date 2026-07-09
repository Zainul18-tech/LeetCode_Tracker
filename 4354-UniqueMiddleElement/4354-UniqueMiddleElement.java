// Last updated: 09/07/2026, 10:35:27
class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid = nums[nums.length/2],c=0;
        for(int x : nums)
            if(x==mid)c++;
        return c==1;
    }
}