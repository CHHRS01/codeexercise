package strMatching.strStr;

/**
 * 28. 找出字符串中第一个匹配项的下标
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        // 原串和匹配串前面都加空格，使其下标从 1 开始
        // 方便字串判断
        haystack = " " + haystack;
        char[] s = haystack.toCharArray();
        needle = " " + needle;
        char[] p = needle.toCharArray();
        // 构造匹配数组
        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) {
                j = next[j];
            }
            if (p[i] == p[j + 1]) {
                ++j;
            }
            next[i] = j;
        }

        // 匹配过程
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) {
                j = next[j];
            }
            if (s[i] == p[j + 1]) {
                ++j;
            }
            if (j == m) {
                return i - m;
            }
        }

        return -1;
    }
}
