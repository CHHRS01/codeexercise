package leetcode.dp.impl;


import common.CommonConstants;
import leetcode.dp.DynamicProgrammingService13;

import java.util.*;

/**
 * basic sort methon for array
 * param is not null
 */
public class DynamicProgrammingService13Impl implements DynamicProgrammingService13 {

    @Override
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (a > b + x) {
            return -1;
        }
        if (a == x) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        Set<Integer> l = new HashSet<>();
        l.add(a);
        int step = 1;
        Map<Integer, Integer> visitedMap = new HashMap<>();
        while (!l.isEmpty()) {
            boolean arrive = false;
            int size = l.size();
//            System.out.println(step + ": " + l);
            Integer[] is = new Integer[size];
            l.toArray(is);
            l.clear();
            for (int i = 0; i < size; i++) {
                Integer head = is[i];
                boolean cont = contain(forbidden, head);
                if ((a > b && head - b > x) || head > x + 4000 || cont) {
                    continue;
                }
                if (head == x) {
                    return step;
                }
                Integer exists = visitedMap.get(head - b);
                if (exists != null && exists == -1) {
                    continue;
                }
                int visited = visitedMap.getOrDefault(head, 0);
                cont = contain(forbidden, head - b);
                if (head - b > 0 && !cont && visited != -1) {
                    l.add(head - b);
                    // 当前位置可向左跳，并且要即将到达的位置在本次for循环中没有被向右的step到达过（换句话说就是：即将到达的点最后一步可以是以向右跳的方式，这样的话，就不要用向左跳这种更差的方式去覆盖）
                    if(visited == 0 && visitedMap.getOrDefault(head - b, 0) != 1) {
                        visitedMap.put(head - b, -1);
                    }
                    arrive = true;
                }
                cont = contain(forbidden, head + a);
                if (!cont) {
                    l.add(head + a);
                    visitedMap.put(head + a, 1);
                    arrive = true;
                }
            }
            if (arrive) {
                step++;
            }
            // 所有向右跳之后 达到的点都置成可向左跳
            for (Integer v : l) {
                if (visitedMap.get(v) != -1) {
                    visitedMap.put(v, 0);
                }
            }
        }
        return -1;
    }

    private boolean contain(int[] arr, int k) {
        for (int i : arr) {
            if (k == i) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for(int i=0;i<5;i++){
            dp[0][i] = 1;
        }
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<5;j++){
                for(int k=0;k<=j;k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        int res = 0;
        for(int i=0;i<5;i++){
            res += dp[n-1][i];
        }
        return res;
    }

    @Override
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int[] odd=new int[n];
        int[] even=new int[n];
        even[0]=nums[0];
        for(int i=1;i<n;i++){
            if(i%2==0){
                even[i]=even[i-1]+nums[i];
                odd[i]=odd[i-1];
            }else{
                odd[i]=odd[i-1]+nums[i];
                even[i]=even[i-1];
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            int leftOdd=i-1>=0?odd[i-1]:0;
            int leftEven=i-1>=0?even[i-1]:0;

            int rightOdd=odd[n-1]-odd[i];
            int rightEven=even[n-1]-even[i];

            if(leftOdd+rightEven==leftEven+rightOdd) {
                res++;
            }
        }
        return res;
    }

    @Override
    public int stoneGameVII(int[] stones) {
        int n =  stones.length;
        int [] []dp = new int[n][n];
        for(int i = 1; i < n;i++){
            for(int j = i;j < n;j++){
                int a = j - i ;
                int b = j;
                if( a + 1 == b){
                    dp[a][b] = Math.max(stones[a],stones[b]);
                }else if(a + 2 == b){
                    if(stones[a]<stones[b]){
                        dp[a][b] = Math.min(stones[b],stones[b-1]);
                    }else{
                        dp[a][b] = Math.min(stones[a],stones[a+1]);
                    }
                }else{
                    int selectB = Math.min(stones[a]+dp[a+1][b-1],stones[b-1]+dp[a][b-2]);
                    int selectA = Math.min(stones[a+1]+dp[a+2][b],stones[b]+dp[a+1][b-1]);
                    dp[a][b] = Math.max(selectB,selectA);
                }
            }
        }
        return dp[0][n-1];
    }

    @Override
    public int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        // dp[i] = 到达i位置可得的最大分数
        int[] dp = new int[length];
        // 初始化除0外的所有值为最小
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < length; i++) {
            // dp[i]可到达的所有位置
            for (int j = i+1; j < length && j <= i+k; j++) {
                // 从i跳跃到j位置, j位置的最大得分
                int nextNum = dp[i]+nums[j];
                // 如果比j位置当前最大得分大, 则更新j位置最大得分
                if (dp[j] < nextNum) {
                    dp[j] = nextNum;
                }
                // 剪枝, i后面能影响到的分数, 可以由遍历到j时进行更新
                if (dp[j] >= dp[i]) {
                    break;
                }
            }
        }
        return dp[length-1];
    }

    @Override
    public int maxAbsoluteSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int min = nums[0];
        int diff = Math.abs(max- min);
        return Math.max(Math.max(Math.abs(max),Math.abs(min)),diff);
    }

    @Override
    public int maximumScore(int[] nums, int[] mult) {
        int n = nums.length, m = mult.length;
        int[][] dp = new int[m+1][m+1];
        // 计算只从左边取或者只从右边取的情况，避免后面的越界判断
        for(int i=1; i<=m; i++) {
            dp[0][i] = dp[0][i-1] + nums[n-i] * mult[i-1];
            dp[i][0] = dp[i-1][0] + nums[i-1] * mult[i-1];
        }

        // 状态计算
        for(int i=1; i<=m; i++){
            for(int j=1; j<=m-i; j++){
                int idx = i + j - 1;
                dp[i][j] = Math.max(dp[i-1][j] + nums[i-1]*mult[idx], dp[i][j-1] + nums[n-j] * mult[idx]);
            }
        }

        // 获取最终结果
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<=m; i++){
            ans = Math.max(ans, dp[i][m-i]);
        }

        return ans;
    }

    @Override
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int res=Integer.MAX_VALUE;
        for(int base: baseCosts){
            dfs(0,base,target,toppingCosts,res);
        }
        return res;
    }
    private void dfs(int cur,int cost,int target,int[] toppingCosts,int res){
        if(Math.abs(target-cost)<Math.abs(target-res)||Math.abs(target-cost)==Math.abs(target-res)&&cost<res){
            res=cost;
        }
        if(cost>=target||cur==toppingCosts.length){
            return;
        }
        dfs(cur+1,cost,target,toppingCosts,res);
        dfs(cur+1,cost+toppingCosts[cur],target,toppingCosts,res);
        dfs(cur+1,cost+2*toppingCosts[cur],target,toppingCosts,res);
    }

    @Override
    public int countRestrictedPaths(int n, int[][] es) {
        // 预处理所有的边权。 a b w -> a : { b : w } + b : { a : w }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] e : es) {
            int a = e[0], b = e[1], w = e[2];
            Map<Integer, Integer> am = map.getOrDefault(a, new HashMap<Integer, Integer>());
            am.put(b, w);
            map.put(a, am);
            Map<Integer, Integer> bm = map.getOrDefault(b, new HashMap<Integer, Integer>());
            bm.put(a, w);
            map.put(b, bm);
        }

        // 堆优化 Dijkstra：求 每个点 到 第n个点 的最短路
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        Queue<int[]> q = new PriorityQueue<int[]>((a, b)->a[1]-b[1]); // 点编号，点距离。根据点距离从小到大
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int idx = e[0], cur = e[1];
            if (st[idx]) continue;
            st[idx] = true;
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) continue;
            for (int i : mm.keySet()) {
                dist[i] = Math.min(dist[i], dist[idx] + mm.get(i));
                q.add(new int[]{i, dist[i]});
            }
        }

        // dp 过程
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{i + 1, dist[i + 1]}; // 点编号，点距离
        }
        Arrays.sort(arr, (a, b)->a[1]-b[1]); // 根据点距离从小到大排序

        // 定义 f(i) 为从第 i 个点到结尾的受限路径数量
        // 从 f[n] 递推到 f[1]
        int[] f = new int[n + 1];
        f[n] = 1;
        for (int i = 0; i < n; i++) {
            int idx = arr[i][0], cur = arr[i][1];
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) {
                continue;
            }
            for (int next : mm.keySet()) {
                if (cur > dist[next]) {
                    f[idx] += f[next];
                    f[idx] %= CommonConstants.MOD;
                }
            }
            // 第 1 个节点不一定是距离第 n 个节点最远的点，但我们只需要 f[1]，可以直接跳出循环
            if (idx == 1) {
                break;
            }
        }
        return f[1];
    }

    @Override
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int num1=1,num2=0,num3=1;

        for(int i=1;i<n;++i){
            int temp1=num1,temp2=num2,temp3=num3;
            if(obstacles[i]==1){
                num1=Integer.MAX_VALUE-1;
                num2=Math.min(temp2,temp3+1);
                num3=Math.min(temp3,temp2+1);
            }else if(obstacles[i]==2){
                num2=Integer.MAX_VALUE-1;
                num1=Math.min(temp1,temp3+1);
                num3=Math.min(temp3,temp1+1);
            }else if(obstacles[i]==3){
                num3=Integer.MAX_VALUE-1;
                num1=Math.min(temp1,temp2+1);
                num2=Math.min(temp2,temp1+1);
            }else{
                num1=Math.min(temp1,Math.min(temp2,temp3)+1);
                num2=Math.min(temp2,Math.min(temp1,temp3)+1);
                num3=Math.min(temp3,Math.min(temp1,temp2)+1);
            }
        }
        return Math.min(num1,Math.min(num2,num3));
    }
}
