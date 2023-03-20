package leetcode.countOdds;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class CountOdds {
    public static int countOdds(int low, int high) {
        return getOdd(high) - getOdd(low - 1);
    }

    public static int getOdd(int num) {
        return (num + 1) >> 1;
    }

    public static void main(String[] args) {

        System.out.println(countOdds(23232323, 1487444541));
    }
}
