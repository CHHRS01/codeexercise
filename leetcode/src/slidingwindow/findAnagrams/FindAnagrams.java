package slidingwindow.findAnagrams;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @auther 韩仁松
 * @since business V1.0.0
 */
public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {

        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {
                // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = findAnagrams("abab","ab");
        for (Integer val : ans) {
            System.out.print(val);
            System.out.print(" ");
        }
    }
}
