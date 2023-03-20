package leetcode.isAnagram;

/**
 * 242. 有效的字母异位词
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] maps = new int[26];
        int[] mapt = new int[26];
        for (int i= 0; i < s.length(); i++) {
            maps[s.charAt(i) - 'a'] += 1;
            mapt[t.charAt(i) - 'a'] += 1;
        }
        for (int i= 0; i < 26; i++) {
            if (maps[i] != mapt[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
}
