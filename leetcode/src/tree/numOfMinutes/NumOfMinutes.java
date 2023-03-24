package tree.numOfMinutes;

import java.util.*;

/**
 * 1376. 通知所有员工所需的时间
 *
 * @auther 韩仁松
 * @since business V1.0.0
 */
public class NumOfMinutes {
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> temp;
        for (int i = 0; i< n; i++) {
            if (map.containsKey(manager[i])) {
                temp = map.get(manager[i]);
            }
            else {
                temp = new LinkedList<>();
                map.put(manager[i], temp);
            }
            temp.add(i);
        }
//        for (int i = 0; i < manager.length; i++) {
//            map.computeIfAbsent(manager[i], v -> new ArrayList<>()).add(i);
//        }

        return dfs(map, informTime, headID);
    }

    public static int dfs(Map<Integer, List<Integer>> map, int[] informTime, int index) {
        if (informTime[index] == 0) {
            return 0;
        }
        int max = 0;

        for (Integer  value : map.get(index)) {
            max = Math.max(max, dfs(map, informTime, value));
        }
        return informTime[index] + max;
    }

    public static void main(String[] args) {
        int[] manager = new int[]{1,2,3,4,5,6,-1};
        int[] informTime = new int[]{0,6,5,4,3,2,1};
        System.out.println(numOfMinutes(7,6,manager,informTime));
    }
}
