package leetcode.isSubPath;

import entity.ListNode;
import entity.TreeNode;

/**
 * 1367. 二叉树中的链表
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class IsSubPath {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root ==  null) {
            return false;
        }
        return dfs(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }

    public boolean dfs(ListNode p, TreeNode root) {
        if (p == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != p.val) {
            return false;
        }
        return dfs(p.next, root.left) || dfs(p.next, root.right);
    }
}
