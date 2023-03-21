package matrix.rotate;

/**
 * 48. 旋转图像
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class Rotate {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < (length >> 1);i++) {
            // 循环几圈
            for (int j = 0; j < ((length + 1) >> 1); j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = tmp;
            }
        }
    }
}
