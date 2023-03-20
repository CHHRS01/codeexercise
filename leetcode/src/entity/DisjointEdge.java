package entity;

/**
 * @author hanrensong
 * @date 2021/8/12
 */

public class DisjointEdge {

    public int[] f;

    public DisjointEdge(int m, int n) {
        f = new int[m * n];
        for (int i = 0; i < m * n; ++i) {
            f[i] = i;
        }
    }

    public int find(int x) {
        return x == f[x] ? x : (f[x] = find(f[x]));
    }

    public void merge(int x, int y) {
        f[find(x)] = find(y);
    }
}
