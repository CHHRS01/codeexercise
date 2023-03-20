package leetcode.containsDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
