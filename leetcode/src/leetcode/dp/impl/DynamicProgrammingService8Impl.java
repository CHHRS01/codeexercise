package leetcode.dp.impl;

import common.CommonConstants;
import leetcode.dp.DynamicProgrammingService8;
import entity.RepInteger;
import entity.TreeNode;

import java.util.*;

public class DynamicProgrammingService8Impl implements DynamicProgrammingService8 {

    @Override
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            index.put(A[i], i);
        }

        Map<Integer, Integer> longest = new HashMap<>();
        int ans = 0;

        for (int k = 0; k < N; ++k) {
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }
        }

        return ans >= 3 ? ans : 0;
    }

    @Override
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    @Override
    public List<TreeNode> allPossibleFBT(int N) {

        Map<Integer,List<TreeNode>> map=new HashMap<>();

        if(map.containsKey(N)) {
            return map.get(N);
        }

        List<TreeNode> ans=new ArrayList<>();

        if(N==1) {
            ans.add(new TreeNode(0));
        } else if(N%2==1) {
            for(int i=0;i<N;i++) {
                int y=N-1-i;
                for(TreeNode left : allPossibleFBT(i)) {
                    for(TreeNode right : allPossibleFBT(y)) {
                        TreeNode tmp=new TreeNode(0);
                        tmp.left=left;
                        tmp.right=right;
                        ans.add(tmp);
                    }
                }
            }
        }

        map.put(N, ans);

        return ans;
    }

    @Override
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int x: A) {
            Set<Integer> cur2 = new HashSet<>();
            for (int y: cur) {
                cur2.add(x | y);
            }
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }

    @Override
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;

        Stack<RepInteger> stack = new Stack<>();
        int ans = 0, dot = 0;
        for (int j = 0; j < A.length; ++j) {
            // Add all answers for subarrays [i, j], i <= j
            int count = 1;
            while (!stack.isEmpty() && stack.peek().getVal() >= A[j]) {
                RepInteger node = stack.pop();
                count += node.getCount();
                dot -= node.getVal() * node.getCount();
            }
            stack.push(new RepInteger(A[j], count));
            dot += A[j] * count;
            ans += dot;
            ans %= MOD;
        }

        return ans;
    }

    @Override
    public int maxSubarraySumCircular(int[] A) {
        // S: sum of A
        int S = 0;
        for (int x: A) {
            S += x;
        }

        // ans1: answer for one-interval subarray
        int ans1 = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int x: A) {
            cur = x + Math.max(cur, 0);
            ans1 = Math.max(ans1, cur);
        }

        // ans2: answer for two-interval subarray, interior in A[1:]
        int ans2 = Integer.MAX_VALUE;
        cur = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; ++i) {
            cur = A[i] + Math.min(cur, 0);
            ans2 = Math.min(ans2, cur);
        }
        ans2 = S - ans2;

        // ans3: answer for two-interval subarray, interior in A[:-1]
        int ans3 = Integer.MAX_VALUE;
        cur = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; ++i) {
            cur = A[i] + Math.min(cur, 0);
            ans3 = Math.min(ans3, cur);
        }

        return Math.max(ans1, Math.max(ans2, ans3));
    }

    @Override
    public int minFlipsMonoIncr(String S) {
        int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            P[i+1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            ans = Math.min(ans, P[j] + N-j-(P[N]-P[j]));
        }

        return ans;
    }

    @Override
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        for (int r = N - CommonConstants.INTEGER_2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r+1][c];
                if (c > 0) {
                    best = Math.min(best, A[r+1][c-1]);
                }
                if (c+1 < N) {
                    best = Math.min(best, A[r+1][c+1]);
                }
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: A[0]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }

    @Override
    public int knightDialer(int N) {
        int MOD = 1_000_000_007;
        int[][] moves = new int[][]{
                {4,6},{6,8},{7,9},{4,8},{3,9,0},
                {},{1,7,0},{2,6},{1,3},{2,4}};

        int[][] dp = new int[2][10];
        Arrays.fill(dp[0], 1);
        for (int hops = 0; hops < N-1; ++hops) {
            Arrays.fill(dp[~hops & 1], 0);
            for (int node = 0; node < 10; ++node) {
                for (int nei: moves[node]) {
                    dp[~hops & 1][nei] += dp[hops & 1][node];
                    dp[~hops & 1][nei] %= MOD;
                }
            }
        }

        long ans = 0;
        for (int x: dp[~N & 1]) {
            ans += x;
        }
        return (int) (ans % MOD);
    }

    @Override
    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            if (arr[i - 1] > arr[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i - 1] < arr[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }

        int ret = 1;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i][0]);
            ret = Math.max(ret, dp[i][1]);
        }
        return ret;
    }
}
