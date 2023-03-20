package leetcode.tree.preorder;

import entity.NNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class Preorder {

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(NNode root) {
        this.addInteger(root);
        return ans;
    }

    // 迭代
    private void addInteger(NNode node) {
        if (node != null) {
            ans.add(node.val);
            for (NNode child : node.children) {
                addInteger(child);
            }
        }
    }
}
