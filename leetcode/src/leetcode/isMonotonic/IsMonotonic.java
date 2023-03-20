package leetcode.isMonotonic;

/**
 * 896. 单调数列
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class IsMonotonic {
    public static boolean isMonotonic(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        boolean flag = nums[nums.length - 1] > nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (flag && nums[i] < nums[i - 1]) {
                return false;
            }
            if (!flag && nums[i] > nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4,4};
        System.out.println(isMonotonic(nums));
    }
}
