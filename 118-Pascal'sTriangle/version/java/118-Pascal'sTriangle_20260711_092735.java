// Last updated: 11/07/2026, 09:27:35
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> generate(int numRows) {
5        List<List<Integer>> result = new ArrayList<>();
6
7        for (int i = 0; i < numRows; i++) {
8            List<Integer> row = new ArrayList<>();
9
10            for (int j = 0; j <= i; j++) {
11                if (j == 0 || j == i) {
12                    row.add(1);
13                } else {
14                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
15                }
16            }
17
18            result.add(row);
19        }
20
21        return result;
22    }
23}