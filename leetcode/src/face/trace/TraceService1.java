package face.trace;

import entity.TreeNode;

import java.util.List;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public interface TraceService1 {


    /**
     * 面试题 04.01. 节点间通路
     * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
     *
     * */
    boolean findWhetherExistsPath(int n, int[][] graph, int start, int target);

    /**
     * 面试题 04.12. 求和路径
     * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int pathSum(TreeNode root, int sum);


    /**
     * 面试题 08.02. 迷路的机器人
     * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    List<List<Integer>> pathWithObstacles(int[][] obstacleGrid);
}
