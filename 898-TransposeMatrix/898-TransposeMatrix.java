// Last updated: 09/07/2026, 10:36:53
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                res[c][r] = matrix[r][c];
            }
        }

        return res;        
    }
}