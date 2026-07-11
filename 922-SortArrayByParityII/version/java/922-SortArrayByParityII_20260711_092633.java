// Last updated: 11/07/2026, 09:26:33
1class Solution {
2    public int[] sortArrayByParityII(int[] nums) {
3        int j = 1;
4
5        for (int i = 0; i < nums.length; i += 2) {
6            if (nums[i] % 2 != 0) {
7                while (nums[j] % 2 != 0) {
8                    j += 2;
9                }
10
11                int temp = nums[i];
12                nums[i] = nums[j];
13                nums[j] = temp;
14            }
15        }
16
17        return nums;
18    }
19}