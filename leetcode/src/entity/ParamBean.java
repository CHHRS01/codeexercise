package entity;

public class ParamBean {

    private int[] param1 = {2, 1, 3, 1, 4, 2, 5, 3, 7};

    private String paramString = "ababcdcba";

    private Integer paramInt = 4;

    private Integer paramInt2 = 4;

    private int[][] param2dArray = {{}};

    public int[] getParam1() {
        return param1;
    }

    public void setParam1(int[] param1) {
        this.param1 = param1;
    }

    public String getParamString() {
        return paramString;
    }

    public void setParamString(String paramString) {
        this.paramString = paramString;
    }

    public Integer getParamInt() {
        return paramInt;
    }

    public void setParamInt(Integer paramInt) {
        this.paramInt = paramInt;
    }

    public int[][] getParam2dArray() {
        return param2dArray;
    }

    public void setParam2dArray(int[][] param2dArray) {
        this.param2dArray = param2dArray;
    }

    public Integer getParamInt2() {
        return paramInt2;
    }

    public void setParamInt2(Integer paramInt2) {
        this.paramInt2 = paramInt2;
    }
}
