package leetcode.dp.impl;

import common.CommonConstants;
import leetcode.dp.DynamicProgrammingService10;

import java.util.Arrays;

public class DynamicProgrammingService10Impl implements DynamicProgrammingService10 {

    @Override
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = m; j >= weight; --j) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = m;; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }

    @Override
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        //dp[i]表示以第i-1本书（从第0本算起）结尾的前i本书叠成的最小高度
        int[] dp = new int[n+1];

        dp[1] = books[0][1];

        for(int i = 2; i <= n; i++) {
            dp[i] = books[i-1][1] + dp[i-1];
            int w = books[i-1][0], h = books[i-1][1];
            for(int j = i-1; j > 0; j--) {
                w += books[j-1][0];
                if(w > shelf_width) {
                    break;
                }
                h = Math.max(h, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + h);
            }
        }

        return dp[n];
    }

    @Override
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        int[][] max = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int l = r; l >= 0; l--) {
                max[l][r] = l == r ? arr[l] : Math.max(max[l + 1][r], arr[l]);
            }
        }
        for (int r = 0; r < n; r++) {
            for (int l = r; l >= 0; l--) {
                for (int i = l; i < r; i++) {
                    int val = max[l][i] * max[i + 1][r];
                    dp[l][r] = Math.min(dp[l][r], val + dp[l][i] + dp[i + 1][r]);
                }
            }
        }
        return dp[0][n - 1];
    }

    @Override
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j][0]: i,j左边连续的1的个数
        //dp[i][j][1]: i,j上边连续的1的个数
        int[][][] dp = new int[m+1][n+1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i-1][j-1] == 1){
                    dp[i][j][0] = 1 + dp[i][j-1][0];
                    dp[i][j][1] = 1 + dp[i-1][j][1];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //最短的那条边不一定是合法的边长，如果该边长不合法就需要缩减边长，直到找到合法的
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--){
                    if (dp[i][j-side+1][1] >= side && dp[i-side+1][j][0] >= side){
                        res = Math.max(res, side);
                        break; //更短的就没必要考虑了
                    }
                }
            }
        }
        return res * res;
    }

    @Override
    public int stoneGameII(int[] piles) {
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    @Override
    public int numRollsToTarget(int d, int f, int target) {

        if(target==0||f==0||d==0){return 0;}
        int[][] dp=new int[2][target+1];
        for(int i=0;i<=target;i++){
            dp[0][i]=0;
        }
        dp[0][0]=1;
        for(int i=0;i<d;i++){
            int row=i&1;
            int nextRow=~i&1;
            for(int j=0;j<=target;j++){
                if(dp[row][j]!=0){
                    for(int k=1;k<=f;k++){
                        if(j+k<=target){
                            dp[nextRow][j+k]+=dp[row][j];
                            dp[nextRow][j+k]%= CommonConstants.MOD;
                        }
                    }
                }
            }
            Arrays.fill(dp[row],0);
        }
        return dp[d&1][target];
    }

    @Override
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int k = 1;
        int max = arr[0];
        int[][] dp = new int[n][k + 1];
        //init
        dp[0][0] = arr[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i],arr[i]);
            max = Math.max(max,dp[i][0]);
        }
        //dp
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j] = Math.max(dp[i - 1][j] + arr[i],dp[i - 1][j - 1]);
                max = Math.max(max,dp[i][j]);
            }
        }

        return max;
    }

    @Override
    public int kConcatenationMaxSum(int[] arr, int k) {
        int len = arr.length, sum = 0;
        int cur = 0, res = 0;
        int loopCount = Math.min(2, k) * len;
        for (int i = 0; i < len; ++i) {
            sum += arr[i];
        }
        for (int i = 0; i < loopCount; ++i) {
            int val = arr[i % len];
            cur = cur + val > 0 ? cur + val : 0;
            res = Math.max(res, cur);
        }
        if (sum > 0) {
            while (k-- > 2) {
                res = (res + sum) % 1000000007;
            }
        }
        return res;
    }

    @Override
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] ans = new int[col];

        // 默认位置
        for (int i = 0; i < col; i++) {
            ans[i] = i;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ans[j] == -1) {//忽略卡住的球
                    continue;
                }
                if (grid[i][ans[j]] == 1 && ans[j] + 1 < col && grid[i][ans[j] + 1] == 1) {
                    //右移
                    ans[j]++;
                } else if (grid[i][ans[j]] == -1 && ans[j] - 1 >= 0 && grid[i][ans[j] - 1] == -1) {
                    //左移
                    ans[j]--;
                } else {
                    //卡住
                    ans[j] = -1;
                }
            }
        }
        return ans;
    }

}
