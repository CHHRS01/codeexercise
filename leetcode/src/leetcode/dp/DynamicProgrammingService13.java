package leetcode.dp;

public interface DynamicProgrammingService13 {

    /**
     * 1654. 到家的最少跳跃次数
     * 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
     *
     * 跳蚤跳跃的规则如下：
     *
     * 它可以 往前 跳恰好 a 个位置（即往右跳）。
     * 它可以 往后 跳恰好 b 个位置（即往左跳）。
     * 它不能 连续 往后跳 2 次。
     * 它不能跳到任何 forbidden 数组中的位置。
     * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
     *
     * 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-jumps-to-reach-home
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * */
    int minimumJumps(int[] forbidden, int a, int b, int x);


    /**
     * 1641. 统计字典序元音字符串的数目
     * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
     *
     * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int countVowelStrings(int n);


    /**
     * 1664. 生成平衡数组的方案数
     * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
     *
     * 比方说，如果 nums = [6,1,7,4,1] ，那么：
     *
     * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
     * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
     * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
     * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
     *
     * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ways-to-make-a-fair-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int waysToMakeFair(int[] nums);


    /**
     * 1690. 石子游戏 VII
     * 石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
     *
     * 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
     *
     * 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
     *
     * 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/stone-game-vii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int stoneGameVII(int[] stones);


    /**
     * 1696. 跳跃游戏 VI
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     *
     * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
     *
     * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
     *
     * 请你返回你能得到的 最大得分 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-vi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int maxResult(int[] nums, int k);


    /**
     * 1749. 任意子数组和的绝对值的最大值
     * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
     *
     * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
     *
     * abs(x) 定义如下：
     *
     * 如果 x 是负整数，那么 abs(x) = -x 。
     * 如果 x 是非负整数，那么 abs(x) = x 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-absolute-sum-of-any-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int maxAbsoluteSum(int[] nums);


    /**
     * 1770. 执行乘法运算的最大分数
     * 给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
     *
     * 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
     *
     * 选择数组 nums 开头处或者末尾处 的整数 x 。
     * 你获得 multipliers[i] * x 分，并累加到你的分数中。
     * 将 x 从数组 nums 中移除。
     * 在执行 m 步操作后，返回 最大 分数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-score-from-performing-multiplication-operations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int maximumScore(int[] nums, int[] multipliers);


    /**
     * 1774. 最接近目标价格的甜点成本
     * 你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
     *
     * 必须选择 一种 冰激凌基料。
     * 可以添加 一种或多种 配料，也可以不添加任何配料。
     * 每种类型的配料 最多两份 。
     * 给你以下三个输入：
     *
     * baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
     * toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
     * target ，一个整数，表示你制作甜点的目标价格。
     * 你希望自己做的甜点总成本尽可能接近目标价格 target 。
     *
     * 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/closest-dessert-cost
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int closestCost(int[] baseCosts, int[] toppingCosts, int target);


    /**
     * 1786. 从第一个节点出发到最后一个节点的受限路径数
     * 现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，其中每个 edges[i] = [ui, vi, weighti] 表示存在一条位于节点 ui 和 vi 之间的边，这条边的权重为 weighti 。
     *
     * 从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，满足 z0 = start 、zk = end 且在所有符合 0 <= i <= k-1 的节点 zi 和 zi+1 之间存在一条边。
     *
     * 路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。受限路径 为满足 distanceToLastNode(zi) > distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。
     *
     * 返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 109 + 7 取余 的结果。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-restricted-paths-from-first-to-last-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int countRestrictedPaths(int n, int[][] edges);

    /**
     * 1824. 最少侧跳次数
     * 给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处。然而道路上可能有一些障碍。
     *
     * 给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。
     *
     * 比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
     * 这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
     *
     * 比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
     * 这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。
     *
     * 注意：点 0 处和点 n 处的任一跑道都不会有障碍。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-sideway-jumps
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    int minSideJumps(int[] obstacles);
}
