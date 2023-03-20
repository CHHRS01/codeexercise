package leetcode.toLowerCase;

/**
 * 709. 转换成小写字母
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class ToLowerCase {
    public static String toLowerCase(String s) {
        if ("".equals(s)) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ? (char) (s.charAt(i)+32) : s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(toLowerCase("al&phaBET"));
    }
}
