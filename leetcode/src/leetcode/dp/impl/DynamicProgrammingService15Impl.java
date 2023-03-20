package leetcode.dp.impl;


import leetcode.dp.DynamicProgrammingService15;
import entity.TreeNode;
import entity.Trie;

import java.util.*;

/**
 * basic sort methon for array
 * param is not null
 */
public class DynamicProgrammingService15Impl implements DynamicProgrammingService15 {

    @Override
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    @Override
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; ++i){
            // 如果价格更低，我应该买入，dp[i] = dp[i - 1];
            //如果价格更高，那么我考虑是否卖出，dp[i] = max(dp[i - 1],prices[i] - minPrice);
            if(prices[i] > minPrice){
                dp[i] = Math.max(dp[i - 1],prices[i] - minPrice);
            }else{
                dp[i] = dp[i - 1];
                minPrice = prices[i];
            }
        }
        return dp[prices.length - 1];
    }

    @Override
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return new ArrayList<>();
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i - 1 >= 0 && dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                    if (j - 1 >= 0 && dp[i][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        if (dp[m - 1][n - 1]) {
            int row = m - 1, col = n - 1;
            while (row != 0 || col != 0) {
                res.add(0, Arrays.asList(row, col));
                if (row - 1 >= 0 && dp[row - 1][col]) {
                    row--;
                } else {
                    col--;
                }
            }
            res.add(0, Arrays.asList(0, 0));
        }
        return res ;
    }

    @Override
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }

    @Override
    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for(int len = 1;len <= n;len += 2) {
            for(int i = 0;i + len - 1 < n;i += 2) {
                // 赋初始值，即只有一个数时
                if(len == 1) {
                    dp[i][i + len - 1][s.charAt(i) == '0' ? 0 : 1]++;
                }
                // 状态转移
                for(int j = i + 1;j < i + len - 1;j += 2) {
                    char op = s.charAt(j);
                    switch (op) {
                        // i === j - 1   j + 1 === i + len - 1
                        case '&':
                            dp[i][i + len - 1][0] += dp[i][j - 1][0] * (dp[j + 1][i + len - 1][0] + dp[j + 1][i + len - 1][1]) +
                                    dp[i][j - 1][1] * dp[j + 1][i + len - 1][0];
                            dp[i][i + len - 1][1] += dp[i][j - 1][1] * dp[j + 1][i + len - 1][1];
                            break;
                        case '|':
                            dp[i][i + len - 1][0] += dp[i][j - 1][0] * dp[j + 1][i + len - 1][0];
                            dp[i][i + len - 1][1] += dp[i][j - 1][1] * (dp[j + 1][i + len - 1][0] + dp[j + 1][i + len - 1][1]) +
                                    dp[i][j - 1][0] * dp[j + 1][i + len - 1][1];
                            break;
                        case '^':
                            dp[i][i + len - 1][0] += dp[i][j - 1][0] * dp[j + 1][i + len - 1][0] +
                                    dp[i][j - 1][1] * dp[j + 1][i + len - 1][1];
                            dp[i][i + len - 1][1] += dp[i][j - 1][0] * dp[j + 1][i + len - 1][1] +
                                    dp[i][j - 1][1] * dp[j + 1][i + len - 1][0];
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return dp[0][n - 1][result];
    }

    @Override
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i) {
            person[i] = new int[]{height[i], weight[i]};
        }
        Arrays.sort(person, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o2[1]-o1[1];
                }
            }
        });
        int [] dp = new int [person.length];
        int res = 0;
        for(int [] p:person){
            int i=0,j=res;
            while(i<j){
                int mid = i+(j-i)/2;
                if(dp[mid]<p[1]) {
                    i = mid+1;
                } else {
                    j = mid;
                }
            }
            dp[i] = p[1];
            if(res==j) {
                res++;
            }
        }
        return res;
    }

    @Override
    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        res[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        while (--k > 0) {
            int p3Val = 3 * res[p3];
            int p5Val = 5 * res[p5];
            int p7Val = 7 * res[p7];

            int min = p3Val;
            if (min >= p5Val) {
                min = p5Val;
                p5++;
            }
            if (min >= p7Val) {
                min = p7Val;
                p7++;
            }
            if (min == p3Val) {
                p3++;
            }
            res[res.length - k] = min;
        }
        return res[res.length - 1];
    }

    @Override
    public int[] findSquare(int[][] matrix) {
        int[] result = new int[]{0,0,0};

        if(matrix.length==0){
            return new int[]{};
        }
        for(int i=0;i<matrix.length-result[2];i++){
            for(int j=0;j<matrix.length-result[2];j++){
                if(matrix[i][j]==0){
                    int count=1;
                    while(count+i<matrix.length&&count+j<matrix.length
                            &&matrix[count+i][j]==0&&matrix[i][count+j]==0
                    ){
                        count++;
                    }
                    int actualLen=isBlackMatrix(i,j,count,matrix);
                    if(actualLen>result[2]){
                        result[0]=i;
                        result[1]=j;
                        result[2]=actualLen;
                    }
                }
            }
        }
        if(result[2]==0){
            return new int[]{};
        }
        return result;
    }

    private int isBlackMatrix(int i,int j,int size, int[][] matrix){//recursive check
        if(size==1){
            return size;
        }
        else{
            for(int x=0;x<size;x++){
                if(matrix[i+size-1][j+x]==0&&matrix[i+x][j+size-1]==0){
                    continue;
                }
                else{
                    int miniLen=isBlackMatrix(i,j,size-1, matrix);
                    return miniLen;
                }
            }
            return size;
        }
    }

    @Override
    public int maxValue(TreeNode root, int k) {
            int[] dp = dynamic(root, k);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            //取root的各种染色情况的最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private int[] dynamic(TreeNode root, int k) {
        int[] dp = new int[k + 1];
        //1.初始化：空节点为底，自底向上
        if (root == null) {
            return dp;
        }
        //2.获取左、右子树染色状态的dp表
        //- 左子树
        int[] l = dynamic(root.left, k);
        //- 右子树
        int[] r = dynamic(root.right, k);
        //3.更新处理root 染色/不染色 的情况下的dp表
        //- 不染root
        int ml = Integer.MIN_VALUE, mr = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            //- 分别取子节点的最大值
            ml = Math.max(ml, l[i]);
            mr = Math.max(mr, r[i]);
        }
        dp[0] = ml + mr;
        //- 染root
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < i; j++) {
                //- 还需要染色 i - 1 个点，左子树 j 个，右子树 i-1-j 个
                dp[i] = Math.max(dp[i], root.val + l[j] + r[i - 1 - j]);
            }
        }
        //4.更新完毕，返回后继续向上动态规划
        return dp;
    }

    @Override
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] f = new int[n][3];
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            f[i][0] = f[i - 1][0] + isYellow;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
            if (i >= 2) {
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
            }
        }
        return f[n - 1][2];
    }
}
