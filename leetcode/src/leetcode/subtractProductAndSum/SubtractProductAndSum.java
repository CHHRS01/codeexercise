package leetcode.subtractProductAndSum;

/**
 * 计算并返回该整数「各位数字之积」与「各位数字之和」的差
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class SubtractProductAndSum {
    public static int subtractProductAndSum(int n) {

        int[] array = new int[10];
        while (n > 0) {
            array[n % 10] += 1;
            n = n / 10;
        }
        int mul = (array[0] == 0) ? 1 : 0;
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (array[0] == 0) {
                mul *= Math.pow(i, array[i]);
            }

            sum += array[i] * i;
        }

        return mul - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(1451245));
    }
}
