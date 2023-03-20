package leetcode.maximalNetworkRank;

import java.util.*;

/**
 * 1615. 最大网络秩
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MaximalNetworkRank {
    public static int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) {
            return 0;
        }
        List<Integer>[] table = new ArrayList[n];
        for (int i = 0; i <n; i++) {
            table[i] = new ArrayList<>();
        }
        for (int[] obj : roads) {
            table[obj[0]].add(obj[1]);
            table[obj[1]].add(obj[0]);
        }

        // 取两个最值
        // 判断最值是否关联
        int oneMax = 0;
        int oneIndex = -1;
        int twoMax = 0;
        List<Integer> twoIndex = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            if (table[i].size() > oneMax) {
                if (twoMax != oneMax) {
                    twoMax = oneMax;
                    twoIndex = new ArrayList<>();
                }
                twoIndex.add(oneIndex);
                oneMax = table[i].size();
                oneIndex = i;
            }
            else if (table[i].size() > twoMax) {
                twoMax = table[i].size();
                twoIndex = new ArrayList<>();
                twoIndex.add(i);
            }
            else if (table[i].size() == twoMax) {
                twoIndex.add(i);
            }
        }
        for (Integer i : twoIndex) {
            if (!table[oneIndex].contains(i)) {
                return twoMax + oneMax;
            }
        }
        return twoMax + oneMax -1;
    }

    public static void main(String[] args) {
        int[][] roads = new int[][]{{0,1},{0,3},{1,2},{1,3}};
        System.out.println(maximalNetworkRank(4, roads));
    }
}
