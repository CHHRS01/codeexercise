package leetcode.sumOfLeftLeaves;

import entity.TreeNode;

/**
 * 404. 左叶子之和
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root.left, true) + dfs(root.right, false);
    }

    public int dfs(TreeNode treeNode, boolean left) {
        if (treeNode == null) {
            return 0;
        }
        if (left && treeNode.left == null && treeNode.right == null) {
            return treeNode.val;
        }
        return dfs(treeNode.left, true) + dfs(treeNode.right, false);
    }
}
