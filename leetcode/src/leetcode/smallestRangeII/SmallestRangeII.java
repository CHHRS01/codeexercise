package leetcode.smallestRangeII;

import java.util.Arrays;

/**
 * 910. 最小差值 II
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class SmallestRangeII {
    public static int smallestRangeII(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        int ans = nums[N-1] - nums[0];

        for (int i = 0; i < nums.length - 1; ++i) {
            int a = nums[i], b = nums[i+1];
            int high = Math.max(nums[N-1] - k, a + k);
            int low = Math.min(nums[0] + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6};
        System.out.println(smallestRangeII(nums, 3));
    }
}
