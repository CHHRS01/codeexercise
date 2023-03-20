package leetcode.dp;


import java.util.List;

public interface DynamicProgrammingService3 {

    /**
     * 264. 丑数 II
     */
    int nthUglyNumber(int n);

    /**
     * 279. 完全平方数
     */
    int numSquares(int n);

    /**
     * 300. 最长递增子序列
     */
    int lengthOfLIS(int[] nums);

    /**
     * 309. 最佳买卖股票时机含冷冻期
     */
    int maxProfit(int[] prices);

    /**
     * 313. 超级丑数
     */
    int nthSuperUglyNumber(int n, int[] primes);

    /**
     * 322. 零钱兑换
     */
    int coinChange(int[] coins, int amount);

    /**
     * 343. 整数拆分
     */
    int integerBreak(int n);

    /**
     * 357. 计算各个位数不同的数字个数
     */
    int countNumbersWithUniqueDigits(int n);

    /**
     * 368. 最大整除子集
     */
    List<Integer> largestDivisibleSubset(int[] nums);

    /**
     * 375. 猜数字大小 II
     */
    int getMoneyAmount(int n)   ;

}
