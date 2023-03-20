package strMatching.repeatedSubstringPattern;

import java.util.Arrays;

/**
 * 459. 重复的子字符串
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        return kmp(s + s, s);
    }

    public static boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        // 构造匹配数组
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; i++) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(i) != pattern.charAt(j + 1)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }

        // 字符串匹配
        //匹配的下标
        int match = -1;
        for (int i = 1; i < n - 1; i++) {
            while (match != -1 && query.charAt(i) != query.charAt(match + 1)) {
                match = fail[match];
            }
            if (query.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m -1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aba"));
    }
}
