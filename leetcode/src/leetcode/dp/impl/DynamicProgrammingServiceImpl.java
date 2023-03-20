package leetcode.dp.impl;

import leetcode.dp.DynamicProgrammingService;
import entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgrammingServiceImpl implements DynamicProgrammingService {

    /**
     * dp:O(n*n),O(n*n)
     * 提升：中心扩展算法，空间O(1)
     * 提升：Manacher算法,O(n),O(n)
     * */
    @Override
    public String longestPalindromicSubstring(String param) {
        if (param == null || param.length() < 1) {
            return "";
        }
        int start = 0, end = 0;

        for (int i = 0; i <= param.length() - 1; i++) {
            int len1 = expandAroundCenter(param, i, i);
            int len2 = expandAroundCenter(param, i, i + 1);
            int len = Math.max(len1,len2);
            //调整下表位置，根据end - start 判断最长
            if (len + start > end) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return param.substring(start, end + 1);
    }

    private int expandAroundCenter(String param, int left, int right) {
        while (left >= 0 && right <= param.length() - 1 && param.charAt(left) == param.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    @Override
    public List<String> generateParenthesis(int n) {

        List<List<String>> dp = new ArrayList<>();
        if (n >= 1) {
            //初始状态
            List<String> dp0 = new ArrayList<>();
            dp0.add("");
            dp.add(dp0);
            for (int i = 1; i <= n; i++) {
                List<String> tmp = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    //符合数量为j的所有数组
                    List<String> left = dp.get(j);
                    //符合数量为i - j - 1的所有数组
                    List<String> right = dp.get(i - j - 1);

                    for(String str1: left){
                        for(String str2 : right){
                            //计算所有的排列组合
                            tmp.add("(" + str1 + ")" + str2);
                        }
                    }
                }
                dp.add(tmp);
            }
        }

        return dp.get(n);
    }

    @Override
    public boolean canJump(int[] nums) {

        int length = nums.length;

        if (length < 2) {return true;}
        //数组dp[]用来记录dp[i]能到达的最远下标
        int[] dp = new int[length];
        dp[0] = nums[0];
        //end记录最远能跳到哪里，end超过数组长度-1(即数组最大下标)即能跳到终点
        int end = nums[0];
        for (int i = 1; i < length - 1; i++){
            //如果到达不了当前位置，就没办法继续往后跳，因而到不了终点
            if (dp[i - 1] < i) {return false;}
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            end = Math.max(dp[i], end);
        }
        return end + 1 >= length;
    }

    @Override
    public int canJump2(int[] nums) {

        int end=0,maxPosition=0,step=0;
        //用nums.length-1去掉最后一次边界， 以免多增加一次step
        for(int i = 0; i < nums.length - 1; i++){
            //一致获取最大值的跳跃
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    @Override
    public int uniquePaths(int m, int n) {

        int[] memo = new int[n];
        Arrays.fill(memo,1);
        for(int i = 1; i < m; i++){
            for(int j = 1 ; j < n; j++){
                memo[j] += memo[j-1];
            }
        }
        return memo[n-1];
    }

    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    @Override
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

    @Override
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if(s.charAt(len - 1) == '0'){
            dp[len - 1] = 0;
        }else{
            dp[len - 1]=1;
        }
        for(int i = len - 2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            if((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26){
                dp[i] = dp[i + 1] + dp[i + 2];
            }else{
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    @Override
    public int numTrees(int n) {

        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    @Override
    public List<TreeNode> generateTrees(int n) {
        //一维数组 泛型类型为ArrayList<TreeNode>
        ArrayList<TreeNode>[] dp = (ArrayList<TreeNode>[]) new Object[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return dp[0];
        }
        //空节点的二叉搜索树个数为0
        dp[0].add(null);
        //长度为 1 到 n
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<TreeNode>();
            //将不同的数字作为根节点，只需要考虑到 len
            for (int root = 1; root <= len; root++) {
                int left = root - 1;  //左子树的长度
                int right = len - root; //右子树的长度
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        //克隆右子树并且加上偏差
                        treeRoot.right = this.clone(rightTree, root);
                        dp[len].add(treeRoot);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = this.clone(n.left, offset);
        node.right = this.clone(n.right, offset);
        return node;
    }
}
