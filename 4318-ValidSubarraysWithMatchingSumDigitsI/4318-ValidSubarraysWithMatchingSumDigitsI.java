// Last updated: 09/07/2026, 10:35:39
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count = 0;
        
        for (int l = 0; l < n; l++) {
            long sum = 0;
            for (int r = l; r < n; r++) {
                sum += nums[r];
                
                int lastDigit = (int) (sum % 10);
                int firstDigit = getFirstDigit(sum);
                
                if (firstDigit == x && lastDigit == x) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private int getFirstDigit(long num) {
        while (num >= 10) {
            num /= 10;
        }
        return (int) num;
    }
}