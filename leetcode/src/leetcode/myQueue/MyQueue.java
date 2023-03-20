package leetcode.myQueue;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 232. 用栈实现队列
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MyQueue {

    private Deque<Integer> instack;
    private Deque<Integer> outstack;

    public MyQueue() {
        instack = new LinkedList<>();
        outstack = new LinkedList<>();
    }

    public void push(int x) {
        instack.push(x);
    }

    public int pop() {
        if (outstack.isEmpty()) {
            while (!instack.isEmpty()) {
                outstack.push(instack.pop());
            }
        }
        return outstack.pop();
    }

    public int peek() {
        if (outstack.isEmpty()) {
            while (!instack.isEmpty()) {
                outstack.push(instack.pop());
            }
        }
        return outstack.peek();
    }

    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
    }
}
