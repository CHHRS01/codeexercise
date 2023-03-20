package leetcode.arraySign;

/**
 * 数组元素积的符号
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class ArraySign {
    public static int arraySign(int[] nums) {
        int count = 0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] < 0) {
                ++count;
            }
        }
        return (count & 1) == 1? -1 : 1;
    }
    public static void main(String[] args) {
        int[] nums = {-1,1,-1,1,-1};
        System.out.println(arraySign(nums));
    }
}
