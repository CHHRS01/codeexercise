package entity;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public class QueueNode {
    public TreeNode node;
    public int depth;

    public QueueNode(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
