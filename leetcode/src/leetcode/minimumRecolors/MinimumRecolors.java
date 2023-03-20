package leetcode.minimumRecolors;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MinimumRecolors {
    public static int minimumRecolors(String blocks, int k) {
        int ans = k + 1;
        int w = 0;
        int i = 0;
        int tmp = 0;
        for (; i<k; i++) {
            tmp += addBlack(blocks.charAt(i));
        }
        ans = Math.min(ans, tmp);
        while (i < blocks.length()) {
            tmp -= addBlack(blocks.charAt(i-k));
            tmp += addBlack(blocks.charAt(i));
            ans = Math.min(ans, tmp);
            ++i;
        }
        return ans;
    }

    public static int addBlack(Character strChar) {
        return strChar == 'B' ? 0 : 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WWBBBWBBBBBWWBWWWB",16));
    }
}
