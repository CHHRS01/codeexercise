package leetcode.trace;

import entity.TreeNode;

import java.util.List;

/**
 * @author hanrensong
 * @date 2021/8/3
 */

public interface TraceService3 {



    /**
     * 893. 特殊等价字符串组
     * 给你一个字符串数组 words。
     *
     * 一步操作中，你可以交换字符串 words[i] 的任意两个偶数下标对应的字符或任意两个奇数下标对应的字符。
     *
     * 对两个字符串 words[i] 和 words[j] 而言，如果经过任意次数的操作，words[i] == words[j] ，那么这两个字符串是 特殊等价 的。
     *
     * 例如，words[i] = "zzxy" 和 words[j] = "xyzz" 是一对 特殊等价 字符串，因为可以按 "zzxy" -> "xzzy" -> "xyzz" 的操作路径使 words[i] == words[j] 。
     * 现在规定，words 的 一组特殊等价字符串 就是 words 的一个同时满足下述条件的非空子集：
     *
     * 该组中的每一对字符串都是 特殊等价 的
     * 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
     * 返回 words 中 特殊等价字符串组 的数量。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int numSpecialEquivGroups(String[] words);

    /**
     * 931. 下降路径最小和
     * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
     *
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int minFallingPathSum(int[][] matrix);

    /**
     * 1042. 不邻接植花
     * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
     *
     * 另外，所有花园 最多 有 3 条路径可以进入或离开.
     *
     * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
     *
     * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int[] gardenNoAdj(int n, int[][] paths);


    /**
     * 1080. 根到叶路径上的不足节点
     * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
     *
     * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
     *
     * 请你删除所有不足节点，并返回生成的二叉树的根。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    TreeNode sufficientSubset(TreeNode root, int limit);


    /**
     * 1091. 二进制矩阵中的最短路径
     * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
     *
     * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
     *
     * 路径途经的所有单元格都的值都是 0 。
     * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
     * 畅通路径的长度 是该路径途经的单元格总数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int shortestPathBinaryMatrix(int[][] grid);


    /**
     * 1104. 二叉树寻路
     * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
     *
     * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
     *
     * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
     *
     * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    List<Integer> pathInZigZagTree(int label);


    /**
     * 1129. 颜色交替的最短路径
     * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
     *
     * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
     *
     * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-path-with-alternating-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges);


    /**
     * 1138. 字母板上的路径
     * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
     *
     * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
     *
     * 我们可以按下面的指令规则行动：
     *
     * 如果方格存在，'U' 意味着将我们的位置上移一行；
     * 如果方格存在，'D' 意味着将我们的位置下移一行；
     * 如果方格存在，'L' 意味着将我们的位置左移一列；
     * 如果方格存在，'R' 意味着将我们的位置右移一列；
     * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
     * （注意，字母板上只存在有字母的位置。）
     *
     * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/alphabet-board-path
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    String alphabetBoardPath(String target);


    /**
     * 1233. 删除子文件夹
     * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
     *
     * 我们这样定义「子文件夹」：
     *
     * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
     * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
     *
     * / 后跟一个或者多个小写英文字母。
     * 例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    List<String> removeSubfolders(String[] folder);


    /**
     * 1334. 阈值距离内邻居最少的城市
     * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
     *
     * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
     *
     * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int findTheCity(int n, int[][] edges, int distanceThreshold);
}
