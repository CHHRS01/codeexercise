package newObject.myLinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * 707. 设计链表
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class MyLinkedList {

//    MyLinkedList() 初始化 MyLinkedList 对象。
//    int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
//    void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
//    void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
//    void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
//    void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。

    int count;
    List<Integer> list;

    public MyLinkedList() {
        count = 0;
        list = new LinkedList<>();
    }

    public int get(int index) {
        if (checkPosition(index)) {
            return list.get(index);
        }
        return -1;
    }

    public void addAtHead(int val) {
        list.add(0, val);
        count++;
    }

    public void addAtTail(int val) {
        list.add(count, val);
        count++;
    }

    public void addAtIndex(int index, int val) {
        if (index > count || index < 0) {
            return;
        }
        list.add(index, val);
        count++;
    }

    public void deleteAtIndex(int index) {
        if (checkPosition(index)) {
            list.remove(index);
            count--;
        }
    }

    private boolean checkPosition(int index) {
        return index >= 0 && index <= count - 1;
    }
}
