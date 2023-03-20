package leetcode.dp.impl;

import leetcode.dp.DynamicProgrammingService11;
import entity.TreeNode;

import java.util.*;

public class DynamicProgrammingService11Impl implements DynamicProgrammingService11 {

    @Override
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 1;//最小返回1
        for (int length : arr) {
            //查看在这个数之前是否有length - difference这个数，有则返回，没有就是0，加一是要加上自己的长度
            int orDefault = map.getOrDefault(length - difference, 0)+1;
            //得到最大长度
            max = Math.max(max,orDefault);
            //将当前值存入
            map.put(length,orDefault);
        }
        return max;
    }

    @Override
    public double nthPersonGetsNthSeat(int n) {
        double[] dp=new double[n+1];
        dp[1]=1.0;
        for (int i=2; i<=n; i++){
            if (i==2){
                dp[2]=0.5;
            }else{
                dp[i]=1-dp[i-1];
            }
        }
        return dp[n];
    }

    @Override
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        //状态定义：dp[i][j]：nums[0,...,i]模3余j的最大和
        int[][] dp = new int[n+1][3];
        //状态初始化
        dp[0][0] =0;
        dp[0][1] =Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        //状态转移方程
        for(int i=1;i<=n;i++){
            if(nums[i-1]%3 ==0){
                //能整除的还能整除
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][0]+nums[i-1]);
                //余1的还是余1
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][1]+nums[i-1]);
                //余2的还是余2
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][2]+nums[i-1]);
            }else if(nums[i-1]%3 == 1){
                //要能整除，两种请情况：不加该数就能整除，或者：之前的和整除余2+该数
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]+nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+nums[i-1]);
            }else if(nums[i-1]%3 ==2){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0] + nums[i-1]);
            }

        }
        return dp[n][0];
    }

    @Override
    public int countSquares(int[][] matrix) {
        /**
         dp[i][j]表示以i,j为右下顶点的正方形的最大边长
         */
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m+1][n+1];
        int res = 0;
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                //当前值为1时候进入
                if(matrix[i-1][j-1] == 1){
                    //左边与上边的正方形边长最小值
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]);
                    //当前matrix为i-1和j-1，此时还需要判断对角线的那个值是否为1
                    //而这个需要判断值的位置在 i-1即当前位置减去左和上的最小边长即dp[i][j]
                    //如果为1，则dp[i][j]++，因为dp[i][j]的值最多比左和上最小值多1
                    if(matrix[i-1-dp[i][j]][j-1-dp[i][j]] == 1){
                        dp[i][j]++;
                    }
                    res += dp[i][j];
                }
            }
        }
        return res;
    }

    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] map = new int[n][n];
        final int INF = 0x3f3f3f3f;
        //init map
        for (int[] ints : map) {
            Arrays.fill(ints, INF);
        }
        for (int i = 0; i < n; i++) {
            map[i][i] = 0;
        }
        for (int[] e : edges) {
            map[e[0]][e[1]] = map[e[1]][e[0]] = e[2];
        }
        int res = 0;
        int MIN = n + 1;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            boolean[] set = new boolean[n];
            for (int v = 0; v < n; v++) {
                dist[v] = map[i][v];
            }
            dist[i] = 0;
            set[i] = true;
            for (int j = 0; j < n - 1; j++) {
                int min = INF;
                int start = i;
                for (int k = 0; k < n; k++) {
                    if (!set[k] && dist[k] < min) {
                        min = dist[k];
                        start = k;
                    }
                }
                set[start] = true;
                for (int k = 0; k < n; k++) {
                    if (!set[k] && dist[k] > dist[start] + map[start][k]) {
                        dist[k] = dist[start] + map[start][k];
                    }
                }
            }
            int temp = 0;
            for (int j = 0; j < dist.length; j++) {
                if (dist[j] <= distanceThreshold) {
                    temp++;
                }
            }
            if (temp <= MIN) {
                MIN = temp;
                res = i;
            }
        }
        return res;
    }

    @Override
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxAns = 0;
        dfs(root, false, 0, maxAns);
        dfs(root, true, 0, maxAns);
        return maxAns;
    }

    private void dfs(TreeNode o, boolean dir, int len, int maxAns) {
        maxAns = Math.max(maxAns, len);
        if (!dir) {
            if (o.left != null) {
                dfs(o.left, true, len + 1, maxAns);
            }
            if (o.right != null) {
                dfs(o.right, false, 1, maxAns);
            }
        } else {
            if (o.right != null) {
                dfs(o.right, false, len + 1, maxAns);
            }
            if (o.left != null) {
                dfs(o.left, true, 1, maxAns);
            }
        }
    }

    @Override
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> f = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for (int i = lo; i <= hi; ++i) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer u, Integer v) {
                if (getF(u, f) != getF(v, f)) {
                    return getF(u, f) - getF(v, f);
                } else {
                    return u - v;
                }
            }
        });
        return list.get(k - 1);
    }

    private int getF(int x, Map<Integer, Integer> f) {
        if (!f.containsKey(x)) {
            if (x == 1) {
                f.put(x, 0);
            } else if ((x & 1) != 0) {
                f.put(x, getF(x * 3 + 1, f) + 1);
            } else {
                f.put(x, getF(x / 2, f) + 1);
            }
        }
        return f.get(x);
    }

    @Override
    public int numTeams(int[] rating){
        int n=rating.length;
        if(n<=2){
            return 0;   //总共没有3个士兵
        }
        int[] minToMax2=new int[n];     //minToMax2[j]代表,i->j中间有多少数rating[j]小
        int[] maxToMin2=new int[n];     //maxToMin2[j]代表,i->j中间有多少数rating[j]大
        int i,j,result=0;
        for(i=0;i<n;i++){
            minToMax2[i]=0;
            maxToMin2[i]=0;
            for(j=i-1;j>=0;j--){
                if(rating[i]>rating[j]){
                    minToMax2[i]++;     //计算有多少数比rating[i]小
                    result+=minToMax2[j];       //rating[i]>rating[j],rating[j]比minToMax2[j]个下标小于j的数大,所以{rating[k](k<j)<rating[j]<rating[i]}共有minToMax2[j种情况]
                }
                if(rating[i]<rating[j]){
                    maxToMin2[i]++;
                    result+=maxToMin2[j];
                }
            }
        }
        return result;
    }

    @Override
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, -1);
        int min = Integer.MAX_VALUE;
        // 可以取前i个数字时组成target的1个子数组的最短长度
        int[] record1 = new int[arr.length + 1];
        Arrays.fill(record1, Integer.MAX_VALUE);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //前缀和
            sum += arr[i];
            if (sums.get(sum - target) != null) {
                int left = sums.get(sum - target);
                int len = record1[left + 1];
                if (len != Integer.MAX_VALUE) {
                    min = Math.min(min, len + i - left);
                }
                record1[i + 1] = i - left;
            }
            record1[i + 1] = Math.min(record1[i], record1[i + 1]);
            sums.put(sum, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    @Override
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            pre[i] = nums[i] != 0 ? pre[i - 1] + 1 : 0;
        }

        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suf[i] = nums[i] != 0 ? suf[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int preSum = i == 0 ? 0 : pre[i - 1];
            int sufSum = i == n - 1 ? 0 : suf[i + 1];
            ans = Math.max(ans, preSum + sufSum);
        }

        return ans;
    }
}
