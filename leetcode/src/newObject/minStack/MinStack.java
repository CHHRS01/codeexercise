package newObject.minStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class MinStack {

    private Deque<Integer> data;
    private Deque<Integer> min;

    public MinStack() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            // 记录同数量的当前最小值
            min.push(Math.min(min.peek(), x));
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        // 获得但不取出
        return min.peek();
    }
}
