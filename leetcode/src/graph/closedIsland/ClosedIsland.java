package graph.closedIsland;

/**
 * 1254. 统计封闭岛屿的数目
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class ClosedIsland {

    int val;

    public int closedIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    val = 1;
                    dfs(grid, i, j);
                    ans += val;
                }
            }
        }
        return ans;
    }



    public void dfs(int[][] grid, int i, int j) {
        if(!isArea(grid, i, j)){
            val = 0;
            return;
        }
        if(grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public boolean isArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length
                && j >= 0 && j < grid[0].length;
    }
}
