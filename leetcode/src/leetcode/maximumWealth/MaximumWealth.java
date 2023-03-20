package leetcode.maximumWealth;

/**
 * 1672. 最富有客户的资产总量
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MaximumWealth {
    public static int maximumWealth(int[][] accounts) {
        int[][] sum = new int[accounts.length][accounts[0].length];
        for (int i = 0; i < accounts.length; i++) {
            sum[i][0] = accounts[i][0];
        }
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 1; j < accounts[0].length; j++) {
                sum[i][j] = sum[i][j - 1] + accounts[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < accounts.length; j++) {
            ans = Math.max(ans, sum[j][accounts[0].length - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1,5},{7,3},{3,5},{1,1}};
        System.out.println(maximumWealth(accounts));
    }
}
