// Last updated: 09/07/2026, 10:35:48
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int l = 0; l < n; l++) {
            int targetCount = 0;

            for (int r = l; r < n; r++) {
                if (nums[r] == target) {
                    targetCount++;
                }

                int len = r - l + 1;

                if (targetCount > len / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}