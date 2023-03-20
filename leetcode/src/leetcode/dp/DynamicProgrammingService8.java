package leetcode.dp;

import entity.TreeNode;

import java.util.List;

public interface DynamicProgrammingService8 {

    /**
     * 873. 最长的斐波那契子序列的长度
     * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
     *
     * n >= 3
     * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
     * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
     *
     * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int lenLongestFibSubseq(int[] arr);


    /**
     * 877. 石子游戏
     * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
     *
     * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
     *
     * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
     *
     * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/stone-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    boolean stoneGame(int[] piles);

    /**
     * 894. 所有可能的满二叉树
     * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
     *
     * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
     *
     * 答案中每个树的每个结点都必须有 node.val=0。
     *
     * 你可以按任何顺序返回树的最终列表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    List<TreeNode> allPossibleFBT(int n);

    /**
     * 898. 子数组按位或操作
     * 我们有一个非负整数数组 A。
     *
     * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
     *
     * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bitwise-ors-of-subarrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int subarrayBitwiseORs(int[] arr);

    /**
     * 907. 子数组的最小值之和
     * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
     *
     * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int sumSubarrayMins(int[] arr);

    /**
     * 918. 环形子数组的最大和(Kadane 算法)
     * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
     *
     * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
     *
     * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-sum-circular-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int maxSubarraySumCircular(int[] nums);

    /**
     * 926. 将字符串翻转到单调递增
     * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
     *
     * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
     *
     * 返回使 S 单调递增的最小翻转次数。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flip-string-to-monotone-increasing
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int minFlipsMonoIncr(String s);

    /**
     * 931. 下降路径最小和
     * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
     *
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int minFallingPathSum(int[][] matrix);

    /**
     * 935. 骑士拨号器
     * 国际象棋中的骑士可以按下图所示进行移动：直行两步，垂直一步
     * 这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。
     *
     * 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。
     *
     * 你能用这种方式拨出多少个不同的号码？
     *
     * 因为答案可能很大，所以输出答案模 10^9 + 7。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/knight-dialer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int knightDialer(int n);


    /**
     * 978. 最长湍流子数组
     * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
     *
     * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
     * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
     *
     * 返回 A 的最大湍流子数组的长度。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int maxTurbulenceSize(int[] arr);
}
