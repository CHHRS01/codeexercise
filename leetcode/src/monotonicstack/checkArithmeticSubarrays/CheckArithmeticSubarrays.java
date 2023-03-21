package monotonicstack.checkArithmeticSubarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1630. 等差子数组
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class CheckArithmeticSubarrays {
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < r.length; i++) {
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(arr);
            int dif = arr[1] - arr[0];
            boolean cur = true;
            for (int j = 2; j < arr.length; j++) {
                if (arr[j] - arr[j - 1] != dif) {
                    cur = false;
                    break;
                }
            }
            ans.add(cur);
        }
        return ans;
    }
}
