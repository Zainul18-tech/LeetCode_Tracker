// Last updated: 11/07/2026, 09:34:17
1class Solution {
2    public int missingNumber(int[] nums) {
3        int n = nums.length;
4        int expectedSum = n * (n + 1) / 2;
5        int actualSum = 0;
6
7        for (int num : nums) {
8            actualSum += num;
9        }
10
11        return expectedSum - actualSum;
12    }
13}