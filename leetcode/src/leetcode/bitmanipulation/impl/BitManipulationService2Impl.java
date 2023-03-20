package leetcode.bitmanipulation.impl;

import javafx.util.Pair;
import leetcode.bitmanipulation.BitManipulationService;
import leetcode.bitmanipulation.BitManipulationService1;
import leetcode.bitmanipulation.BitManipulationService2;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/27
 */

public class BitManipulationService2Impl implements BitManipulationService2 {



    /**
     * 371. 两整数之和
     * <p>
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int getSum(int a, int b) {
        BitManipulationService bitManipulationService = new BitManipulationServiceImpl();
        return bitManipulationService.add(a, b);
    }

    /**
     * 393. UTF-8 编码验证
     * <p>
     * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
     * <p>
     * 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
     * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
     * 这是 UTF-8 编码的工作方式：
     * <p>
     * Char. number range  |        UTF-8 octet sequence
     * (hexadecimal)    |              (binary)
     * --------------------+---------------------------------------------
     * 0000 0000-0000 007F | 0xxxxxxx
     * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
     * <p>
     * 注意：
     * 输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/utf-8-validation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param data
     * @return
     */
    @Override
    public boolean validUtf8(int[] data) {
        return false;
    }

    /**
     * 397. 整数替换
     * <p>
     * 给定一个正整数 n ，你可以做如下操作：
     * <p>
     * 如果 n 是偶数，则用 n / 2替换 n 。
     * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
     * n 变为 1 所需的最小替换次数是多少？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-replacement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    @Override
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>= 1;
            } else {
                if ((n & 2) == 0 || n == 3) {
                    n += -1;
                } else {
                    n += 1;
                }
            }
            count++;
        }
        return count;
    }

    /**
     * 421. 数组中两个数的最大异或值(字典树)
     * <p>
     * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     * <p>
     * 进阶：你可以在 O(n) 的时间解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    @Override
    public int findMaximumXOR(int[] nums) {
        return 0;
    }

    /**
     * 464. 我能赢吗
     * <p>
     * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。
     * <p>
     * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
     * <p>
     * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
     * <p>
     * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
     * <p>
     * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/can-i-win
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    @Override
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        /**
         *  dp表示"每个"取数(A和B共同作用的结果)状态下的输赢
         *  例如只有1,2两个数选择，那么 (1 << 2) - 1 = 4 - 1 = 3种状态表示：
         *  01,10,11分别表示：A和B已经选了1，已经选了2，已经选了1、2状态下，A的输赢情况
         *  并且可见这个表示所有状态的dp数组的每个状态元素的长度为maxChoosableInteger位的二进制数
         */
        Boolean[] dp = new Boolean[(1 << maxChoosableInteger) - 1];
        return dfs(maxChoosableInteger, desiredTotal, 0, dp);
    }

    /**
     * @param maxChoosableInteger 选择的数的范围[1,2,...maxChoosableInteger]
     * @param desiredTotal 目标和
     * @param state 当前状态的十进制表示（记录着可能不止一个数被选择的状态）
     * @param dp 记录所有状态
     * @return
     */
    private boolean dfs(int maxChoosableInteger, int desiredTotal, int state, Boolean[] dp) {
        if (dp[state] != null) {
            return dp[state];
        }
        /**
         * 例如maxChoosableInteger=2，选择的数只有1,2两个，二进制只要两位就可以表示他们的选择状态
         * 最大位为2（第2位），也就是1 << (2 - 1)的结果，所以最大的位可以表示为  1 << (maxChoosableInteger - 1)
         * 最小的位可以表示为 1 << (1 - 1)，也就是1（第1位）
         * 这里i表示括号的范围
         */
        for (int i = 1; i <= maxChoosableInteger; i++){
            //当前待抉择的位，这里的tmp十进制只有一位为1，用来判断其为1的位，对于state是否也是在该位上为1
            //用以表示该位（数字）是否被使用过
            /**
             * (&运算规则，都1才为1)
             * 例如,i=3, tmp = 4, state = 3;
             *  100
             * &011
             * =0  表示该位没有被使用过，也就是第三位没有被使用过，即数字3 (i)没有被使用过
             */
            int tmp = (1 << (i - 1));
            if ((tmp & state) == 0){  //该位没有被使用过
                //如果当前选了i已经赢了或者选了i还没赢但是后面对方选择输了,tmp|state表示进行状态的更新
                /**
                 * 例如
                 *  100
                 * |011
                 * =111
                 */
                //注意这里并没有像回溯一样进行状态的(赋值化的)更新、回溯
                //其实这里是隐含了回溯的，我们通过参数传递更新后的state
                //但是我们在这个调用者这里的state还是没有进行更新的，所以
                //就相当于回溯了状态。
                if (desiredTotal - i <= 0 || !dfs(maxChoosableInteger, desiredTotal - i, tmp|state, dp)) {
                    dp[state] = true;
                    return true;
                }
            }
        }
        //如果都赢不了
        dp[state] = false;
        return false;
    }

    /**
     * 473. 火柴拼正方形
     * <p>
     * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
     * <p>
     * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    @Override
    public boolean makesquare(int[] nums) {

        // Empty matchsticks.
        if (nums == null || nums.length == 0) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += nums[i];
        }

        int possibleSquareSide =  perimeter / 4;
        if (possibleSquareSide * 4 != perimeter) {
            return false;
        }

        this.nums = nums;
        this.possibleSquareSide = possibleSquareSide;
        return this.recurse((1 << L) - 1, 0);
    }

    // The memoization cache to be used during recursion.
    private HashMap<Pair<Integer, Integer>, Boolean> memo = new HashMap<>();

    // Array containing our matchsticks.
    private int[] nums;

    // Possible side of our square depending on the total sum of all the matchsticks. 
    private int possibleSquareSide;

    // Main DP function.
    private boolean recurse(Integer mask, Integer sidesDone) {
        int total = 0;
        int L = this.nums.length;

        // The memo key for this recursion
        Pair<Integer, Integer> memoKey = new Pair(mask, sidesDone);

        // Find out the sum of matchsticks used till now.
        for(int i = L - 1; i >= 0; i--) {
            if ((mask&(1 << i)) == 0) {
                total += this.nums[L - 1 - i];
            }
        }

        // If the sum if divisible by our square's side, then we increment our number of complete sides formed variable.
        if (total > 0 && total % this.possibleSquareSide == 0) {
            sidesDone++;
        }

        // Base case.
        if (sidesDone == 3) {
            return true;
        }


        // Return precomputed results
        if (this.memo.containsKey(memoKey)) {
            return this.memo.get(memoKey);
        }

        boolean ans = false;
        int c = total / this.possibleSquareSide;

        // Remaining vlength in the current partially formed side.
        int rem = this.possibleSquareSide * (c + 1) - total;

        // Try out all remaining options (that are valid)
        for(int i = L - 1; i >= 0; i--) {
            if (this.nums[L - 1 - i] <= rem && (mask&(1 << i)) > 0) {
                if (this.recurse(mask ^ (1 << i), sidesDone)) {
                    ans = true;
                    break;
                }
            }
        }

        // Cache the computed results.
        this.memo.put(memoKey, ans);
        return ans;
    }

    /**
     * 477. 汉明距离总和
     * <p>
     * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
     * <p>
     * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间汉明距离的总和。
     *
     * @param nums
     * @return
     */
    @Override
    public int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

    /**
     * 491. 递增子序列 存hash值记录是否重复
     * <p>
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     * <p>
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/increasing-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    @Override
    public List<List<Integer>> findSubsequences(int[] nums) {

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, Integer.MIN_VALUE, nums,temp,ans);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums,List<Integer> temp,List<List<Integer>> ans) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums,temp,ans);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums,temp,ans);
        }
    }

    /**
     * 526. 优美的排列
     * <p>
     * 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
     * <p>
     * perm[i] 能够被 i 整除
     * i 能够被 perm[i] 整除
     * 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/beautiful-arrangement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    @Override
    public int countArrangement(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }

    /**
     * 638. 大礼包
     * <p>
     * 在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
     * <p>
     * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
     * <p>
     * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
     * <p>
     * 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shopping-offers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param price
     * @param special
     * @param needs
     * @return
     */
    @Override
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return 0;
    }
}
