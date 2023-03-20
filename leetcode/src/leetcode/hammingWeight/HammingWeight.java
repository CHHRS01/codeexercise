package leetcode.hammingWeight;

/**
 * 输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class HammingWeight {

    public int hammingWeight(int n) {
        int ans = 0;
        // 取末尾1
        while (n != 0) {
            n &= n - 1;
            ans++;
        }

        return ans;
    }
}
