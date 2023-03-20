package leetcode.addToArrayForm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class AddToArrayForm {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = num.length -1, pre = 0;
        while (n >=0 || k > 0 || pre != 0) {
            int i = n >= 0 ? num[n] : 0;
            int j = 0;
            if (k > 0) {
                j = k % 10;
                k = k / 10;
            }
            int sum = i + j + pre;
            ans.add(sum % 10);
            pre = sum / 10;
            n--;
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,1,5};
        System.out.println(addToArrayForm(num, 806));
    }
}
