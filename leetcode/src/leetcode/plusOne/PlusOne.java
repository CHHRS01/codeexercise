package leetcode.plusOne;

/**
 * 66. 加一
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int tmp = 1;
        int pre = (digits[length - 1] + tmp) / 10;
        digits[length - 1] = (digits[length - 1] + tmp) % 10;
        for (int i = length - 2; i >= 0; i--) {
            tmp = pre;
            pre = (digits[i] + tmp) / 10;
            digits[i] = (digits[i] + tmp) % 10;
        }
        if (pre == 1) {
            int[] ans = new int[length + 1];
            ans[0] = 1;
            for (int i = length - 1; i >= 0; i--) {
                ans[i+1] = digits[i];
            }
            return ans;
        }
        else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,9};
        int[] ans = plusOne(digits);
        for (int i : ans) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
