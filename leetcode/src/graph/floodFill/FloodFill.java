package graph.floodFill;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. 图像渲染
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class FloodFill {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor == color) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }

    // 深度优先
    public static int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor != color) {
            dfs(image, sr, sc, currColor, color);
        }
        return image;
    }

    public static void dfs(int[][] image, int x, int y, int currColor, int color) {
        if (image[x][y] == currColor) {
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, currColor, color);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{0,0,0},{0,0,0}};
        int[][] ans1 = floodFill(image,0,0,2);
        System.out.println(Arrays.deepToString(ans1));
        int[][] ans2 = floodFill2(image,0,0,2);
        System.out.println(Arrays.deepToString(ans2));
    }
}
