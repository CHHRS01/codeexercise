package leetcode.dp;

import entity.TreeNode;

import java.util.List;

public interface DynamicProgrammingService {

    /**
     * 最长回文子串
     *
     * */
    String longestPalindromicSubstring(String param);

    /**
     * 生成括号
     *[()()()(), ()()(()), ()(())(), ()(()()), ()((())), (())()(), (())(()), (()())(), ((()))(), (()()()), (()(())), ((())()), ((()())), (((())))]
     * */
    List<String> generateParenthesis(int n);


    /**
     * 跳跃游戏
     *
     * */
    boolean canJump(int[] nums);


    /**
     * 跳跃游戏 II
     * 前提条件：总是可以到达数组的最后一个位置。
     * */
    int canJump2(int[] nums);

    /**
     * 不同路径
     *
     * */
    int uniquePaths(int m, int n);

    /**
     * 不同路径 II
     *
     * */
    int uniquePathsWithObstacles(int[][] obstacleGrid);

    /**
     * 最小路径和
     *
     * */
    int minPathSum(int[][] grid);

    /**
     * 解码方法
     *
     * */
    int numDecodings(String s);

    /**
     * 不同的二叉搜索树
     *
     * */
    int numTrees(int n);

    /**
     * 不同的二叉搜索树 II
     *
     * */
    List<TreeNode> generateTrees(int n);
}
