package leetcode.dp.impl;

import leetcode.dp.DynamicProgrammingService7;

import java.util.*;

public class DynamicProgrammingService7Impl implements DynamicProgrammingService7 {

    @Override
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        int[][] dp = new int[N][N];

        for (int[] mine: mines) {
            banned.add(mine[0] * N + mine[1]);
        }
        int ans = 0, count;

        for (int r = 0; r < N; ++r) {
            count = 0;
            for (int c = 0; c < N; ++c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            for (int c = N-1; c >= 0; --c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for (int c = 0; c < N; ++c) {
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for (int r = N-1; r >= 0; --r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }

        return ans;
    }

    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 使用邻接矩阵表示有向图，0 表示不连通
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 向集合添加一个记录（起点, 费用, 站数限制）的数组，K + 1 表示可以走过站点的个数
        minHeap.offer(new int[]{src, 0, K + 1});

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int v = front[0];
            int price = front[1];
            int k = front[2];

            if (v == dst) {
                return price;
            }

            // 如果还可以中转一个站
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    // 并且存在一条有向边
                    if (graph[v][i] > 0 ) {
                        // 优先队列中存入：有向边指向的顶点 i、从起点 src 到 i 的总路径长度、还有多少站可以中转
                        minHeap.offer(new int[]{i, price + graph[v][i]  , k - 1});
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public int numTilings(int N) {
        int MOD = 1_000_000_007;
        long[] dp = new long[]{1, 0, 0, 0};
        for (int i = 0; i < N; ++i) {
            long[] ndp = new long[4];
            ndp[0b00] = (dp[0b00] + dp[0b11]) % MOD;
            ndp[0b01] = (dp[0b00] + dp[0b10]) % MOD;
            ndp[0b10] = (dp[0b00] + dp[0b01]) % MOD;
            ndp[0b11] = (dp[0b00] + dp[0b01] + dp[0b10]) % MOD;
            dp = ndp;
        }
        return (int) dp[0];
    }

    @Override
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r+1][c] += q;
                    A[r+1][c+1] += q;
                }
            }
        }

        return Math.min(1, A[query_row][query_glass]);
    }

    @Override
    public double soupServings(int N) {
        N = N/25 + (N%25 > 0 ? 1 : 0);
        if (N >= 500) {
            return 1.0;
        }

        double[][] memo = new double[N+1][N+1];
        for (int s = 0; s <= 2*N; ++s) {
            for (int i = 0; i <= N; ++i) {
                int j = s-i;
                if (j < 0 || j > N) continue;
                double ans = 0.0;
                if (i == 0) ans = 1.0;
                if (i == 0 && j == 0) ans = 0.5;
                if (i > 0 && j > 0) {
                    ans = 0.25 * (memo[M(i-4)][j] + memo[M(i-3)][M(j-1)] +
                            memo[M(i-2)][M(j-2)] + memo[M(i-1)][M(j-3)]);
                }
                memo[i][j] = ans;

            }
        }
        return memo[N][N];
    }

    private int M(int x) { return Math.max(0, x); }

    @Override
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[] P = new double[N+1];
        for (int i = 0; i < N; ++i) {
            P[i+1] = P[i] + A[i];
        }

        double[] dp = new double[N];
        for (int i = 0; i < N; ++i) {
            dp[i] = (P[N] - P[i]) / (N - i);
        }

        for (int k = 0; k < K-1; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = i+1; j < N; ++j) {
                    dp[i] = Math.max(dp[i], (P[j]-P[i]) / (j-i) + dp[j]);
                }
            }
        }

        return dp[0];
    }

    @Override
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i) {
            index.put(A[i], i);
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (long x: dp) {
            ans += x;
        }
        return (int) (ans % MOD);
    }

    @Override
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1.0;
        }
        double[] dp = new double[k + maxPts];
        for (int i = k; i <= n && i < k + maxPts; i++) {
            dp[i] = 1.0;
        }
        for (int i = k - 1; i >= 0; i--) {
            for (int j = 1; j <= maxPts; j++) {
                dp[i] += dp[i + j] / maxPts;
            }
        }
        return dp[0];
    }

    @Override
    public String pushDominoes(String dominoes) {
        return null;
    }

    @Override
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = arr[i - 1] < arr[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = arr[i + 1] < arr[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
