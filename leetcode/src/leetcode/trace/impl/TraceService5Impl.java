package leetcode.trace.impl;

import common.CommonConstants;
import leetcode.trace.TraceService5;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public class TraceService5Impl implements TraceService5 {

    /**
     * 1786. 从第一个节点出发到最后一个节点的受限路径数
     * 现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，其中每个 edges[i] = [ui, vi, weighti] 表示存在一条位于节点 ui 和 vi 之间的边，这条边的权重为 weighti 。
     * <p>
     * 从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，满足 z0 = start 、zk = end 且在所有符合 0 <= i <= k-1 的节点 zi 和 zi+1 之间存在一条边。
     * <p>
     * 路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。受限路径 为满足 distanceToLastNode(zi) > distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。
     * <p>
     * 返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 109 + 7 取余 的结果。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-restricted-paths-from-first-to-last-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param edges
     */
    @Override
    public int countRestrictedPaths(int n, int[][] edges) {
        // 预处理所有的边权。 a b w -> a : { b : w } + b : { a : w }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            int a = e[0], b = e[1], w = e[2];
            Map<Integer, Integer> am = map.getOrDefault(a, new HashMap<Integer, Integer>());
            am.put(b, w);
            map.put(a, am);
            Map<Integer, Integer> bm = map.getOrDefault(b, new HashMap<Integer, Integer>());
            bm.put(a, w);
            map.put(b, bm);
        }

        // 堆优化 Dijkstra：求 每个点 到 第n个点 的最短路
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        Queue<int[]> q = new PriorityQueue<int[]>((a, b)->a[1]-b[1]); // 点编号，点距离。根据点距离从小到大
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int idx = e[0], cur = e[1];
            if (st[idx]) continue;
            st[idx] = true;
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) continue;
            for (int i : mm.keySet()) {
                dist[i] = Math.min(dist[i], dist[idx] + mm.get(i));
                q.add(new int[]{i, dist[i]});
            }
        }

        // dp 过程
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i] = new int[]{i + 1, dist[i + 1]}; // 点编号，点距离
        Arrays.sort(arr, (a, b)->a[1]-b[1]); // 根据点距离从小到大排序

        // 定义 f(i) 为从第 i 个点到结尾的受限路径数量
        // 从 f[n] 递推到 f[1]
        int[] f = new int[n + 1];
        f[n] = 1;
        for (int i = 0; i < n; i++) {
            int idx = arr[i][0], cur = arr[i][1];
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) {
                continue;
            }
            for (int next : mm.keySet()) {
                if (cur > dist[next]) {
                    f[idx] += f[next];
                    f[idx] %= CommonConstants.MOD;
                }
            }
            // 第 1 个节点不一定是距离第 n 个节点最远的点，但我们只需要 f[1]，可以直接跳出循环
            if (idx == 1) {
                break;
            }
        }
        return f[1];
    }

    /**
     * 1926. 迷宫中离入口最近的出口
     * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
     * <p>
     * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
     * <p>
     * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param maze
     * @param entrance
     */
    @Override
    public int nearestExit(char[][] maze, int[] entrance) {
        //存四个方向
        int m = maze.length,n = maze[0].length;

        //存位置的队列
        Queue<int[]> queue = new LinkedList<>();
        //最开始位置入队
        queue.offer(entrance);

        //可有可无
        int[][] dist = new int[m][n];
        //访问判断
        boolean[][] visit = new boolean[m][n];
        //起点初始化
        visit[entrance[0]][entrance[1]] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            //当前队列的位置个数
            int size = queue.size();
            count++;//记录需要几次走到要求的位置
            while (size-- > 0) {
                int[] nowindex = queue.poll();
                int i = nowindex[0], j = nowindex[1];
                //走四个方向
                for (int k = 0; k < 4; k++) {
                    int i_new = i + CommonConstants.DIRS[k][0];
                    int j_new = j + CommonConstants.DIRS[k][1];

                    //边界条件或者剪枝策略
                    if (i_new >= 0 && i_new < m && j_new >= 0 && j_new < n && maze[i_new][j_new] == '.'&&visit[i_new][j_new]!=true) {
                        //dist[i_new][j_new] = 1; 可有可无
                        //题目所求，如果符合条件，直接返回
                        if(i_new==0||i_new==m-1||j_new==0||j_new==n-1){
                            return  count;
                        }
                        //将当前位置标记为true 防止下次再访问
                        visit[i_new][j_new] = true;
                        //当前位置入队，便于进行下一次操作。
                        queue.offer(new int[]{i_new, j_new});
                    }
                }
            }
        }

//        for (int[] ints : dist) {
//            for (int anInt : ints) {
//                System.out.print(anInt+" ");
//            }
//            System.out.println();
//        }
        //找不到的时候返回题目要求的-1
        return -1;
    }


}
