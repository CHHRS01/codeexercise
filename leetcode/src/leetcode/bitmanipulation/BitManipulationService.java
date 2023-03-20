package leetcode.bitmanipulation;

/**
 * @author hanrensong
 * @date 2021/8/31
 */

public interface BitManipulationService {

    /**
     * 加法
     * 直接二进制相加的结果，0+0=0,1+0=1,1+1=10。好像能看出点什么。前两个的运算规则复合“异或运算”，而后者则复合与运算并左移1位。
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b);

    /**
     * 负数
     * @param num
     * @return
     */
    int negative(int num);

    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    int minus(int a, int b);

    /**
     * 绝对值
     * @param num
     * @return
     */
    int abs(int num);

    /**
     * 乘法
     * 二进制乘法的原理是：从乘数的低位到高位，遇到1并且这个1在乘数的右边起第i（i从0开始）位，那么就把被乘数左移i位得到temp_i，直到乘数中的1遍历完毕后，把根据各位1而得到的被乘数的左移值全部相加即得到乘法结果。
     *
     * 而至于存在负数的运算，可以先获取负数的个数，再将两个数字转换成绝对值计算，最后判断当负数是1个时，计算结果就是负数，其他情况则是正数。
     * ————————————————
     * 版权声明：本文为CSDN博主「齐天大头」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_36403693/article/details/105446973
     * @param a
     * @param b
     * @return
     */
    int multi(int a, int b);

    /**
     * 除法
     * 计算机中的除法也是通过连减去计算的
     * @param a
     * @param b
     * @return
     */
    int sub(int a, int b);

    /**
     * 取模
     * @param a
     * @param b
     * @return
     */
    int mode(int a, int b);
}
