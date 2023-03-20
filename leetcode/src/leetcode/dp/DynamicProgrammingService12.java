package leetcode.dp;

public interface DynamicProgrammingService12 {

    /**
     * 1504. 统计全 1 子矩形
     * 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
     *
     * */
    int numSubmat(int[][] mat);


    /**
     * 1524. 和为奇数的子数组数目
     * 给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
     *
     * 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
     * */
    int numOfSubarrays(int[] arr);


    /**
     * 1525. 字符串的好分割数目
     * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
     *
     * 请你返回 s 中好分割的数目。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int numSplits(String s);


    /**
     * 1567. 乘积为正数的最长子数组长度
     * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
     *
     * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
     *
     * 请你返回乘积为正数的最长子数组长度。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int getMaxLen(int[] nums);


    /**
     * 1578. 避免重复字母的最小删除成本
     * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
     *
     * 返回使字符串任意相邻两个字母不相同的最小删除成本。
     *
     * 请注意，删除一个字符后，删除其他字符的成本不会改变。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int minCost(String s, int[] cost);


    /**
     * 1594. 矩阵的最大非负积
     * 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
     *
     * 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
     *
     * 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。
     *
     * 注意，取余是在得到最大积之后执行的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int maxProductPath(int[][] grid);


    /**
     * 1621. 大小为 K 的不重叠线段的数目
     * 给你一维空间的 n 个点，其中第 i 个点（编号从 0 到 n-1）位于 x = i 处，请你找到 恰好 k 个不重叠 线段且每个线段至少覆盖两个点的方案数。线段的两个端点必须都是 整数坐标 。这 k 个线段不需要全部覆盖全部 n 个点，且它们的端点 可以 重合。
     *
     * 请你返回 k 个不重叠线段的方案数。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-sets-of-k-non-overlapping-line-segments
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int numberOfSets(int n, int k);


    /**
     * 1638. 统计只差一个字符的子串数目
     * 给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。换言之，请你找到 s 和 t 串中 恰好 只有一个字符不同的子字符串对的数目。
     *
     * 比方说， "computer" 和 "computation" 加粗部分只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。
     *
     * 请你返回满足上述条件的不同子字符串对数目。
     *
     * 一个 子字符串 是一个字符串中连续的字符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-substrings-that-differ-by-one-character
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int countSubstrings(String s, String t);


    /**
     * 1626. 无矛盾的最佳球队
     * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
     *
     * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
     *
     * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-team-with-no-conflicts
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int bestTeamScore(int[] scores, int[] ages);

    /**
     * 1653. 使字符串平衡的最少删除次数
     * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
     *
     * 你可以删除 s 中任意数目的字符，使得 s 平衡 。我们称 s 平衡的 当不存在下标对 (i,j) 满足 i < j 且 s[i] = 'b' 同时 s[j]= 'a' 。
     *
     * 请你返回使 s 平衡 的 最少 删除次数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-deletions-to-make-string-balanced
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int minimumDeletions(String s);
}
