package slidingwindow.numSubarrayProductLessThanK;

/**
 * 713. 乘积小于 K 的子数组
 * #####
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int[][] dp = new int[k][nums.length];

        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            // 元素乘积小于k的子数组数目为j−i+1
            // 没有懂
            ret += j - i + 1;
        }
        return ret;
    }
}
