package leetcode.findTheDifference;

import java.util.HashSet;

/**
 * 389. 找不同
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class FindTheDifference {
    public static char findTheDifference(String s, String t) {

        int[] charArray = new int[26];
        for (int i = 0; i<s.length(); i++) {
            charArray[s.charAt(i) - 'a'] += 1;
        }
        for (int j = 0; j< t.length();j++) {
            charArray[t.charAt(j) - 'a'] -= 1;
            if (charArray[t.charAt(j) - 'a'] < 0) {
                return t.charAt(j);
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("a", "aa"));
    }
}
