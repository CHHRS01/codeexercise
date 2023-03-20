package leetcode.dp.impl;


import common.CommonConstants;
import leetcode.dp.DynamicProgrammingService14;

import java.util.*;

/**
 * basic sort methon for array
 * param is not null
 */
public class DynamicProgrammingService14Impl implements DynamicProgrammingService14 {


    @Override
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long odd = nums[0], even = Integer.MIN_VALUE;
        long[][] f = new long[n][2];
        for (int i = 1; i < n; i++) {
            long t1 = odd, t2 = even;
            odd = Math.max(t1, Math.max(nums[i], t2 + nums[i]));
            even = Math.max(t2, t1 - nums[i]);
        }
        return odd;
    }

    @Override
    public int twoEggDrop(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] = Math.min(f[i], Math.max(j, f[i - j] + 1));
            }
        }
        return f[n];
    }

    @Override
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        dfs(n,res,0,0,"");
        return res;
    }

    //DFS模板
    private void dfs(int n,ArrayList<String> temp,int leftNum,int rightNum,String str){
        //出口一：判断不满足条件的情况，主要从左右括号数量上判断，三种情况。
        if(leftNum < rightNum || leftNum > n || rightNum > n){
            return;
        }
        //出口二：满足条件，即左右括号数量相等且已经达到最大值。
        if(leftNum == rightNum && rightNum == n){
            temp.add(str);
        }
        //否则
        else{
            //一定要先加左括号，再加右括号；
            //加完左括号后，左括号数量加1,回溯；
            dfs(n,temp,leftNum+1,rightNum,str+"(");

            //再加右括号，然后dfs，再回溯。
            dfs(n,temp,leftNum,rightNum+1,str+")");
        }
    }

    @Override
    public int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1};
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % CommonConstants.MOD;
            }
        }
        return f[n];
    }

    @Override
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    @Override
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 2; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    @Override
    public int cuttingRopeII(int n) {
        if(n < 4) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if(b == 0) {
            return (int) (myPow(3, a) % CommonConstants.MOD);
        }
        else if(b == 1) {
            return (int) (myPow(3, a - 1) * 4 % CommonConstants.MOD);
        }
        else {
            return (int) (myPow(3, a) * 2 % CommonConstants.MOD);
        }
    }

    private long myPow(long base, int num){
        long res = 1;
        while(num > 0){
            if((num & 1) == 1){
                res *= base;
                res %= CommonConstants.MOD;
            }
            base *= base;
            base %= CommonConstants.MOD;
            num >>= 1;
        }
        return res;
    }

    @Override
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    @Override
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    @Override
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
