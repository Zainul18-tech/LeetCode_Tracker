// Last updated: 11/07/2026, 09:33:35
1class Solution {
2    public int[] decompressRLElist(int[] nums) {
3        int size = 0;
4
5        // Calculate the size of the decompressed array
6        for (int i = 0; i < nums.length; i += 2) {
7            size += nums[i];
8        }
9
10        int[] result = new int[size];
11        int index = 0;
12
13        // Fill the decompressed array
14        for (int i = 0; i < nums.length; i += 2) {
15            int freq = nums[i];
16            int val = nums[i + 1];
17
18            while (freq-- > 0) {
19                result[index++] = val;
20            }
21        }
22
23        return result;
24    }
25}