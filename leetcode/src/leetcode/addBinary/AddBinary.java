package leetcode.addBinary;

/**
 * 67. 二进制求和
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class AddBinary {
    public static String addBinary(String a, String b) {
        int n = a.length() - 1, m = b.length() - 1, pre = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= 0 || m >= 0 || pre != 0) {
            int i = n >= 0 ? a.charAt(n) - '0' : 0;
            int j = m >= 0 ? b.charAt(m) - '0' : 0;
            int sum = i + j + pre;
            sb.append(sum & 1);
            pre = sum >> 1;
            n--;
            m--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
