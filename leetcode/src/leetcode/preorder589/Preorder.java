package leetcode.preorder589;

import entity.NNode;

import java.util.*;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class Preorder {
    public List<Integer> bfs (NNode root) {
        // 使用队列
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Queue<NNode> queue = new LinkedList<>();
            queue.add(root);

            while(queue.size() > 0) {
                NNode n = queue.poll();
                ans.add(n.val);
                if (n.children != null && n.children.size() > 0) {
                    ((LinkedList<NNode>) queue).addAll(n.children);
                }
            }
        }
        return ans;
    }

    public List<Integer> dfs (NNode root) {
        // 使用栈 ，倒序加入
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<NNode> stack = new ArrayDeque<NNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NNode node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; --i) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}
