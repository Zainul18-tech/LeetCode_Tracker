// Last updated: 11/07/2026, 09:29:08
1class Solution {
2    public int areaOfMaxDiagonal(int[][] dimensions) {
3        int maxArea = 0;
4        int maxDiagonal = 0;
5
6        for (int[] rect : dimensions) {
7            int length = rect[0];
8            int width = rect[1];
9
10            int diagonal = length * length + width * width;
11            int area = length * width;
12
13            if (diagonal > maxDiagonal || (diagonal == maxDiagonal && area > maxArea)) {
14                maxDiagonal = diagonal;
15                maxArea = area;
16            }
17        }
18
19        return maxArea;
20    }
21}