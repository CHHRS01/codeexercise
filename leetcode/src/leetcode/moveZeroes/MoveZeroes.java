package leetcode.moveZeroes;

/**
 * 283. 移动零
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {

        //  获取二进制
//        int x = 1 << nums.length;

        int zeroIndex = getZeroIndex(0, nums);
        int noZeroIndex = getNoZeroIndex(zeroIndex + 1, nums);
        while (zeroIndex <= nums.length -1 && noZeroIndex <= nums.length -1) {
            nums[zeroIndex] = nums[noZeroIndex];
            nums[noZeroIndex] = 0;
            zeroIndex = getZeroIndex(zeroIndex + 1, nums);
            noZeroIndex = getNoZeroIndex(noZeroIndex + 1, nums);
        }
    }

    public static int getZeroIndex(int zeroIndex, int[] nums) {
        while (zeroIndex <= nums.length - 1) {
            if (nums[zeroIndex] == 0) {
                break;
            }
            ++zeroIndex;
        }
        return zeroIndex;
    }

    public static int getNoZeroIndex(int noZeroIndex, int[] nums) {
        while (noZeroIndex <= nums.length - 1) {
            if (nums[noZeroIndex] != 0) {
                break;
            }
            ++noZeroIndex;
        }
        return noZeroIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1,0};
        moveZeroes(arr);
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
