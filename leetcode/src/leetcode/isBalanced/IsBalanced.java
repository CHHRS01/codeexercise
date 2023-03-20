package leetcode.isBalanced;

import entity.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        // 自顶向下
        if (root == null) {
            return true;
        }
        else {
            return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 &&
                    isBalanced(root.left) &&
                    isBalanced(root.right);
        }

    }

    public int getDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getDepth(treeNode.left), getDepth(treeNode.right)) + 1;
    }
    public boolean isBalanced2(TreeNode root) {
        //自底向上
        return height(root) >= 0;
    }

    public int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHight = height(treeNode.left);
        int rightHight = height(treeNode.right);
        if (leftHight == -1 || rightHight == -1 || Math.abs(leftHight - rightHight) > 1) {
            return -1;
        }
        else {
            return Math.max(leftHight, rightHight) + 1;
        }
    }
}
