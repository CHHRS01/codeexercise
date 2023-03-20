package leetcode.dp.impl;

import leetcode.dp.DynamicProgrammingService2;
import entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgrammingService2Impl implements DynamicProgrammingService2 {
    @Override
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n1 + n2 != n3){
            return false;
        }
        boolean[][] flags = new boolean[n1 + 1][n2 + 1];
        flags[0][0] = true;
        for (int i = 1; i < n1 + 1; i++) {
            if(!flags[i - 1][0] || s1.charAt(i - 1) != s3.charAt(i - 1)){
                break;
            }
            flags[i][0] = true;
        }
        for(int i = 1; i < n2 + 1; i++){
            if(!flags[0][i - 1] || s2.charAt(i - 1) != s3.charAt(i - 1)){
                break;
            }
            flags[0][i] = true;
        }
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if(flags[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    flags[i][j] = true;
                    continue;
                }
                if(flags[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    flags[i][j] = true;
                }
            }
        }
        return flags[n1][n2];
    }

    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int j = triangle.size() - 1; j >= 0; j--){
            dp[triangle.size() - 1][j] = triangle.get(triangle.size() - 1).get(j);
        }
        for(int i = triangle.size() - 2; i >= 0;i--) {
            for(int j = 0;j < triangle.get(i).size();j++) {
                dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    @Override
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        if (null == s || s.length() == 0) {
            return res;
        }
        int length = s.length();
        /*
        它是一个二维矩阵，有三种状态值：
        0表示之前还没有计算过
        1表示从下表i到j的子串是回文串
        2表示不是回文串
        我们只用到了数组的右上半部分
        当然这里也可以使用char数组，空间复杂度更低
         */
        int[][] dp = new int[length][length];
        //初始化，单个字符的肯定是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        ArrayList<String> templist = new ArrayList<>();
        this.helper(res, templist, s, length, 0, dp);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param res      结果集
     * @param templist 中间list
     * @param s        字符串
     * @param length   字符串长度
     * @param index    从当前位置向后组合判断
     */
    private void helper(List<List<String>> res, ArrayList<String> templist, String s, int length, int index, int[][] dp) {
        //走到这一步就表示走到了最后，添加到结果集
        if (index == length) {
            res.add(new ArrayList<>(templist));//一定要重新new一个对象，templist可以得到重用
        }
        //走到某一步有若干的选择继续走下一步
        for (int i = index; i < length; i++) {
            if (isPalindrome(s, index, i, dp)) {
                templist.add(s.substring(index, i + 1));
                this.helper(res, templist, s, length, i + 1, dp);
                templist.remove(templist.size() - 1);//回溯算法中回退一定要记得这一步
            }
        }
    }

    private boolean isPalindrome(String s, int from, int to, int[][] dp) {
        //判断是否是回文串，这里首先需要到保存的状态中查看是否之前已经有了，优化时间复杂度
        if (dp[from][to] == 1) {
            return true;
        } else if (dp[from][to] == 2) {
            return false;
        } else {
            for (int i = from, j = to; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[from][to] = 2;
                    return false;
                }
            }
            dp[from][to] = 1;
            return true;
        }
    }

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i ; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    @Override
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int preMax = nums[0];
        int preMin = nums[0];

        // 滚动变量
        int curMax;
        int curMin;

        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(preMax * nums[i], nums[i]);
                curMin = Math.min(preMin * nums[i], nums[i]);
            } else {
                curMax = Math.max(preMin * nums[i], nums[i]);
                curMin = Math.min(preMax * nums[i], nums[i]);
            }
            res = Math.max(res, curMax);

            // 赋值滚动变量
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }

    @Override
    public int rob(int[] nums) {
        int y = 0, n = 0;
        // 初始化2个变量，代表着选取该节点和不选取该节点。y: yes, n: no
        int[] opt = new int[nums.length];
        // 初始化一个数组，用于存储每个节点的当前元素及其之前元素的最优解（不管之后的元素 是否选择）
        if (nums.length == 0)
        {
            // 如果传入的数组为空，返回值为0
            return 0;
        }
        if (nums.length == 1)
        {
            // 如果传入的值为1，返回值为当前数组的唯一元素
            return nums[0];
        }
        // 如果，满足传入数组的长度大于等于2
        opt[0] = nums[0];
        opt[1] = Math.max(nums[0],nums[1]);
        // 第一个元素及之前元素的最优解为第一个元素本身
        // 第二个元素及之前元素的最优解为第一个元素或者第二个元素（取大值）
        for(int i = 2;i <= nums.length - 1; i++ )
        {
            // 循环计算，2和2之后每一个元素及之前元素的最优解
            // 每个节点都会遇到2个可能，需要当前元素和不需要当前元素
            y = nums[i] + opt[i - 2];
            n = opt[i - 1];
            opt[i] = Math.max(y,n);
            // 取最优解
        }
        Arrays.sort(opt);
        // 对最优解进行排序，取最大值即为当前题目的最优解
        return opt[nums.length - 1];
        // 返回排序后最后一个元素（最大的元素）
    }

    @Override
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int[] dp1 = new int[nums.length];//一定不偷最后一家
        int[] dp2 = new int[nums.length];//一定不偷第一家

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);

        for(int j = 2; j < nums.length-1; j ++){
            dp1[j] = Math.max(dp1[j-2] + nums[j], dp1[j-1]);
        }
        for(int i = 3; i < nums.length; i ++){
            dp2[i] = Math.max(dp2[i-2] + nums[i],dp2[i-1]);
        }
        return Math.max(dp1[nums.length-2],dp2[nums.length-1]);
    }

    @Override
    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int len = 0;
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    len = Math.max(len, dp[i][j]);
                }
            }
        }
        return len * len;
    }

    @Override
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        char[] array = input.toCharArray();
        int num = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (isOperation(array[i]))
            {
                numList.add(num);
                num = 0;
                opList.add(array[i]);
                continue;
            }
            num = num * 10 + array[i] - '0';
        }
        numList.add(num);
        int N = numList.size(); // 数字的个数

        // 一个数字
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
        for (int i = 0; i < N; i++)
        {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(numList.get(i));
            dp[i][i] = result;
        }
        // 2 个数字到 N 个数字
        for (int n = 2; n <= N; n++) {
            // 开始下标
            for (int i = 0; i < N; i++)
            {
                // 结束下标
                int j = i + n - 1;
                if (j >= N)
                {
                    break;
                }
                ArrayList<Integer> result = new ArrayList<>();
                // 分成 i ~ s 和 s+1 ~ j 两部分
                for (int s = i; s < j; s++)
                {
                    ArrayList<Integer> result1 = dp[i][s];
                    ArrayList<Integer> result2 = dp[s + 1][j];
                    for (int x = 0; x < result1.size(); x++)
                    {
                        for (int y = 0; y < result2.size(); y++)
                        {
                            // 第 s 个数字下标对应是第 s 个运算符
                            char op = opList.get(s);
                            result.add(caculate(result1.get(x), op, result2.get(y)));
                        }
                    }
                }
                dp[i][j] = result;

            }
        }
        return dp[0][N-1];
    }

    private int caculate(int num1, char c, int num2) {
        switch (c)
        {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    @Override
    public int rob3(TreeNode root) {
        // 0：当前结点未取     1：当前结点取了
        int[] result = this.forRob(root);
        return Math.max(result[0], result[1]);
    }

    private int[] forRob(TreeNode root){
        // 边界
        if(root == null){
            return new int[2];
        }
        int[] result = new int[2];
        // 最优子结构
        int[] right = this.forRob(root.right);
        int[] left = this.forRob(root.left);
        // 状态转移方程
        // root 没偷的情况：左右结点可偷，也可不偷
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // root 偷了的情况：左右结点一定不偷
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
