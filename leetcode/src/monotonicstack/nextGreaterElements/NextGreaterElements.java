package monotonicstack.nextGreaterElements;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */
public class NextGreaterElements {
    // 下一个更大
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,3};
        int[] ans = nextGreaterElements(nums);
        for (int value : ans) {
            System.out.print(value);
            System.out.print(" ");
        }
    }
}
