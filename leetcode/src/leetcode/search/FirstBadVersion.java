package leetcode.search;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class FirstBadVersion {

    public Boolean isBadVersion(int num) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            // 防止计算时溢出
            //  位运算  注意使用括号
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}
