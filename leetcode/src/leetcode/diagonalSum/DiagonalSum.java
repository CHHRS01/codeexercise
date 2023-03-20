package leetcode.diagonalSum;

/**
 * 1572. 矩阵对角线元素的和
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class DiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int length = mat.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += mat[i][i];
            ans += mat[i][length - 1 - i];
        }
        if ((mat.length & 1) == 1) {
            int index = length >> 1;
            ans -= mat[index][index];
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] mat = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int[][] mat = {{7,3,1,9},{3,4,6,9},{6,9,6,6},{9,5,8,5}};
        System.out.println(diagonalSum(mat));
    }
}
