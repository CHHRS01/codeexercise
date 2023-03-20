package leetcode.trace.impl;

import common.CommonConstants;
import leetcode.trace.TraceService4;
import entity.*;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public class TraceService4Impl implements TraceService4 {

    /**
     * 1367. 二叉树中的列表
     * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     * <p>
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
     * <p>
     * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-in-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param root
     */
    @Override
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        //先判断当前的节点，如果不对，再看左子树和右子树呗
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSub(ListNode head, TreeNode node) {
        //特判：链表走完了，返回true
        if (head == null) {
            return true;
        }
        //特判：链表没走完，树走完了，这肯定不行，返回false
        if (node == null) {
            return false;
        }
        //如果值不同，必定不是啊
        if (head.val != node.val) {
            return false;
        }
        //如果值相同，继续看，左边和右边有一个满足即可
        return isSub(head.next, node.left) || isSub(head.next, node.right);
    }

    /**
     * 1372. 二叉树中的最长交错路径
     * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
     * <p>
     * 选择二叉树中 任意 节点和一个方向（左或者右）。
     * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
     * 改变前进方向：左变右或者右变左。
     * 重复第二步和第三步，直到你在树中无法继续移动。
     * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
     * <p>
     * 请你返回给定树中最长 交错路径 的长度。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     */
    @Override
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxAns = 0;
        dfs(root, false, 0, maxAns);
        dfs(root, true, 0, maxAns);
        return maxAns;
    }

    public void dfs(TreeNode o, boolean dir, int len, int maxAns) {
        maxAns = Math.max(maxAns, len);
        if (!dir) {
            if (o.left != null) {
                dfs(o.left, true, len + 1, maxAns);
            }
            if (o.right != null) {
                dfs(o.right, false, 1, maxAns);
            }
        } else {
            if (o.right != null) {
                dfs(o.right, false, len + 1, maxAns);
            }
            if (o.left != null) {
                dfs(o.left, true, 1, maxAns);
            }
        }
    }

    /**
     * 1391. 检查网格中是否存在有效路径
     * <p>
     * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
     * <p>
     * 1 表示连接左单元格和右单元格的街道。
     * 2 表示连接上单元格和下单元格的街道。
     * 3 表示连接左单元格和下单元格的街道。
     * 4 表示连接右单元格和下单元格的街道。
     * 5 表示连接左单元格和上单元格的街道。
     * 6 表示连接右单元格和上单元格的街道。
     * <p>
     * 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
     * <p>
     * 注意：你 不能 变更街道。
     * <p>
     * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     */
    @Override
    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        ds = new DisjointEdge(m, n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                handler(i, j);
            }
        }
        return ds.find(getId(0, 0)) == ds.find(getId(m - 1, n - 1));
    }

    private int[][] grid;
    private int m, n;
    private DisjointEdge ds;

    private int getId(int x, int y) {
        return x * n + y;
    }

    private void handler(int x, int y) {
        int pattern = CommonConstants.PATTERNS[grid[x][y]];
        for (int i = 0; i < 4; ++i) {
            if ((pattern & (1 << i)) != 0) {
                int sx = x + CommonConstants.DIRS[i][0];
                int sy = y + CommonConstants.DIRS[i][1];
                if (sx >= 0 && sx < m && sy >= 0 && sy < n && (CommonConstants.PATTERNS[grid[sx][sy]] & (1 << ((i + 2) % 4))) != 0) {
                    ds.merge(getId(x, y), getId(sx, sy));
                }
            }
        }
    }

    /**
     * 1448. 统计二叉树中好节点的数目
     * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
     * <p>
     * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
     *
     * @param root
     */
    @Override
    public int goodNodes(TreeNode root) {
        recur(root , Integer.MIN_VALUE);
        return nodeNum;
    }

    // 统计好节点的个数
    private int nodeNum = 0;

    // max用于记录从顶层递归到本层的最大节点值，
    // 若节点大于max说明该结点不小于该结点到根节点路径上所有节点
    public void recur(TreeNode node , int max){
        if(node == null) return;
        if(node.val >= max){
            nodeNum++;
            max = node.val;
        }
        recur(node.left , max);
        recur(node.right , max);
    }

    /**
     * 1457. 二叉树中的伪回文路径
     * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
     * <p>
     * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     */
    @Override
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null) return 0;
        helper(root,0);
        return ans;
    }

    private int ans=0;

    private void helper(TreeNode node,int temp){
        temp^=(1<<node.val);//node节点的val为几就左移几位
        if(node.left==null&&node.right==null){//判断是否叶子节点
            if(temp==0||(temp&(temp-1))==0){//判断是否为伪回文
                ans++;
            }
        }
        if(node.left!=null) helper(node.left,temp);
        if(node.right!=null) helper(node.right,temp);
        return;
    }

    /**
     * 1514. 概率最大的路径
     * 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
     * <p>
     * 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
     * <p>
     * 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-with-maximum-probability
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param edges
     * @param succProb
     * @param start
     * @param end
     */
    @Override
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<ProbabilityPair>> graph = new ArrayList<List<ProbabilityPair>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<ProbabilityPair>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new ProbabilityPair(succProb[i], e[1]));
            graph.get(e[1]).add(new ProbabilityPair(succProb[i], e[0]));
        }

        PriorityQueue<ProbabilityPair> que = new PriorityQueue<ProbabilityPair>();
        double[] prob = new double[n];

        que.offer(new ProbabilityPair(1, start));
        prob[start] = 1;
        while (!que.isEmpty()) {
            ProbabilityPair probabilityPair = que.poll();
            double pr = probabilityPair.probability;
            int node = probabilityPair.node;
            if (pr < prob[node]) {
                continue;
            }
            for (ProbabilityPair probabilityPairNext : graph.get(node)) {
                double prNext = probabilityPairNext.probability;
                int nodeNext = probabilityPairNext.node;
                if (prob[nodeNext] < prob[node] * prNext) {
                    prob[nodeNext] = prob[node] * prNext;
                    que.offer(new ProbabilityPair(prob[nodeNext], nodeNext));
                }
            }
        }
        return prob[end];
    }

    /**
     * 1530. 好叶子节点对的数量
     * 给你二叉树的根节点 root 和一个整数 distance 。
     * <p>
     * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
     * <p>
     * 返回树中 好叶子节点对的数量 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param distance
     */
    @Override
    public int countPairs(TreeNode root, int distance) {
        Record1Example record1Example = dfs(root, distance);
        return record1Example.count;
    }

    // 对于 dfs(root,distance)，同时返回：
    // 1）每个叶子节点与 root 之间的距离
    // 2) 以 root 为根节点的子树中好叶子节点对的数量
    public Record1Example dfs(TreeNode root, int distance) {
        int[] depths = new int[distance + 1];
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf) {
            depths[0] = 1;
            return new Record1Example(depths, 0);
        }

        int[] leftDepths = new int[distance + 1];
        int[] rightDepths = new int[distance + 1];
        int leftCount = 0, rightCount = 0;
        if (root.left != null) {
            Record1Example leftRecord1Example = dfs(root.left, distance);
            leftDepths = leftRecord1Example.depths;
            leftCount = leftRecord1Example.count;
        }
        if (root.right != null) {
            Record1Example rightRecord1Example = dfs(root.right, distance);
            rightDepths = rightRecord1Example.depths;
            rightCount = rightRecord1Example.count;
        }

        for (int i = 0; i < distance; i++) {
            depths[i + 1] += leftDepths[i];
            depths[i + 1] += rightDepths[i];
        }

        int cnt = 0;
        for (int i = 0; i <= distance; i++) {
            for (int j = 0; j + i + 2 <= distance; j++) {
                cnt += leftDepths[i] * rightDepths[j];
            }
        }
        return new Record1Example(depths, cnt + leftCount + rightCount);
    }

    /**
     * 1584. 连接所有点的最小费用
     * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
     * <p>
     * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
     * <p>
     * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param points
     */
    @Override
    public int minCostConnectPoints(int[][] points) {
        p = new ArrayList<>();
        int n = points.length;
        // 初始化并查集
        for(int i = 0; i < n; i++) {
            p.add(i);
        }
        // 添加所有可能的边到列表中
        List<WeightEdge> weightEdges = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                // 添加第i个点和第j个点组成的边
                weightEdges.add(new WeightEdge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        // 进行一个升序排序，为了优先选取短的边
        Collections.sort(weightEdges, (a, b) -> a.val - b.val);

        // 从低到高遍历所有边
        int res = 0;
        for(WeightEdge e : weightEdges) {
            // 查找这条边两个端点所处的集合根元素
            int a = find(e.a), b = find(e.b);
            // 如果这两条边不是一个集合的，那么就添加这条边
            if(a != b) {
                // 并且将这两个点所在的集合根元素加入一个集合
                p.set(a, b);
                // 答案中添加这条边长度
                res += e.val;
            }
        }

        return res;
    }

    private List<Integer> p;

    // 并查集模板方法，用于查找根元素
    private int find(int x) {
        //p 数组 x下标 也对应值
        if(p.get(x) != x) {
            p.set(x, find(p.get(x)));
        }

        return p.get(x);
    }

    /**
     * 1594. 矩阵的最大非负积
     * 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
     * <p>
     * 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
     * <p>
     * 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。
     * <p>
     * 注意，取余是在得到最大积之后执行的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     */
    @Override
    public int maxProductPath(int[][] grid) {
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
            return (int) (maxgt[m - 1][n - 1] % CommonConstants.MOD);
        }
    }

    /**
     * 1631. 最小体力消耗路径
     * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
     * <p>
     * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
     * <p>
     * 请你返回从左上角走到右下角的最小 体力消耗值 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param heights
     */
    @Override
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });

        UnionFindEdge uf = new UnionFindEdge(m * n);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.unite(x, y);
            if (uf.connected(0, m * n - 1)) {
                ans = v;
                break;
            }
        }
        return ans;
    }
}
