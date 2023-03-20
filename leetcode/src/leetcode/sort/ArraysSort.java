package leetcode.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class ArraysSort {

    public static int[] arraysSort(int[] param) {
        Arrays.sort(param);
        return param;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,73,1,3,5,32,5,322,4,3,2,5};
        int[] ints = arraysSort(a);
        for (int aInt : ints) {
            System.out.println(aInt);
        }

    }
}
