package matrix.spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length- 1;
        while (left <= right && top <= bottom) {
            //1
            for (int column = left; column <= right; column++) {
                ans.add(matrix[top][column]);
            }
            //2
            for (int row = top + 1; row <= bottom; row++) {
                ans.add(matrix[row][right]);
            }

            if (left < right && top < bottom) {
                //3
                for (int column = right - 1; column > left; column--) {
                    ans.add(matrix[bottom][column]);
                }
                //4
                for (int row = bottom; row > top; row--) {
                    ans.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1}
        };
        List<Integer> ans = spiralOrder(matrix);
        for (Integer value : ans) {
            System.out.print(value);
            System.out.print(" ");
        }

    }
}
