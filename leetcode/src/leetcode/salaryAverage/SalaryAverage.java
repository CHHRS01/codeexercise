package leetcode.salaryAverage;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class SalaryAverage {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = Arrays.stream(salary).sum();
        sum = sum - salary[0]- salary[salary.length - 1];

        return (double) sum / (salary.length - 2);
    }
}
