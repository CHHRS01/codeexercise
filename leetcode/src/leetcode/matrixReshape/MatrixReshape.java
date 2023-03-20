package leetcode.matrixReshape;

/**
 * 566. 重塑矩阵
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ans = new int[r][c];
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        for (int i = 0; i< m * n; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }
        return ans;
    }
}
