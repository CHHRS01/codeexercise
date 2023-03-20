package leetcode.sumOddLengthSubarrays;

/**
 * 1588. 所有奇数长度子数组的和
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class SumOddLengthSubarrays {
    public static int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        // 前缀长度增加1，避免j-w位置等于-1 差值的计算
        int[] preSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            preSum[i+1] = arr[i] + preSum[i];
        }
        int w = 1;
        while (w <= arr.length) {
            for (int j = arr.length; j-w >= 0; j--) {
                ans += (preSum[j] - preSum[j - w]);
            }
            w += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};

        System.out.println(sumOddLengthSubarrays(arr));
    }
}
