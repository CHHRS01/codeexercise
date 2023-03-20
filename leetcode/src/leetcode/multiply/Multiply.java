package leetcode.multiply;

/**
 * 43. 字符串相乘
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class Multiply {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = add(ans, curr.reverse().toString());
        }

        return ans;
    }

    // 字符累加
    public static String add(String str1, String str2) {
        int n = str1.length() - 1;
        int m = str2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        while (m >= 0 || n >= 0 || pre != 0) {
            int i = n >= 0?  str1.charAt(n)  - '0': 0;
            int j = m >= 0?  str2.charAt(m)  - '0': 0;
            sb.append((i + j + pre) % 10);
            pre = (i + j + pre) / 10;
            n--;
            m--;
        }
        return sb.reverse().toString();
    }
}
