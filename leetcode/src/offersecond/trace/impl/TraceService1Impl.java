package offersecond.trace.impl;

import offersecond.trace.TraceService1;
import entity.TreeNode;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public class TraceService1Impl implements TraceService1 {
    /**
     * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
     * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * <p>
     * 每条从根节点到叶节点的路径都代表一个数字：
     * <p>
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * <p>
     * 叶节点 是指没有子节点的节点。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3Etpl5
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     */
    @Override
    public int sumNumbers(TreeNode root) {
        dfs_NLR(root, 0);
        return res;
    }

    private int res = 0;

    private void dfs_NLR(TreeNode x, int prefix) {
        int cur = prefix * 10 + x.val;

        if (x.left == null && x.right == null) {
            res += cur;
        } else {
            if (x.left != null) {
                dfs_NLR(x.left, cur);
            }
            if (x.right != null) {
                dfs_NLR(x.right, cur);
            }
        }
    }

    /**
     * 剑指 Offer II 050. 向下的路径节点之和
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/6eUYwP
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param targetSum
     */
    @Override
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        int[] ret = new int[1];
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        valueList.add(targetSum);
        inOrder(root, valueList, ret, targetSum);
        return ret[0];
    }

    private void inOrder(TreeNode root, ArrayList<Integer> valueList, int[] ret, int sum){
        ArrayList<Integer> listChild = new ArrayList<Integer>();
        listChild.add(sum);
        for(Integer value: valueList){
            if(root.val == value) {
                ret[0]++;
            }
            listChild.add(value-root.val);
        }
        if(root.left !=null) {
            inOrder(root.left, listChild, ret, sum);
        }
        if(root.right !=null) {
            inOrder(root.right, listChild, ret, sum);
        }
    }

    /**
     * 剑指 Offer II 098. 路径的数目
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/2AoeFn
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     */
    @Override
    public int uniquePaths(int m, int n) {
        int []dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                dp[j]+=dp[j-1];
        return dp[n-1];
    }

    /**
     * 剑指 Offer II 099. 最小路径之和
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：一个机器人每次只能向下或者向右移动一步。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/0i0mDW
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     */
    @Override
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) {
            return 0;
        }

        int m=grid.length-1;
        int n=grid[0].length-1;
        int[][] dp=new int[m+1][n+1];

        dp[m][n]=grid[m][n];
        for(int i=m-1;i>=0;i--){
            dp[i][n]=dp[i+1][n]+grid[i][n];
        }
        for(int j=n-1;j>=0;j--){
            dp[m][j]=dp[m][j+1]+grid[m][j];
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
            }
        }
        return dp[0][0];
    }

    /**
     * 剑指 Offer II 100. 三角形中最小路径之和
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * <p>
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/IlPe0q
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param triangle
     */
    @Override
    public int minimumTotal(List<List<Integer>> triangle) {

        int length= triangle.size();
        int width=triangle.get(length-1).size();
        long[][]dp=new long[length][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<length;i++){
            int length_2=triangle.get(i).size();
            for(int j=0;j<length_2;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                }else if(j==length_2-1){
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
                }

            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<width;i++){
            if(dp[length-1][i]<min){
                min=(int)dp[length-1][i];
            }
        }
        return min;
    }

    /**
     * 剑指 Offer II 106. 二分图
     * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。
     * <p>
     * 给定一个二维数组 graph ，表示图，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
     * <p>
     * 不存在自环（graph[u] 不包含 u）。
     * 不存在平行边（graph[u] 不包含重复值）。
     * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
     * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
     * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
     * <p>
     * 如果图是二分图，返回 true ；否则，返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/vEAB3K
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param graph
     */
    @Override
    public boolean isBipartite(int[][] graph) {
        //相邻两个加入一个并查集，若检查时发现和相邻节点在同一并查集则false
        int[] parent = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            parent[i] = i;
        }
        for(int i = 0;i<graph.length;i++){
            if(graph[i].length == 0) continue;
            int pre = find(parent,graph[i][0]);
            int p1 = find(parent,i);
            for(int j = 0;j<graph[i].length;j++){
                int p2 = find(parent,graph[i][j]);
                if(p1 == p2) return false;
                else parent[p2] = pre;
            }
        }
        return true;
    }

    private int find(int[] parent,int i){
        if(parent[i] != i){
            parent[i] = find(parent,parent[i]);
        }
        return parent[i];
    }

    /**
     * 剑指 Offer II 110. 所有路径
     * 给定一个有 n 个节点的有向无环图，用二维数组 graph 表示，请找到所有从 0 到 n-1 的路径并输出（不要求按顺序）。
     * <p>
     * graph 的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若为空，就是没有下一个节点了。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bP4bmD
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param graph
     */
    @Override
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        sublist.add(0);//添加初始点
        getList(graph, 0, sublist, list);
        return list;
    }

    private void getList(int[][] graph, int index, List<Integer> sublist, List<List<Integer>> list){
        if(index == graph.length-1) {
            list.add(new ArrayList<>(sublist));//遍历到尾部保存路径
        }
        for(int i = 0 ; i < graph[index].length ; i++){//遍历之后的路径
            sublist.add(graph[index][i]);
            getList(graph, graph[index][i], sublist, list);//递归回溯
            sublist.remove(sublist.size()-1);
        }
    }
}
