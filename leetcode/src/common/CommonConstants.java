package common;

public interface CommonConstants {

    /**
     * int  0
     * */
    int INTEGER_0 = 0;

    /**
     * int  1
     * */
    int INTEGER_1 = 1;

    /**
     * int  2
     * */
    int INTEGER_2 = 2;

    /**
     * int  3
     * */
    int INTEGER_3 = 3;

    /**
     * int  4
     * */
    int INTEGER_4 = 4;

    /**
     * int  5
     * */
    int INTEGER_5 = 5;

    /**
     * int  6
     * */
    int INTEGER_6 = 6;

    /**
     * int  7
     * */
    int INTEGER_7 = 7;

    /**
     * int  8
     * */
    int INTEGER_8 = 8;

    /**
     * int  9
     * */
    int INTEGER_9 = 9;

    /**
     * 质数，对于int32位来说1000000007足够大
     * 平方（乘积）不会在int64中溢出
     * */
    int MOD = 1_000_000_007;

    int UNCOLORED = 0;

    int RED = 1;

    int GREEN = 2;


    /**
     * 无穷大常量
     * */
    int INF = 0x3f3f3f3f;

    int[] PATTERNS = {0, 0b1010, 0b0101, 0b1100, 0b0110, 0b1001, 0b0011};

    int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
}
