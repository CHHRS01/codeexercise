package leetcode.bitmanipulation;

import java.util.List;

/**
 * @author hanrensong
 * @date 2021/8/27
 */

public interface BitManipulationService2 {


    /**
     * 371. 两整数之和
     *
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     * @param a
     * @param b
     * @return
     */
    int getSum(int a, int b);


    /**
     * 393. UTF-8 编码验证
     *
     * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
     *
     * 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
     * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
     * 这是 UTF-8 编码的工作方式：
     *
     *    Char. number range  |        UTF-8 octet sequence
     *       (hexadecimal)    |              (binary)
     *    --------------------+---------------------------------------------
     *    0000 0000-0000 007F | 0xxxxxxx
     *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
     *
     * 注意：
     * 输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/utf-8-validation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param data
     * @return
     */
    boolean validUtf8(int[] data);

    /**
     * 397. 整数替换
     *
     * 给定一个正整数 n ，你可以做如下操作：
     *
     * 如果 n 是偶数，则用 n / 2替换 n 。
     * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
     * n 变为 1 所需的最小替换次数是多少？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-replacement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    int integerReplacement(int n);

    /**
     * 421. 数组中两个数的最大异或值
     *
     * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     *
     * 进阶：你可以在 O(n) 的时间解决这个问题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    int findMaximumXOR(int[] nums);

    /**
     * 464. 我能赢吗
     *
     * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。
     *
     * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
     *
     * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
     *
     * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
     *
     * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/can-i-win
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    boolean canIWin(int maxChoosableInteger, int desiredTotal);

    /**
     * 473. 火柴拼正方形
     *
     * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
     *
     * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param matchsticks
     * @return
     */
    boolean makesquare(int[] matchsticks);

    /**
     * 477. 汉明距离总和
     *
     * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
     *
     * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间汉明距离的总和。
     * @param nums
     * @return
     */
    int totalHammingDistance(int[] nums);

    /**
     * 491. 递增子序列
     *
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     *
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/increasing-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    List<List<Integer>> findSubsequences(int[] nums);

    /**
     * 526. 优美的排列
     *
     * 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
     *
     * perm[i] 能够被 i 整除
     * i 能够被 perm[i] 整除
     * 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/beautiful-arrangement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    int countArrangement(int n);

    /**
     * 638. 大礼包
     *
     * 在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
     *
     * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
     *
     * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
     *
     * 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shopping-offers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param price
     * @param special
     * @param needs
     * @return
     */
    int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs);
}
