package leetcode.numArray;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class NumArray {

    private int[] elemSum;

    public NumArray(int[] nums) {
        elemSum = new int[nums.length + 1];
        elemSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            elemSum[i + 1] = nums[i] + elemSum[i];
        }
    }

    public int sumRange(int left, int right) {
        return elemSum[right + 1] - elemSum[left];
    }
}
