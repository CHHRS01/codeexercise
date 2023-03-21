package matrix.kClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 973. 最接近原点的 K 个点
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        if (k > points.length) {
            return points;
        }
        Arrays.sort(points, ((o1, o2) -> {
            return o1[0]*o1[0] + o1[1]*o1[1] - (o2[0]*o2[0] + o2[1]*o2[1]);
        }));
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(points[i]);
        }
        return ans.toArray(new int[k][2]);
    }
}
