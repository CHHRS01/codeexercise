package leetcode.dp.impl;

import common.CommonConstants;
import javafx.util.Pair;
import leetcode.dp.DynamicProgrammingService4;

import java.util.*;

public class DynamicProgrammingService4Impl implements DynamicProgrammingService4 {

    @Override
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }

    @Override
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 1.初始化dp数组 dynamic programming
        int dp[] = new int[target + 1];
        // 代表一个空集 空集和它"前面"的元素凑成一种解法，所以是 1
        dp[0] = 1;
        // 动态规划
        // 2.遍历目标正整数 i的意思是当前的目标正整数
        for (int i = 1; i <= target; i++) {
            // 3.遍历数组
            for (int num : nums) {
                if (i - num >= 0) {
                    // dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ...
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    @Override
    public int maxRotateFunction(int[] nums) {
        int Fk = 0;
        int max = 0;
        int sum = 0;
        //计算 F(0)和 sum(A)
        for (int i = 0; i < nums.length; i++) {
            Fk += i * nums[i];
            sum += nums[i];
        }
        max = Fk;
        for (int i = 0; i < nums.length; i++) {
            //F(k+1) = F(k) + sum(A) -n*Bk[n-1]
            Fk = Fk + sum - nums.length * nums[nums.length - i - 1];
            //比较 Fk求最大值
            if (Fk > max) {
                max = Fk;
            }
        }
        return max;
    }

    @Override
    public int integerReplacement(int n) {
        long m = (long) n;
        int count = 0;
        while (m != 1) {
            if ((m & 1) == 0) {
                m >>= 1;
                //与三==1的话，要减减才快一些
            } else if (m == 3 || (m & 3) == 1) {
                --m;
                //与3的时候可以二进制除两位
            } else if ((m & 3) == 3) {
                ++m;
            }
            ++count;
        }
        return count;
    }

    @Override
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return 0;
        }
        int ans = 0;
        int[] dp = new int[n];
        int dis = 0;
        int mark = 2;
        if ((nums[2] - nums[1]) == (nums[1] - nums[0])) {
            dp[2] = 1;
            mark = 3;
        }
        dis = nums[2] - nums[1];
        for (int i = 3; i < n; i++) {
            if (nums[i] - nums[i - 1] == dis) {
                mark++;
                if (mark >= 3) {
                    dp[i] = dp[i - 1] + 1;
                }

            } else {

                ans += dp[i - 1] * (dp[i - 1] + 1) / 2;
                dis = nums[i] - nums[i - 1];
                dp[i] = 0;
                mark = 2;
            }
        }
        ans += dp[n - 1] * (dp[n - 1] + 1) / 2;
        return ans;
    }

    @Override
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            maxNum = Math.max(maxNum, i);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，无法装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 不装入或装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

    @Override
    public int eraseOverlapIntervals(int[][] intervals) {
        // 判空，没有区间当然是不需要移除啦
        if (intervals.length == 0) {
            return 0;
        }
        // 我们首先按照每个区间的左值排序，在这里我们其实不需要考虑左值相等，右边不一样怎么排序的情况；
        // 由于我们不需要知道具体去除哪一个区间，只需要知道去除的数量，因此我们后面的动态规划会自动找到最优的情况
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });
        // 动态规划数组大小只需要等于区间的个数即可
        int n = intervals.length;
        // 初始化动态规划数组
        int[] dp = new int[n];
        // 至少都可以留一个区间，所以无论如何都会大于1，我们先都赋值1即可
        Arrays.fill(dp, 1);
        // 动态规划开始，这里有点精妙，其实就是模拟流程
        // 其实外层循环就是完整遍历每一个区间
        for (int i = 0; i < n; i++) {
            // 动态规划的流程如下：
            /**对应外层的每一个区间，我们都用这个区间和该区间左边的比较，为什么比左边？
             因为我们是排序过的，右边的区间左值只要大于左边区间的右值，那么这两个区间是可以同时保留的；
             而前一个区间可以可以和再前面的区间同时保留，因此到这个区间为止我们就最多能保留dp[j] + 1即可
             到这里好像就结束了，其实没有，因为内层循环时，可能有多个区间，我们不知道匹配前面的哪个区间是最优的
             所以我们这里需要看dp[j] + 1和内循环的前一次的值（上一次存下来的dp[i]）哪个大，哪个大我们就存哪个*/
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // num为可以保留的最大区间数
        // Arrays.stream().max()是java8新特性，因为数组不好进行最大值的获取，我们转成流并取出最大值，再将取出的最大值转为Int
        int num = Arrays.stream(dp).max().getAsInt();
        // 返回移除区间的最小数量
        return n - num;
    }

    @Override
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        // 注意这里用的是Boolean 不是boolean 所以才能在递归里判断值是不是null
        // 多一位冗余,比如num=8,如果数组大小是1<<8,
        // 那么刚开始的时候就会误以为8已经选了,因为对应二进制位是1
        Boolean[] vis = new Boolean[1 << (maxChoosableInteger + 1)];
        return canWinHelper(maxChoosableInteger, desiredTotal, 0, vis);
    }

    /**
     * @param num    选择的数的范围[1,2,...num]
     * @param target 目标和
     * @param state  当前状态的十进制表示（记录着可能不止一个数被选择的状态）
     * @param vis    记录所有状态
     * @return 这个人能不能赢
     * 函数里面返回的是state的状态,而不是curState
     */
    private boolean canWinHelper(int num, int target, int state, Boolean[] vis) {
        if (target <= 0) {
            return false;
        }
        if (vis[state] != null) {
            return vis[state];
        }
        for (int i = 1; i <= num; ++i) {  // 每次递归都要完整遍历1~num
            int curChooseNum = 1 << i;    // 这次选的i
            int curState = curChooseNum | state; //已经选的状态合并当前i得到新状态
            if ((curChooseNum & state) != 0) {
                continue;
            }
            if (!canWinHelper(num, target - i, curState, vis)) {
                return vis[state] = true;
            }
        }
        return vis[state] = false;
    }

    @Override
    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        int[] tabLen = new int[26];
        int curLen = 1;
        tabLen[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < p.length(); ++i) {
            int pre = p.charAt(i - 1) - 'a';
            int cur = p.charAt(i) - 'a';
            if ((cur - pre + 26) % 26 == 1) {
                curLen++;
            } else {
                curLen = 1;
            }
            // 为什么下面是取max?
            //比如zaba, 最后一个a单独出现的情况已经在第一个a出现的时候计算过了
            // 最后一个a造成的答案长是1，但是第一个a可以造成a，za两个结果
            // 所以，对于a这个字符，取最大的也就是第一个a产生的子集
            tabLen[cur] = Math.max(tabLen[cur], curLen);
        }

        int ans = 0;
        //累加数组的值得到所有字母结尾有效字符串的和
        for (int count : tabLen) {
            ans += count;
        }
        return ans;
    }

    @Override
    public boolean makesquare(int[] nums) {

        // Empty matchsticks.
        if (nums == null || nums.length < CommonConstants.INTEGER_3) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int length = nums.length;
        int perimeter = 0;
        for(int i = 0; i < length; i++) {
            perimeter += nums[i];
        }

        int possibleSquareSide =  perimeter / 4;
        if (possibleSquareSide * CommonConstants.INTEGER_4 != perimeter) {
            return false;
        }

        return this.recurse((1 << length) - 1, 0, nums, possibleSquareSide);
    }

    private boolean recurse(Integer mask, Integer sidesDone, int[] nums, int possibleSquareSide) {
        int total = 0;
        int L = nums.length;

        // The memo key for this recursion
        Pair<Integer, Integer> memoKey = new Pair(mask, sidesDone);

        // Find out the sum of matchsticks used till now.
        for(int i = L - 1; i >= 0; i--) {
            if ((mask&(1 << i)) == 0) {
                total += nums[L - 1 - i];
            }
        }

        // If the sum if divisible by our square's side, then we increment our number of complete sides formed variable.
        HashMap<Pair<Integer, Integer>, Boolean> memo = new HashMap<>();
        if (total > 0 && total % possibleSquareSide == 0) {
            sidesDone++;
        }

        // Base case.
        if (sidesDone == 3) {
            return true;
        }


        // Return precomputed results
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        boolean ans = false;
        int c = total / possibleSquareSide;

        // Remaining vlength in the current partially formed side.
        int rem = possibleSquareSide * (c + 1) - total;

        // Try out all remaining options (that are valid)
        for(int i = L - 1; i >= 0; i--) {
            if (nums[L - 1 - i] <= rem && (mask&(1 << i)) > 0) {
                if (this.recurse(mask ^ (1 << i), sidesDone, nums, possibleSquareSide)) {
                    ans = true;
                    break;
                }
            }
        }

        // Cache the computed results.
        memo.put(memoKey, ans);
        return ans;
    }


}