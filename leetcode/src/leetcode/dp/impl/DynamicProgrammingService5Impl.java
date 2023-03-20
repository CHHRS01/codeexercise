package leetcode.dp.impl;

import leetcode.dp.DynamicProgrammingService5;

import java.util.Arrays;

public class DynamicProgrammingService5Impl implements DynamicProgrammingService5 {

    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    private int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

    @Override
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    @Override
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

    @Override
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    @Override
    public int countArrangement(int n) {
        return 0;
    }

    @Override
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        // 如果 (i, j) 的元素为 0，那么距离为 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (i + 1 < m) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j + 1 < n) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < m) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }

    @Override
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        double[][][] dp = new double[n][n][2];
        String[][][] strings = new String[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = nums[i];
            strings[i][i][0] = String.valueOf(nums[i]);
            strings[i][i][1] = String.valueOf(nums[i]);
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                double max = Double.MIN_VALUE;
                double min = Double.MAX_VALUE;
                StringBuilder a = new StringBuilder(), b = new StringBuilder();
                for (int k = i; k < j; k++) {
                    if (dp[i][k][0] / dp[k + 1][j][1] > max) {
                        max = dp[i][k][0] / dp[k + 1][j][1];
                        a = new StringBuilder();
                        if (k + 1 == j) {
                            a.append(strings[i][k][0]).append('/').append(strings[k + 1][j][1]);
                        } else {
                            a.append(strings[i][k][0]).append("/(").append(strings[k + 1][j][1]).append(')');
                        }
                    }
                    if (dp[i][k][1] / dp[k + 1][j][0] < min) {
                        min = dp[i][k][1] / dp[k + 1][j][0];
                        b = new StringBuilder();
                        if (k + 1 == j) {
                            b.append(strings[i][k][1]).append('/').append(strings[k + 1][j][0]);
                        } else {
                            b.append(strings[i][k][1]).append("/(").append(strings[k + 1][j][0]).append(')');
                        }
                    }
                }
                dp[i][j][0] = max;
                dp[i][j][1] = min;
                strings[i][j][0] = a.toString();
                strings[i][j][1] = b.toString();
            }
        }
        return strings[0][n - 1][0];
    }

    @Override
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int)1e9+7;

        // f[i][j] 代表从 idx 为 i 的位置出发，移动步数不超过 j 的路径数量
        int[][] f = new int[m * n][maxMove + 1];

        // 初始化边缘格子的路径数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    add(i, j, f, n, maxMove);
                }
                if (i == m - 1) {
                    add(i, j, f, n, maxMove);
                }
                if (j == 0) {
                    add(i, j, f, n, maxMove);
                }
                if (j == n - 1) {
                    add(i, j, f, n, maxMove);
                }
            }
        }

        // 定义可移动的四个方向
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        // 从小到大枚举「可移动步数」
        for (int step = 1; step <= maxMove; step++) {
            // 枚举所有的「位置」
            for (int k = 0; k < m * n; k++) {
                int x = parseIdx(k, n)[0], y = parseIdx(k, n)[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    // 如果位置有「相邻格子」，则「相邻格子」参与状态转移
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        f[k][step] += f[getIndex(nx, ny, n)][step - 1];
                        f[k][step] %= mod;
                    }
                }
            }
        }

        // 最终结果为从起始点触发，最大移动步数不超 maxMove 的路径数量
        return f[getIndex(startRow, startColumn, n)][maxMove];
    }

    // 为每个「边缘」格子，添加一条路径
    private void add(int x, int y, int[][] f, int n,int maxMove) {
        int idx = getIndex(x, y, n);
        for (int step = 1; step <= maxMove; step++) {
            f[idx][step]++;
        }
    }

    // 将 (x, y) 转换为 index
    private int getIndex(int x, int y, int n) {
        return x * n + y;
    }

    // 将 index 解析回 (x, y)
    private int[] parseIdx(int idx, int n) {
        return new int[]{idx / n, idx % n};
    }

    @Override
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
