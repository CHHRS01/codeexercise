package leetcode.dp;

import entity.TreeNode;

public interface DynamicProgrammingService11 {

    /**
     * 1218. 最长定差子序列
     * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
     *
     * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int longestSubsequence(int[] arr, int difference);


    /**
     * 1227. 飞机座位分配概率
     * 有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
     *
     * 剩下的乘客将会：
     *
     * 如果他们自己的座位还空着，就坐到自己的座位上，
     *
     * 当他们自己的座位被占用时，随机选择其他座位
     * 第 n 位乘客坐在自己的座位上的概率是多少？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/airplane-seat-assignment-probability
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    double nthPersonGetsNthSeat(int n);

    /**
     * 1262. 可被三整除的最大和
     * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
     *
     * */
    int maxSumDivThree(int[] nums);

    /**
     * 1277. 统计全为 1 的正方形子矩阵
     * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
     *
     * */
    int countSquares(int[][] matrix);

    /**
     * 1334. 阈值距离内邻居最少的城市
     * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
     *
     * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
     *
     * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int findTheCity(int n, int[][] edges, int distanceThreshold);

    /**
     * 1372. 二叉树中的最长交错路径
     * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
     *
     * 选择二叉树中 任意 节点和一个方向（左或者右）。
     * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
     * 改变前进方向：左变右或者右变左。
     * 重复第二步和第三步，直到你在树中无法继续移动。
     * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
     *
     * 请你返回给定树中最长 交错路径 的长度。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int longestZigZag(TreeNode root);

    /**
     * 1387. 将整数按权重排序
     *
     * 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
     *
     * 如果 x 是偶数，那么 x = x / 2
     * 如果 x 是奇数，那么 x = 3 * x + 1
     * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
     *
     * 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
     *
     * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
     *
     * 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
     *
     * */
    int getKth(int lo, int hi, int k);

    /**
     * 1395. 统计作战单位数
     * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
     *
     * 每 3 个士兵可以组成一个作战单位，分组规则如下：
     *
     * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
     * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
     * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-number-of-teams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int numTeams(int[] rating);

    /**
     * 1477. 找两个和为目标值且不重叠的子数组
     * 给你一个整数数组 arr 和一个整数值 target 。
     *
     * 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
     *
     * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int minSumOfLengths(int[] arr, int target);


    /**
     * 1493. 删掉一个元素以后全为 1 的最长子数组
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     *
     * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     *
     * 如果不存在这样的子数组，请返回 0 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int longestSubarray(int[] nums);
}
