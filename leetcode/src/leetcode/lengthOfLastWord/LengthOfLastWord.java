package leetcode.lengthOfLastWord;

/**
 * 58. 最后一个单词的长度
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int length = s.length();
        int ans = 0;
        int i = length - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        for (; i >=0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
