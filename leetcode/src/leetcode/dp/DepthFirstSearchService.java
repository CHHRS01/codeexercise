package leetcode.dp;

import entity.TreeNode;
import entity.Node;

import java.util.List;

public interface DepthFirstSearchService {

    /**
     * 98. 验证二叉搜索树
     */
    boolean isValidBST(TreeNode root);

    /**
     * 99. 恢复二叉搜索树
     */
    void recoverTree(TreeNode root);

    /**
     * 113. 路径总和 II
     */
    List<List<Integer>> pathSum(TreeNode root, int targetSum);

    /**
     * 114. 二叉树展开为链表
     */
    void flatten(TreeNode root);

    /**
     * 116. 填充每个节点的下一个右侧节点指针
     */
    Node connect(Node root);

    /**
     * 117. 填充每个节点的下一个右侧节点指针 II
     */
    Node connect2(Node root);

    /**
     * 129. 求根节点到叶节点数字之和
     */
    int sumNumbers(TreeNode root);

    /**
     * 130. 被围绕的区域
     */
    void solve(char[][] board);

    /**
     * 133. 克隆图
     */
    Node cloneGraph(Node node);

    /**
     * 199. 二叉树的右视图
     */
    List<Integer> rightSideView(TreeNode root);

}
