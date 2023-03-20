package leetcode.evalRPN;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 150. 逆波兰表达式求值
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        // 出现一个计算符号 计算一个结果
        Deque<Integer> stack = new LinkedList<>();
        for (String str : tokens) {
            if ("+".equals(str)
                || "-".equals(str)
                || "*".equals(str)
                || "/".equals(str)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(
                        count(a, b, str)
                );
            }
            else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.peek();
    }

    public static int count(int a, int b, String sep) {
        switch (sep) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
