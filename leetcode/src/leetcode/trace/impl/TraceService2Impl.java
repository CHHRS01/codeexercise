package leetcode.trace.impl;

import common.CommonConstants;
import leetcode.trace.TraceService2;
import entity.QuadTreeNode;
import entity.TreeNode;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public class TraceService2Impl implements TraceService2 {

    /**
     * 310. 最小高度树
     * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
     * <p>
     * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
     * <p>
     * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
     * <p>
     * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
     * <p>
     * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-height-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param edges
     */
    @Override
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        /*如果只有一个节点，那么他就是最小高度树*/
        if (n == 1) {
            res.add(0);
            return res;
        }
        /*建立各个节点的出度表*/
        int[] degree = new int[n];
        /*建立图关系，在每个节点的list中存储相连节点*/
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;/*出度++*/
            map.get(edge[0]).add(edge[1]);/*添加相邻节点*/
            map.get(edge[1]).add(edge[0]);
        }
        /*建立队列*/
        Queue<Integer> queue = new LinkedList<>();
        /*把所有出度为1的节点，也就是叶子节点入队*/
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        /*循环条件当然是经典的不空判断*/
        while (!queue.isEmpty()) {
            res = new ArrayList<>();/*这个地方注意，我们每层循环都要new一个新的结果集合，
            这样最后保存的就是最终的最小高度树了*/
            int size = queue.size();/*这是每一层的节点的数量*/
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);/*把当前节点加入结果集，不要有疑问，为什么当前只是叶子节点为什么要加入结果集呢?
                因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点，
                这也是很多题解里面所说的剪掉叶子节点的部分，你可以想象一下图，每层遍历完，
                都会把该层（也就是叶子节点层）这一层从队列中移除掉，
                不就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图吗*/
                List<Integer> neighbors = map.get(cur);
                /*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
                 * 把它们的出度都减1，因为当前节点已经不存在了，所以，
                 * 它的相邻节点们就有可能变成叶子节点*/
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        /*如果是叶子节点我们就入队*/
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;/*返回最后一次保存的list*/
    }

    /**
     * 388. 文件的最长绝对路径
     * 将 dir 作为根目录中的唯一目录。dir 包含两个子目录 subdir1 和 subdir2 。subdir1 包含文件 file1.ext 和子目录 subsubdir1；subdir2 包含子目录 subsubdir2，该子目录下包含文件 file2.ext 。
     * <p>
     * 在文本格式中，如下所示(⟶表示制表符)：
     * <p>
     * dir
     * ⟶ subdir1
     * ⟶ ⟶ file1.ext
     * ⟶ ⟶ subsubdir1
     * ⟶ subdir2
     * ⟶ ⟶ subsubdir2
     * ⟶ ⟶ ⟶ file2.ext
     * 如果是代码表示，上面的文件系统可以写为 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 。'\n' 和 '\t' 分别是换行符和制表符。
     * <p>
     * 文件系统中的每个文件和文件夹都有一个唯一的 绝对路径 ，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用 '/' 连接。上面例子中，指向 file2.ext 的绝对路径是 "dir/subdir2/subsubdir2/file2.ext" 。每个目录名由字母、数字和/或空格组成，每个文件名遵循 name.extension 的格式，其中名称和扩展名由字母、数字和/或空格组成。
     * <p>
     * 给定一个以上述格式表示文件系统的字符串 input ，返回文件系统中 指向文件的最长绝对路径 的长度。 如果系统中没有文件，返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-absolute-file-path
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param input
     */
    @Override
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        // 以 \n 分割成字符串数组
        String[] str = input.split("\n");
        // dir,\tsubdir1,\tsubdir2,\tfile.ext
        for (String s : str) {
            // level 代表当前字符串的首字母索引
            // 字符串前面可能会有多个 \t,故使用 lastIndexOf 找出最后一个 \t 位置即可
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            // 之前入栈的字符串 + 当前遍历到的字符串的长度
            int len = stack.peek() + (s.length() - level + 1);
            stack.push(len);
            if (s.contains(".")) {
                ans = Math.max(ans, len - 1);
            }
        }
        return ans;
    }

    /**
     * 427. 建立四叉树
     * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
     * <p>
     * 你需要返回能表示矩阵的 四叉树 的根结点。
     * <p>
     * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
     * <p>
     * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
     * <p>
     * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
     * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
     * class Node {
     * public boolean val;
     *     public boolean isLeaf;
     *     public Node topLeft;
     *     public Node topRight;
     *     public Node bottomLeft;
     *     public Node bottomRight;
     * }
     * 我们可以按以下步骤为二维区域构建四叉树：
     * <p>
     * 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
     * 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
     * 使用适当的子网格递归每个子节点。
     * <p>
     * 四叉树格式：
     * <p>
     * 输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节点。
     * <p>
     * 它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。
     * <p>
     * 如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；如果 isLeaf 或者 val 的值为 False ，则表示值为 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-quad-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     */
    @Override
    public QuadTreeNode construct(int[][] grid) {
        if (grid == null) {
            return null;
        }
        return helper(grid, 0, grid.length, 0, grid[0].length);
    }

    private QuadTreeNode helper(int[][] grid, int i, int j, int k, int l) {
        //先判断包含的值是否都相同
        boolean[] same = same(grid, i, j, k, l);
        if (same[0]) {
            //是，直接构建叶子节点，返回
            return new QuadTreeNode(same[1],true);
        }
        //判断是否达到最小范围
        if (j - i == 2) {
            //是，构建叶子节点返回
            QuadTreeNode node = new QuadTreeNode();
            node.topLeft = new QuadTreeNode(grid[i][k] == 1, true);
            node.topRight = new QuadTreeNode(grid[i][k + 1] == 1, true);
            node.bottomLeft = new QuadTreeNode(grid[i + 1][k] == 1, true);
            node.bottomRight = new QuadTreeNode(grid[i + 1][k + 1] == 1, true);
            return node;
        } else {
            //否，递归
            QuadTreeNode node = new QuadTreeNode();
            int rowMid = (j - i) / 2 + i;
            int columnMid = (l - k) / 2 + k;
            node.topLeft = helper(grid, i, rowMid, k, columnMid);
            node.topRight = helper(grid, i, rowMid, columnMid, l);
            node.bottomLeft = helper(grid, rowMid, j, k, columnMid);
            node.bottomRight = helper(grid, rowMid, j, columnMid, l);
            return node;
        }
    }

    private boolean[] same(int[][] grid, int i, int j, int k, int l) {
        int temp = grid[i][k];
        for (int m = i; m < j; m++) {
            for (int n = k; n < l; n++) {
                if (temp != grid[m][n]) {
                    return new boolean[]{false};
                }
            }
        }
        return new boolean[]{true, temp == 1};
    }

    /**
     * 437. 路径总和 III
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param targetSum
     */
    @Override
    public int pathSumIII(TreeNode root, int targetSum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, targetSum, 0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * @param node 树节点
     * @param prefixSumCount 前缀和Map
     * @param target 目标值
     * @param currSum 当前路径和
     * @return 满足题意的解
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }

    /**
     * 558. 四叉树交集
     * 二进制矩阵中的所有元素不是 0 就是 1 。
     * <p>
     * 给你两个四叉树，quadTree1 和 quadTree2。其中 quadTree1 表示一个 n * n 二进制矩阵，而 quadTree2 表示另一个 n * n 二进制矩阵。
     * <p>
     * 请你返回一个表示 n * n 二进制矩阵的四叉树，它是 quadTree1 和 quadTree2 所表示的两个二进制矩阵进行 按位逻辑或运算 的结果。
     * <p>
     * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
     * <p>
     * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
     * <p>
     * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
     * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
     * class Node {
     * public boolean val;
     *     public boolean isLeaf;
     *     public Node topLeft;
     *     public Node topRight;
     *     public Node bottomLeft;
     *     public Node bottomRight;
     * }
     * 我们可以按以下步骤为二维区域构建四叉树：
     * <p>
     * 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
     * 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
     * 使用适当的子网格递归每个子节点。
     * <p>
     * 四叉树格式：
     * <p>
     * 输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节点。
     * <p>
     * 它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。
     * <p>
     * 如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；如果 isLeaf 或者 val 的值为 False ，则表示值为 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param quadTree1
     * @param quadTree2
     */
    @Override
    public QuadTreeNode intersect(QuadTreeNode quadTree1, QuadTreeNode quadTree2) {
        if(quadTree1 == null || quadTree2 == null) {
            return quadTree1 == null ? quadTree2 : quadTree1;
        }

        /*
            1. deal with special cases
        */

        if(quadTree1.isLeaf || quadTree2.isLeaf){
            if((quadTree1.isLeaf && quadTree2.isLeaf) || (quadTree1.isLeaf && quadTree1.val) || (quadTree2.isLeaf && quadTree2.val)  ) {
                return new QuadTreeNode(quadTree1.val | quadTree2.val, true, null, null, null, null);
            }
        }

        /*
            2. general cases
        */

        QuadTreeNode res   = new QuadTreeNode();
        res.isLeaf = false;
        res.topLeft     = intersect(quadTree1.topLeft, quadTree2.topLeft);
        res.topRight    = intersect(quadTree1.topRight, quadTree2.topRight);
        res.bottomLeft  = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        int isLeaf = sumAll(res.topLeft.isLeaf, res.topRight.isLeaf, res.bottomLeft.isLeaf, res.bottomRight.isLeaf);
        int val    = sumAll(res.topLeft.val, res.topRight.val, res.bottomLeft.val, res.bottomRight.val);

        if(isLeaf == 4 && (val == 4 || val == 0)){
            res.isLeaf = true;
            res.val    = val == 4 ? true : false;
            res.topLeft = res.topRight = res.bottomRight = res.bottomLeft = null;
            return res;
        }

        return res;
    }

    private int sumAll(boolean a, boolean b, boolean c, boolean d){
        int i1 = a ? 1 : 0;
        int i2 = b ? 1 : 0;
        int i3 = c ? 1 : 0;
        int i4 = d ? 1 : 0;

        return i1 + i2 + i3 + i4;
    }

    /**
     * 576. 出界的路径数
     * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
     * <p>
     * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     */
    @Override
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove==0) {
            return 0;
        }
        int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] dp = new int[m][n];
        for(int k=0;k<maxMove;k++){
            int[][] tmp = new int[m][n];
            for(int x=0;x<m;x++){
                for(int y=0;y<n;y++){
                    for(int[] d: direct){
                        if(x+d[0]<0 || x+d[0]>=m || y+d[1]<0 || y+d[1]>=n){
                            tmp[x][y]++;
                        }else{
                            tmp[x][y] = (tmp[x][y]+dp[x+d[0]][y+d[1]])% CommonConstants.MOD;
                        }
                    }
                }
            }
            dp = tmp;
        }
        return dp[startRow][startColumn];
    }

    /**
     * 609. 在系统中查找重复文件
     * 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。一组重复的文件至少包括二个具有完全相同内容的文件。
     * <p>
     * 输入列表中的单个目录信息字符串的格式如下：
     * <p>
     * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
     * <p>
     * 这意味着有 n 个文件（f1.txt, f2.txt ... fn.txt 的内容分别是 f1_content, f2_content ... fn_content）在目录 root/d1/d2/.../dm 下。注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。
     * <p>
     * 该输出是重复文件路径组的列表。对于每个组，它包含具有相同内容的文件的所有文件路径。文件路径是具有下列格式的字符串：
     * <p>
     * "directory_path/file_name.txt"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-duplicate-file-in-system
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param paths
     */
    @Override
    public List < List < String >> findDuplicate(String[] paths) {
        HashMap < String, List < String >> map = new HashMap < > ();
        for (String path: paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name_cont = values[i].split("\\(");
                name_cont[1] = name_cont[1].replace(")", "");
                List < String > list = map.getOrDefault(name_cont[1], new ArrayList < String > ());
                list.add(values[0] + "/" + name_cont[0]);
                map.put(name_cont[1], list);
            }
        }
        List < List < String >> res = new ArrayList < > ();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }
        return res;
    }

    /**
     * 687. 最长同值路径
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * <p>
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     *
     * @param root
     */
    @Override
    public int longestUnivaluePath(TreeNode root) {
        int ans = 0;
        arrowLength(root,ans);
        return ans;
    }
    private int arrowLength(TreeNode node, int ans) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left,ans);
        int right = arrowLength(node.right,ans);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    /**
     * 785. 判断二分图
     * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
     * 不存在自环（graph[u] 不包含 u）。
     * 不存在平行边（graph[u] 不包含重复值）。
     * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
     * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
     * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
     * <p>
     * 如果图是二分图，返回 true ；否则，返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param graph
     */
    @Override
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, CommonConstants.UNCOLORED);
        for (int i = 0; i < n; ++i) {
            if (color[i] == CommonConstants.UNCOLORED) {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                color[i] = CommonConstants.RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color[node] == CommonConstants.RED ? CommonConstants.GREEN : CommonConstants.RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == CommonConstants.UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = cNei;
                        } else if (color[neighbor] != cNei) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 797. 所有可能的路径
     * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
     * <p>
     * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param graph
     */
    @Override
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    private List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N-1);
            ans.add(path);
            return ans;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
}
