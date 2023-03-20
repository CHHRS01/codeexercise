package offersecond.trace;

import entity.TreeNode;

import java.util.List;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public interface TraceService1 {


    /**
     * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
     * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     *
     * 每条从根节点到叶节点的路径都代表一个数字：
     *
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     *
     * 叶节点 是指没有子节点的节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3Etpl5
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int sumNumbers(TreeNode root);

    /**
     * 剑指 Offer II 050. 向下的路径节点之和
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     *
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/6eUYwP
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int pathSum(TreeNode root, int targetSum);


    /**
     * 剑指 Offer II 098. 路径的数目
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/2AoeFn
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int uniquePaths(int m, int n);


    /**
     * 剑指 Offer II 099. 最小路径之和
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：一个机器人每次只能向下或者向右移动一步。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/0i0mDW
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int minPathSum(int[][] grid);


    /**
     * 剑指 Offer II 100. 三角形中最小路径之和
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/IlPe0q
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int minimumTotal(List<List<Integer>> triangle);


    /**
     * 剑指 Offer II 106. 二分图
     * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。
     *
     * 给定一个二维数组 graph ，表示图，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
     *
     * 不存在自环（graph[u] 不包含 u）。
     * 不存在平行边（graph[u] 不包含重复值）。
     * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
     * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
     * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
     *
     * 如果图是二分图，返回 true ；否则，返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/vEAB3K
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    boolean isBipartite(int[][] graph);


    /**
     * 剑指 Offer II 110. 所有路径
     * 给定一个有 n 个节点的有向无环图，用二维数组 graph 表示，请找到所有从 0 到 n-1 的路径并输出（不要求按顺序）。
     *
     * graph 的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若为空，就是没有下一个节点了。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bP4bmD
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    List<List<Integer>> allPathsSourceTarget(int[][] graph);

}
