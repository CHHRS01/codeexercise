package tree.bstIterator;

import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 173. 二叉搜索树迭代器
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class BSTIterator {

    private TreeNode cur;
    // 使用站实现中序遍历
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    public int next() {
        // 左
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        // 中
        cur = stack.pop();
        int ret = cur.val;
        // 右
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
