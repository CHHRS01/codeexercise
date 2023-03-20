package leetcode.dp.impl;

import leetcode.dp.DynamicProgrammingService9;

import java.util.*;

public class DynamicProgrammingService9Impl implements DynamicProgrammingService9 {

    @Override
    public int mincostTickets(int[] days, int[] costs) {
        //判断
        if(days == null || days.length == 0 ||
                costs == null || costs.length == 0) {
            return 0;
        }

        //dp表示到了当天花的最低票价
        int[] dp = new int[days[days.length - 1] + 1];

        //base case: 第0天一定不用买票 则花费0元
        dp[0] = 0;
        //标记一下需要买票的日子
        for(int day: days) {
            dp[day] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < dp.length; i++) {
            //不需要买票
            if(dp[i] == 0) {
                //不需要买票花费的钱就是前一天的花费
                dp[i] = dp[i - 1];
                continue;
            }

            int n1 = dp[i - 1] + costs[0];//当天需要买票
            /**如果今天距离第一天已经超过7天了
             * 则花费: dp[i-7](7天前已经花费的钱)+cost[1](7天前买了一张7天的票)
             * 否则就是直接第一天买了一张7天票
             */
            int n2 = i > 7 ? dp[i - 7] + costs[1] : costs[1];
            //30天与7天 同理
            int n3 = i > 30 ? dp[i - 30] + costs[2] :costs[2];

            dp[i] = Math.min(n1, Math.min(n2, n3));
        }
        //最后一天花费多少钱
        return dp[days[days.length - 1]];
    }

    @Override
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int[] v = new int[len - 1];
        v[len - 2] = values[len - 1] - len + 1;
        for (int i = len - 3; i >= 0; i--) {
            v[i] = Math.max(values[i + 1] - i - 1, v[i + 1]);
        }
        int[] dp = new int[len - 1];
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            dp[i] = values[i] + i + v[i];
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    @Override
    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
    }

    @Override
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        // 特判
        if(n == 0) {
            return 0;
        }
        // 定义哈希表，第一个键表示数组下标索引，其嵌套的哈希表用于存储该元素以不同的公差所包含的最长序列
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 1;
        // 遍历数组
        for(int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            // 向前遍历，寻找不同公差的最长序列
            for(int j = i - 1; j >= 0; j--) {
                // 如果遇到了重复的元素，可以直接跳过，因为肯定不会比后面的元素能组成更长的序列
                if(map.get(i).containsKey(A[i] - A[j])) {
                    continue;
                }
                // 获取以这两个元素差为公差的最长子序列
                int cur =  map.get(j).getOrDefault(A[i] - A[j], 0);
                // 比较答案
                res = Math.max(res, cur + 2);
                // 存入当前元素，某公差下的最长序列
                map.get(i).put(A[i] - A[j], cur + 1);
            }
        }

        return res;
    }

    @Override
    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        if (f > s) {
            int t = f; f = s; s = t;
        }
        int[][] dp = new int[n+1][2];
        int max = 0;
        for (int i = f;i <= n;i++) {
            int s1 = sum[i] - sum[i-f];
            dp[i][0] = Math.max(dp[i-1][0], s1);
            max = Math.max(max, s1 + dp[i-f][1]);
            if (i >= s) {
                int s2 = sum[i] - sum[i-s];
                dp[i][1] = Math.max(dp[i-1][1], s2);
                max = Math.max(max, s2 + dp[i-s][0]);
            }
        }
        return max;
    }

    @Override
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    @Override
    public int minScoreTriangulation(int[] A) {
        if(A==null || A.length<=0) {
            return 0;
        }
        int N=A.length;
        //从 0 ~ N-1 形成一个环
        //    1—3
        //   /    \
        //  5      1
        //   \    /
        //    1—4
        // dp[left][right] 代表left~right区间形成的环的最小得分值
        int[][] dp=new int[N][N];
        for (int len=3;len<=N;len++) { //枚举长度,从3开始
            for (int left=0;left<=N-len;left++) { //枚举左端点
                //left+len-1<N
                int right=left+len-1;
                //init
                dp[left][right]=Integer.MAX_VALUE;
                for (int i=left+1;i<right;i++) { //枚举区间内的所有的点(不包括端点)),将环分割成左右两部分
                    dp[left][right]=Math.min(dp[left][right],dp[left][i]+dp[i][right]+A[i]*A[left]*A[right]);
                }
            }
        }
        return dp[0][N-1];
    }

    @Override
    public int maxDistance(int[][] grid) {
        final int INF = 1000000;
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                f[i][j] = grid[i][j] == 1 ? 0 : INF;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i - 1 >= 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i + 1 < n) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }

        if (ans == INF) {
            return -1;
        } else {
            return ans;
        }
    }

    @Override
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int len = 1; len <= k && len <= i + 1; len++) {
                max = Math.max(max, arr[i - len + 1]);
                f[i + 1] = Math.max(f[i + 1], f[i - len + 1] + len * max);
            }
        }
        return f[n];
    }

    @Override
    public int longestStrChain(String[] words) {
        Arrays.sort(words,Comparator.comparingInt(String::length));
        int n=words.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isPredecessor(words[i],words[j])){
                    dp[j]=Math.max(dp[i]+1,dp[j]);
                }
            }
        }
        int res=0;
        for(int i:dp) {
            res=Math.max(res,i);
        }
        return res+1;
    }

    private boolean isPredecessor(String a,String b){
        if(b.length()-a.length()!=1) {
            return false;
        }
        int flag=0;
        int i=0,j=0;
        while(i<a.length()&&j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }else{
                flag++;
                j++;
                if(flag>1)return false;
            }
        }
        return true;
    }
}
