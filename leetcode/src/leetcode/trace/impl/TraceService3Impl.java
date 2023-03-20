package leetcode.trace.impl;

import common.CommonConstants;
import leetcode.trace.TraceService3;
import entity.PrefixNode;
import entity.TreeNode;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public class TraceService3Impl implements TraceService3 {
    /**
     * 893. 特殊等价字符串组
     * 给你一个字符串数组 words。
     * <p>
     * 一步操作中，你可以交换字符串 words[i] 的任意两个偶数下标对应的字符或任意两个奇数下标对应的字符。
     * <p>
     * 对两个字符串 words[i] 和 words[j] 而言，如果经过任意次数的操作，words[i] == words[j] ，那么这两个字符串是 特殊等价 的。
     * <p>
     * 例如，words[i] = "zzxy" 和 words[j] = "xyzz" 是一对 特殊等价 字符串，因为可以按 "zzxy" -> "xzzy" -> "xyzz" 的操作路径使 words[i] == words[j] 。
     * 现在规定，words 的 一组特殊等价字符串 就是 words 的一个同时满足下述条件的非空子集：
     * <p>
     * 该组中的每一对字符串都是 特殊等价 的
     * 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
     * 返回 words 中 特殊等价字符串组 的数量。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     */
    @Override
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();

        for(String str: words) {
            //这个下标0代表偶数位，先把偶数位的放进sb0中，然后转换成char[]类型进行排序
            StringBuilder sb0=new StringBuilder();
            for(int i=0;i<str.length();i+=2) {
                sb0.append(str.charAt(i));
            }
            char[] c0=sb0.toString().toCharArray();
            Arrays.sort(c0);
            //这个下标1代表奇数位，先把奇数位的放进sb1中，然后转换成char[]类型进行排序
            StringBuilder sb1=new StringBuilder();
            for(int i=1;i<str.length();i+=2) {
                sb1.append(str.charAt(i));
            }
            char[] c1=sb1.toString().toCharArray();
            Arrays.sort(c1);
            //最后把两个char[] c0 和 c1 转换成String 相加添加到set 里面去
            set.add(String.valueOf(c0)+String.valueOf(c1));
        }
        //最后返回set的大小即可
        return set.size();
    }

    /**
     * 931. 下降路径最小和
     * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
     * <p>
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     */
    @Override
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        for (int r = N-2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(matrix[r+1][c-1], matrix[r+1][c], matrix[r+1][c+1])
                int best = matrix[r+1][c];
                if (c > 0)
                    best = Math.min(best, matrix[r+1][c-1]);
                if (c+1 < N)
                    best = Math.min(best, matrix[r+1][c+1]);
                matrix[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: matrix[0]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }

    /**
     * 1042. 不邻接植花
     * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
     * <p>
     * 另外，所有花园 最多 有 3 条路径可以进入或离开.
     * <p>
     * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
     * <p>
     * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param paths
     */
    @Override
    public int[] gardenNoAdj(int N, int[][] paths) {
        if (paths.length==0){//如果没有花园相通
            int []result=new int[N];
            for (int i = 0; i <N; i++) {
                result[i]=1;
            }
        }
        int[][] result =new int[N+1][5];//每个位置维持一个5个长度的数组，第一个位置存放有多少个相邻花园，最后一个位置放花的种类
        for (int i = 0; i <paths.length; i++) {//先遍历 ，把相邻位置放进去
            result[paths[i][0]][0]++;//增加一个相邻花园
            result[paths[i][1]][0]++;//增加一个相邻花园
            result[paths[i][0]][ result[paths[i][0]][0]]=paths[i][1];//把相邻花园放进去
            result[paths[i][1]][ result[paths[i][1]][0]]=paths[i][0];//把相邻花园放进去
        }
        for (int i = 1; i <=N; i++) {//遍历每一个花园
            for (int j = 1; j <=4 ; j++) {//遍历决定放哪一种花
                int k=0;//定义在外面，好判断进行到哪了
                for (k = 1; k <4 ; k++) {//看这个花有没有相邻花园使用
                    if(result[result[i][k]][4]==j)break;//
                }
                if (k==4){
                    result[i][4]=j;
                    break;
                }
            }
        }
        int []result2=new int[N];//真正的结果
        for (int i = 0; i <N; i++) {
            result2[i]=result[i+1][4];
        }
        return result2;
    }

    /**
     * 1080. 根到叶路径上的不足节点
     * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
     * <p>
     * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
     * <p>
     * 请你删除所有不足节点，并返回生成的二叉树的根。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param limit
     */
    @Override
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootDeleted = dfs(root, 0, limit);
        if (rootDeleted) {
            return null;
        }
        return root;
    }

    private Boolean dfs(TreeNode node, int s, int limit) {
        if (node.left == null && node.right == null) {
            return s + node.val < limit;
        }

        // 注意：如果 dfs 的返回值的意义是这个结点是否被删除，它们的默认值应该设置为 true
        boolean lTreeDeleted = true;
        boolean rTreeDeleted = true;

        // 如果有左子树，就先递归处理左子树
        if (node.left != null) {
            lTreeDeleted = dfs(node.left, s + node.val, limit);
        }
        // 如果有右子树，就先递归处理右子树
        if (node.right != null) {
            rTreeDeleted = dfs(node.right, s + node.val, limit);
        }

        // 左右子树是否保留的结论得到了，由自己来执行是否删除它们
        if (lTreeDeleted) {
            node.left = null;
        }
        if (rTreeDeleted) {
            node.right = null;
        }

        // 只有左右子树都被删除了，自己才没有必要保留
        return lTreeDeleted && rTreeDeleted;
    }

    /**
     * 1091. 二进制矩阵中的最短路径
     * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
     * <p>
     * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
     * <p>
     * 路径途经的所有单元格都的值都是 0 。
     * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
     * 畅通路径的长度 是该路径途经的单元格总数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     */
    @Override
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int row, col;
        row = grid.length;
        col = grid[0].length;
        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        Queue<int[]> pos = new LinkedList<>();
        grid[0][0] = 1; // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
        pos.add(new int[]{0,0});
        while(!pos.isEmpty() && grid[row - 1][col - 1] == 0){ // 求最短路径 使用BFS
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]]; // 当前点的路径长度
            for(int i = 0; i < 8; i++){
                int newX = xy[0] + directions[i][0];
                int newY = xy[1] + directions[i][1];
                if(inGrid(newX, newY, row, col) && grid[newX][newY] == 0){
                    pos.add(new int[]{newX, newY});
                    grid[newX][newY] = preLength + 1; // 下一个点的路径长度要+1
                }
            }
        }
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1]; // 如果最后终点的值还是0，说明没有到达
    }

    private boolean inGrid(int x, int y,int row, int col){
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    /**
     * 1104. 二叉树寻路
     * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
     * <p>
     * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
     * <p>
     * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
     * <p>
     * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param label
     */
    @Override
    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<Integer>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    private int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }

    /**
     * 1129. 颜色交替的最短路径
     * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
     * <p>
     * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
     * <p>
     * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-path-with-alternating-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param red_edges
     * @param blue_edges
     */
    @Override
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        // dist存储0点到各个节点的距离
        int[] dist = new int[n];
        // 利用traveled存储访问过的节点
        // 0---表示从未访问
        // 1---表示访问过红
        // 2--表示访问过绿
        // 3--表示全都访问过
        int[][] traveled = new int[n][n];
        Map<Integer, List<Integer>> rmap = new HashMap<>();
        Map<Integer, List<Integer>> bmap = new HashMap<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            rmap.put(i, new ArrayList<>());
            bmap.put(i, new ArrayList<>());
        }
        for (int[] edge : red_edges) {
            rmap.get(edge[0]).add(edge[1]);
        }
        for (int[] edge : blue_edges) {
            bmap.get(edge[0]).add(edge[1]);
        }

        // 通过堆，将存储到某点的距离
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));

        pq.offer(new int[]{0, 0, 0});

        //dijkstra算法
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            // 表示目前到src点
            int src = point[0];
            // 表示0点到src点的距离
            int dis = point[1];
            // 表示到达src路径的颜色，0表示没有颜色，1表示通过红色到达，2表示通过绿色到达
            int last = point[2];
            // 1为上次是red，2为上次是blue

            // 如果上次没访问或者通过红路径访问过，则src->next这次需要通过绿路径访问
            if (last == 0 || last == 1) {
                for (int next : bmap.get(src)) {
                    // 如果全部访问过，则不能再进行访问
                    if (traveled[src][next] == 3) {
                        continue;
                    }
                    if (dis + 1 < dist[next]) {
                        // 如果到next点的距离比dist中更小，则进行更新
                        dist[next] = dis + 1;
                    }
                    // 如果没访问过，src->next则这次访问该点设置为通过绿路径访问
                    if (traveled[src][next] == 0) {
                        traveled[src][next] = 2;
                    } else {
                        // 如果上次通过红路径访问，则这次通过绿路径访问后，将src->next改为3，表示src->next通过各种路径都访问过了，以后不能再通过人和路径scr->next了
                        traveled[src][next] = 3;
                    }
                    //     System.out.println(src+" "+next+" "+(dis+1)+" "+2);
                    pq.offer(new int[]{next, dis + 1, 2});
                }
            }
            if (last == 0 || last == 2) {
                for (int next : rmap.get(src)) {
                    // 如果全部访问过，则不能再进行访问
                    if (traveled[src][next] == 3) {
                        continue;
                    }
                    //
                    if (dis + 1 < dist[next]) {
                        dist[next] = dis + 1;
                    }
                    //如果没访问过，src->next则这次访问该点设置为通过红路径访问
                    if (traveled[src][next] == 0) {
                        traveled[src][next] = 1;
                    } else {
                        // 如果上次通过绿路径访问，则这次通过红路径访问后，将src->next改为3，表示src->next通过各种路径都访问过了，以后不能再通过人和路径scr->next了
                        traveled[src][next] = 3;
                    }

                    //     System.out.println(src+" "+next+" "+(dis+1)+" "+1);
                    pq.offer(new int[]{next, dis + 1, 1});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    /**
     * 1138. 字母板上的路径
     * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
     * <p>
     * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
     * <p>
     * 我们可以按下面的指令规则行动：
     * <p>
     * 如果方格存在，'U' 意味着将我们的位置上移一行；
     * 如果方格存在，'D' 意味着将我们的位置下移一行；
     * 如果方格存在，'L' 意味着将我们的位置左移一列；
     * 如果方格存在，'R' 意味着将我们的位置右移一列；
     * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
     * （注意，字母板上只存在有字母的位置。）
     * <p>
     * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/alphabet-board-path
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param target
     */
    @Override
    public String alphabetBoardPath(String target) {
        char[] tc = target.toCharArray();
        StringBuilder sb = new StringBuilder();

        int curX = 0, curY = 0;
        for(int i = 0; i < tc.length; i++) {
            int tarX = (tc[i]-'a') / 5, tarY = (tc[i] - 'a') % 5;

            int distanceX = tarY - curY;
            char c1 = distanceX>=0 ? 'R' : 'L';

            int distanceY = tarX - curX;
            char c2 = distanceY>=0 ? 'D' : 'U';

            if(distanceY > 0) {
                //当整体位移方向是向下时，采取先走横再走纵的策略来避免走出边界
                go(sb, distanceX, c1);
                go(sb, distanceY, c2);
            }else {
                //当整体位移方向是向上是，采取先走纵再走横的策略来避免走出边界
                go(sb, distanceY, c2);
                go(sb, distanceX, c1);
            }

            //到达目标位置
            sb.append('!');

            //更新当前坐标
            curX = tarX; curY = tarY;
        }

        return sb.toString();
    }

    /**
     * 移动方法
     * distance： 移动距离
     * c： 横移还是纵移
     * */
    private void go(StringBuilder sb, int distance, char c) {
        distance = distance<0 ? -distance : distance;
        for(int j = 0; j < distance; j++) {
            sb.append(c);
        }
    }

    /**
     * 1233. 删除子文件夹
     * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
     * <p>
     * 我们这样定义「子文件夹」：
     * <p>
     * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
     * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
     * <p>
     * / 后跟一个或者多个小写英文字母。
     * 例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param folder
     */
    @Override
    public List<String> removeSubfolders(String[] folder) {
        PrefixNode root = new PrefixNode();
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        List<String> res = new ArrayList<>();
        for (String f : folder) {
            PrefixNode cur = root;
            String[] splits = f.split("/");
            int i = 0;
            while (i < splits.length) {
                if (!cur.children.containsKey(splits[i])) {
                    cur.children.put(splits[i], new PrefixNode());
                }
                cur = cur.children.get(splits[i]);
                if (cur.isEnd) {
                    continue;
                }
                i++;
            }
            res.add(f);
            cur.isEnd = true;
        }
        return res;
    }

    /**
     * 1334. 阈值距离内邻居最少的城市
     * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
     * <p>
     * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
     * <p>
     * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param edges
     * @param distanceThreshold
     */
    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] map = new int[n][n];
        //init map
        for (int[] ints : map) {
            Arrays.fill(ints, CommonConstants.INF);
        }
        for (int i = 0; i < n; i++) {
            map[i][i] = 0;
        }
        for (int[] e : edges) {
            map[e[0]][e[1]] = map[e[1]][e[0]] = e[2];
        }
        int res = 0;
        int MIN = n + 1;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            boolean[] set = new boolean[n];
            for (int v = 0; v < n; v++) {
                dist[v] = map[i][v];
            }
            dist[i] = 0;
            set[i] = true;
            for (int j = 0; j < n - 1; j++) {
                int min = CommonConstants.INF;
                int start = i;
                for (int k = 0; k < n; k++) {
                    if (!set[k] && dist[k] < min) {
                        min = dist[k];
                        start = k;
                    }
                }
                set[start] = true;
                for (int k = 0; k < n; k++) {
                    if (!set[k] && dist[k] > dist[start] + map[start][k]) {
                        dist[k] = dist[start] + map[start][k];
                    }
                }
            }
            int temp = 0;
            for (int j = 0; j < dist.length; j++) {
                if (dist[j] <= distanceThreshold) {
                    temp++;
                }
            }
            if (temp <= MIN) {
                MIN = temp;
                res = i;
            }
        }
        return res;
    }
}
