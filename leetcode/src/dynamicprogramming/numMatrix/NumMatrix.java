package dynamicprogramming.numMatrix;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class NumMatrix {

    public int[][] _matrix;

    public int[][] _dp;

    public NumMatrix(int[][] matrix) {
        _matrix = matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        _dp = new int[n][m];
        _dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            _dp[i][0] = matrix[i][0] + _dp[i - 1][0];
        }
        for (int j = 1; j < m; j++) {
            _dp[0][j] = matrix[0][j] + _dp[0][j - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                _dp[i][j] = _dp[i - 1][j] + _dp[i][j - 1] + matrix[i][j]
                        - _dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (col1 == 0 && row1 == 0) {
            return _dp[row2][col2];
        } else if (row1 == 0) {
            return _dp[row2][col2] - _dp[row2][col1 - 1];

        } else if (col1 == 0) {
            return _dp[row2][col2] - _dp[row1 - 1][col2];
        } else {
            return _dp[row2][col2] - _dp[row1 - 1][col2] - _dp[row2][col1 - 1] + _dp[row1 - 1][col1 - 1];
        }
    }
}
