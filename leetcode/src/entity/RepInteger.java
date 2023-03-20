package entity;

public class RepInteger {
    private int val;
    private int count;
    public RepInteger(int v, int c) {
        val = v;
        count = c;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
