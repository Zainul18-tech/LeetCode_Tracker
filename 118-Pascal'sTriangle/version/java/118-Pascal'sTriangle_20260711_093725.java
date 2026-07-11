// Last updated: 11/07/2026, 09:37:25
1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        int candidate1 = 0, candidate2 = 1;
4        int count1 = 0, count2 = 0;
5
6        // Find potential candidates
7        for (int num : nums) {
8            if (num == candidate1) {
9                count1++;
10            } else if (num == candidate2) {
11                count2++;
12            } else if (count1 == 0) {
13                candidate1 = num;
14                count1 = 1;
15            } else if (count2 == 0) {
16                candidate2 = num;
17                count2 = 1;
18            } else {
19                count1--;
20                count2--;
21            }
22        }
23
24        // Verify the candidates
25        count1 = 0;
26        count2 = 0;
27
28        for (int num : nums) {
29            if (num == candidate1) {
30                count1++;
31            } else if (num == candidate2) {
32                count2++;
33            }
34        }
35
36        List<Integer> result = new ArrayList<>();
37
38        if (count1 > nums.length / 3) {
39            result.add(candidate1);
40        }
41
42        if (count2 > nums.length / 3) {
43            result.add(candidate2);
44        }
45
46        return result;
47    }
48}