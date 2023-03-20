package leetcode.canMakeArithmeticProgression;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class CanMakeArithmeticProgression {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int tmp = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i -1] != tmp) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4};
        System.out.println(canMakeArithmeticProgression(arr));
    }
}
