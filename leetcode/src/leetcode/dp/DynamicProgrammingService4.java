package leetcode.dp;

public interface DynamicProgrammingService4 {

    /**
     * 376. 摆动序列
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。
     * 仅有一个元素或者含两个不等元素的序列也视作摆动序列。
     *
     * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
     *
     * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
     *
     * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
     *
     * */
    int wiggleMaxLength(int[] nums);


    /**
     * 377. 组合总和 Ⅳ
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * 题目数据保证答案符合 32 位整数范围。
     * */
    int combinationSum4(int[] nums, int target);


    /**
     * 396. 旋转函数
     * 给定一个长度为 n 的整数数组 A 。
     *
     * 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
     *
     * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
     *
     * 计算F(0), F(1), ..., F(n-1)中的最大值。
     *
     * 注意:
     * 可以认为 n 的值小于 105。
     * */
    int maxRotateFunction(int[] nums);

    /**
     * 397. 整数替换
     * 给定一个正整数 n ，你可以做如下操作：
     *
     * 如果 n 是偶数，则用 n / 2替换 n 。
     * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
     * n 变为 1 所需的最小替换次数是多少？
     *
     * 位运算更快~~~~~~~~~
     * */
    int integerReplacement(int n);

    /**
     * 没有搞懂~~~~~~~~
     * 413. 等差数列划分
     * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
     *
     * 例如，以下数列为等差数列:
     *
     * 1, 3, 5, 7, 9
     * 7, 7, 7, 7
     * 3, -1, -5, -9
     * 以下数列不是等差数列。
     *
     * 1, 1, 2, 5, 7
     *  
     *
     * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
     *
     * 如果满足以下条件，则称子数组(P, Q)为等差数组：
     *
     * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
     *
     * 函数要返回数组 A 中所有为等差数组的子数组个数。
     * */
    int numberOfArithmeticSlices(int[] nums);

    /**
     * 416. 分割等和子集
     *
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * */
    boolean canPartition(int[] nums);

    /**
     * 435. 无重叠区间
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * */
    int eraseOverlapIntervals(int[][] intervals);

    /**
     * 464. 我能赢吗
     * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。
     *
     * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
     *
     * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
     *
     * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），
     * 判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
     *
     * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/can-i-win
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    boolean canIWin(int maxChoosableInteger, int desiredTotal);

    /**
     * 467. 环绕字符串中唯一的子字符串
     * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的：
     * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
     *
     * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，
     * 你需要输出字符串 s 中 p 的不同的非空子串的数目。 
     *
     * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int findSubstringInWraproundString(String p);

    /**
     * 473. 火柴拼正方形
     * DFS
     * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。
     * 不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
     *
     * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    boolean makesquare(int[] matchsticks);
}
