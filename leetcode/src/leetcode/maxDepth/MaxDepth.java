package leetcode.maxDepth;

import entity.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return  Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
