package tree.nextGreaterElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大元素 I
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums1 是 nums2 子集
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int i= 0; i< nums2.length; i++) {
            for (int j = i+1; j< nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }

        int[] ans = new int[nums1.length];
        for (int t= 0; t< nums1.length; t++) {
            ans[t] = map.getOrDefault(nums1[t], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] ans = nextGreaterElement(nums1, nums2);
        for (int t= 0; t< nums1.length; t++) {
            System.out.print(ans[t]);
            System.out.print(" ");
        }

    }
}
