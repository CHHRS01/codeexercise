package newObject.myCircularQueue;

/**
 * 622. 设计循环队列
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class MyCircularQueue {

//    MyCircularQueue(k): 构造器，设置队列长度为 k 。
//    Front: 从队首获取元素。如果队列为空，返回 -1 。
//    Rear: 获取队尾元素。如果队列为空，返回 -1 。
//    enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
//    deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
//    isEmpty(): 检查循环队列是否为空。
//    isFull(): 检查循环队列是否已满。

    int[] arr;
    int head;
    int end;
    int size;
    int length;

    public MyCircularQueue(int k) {
        arr = new int[k];
        head = 0;
        end = 0;
        size = 0;
        length = k;
    }

    public boolean enQueue(int value) {
        if (size < length) {
            if (size != 0) {
                end = (end + 1) % length;
            }
            arr[end] = value;
            size++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (size > 0) {
            if (head != end) {
                head = (head + 1) % length;
            }
            size--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (size > 0) {
            return arr[head];
        }
        return -1;
    }

    public int Rear() {
        if (size > 0) {
            return arr[end];
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == length;
    }
}
