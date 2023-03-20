package leetcode.largestPerimeter;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class LargestPerimeter {
    public static int largestPerimeter(int[] nums) {
        int ans = 0;
        int lh = nums.length;
        boolean fg = false;
        if (lh >= 3) {
            int x = lh - 3, y = lh - 2, z = lh - 1;
            Arrays.sort(nums);
            while (x >= 0) {
                ans =  nums[y] + nums[z];
                if (nums[x] + nums[y] > nums[z]) {
                    ans += nums[x];
                    fg = true;
                    break;
                }
                ans = ans - nums[z];
                --z;
                --y;
                --x;

            }
        }
        return fg ? ans : 0;
    }

    public static void main(String[] args) {
        int[] an = {2455,142012,0,2421,4500};

        System.out.println(largestPerimeter(an));
    }
}
