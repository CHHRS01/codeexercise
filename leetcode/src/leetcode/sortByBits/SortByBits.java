package leetcode.sortByBits;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class SortByBits {
    public static int[] sortByBits(int[] arr) {
        int[][] tmp = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            tmp[i][0] = countOne(arr[i]);
            tmp[i][1] = arr[i];
        }
        Arrays.sort(tmp, ((o1, o2) -> {
            return o1[0] != o2[0] ? o1[0] - o2[0] :o1[1] - o2[1];
        }));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i][1];
        }
        return arr;
    }

    // 计算数据二进制下 1 的数目
    public static int countOne(int n) {
        int ans = 0;
        while (n > 0) {
            ++ans;
            n = n & (n-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] ans = sortByBits(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            System.out.print(" ");
        }

    }

}
