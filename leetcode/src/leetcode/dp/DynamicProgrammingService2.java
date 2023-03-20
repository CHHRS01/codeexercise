package leetcode.dp;


import entity.TreeNode;

import java.util.List;

public interface DynamicProgrammingService2 {

    /**
     * 97. 交错字符串
     */
    boolean isInterleave(String s1, String s2, String s3);

    /**
     * 120. 三角形最小路径和
     */
    int minimumTotal(List<List<Integer>> triangle);

    /**
     * 131. 分割回文串
     */
    List<List<String>> partition(String s);

    /**
     * 139. 单词拆分
     */
    boolean wordBreak(String s, List<String> wordDict);

    /**
     * 152. 乘积最大子数组
     */
    int maxProduct(int[] nums);

    /**
     * 198. 打家劫舍
     */
    int rob(int[] nums);

    /**
     * 213. 打家劫舍 II
     */
    int rob2(int[] nums);

    /**
     * 221. 最大正方形
     */
    int maximalSquare(char[][] matrix);

    /**
     * 241. 为运算表达式设计优先级
     */
    List<Integer> diffWaysToCompute(String expression);

    /**
     * . 打家劫舍 III
     */
    int rob3(TreeNode root);

}
