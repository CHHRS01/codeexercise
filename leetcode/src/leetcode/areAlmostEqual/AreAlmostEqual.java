package leetcode.areAlmostEqual;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class AreAlmostEqual {
    public static boolean areAlmostEqual(String s1, String s2) {
        StringBuilder tmp1Str = new StringBuilder(2);
        StringBuilder tmp2Str = new StringBuilder(2);
        int count = 0;
        for (int i = 0; i< s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 2) {
                    return false;
                }
                tmp1Str.append(s1.charAt(i));
                tmp2Str.append(s2.charAt(i));
            }
        }
        if (count > 0) {
            return tmp1Str.toString().equals(tmp2Str.reverse().toString());
        }
        return true;
    }

    public  static void main(String[] args) {
        System.out.println(areAlmostEqual("abcd", "abcd"));
    }
}
