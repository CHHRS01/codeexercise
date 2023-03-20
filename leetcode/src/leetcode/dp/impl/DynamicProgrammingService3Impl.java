package leetcode.dp.impl;

import leetcode.dp.DynamicProgrammingService3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgrammingService3Impl implements DynamicProgrammingService3 {
    @Override
    public int nthUglyNumber(int n) {
        if(n == 1) {
            return 1;
        }
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        int[] dp = new int[n];
        dp[0]=1;
        for(int i = 1;i < n; i++){
            dp[i] = Math.min(dp[n2] * 2, Math.min(dp[n3] * 3, dp[n5] * 5));
            if(dp[i] == dp[n2] * 2) {
                n2++;
            }
            if(dp[i] == dp[n3]*3) {
                n3++;
            }
            if(dp[i] == dp[n5]*5) {
                n5++;
            }
        }
        return dp[n - 1];
    }

    @Override
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                if(i >= j * j){
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }

    @Override
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;

        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Override
    public int maxProfit(int[] prices) {
        //sold（卖出股票）、rest（什么也不做）、hold（持有股票）
        int sold = 0,rest = 0,hold = Integer.MIN_VALUE;
        for(int p : prices) {
            int preHold = sold;
            sold = hold + p;
            hold = Math.max(hold, rest - p);
            rest = Math.max(rest, preHold);
        }

        return Math.max(rest, sold);
    }

    @Override
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int primesNumber = primes.length, min = 1, next = 1;
        int[] primeIndexes = new int[primesNumber];
        int[] tempPrimes = new int[primesNumber];

        Arrays.fill(tempPrimes, 1);

        for (int i = 0; i < n; i++) {
            uglyNumbers[i] = min;
            min = Integer.MAX_VALUE;
            for (int j = 0; j < tempPrimes.length; j++) {
                if (tempPrimes[j] == next) {
                    tempPrimes[j] = primes[j] * uglyNumbers[primeIndexes[j]];
                    primeIndexes[j]++;
                }
                min = Math.min(tempPrimes[j], min);
            }
            next = min;
        }

        return uglyNumbers[n - 1];
    }

    @Override
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];  //dp[i]表示达到i用的最少硬币数  默认=初始化全为0
        for (int i = 1; i <= amount; i++) {  //目标为0 的不用计算
            dp[i] = 999999;   //此处不能用int的最大值，最大值+1 会溢出变为最小值
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] =Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount]==999999 ? -1 : dp[amount];
    }

    @Override
    public int integerBreak(int n) {
        //初始化为0
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(Math.max(j * dp[i-j],j * (i-j)), dp[i]);
            }
        }
        return dp[n];
    }

    @Override
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
        }
        return dp[n];
    }

    @Override
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 题目中说「没有重复元素」很重要
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<Integer>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }

    @Override
    public int getMoneyAmount(int n) {
        //区间
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                int temp = Integer.MAX_VALUE;
                for (int k = j + 1; k < i; k++) {
                    temp = Math.min( temp, k + Math.max(dp[j][k-1],dp[k+1][i]) );
                }
                dp[j][i] = j + 1 == i ? j : temp;
            }
        }
        return dp[1][n];
    }
}
