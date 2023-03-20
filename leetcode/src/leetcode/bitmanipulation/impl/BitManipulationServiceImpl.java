package leetcode.bitmanipulation.impl;

import leetcode.bitmanipulation.BitManipulationService;

/**
 * @author hanrensong
 * @date 2021/8/31
 */

public class BitManipulationServiceImpl implements BitManipulationService {

    /**
     * 加法
     * 直接二进制相加的结果，0+0=0,1+0=1,1+1=10。好像能看出点什么。前两个的运算规则复合“异或运算”，而后者则复合与运算并左移1位。
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int add(int a, int b) {
        // 得到原位和
        int xor = a ^ b;
        // 得到进位和
        int forWoad = (a & b) << 1;
        return forWoad == 0 ? xor : add(xor, forWoad);

    }

    /**
     * 负数
     *
     * @param num
     * @return
     */
    @Override
    public int negative(int num) {
        return add(~num, 1);
    }

    /**
     * 减法
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int minus(int a, int b) {
        return add(a, negative(b));
    }

    /**
     * 绝对值
     *
     * @param num
     * @return
     */
    @Override
    public int abs(int num) {
        if (num < 0) {
            num = minus(0, num);
        }
        return num;

    }

    /**
     * 乘法
     * 二进制乘法的原理是：从乘数的低位到高位，遇到1并且这个1在乘数的右边起第i（i从0开始）位，那么就把被乘数左移i位得到temp_i，直到乘数中的1遍历完毕后，把根据各位1而得到的被乘数的左移值全部相加即得到乘法结果。
     * <p>
     * 而至于存在负数的运算，可以先获取负数的个数，再将两个数字转换成绝对值计算，最后判断当负数是1个时，计算结果就是负数，其他情况则是正数。
     * ————————————————
     * 版权声明：本文为CSDN博主「齐天大头」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_36403693/article/details/105446973
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int multi(int a, int b) {
        // 先获取负数的个数
        int negativeCount = negativeCount(a, b);
        // 负数转正数进行计算
        a = abs(a);
        b = abs(b);
        int i = 0;
        int res = 0;
        // 乘数为0则结束
        while (b != 0) {
            // 处理乘数当前位
            if ((b & 1) == 1) {
                res = add(res, a << i);
            }
            b = b >> 1;
            i = add(i, 1);
        }
        if (negativeCount == 1) {
            // 转为负数
            res = negative(res);
        }
        return res;
    }

    private int negativeCount(int a, int b) {
        int count = 0;
        if (a < 0) {
            count = add(count, 1);
        }
        if (b < 0) {
            count = add(count, 1);
        }
        return count;
    }

    /**
     * 除法
     * 计算机中的除法也是通过连减去计算的
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int sub(int a, int b) {
        // 先获取负数的个数
        int negativeCount = negativeCount(a, b);
        // 负数转正数进行计算
        a = abs(a);
        b = abs(b);
        int res;
        if (a < b) {
            return 0;
        } else {
            res = add(sub(minus(a, b), b), 1);
        }
        if (negativeCount == 1) {
            // 转为负数
            res = negative(res);
        }
        return res;
    }

    /**
     * 取模
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int mode(int a, int b) {
        // 先获取负数的个数
        int negativeCount = negativeCount(a, b);
        // 负数转正数进行计算
        a = abs(a);
        b = abs(b);
        int res;
        if (a < b) {
            res = a;
        } else {
            res = mode(minus(a, b), b);
        }
        if (negativeCount == 1) {
            // 转为负数
            res = negative(res);
        }
        return res;
    }
}
