// Last updated: 09/07/2026, 10:37:08
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        int duplicate = -1;
        int missing = -1;

        // Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        // Find duplicate and missing
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                duplicate = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}