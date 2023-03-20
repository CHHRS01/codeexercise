package monotonicstack.dailyTemperatures;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        // 超时
//        int length = temperatures.length;
//        if (length == 1) {
//            return new int[]{0};
//        }
//        int[] ans = new int[length];
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 1; j < length; j++){
//                if (temperatures[j] >temperatures[i]) {
//                    ans[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return ans;
        // 优化 单调栈
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(temperatures);
        for (int value : ans) {
            System.out.print(value);
            System.out.print(" ");
        }
    }
}
