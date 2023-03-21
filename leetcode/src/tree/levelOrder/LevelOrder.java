package tree.levelOrder;

import entity.NNode;

import java.util.*;

/**
 * 429. N 叉树的层序遍历
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class LevelOrder {
    public List<List<Integer>> levelOrder(NNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            Queue<NNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> level = null;
            while (!queue.isEmpty()) {
                level = new ArrayList<>();
                int curSize = queue.size();
                NNode nNode = null;
                for (int i = 0; i < curSize; i++) {
                    nNode = queue.poll();
                    level.add(nNode.val);
                    if (nNode.children != null) {
                        ((LinkedList<NNode>) queue).addAll(nNode.children);
                    }
                }
                ans.add(level);
            }
        }
        return ans;
    }
}
