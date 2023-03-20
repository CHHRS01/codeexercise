package face.trace.impl;

import face.trace.TraceService1;
import entity.TreeNode;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public class TraceService1Impl implements TraceService1 {

    /**
     * 面试题 04.01. 节点间通路
     * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
     *
     * @param n
     * @param graph
     * @param start
     * @param target
     */
    @Override
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        return false;
    }

    /**
     * 面试题 04.12. 求和路径
     * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param sum
     */
    @Override
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int[] ret = new int[1];
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        valueList.add(sum);
        inOrder(root, valueList, ret, sum);
        return ret[0];
    }

    private void inOrder(TreeNode root, ArrayList<Integer> valueList, int[] ret, int sum){
        ArrayList<Integer> listChild = new ArrayList<Integer>();
        listChild.add(sum);
        for(Integer value: valueList){
            if(root.val == value) {
                ret[0]++;
            }
            listChild.add(value-root.val);
        }
        if(root.left !=null) {
            inOrder(root.left, listChild, ret, sum);
        }
        if(root.right !=null) {
            inOrder(root.right, listChild, ret, sum);
        }
    }

    /**
     * 面试题 08.02. 迷路的机器人
     * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param obstacleGrid
     */
    @Override
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return new ArrayList<>();
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i - 1 >= 0 && dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                    if (j - 1 >= 0 && dp[i][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        if (dp[m - 1][n - 1]) {
            int row = m - 1, col = n - 1;
            while (row != 0 || col != 0) {
                res.add(0, Arrays.asList(row, col));
                if (row - 1 >= 0 && dp[row - 1][col]) {
                    row--;
                } else {
                    col--;
                }
            }
            res.add(0, Arrays.asList(0, 0));
        }
        return res ;
    }
}
