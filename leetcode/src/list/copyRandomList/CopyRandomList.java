package list.copyRandomList;

import entity.RandomNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class CopyRandomList {
    Map<RandomNode, RandomNode> cachedNode = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            RandomNode headNew = new RandomNode(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
