package leetcode.isHappy;

/**
 * 202. 快乐数
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class JudgeIsHappy {
    // 有环
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(slow);
        while(slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1 ? true : false;
    }

    public static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (int)Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
