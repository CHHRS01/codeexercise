package entity;

/**
 * random ，该指针可以指向链表中的任何节点或空节点。
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
