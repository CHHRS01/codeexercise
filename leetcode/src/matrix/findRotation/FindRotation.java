package matrix.findRotation;

/**
 * 1886. 判断矩阵经轮转后是否一致
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class FindRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int tmp;
        int length = mat.length;
        // 最多旋转 4 次
        for (int k = 0; k < 4; ++k) {
            for (int i = 0; i < (length >> 1);i++) {
                // 循环几圈
                for (int j = 0; j < ((length + 1) >> 1); j++) {
                    tmp = mat[i][j];
                    mat[i][j] = mat[length - 1 - j][i];
                    mat[length - 1 - j][i] = mat[length - 1 - i][length - 1 - j];
                    mat[length - 1 - i][length - 1 - j] = mat[j][length - 1 - i];
                    mat[j][length - 1 - i] = tmp;
                }
            }

            if (judge(mat, target)) {
                return true;
            }
        }
        return false;

    }

    public static Boolean judge(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n * n; i++) {
            if (mat[i / n][ i % n] != target[i / n][ i % n]) {
                return false;
            }
        }
        return true;
    }
}
