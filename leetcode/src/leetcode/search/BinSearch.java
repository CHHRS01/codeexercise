package leetcode.search;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class BinSearch {
    public static int search(int[] nums, int target) {
        // nums 升序
        int middle = (nums.length - 1) >> 1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            if (target == nums[middle]) {
                return middle;
            }
            else if (target > nums[middle] ) {
                left = middle;
                middle = (middle + right) >> 1;

            }
            else {
                right = middle;
                middle = (middle + left) >> 1;
            }

        }
        if (target == nums[left]) {
            return left;
        }
        if (target == nums[right]) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {-1,0,3,5,9,12};

        System.out.println(search(array, 2));
    }
}
