package leetcode.nearestValidPoint;

import java.util.Arrays;

/**
 * 找到最近的有相同 X 或 Y 坐标的点
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class NearestValidPoint {

    public static int nearestValidPoint(int x, int y, int[][] points) {
        // 枚举所有
        int n = points.length;
        int best = Integer.MAX_VALUE, bestid = -1;
        for (int i = 0; i < n; ++i) {
            int px = points[i][0], py = points[i][1];
            if (x == px) {
                int dist = Math.abs(y - py);
                if (dist < best) {
                    best = dist;
                    bestid = i;
                }
            }
            else if (y == py) {
                int dist = Math.abs(x - px);
                if (dist < best) {
                    best = dist;
                    bestid = i;
                }
            }
        }
        return bestid;

    }


    public  static void main(String[] args) {
        int[][] points = {{1,2},{3,1},{2,4},{2,3},{4,4}};
        System.out.println(nearestValidPoint(1, 2, points));
    }

}
