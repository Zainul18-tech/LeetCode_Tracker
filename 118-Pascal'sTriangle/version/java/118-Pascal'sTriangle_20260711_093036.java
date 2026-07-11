// Last updated: 11/07/2026, 09:30:36
1class Solution {
2    public int[][] modifiedMatrix(int[][] matrix) {
3        int rows = matrix.length;
4        int cols = matrix[0].length;
5
6        int[] maxInCol = new int[cols];
7
8        // Find the maximum value in each column
9        for (int j = 0; j < cols; j++) {
10            int max = Integer.MIN_VALUE;
11            for (int i = 0; i < rows; i++) {
12                max = Math.max(max, matrix[i][j]);
13            }
14            maxInCol[j] = max;
15        }
16
17        // Replace -1 with the maximum of its column
18        for (int i = 0; i < rows; i++) {
19            for (int j = 0; j < cols; j++) {
20                if (matrix[i][j] == -1) {
21                    matrix[i][j] = maxInCol[j];
22                }
23            }
24        }
25
26        return matrix;
27    }
28}