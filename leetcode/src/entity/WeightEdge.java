package entity;

/**
 * @author hanrensong
 * @date 2021/8/12
 */

public class WeightEdge {
    // 分别表示一条边两个点的索引和边长
    public int a;
    public int b;
    public int val;
    public WeightEdge(int a, int b, int val) {
        this.a = a;
        this.b = b;
        this.val = val;
    }
}
