package leetcode.mergeAlternately;

/**
 * 1768. 交替合并字符串
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MergeAlternately {
    public static String mergeAlternately(String word1, String word2) {
        if ("".equals(word1)) {
            return word2;
        }
        if ("".equals(word2)) {
            return word1;
        }

        StringBuilder sb = new StringBuilder();

        int length = Math.min(word1.length(), word2.length());
        int i = 0;
        while (i < length) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
            ++i;
        }
        if (word1.length() > length) {
            sb.append(word1.substring(length, word1.length()));
        }
        if (word2.length() > length) {
            sb.append(word2.substring(length, word2.length()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab","pqrs"));
    }
}
