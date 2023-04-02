package graph;

/**
 * 网格 DFS 遍历的框架代码
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class GraphDfs {
    // 先污染后治理
    // 先超出边框再判断
    public void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        // 避免重复
        // 将格子标记为「已遍历过」
        grid[r][c] = 2;

        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    public boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
}
