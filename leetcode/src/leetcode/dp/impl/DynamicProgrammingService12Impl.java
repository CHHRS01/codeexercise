package leetcode.dp.impl;


import common.CommonConstants;
import leetcode.dp.DynamicProgrammingService12;

import java.util.Arrays;
import java.util.Comparator;

/**
 * basic sort methon for array
 * param is not null
 */
public class DynamicProgrammingService12Impl implements DynamicProgrammingService12 {

    @Override
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    row[i][j] = row[i][j - 1] + 1;
                } else {
                    row[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int col = row[i][j];
                for (int k = i; k >= 0 && col != 0; --k) {
                    col = Math.min(col, row[k][j]);
                    ans += col;
                }
            }
        }
        return ans;
    }

    @Override
    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 1;
        int subarrays = 0;
        int sum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            subarrays = (subarrays + (sum % 2 == 0 ? odd : even)) % CommonConstants.MOD;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return subarrays;
    }

    @Override
    public int numSplits(String s) {
        int n = s.length();
        int[] left = new int[n + 2];
        int[] right = new int[n + 2];
        boolean[] recLeft = new boolean[26];
        boolean[] recRight = new boolean[26];
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            if (recLeft[c]) {
                left[i] = left[i - 1];
            } else {
                recLeft[c] = true;;
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n; i > 0; i--) {
            int c = s.charAt(i - 1) - 'a';
            if (recRight[c]) {
                right[i] = right[i + 1];
            } else {
                recRight[c] = true;
                right[i] = right[i + 1] + 1;
            }
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (left[i] == right[i + 1]) {
                ret++;
            }
        }
        return ret;
    }

    @Override
    public int getMaxLen(int[] nums) {
        int length = nums.length;
        int[] positive = new int[length];
        int[] negative = new int[length];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLength = positive[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLength = Math.max(maxLength, positive[i]);
        }
        return maxLength;
    }

    @Override
    public int minCost(String s, int[] cost) {
        int ans = cost[0];
        int n = s.length();
        int maxValue = cost[0];
        for (int i = 1; i < n; i++) {
            ans += cost[i];
            if (s.charAt(i - 1) == s.charAt(i)) {
                maxValue = Math.max(maxValue, cost[i]);
            } else {
                ans -= maxValue;
                maxValue = cost[i];
            }
        }
        ans -= maxValue;
        return ans;
    }

    @Override
    public int maxProductPath(int[][] grid) {
        final int MOD = 1000000000 + 7;
        int m = grid.length, n = grid[0].length;
        long[][] maxgt = new long[m][n];
        long[][] minlt = new long[m][n];

        maxgt[0][0] = minlt[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            maxgt[0][i] = minlt[0][i] = maxgt[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            maxgt[i][0] = minlt[i][0] = maxgt[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxgt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                } else {
                    maxgt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                }
            }
        }
        if (maxgt[m - 1][n - 1] < 0) {
            return -1;
        } else {
            return (int) (maxgt[m - 1][n - 1] % MOD);
        }
    }

    @Override
    public int numberOfSets(int n, int k) {
        int[] dp = new int[n];
        int[] sums = new int[n];
        dp[0] = sums[0] = 1;
        for (int i = 0; i <= k; i++) { // i个线段
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    dp[j] = 0;
                } else if (j == i || i == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = (sums[j - 1] + dp[j - 1]) % CommonConstants.MOD;
                }
            }
            sums[0] = dp[0];
            for (int j = 1; j < n; j++) {
                sums[j] = (dp[j] + sums[j - 1]) % CommonConstants.MOD;
            }
        }
        return dp[n - 1];
    }

    @Override
    public int countSubstrings(String s, String t) {
        // 找到不一样的，然后向外扩散
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    int left = 1;
                    int right = 1;
                    while (i + right < s.length() && j + right < t.length() && s.charAt(i + right) == t.charAt(j + right)) {
                        right++;
                    }
                    while (i - left >= 0 && j - left >= 0 && s.charAt(i - left) == t.charAt(j - left)) {
                        left++;
                    }
                    res += left * right;
                }
            }
        }
        return res;
    }

    @Override
    public int bestTeamScore(int[] scores, int[] ages) {
        int res = 0;
        int[][] people = new int[ages.length][2];
        for(int i=0;i<ages.length;i++){
            people[i][0] = ages[i];
            people[i][1] = scores[i];
        }
        this.numSort(people);

        int[] dp = new int[people.length];
        for(int i=0;i<people.length;i++){
            dp[i] = people[i][1];
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(people[j][1]<=people[i][1]) {
                    dp[i] = Math.max(dp[j]+people[i][1],dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    private void numSort(int[][] people){
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 升序排列
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
    }

    @Override
    public int minimumDeletions(String s) {
        s = " " + s;
        int n = s.length();
        int[] a = new int[n], b = new int[n];
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                a[i] = a[i - 1];
                b[i] = b[i - 1] + 1;
            } else {
                b[i] = Math.min(b[i - 1], a[i - 1]);
                a[i] = a[i - 1] + 1;
            }
        }
        return Math.min(a[n - 1], b[n - 1]);
    }
}
